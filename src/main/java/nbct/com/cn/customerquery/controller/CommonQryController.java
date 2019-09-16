package nbct.com.cn.customerquery.controller;

import java.util.List;

import nbct.com.cn.customerquery.annotation.CallStatistics;
import nbct.com.cn.customerquery.annotation.NBCTWebFunction;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.service.QryService;
import nbct.com.cn.customerquery.utils.Utils;

/**
 * @author PJ
 * @version 创建时间：2019年7月22日 上午10:54:36 类说明
 *          调用路径：http://localhost:8864/swagger-ui.html
 */
@Api(value = "QRY查询")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommonQryController {

	@Autowired
	QryService qryService;

	// @TokenCheck
	/*
	 * 调用 { "dt": 20190726 }
	 */
	@TokenCheck
	@CallStatistics(NBCTWebFunction.ORDERRECEIVE)
	@ApiOperation(value = "接单公告", notes = "接单公告")
	@RequestMapping(value = "/orderreceive", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getOrderReceive(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			int dt = p.getIntValue("dt");
			List<OrderReceive> list = qryService.getOrderReceives(dt);
			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	@ApiOperation(value = "在场集卡列表", notes = "显示当前在场集卡列表")
	@RequestMapping(value = "/yardtruck", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getYardTruckList() {
		CallResult r = new CallResult();
		try {
			List<YardTruck> list = qryService.getYardTruckList();
			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 { "startdate": 20190726, "enddate": 20190726 }
	 */
	@ApiOperation(value = "集装箱进箱截箱时间公告", notes = "显示进箱截箱时间段在设定范围内的船舶信息")
	@RequestMapping(value = "/cntrinclosedate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getCntrInCloseDateList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			int startdate = p.getIntValue("startdate");
			int enddate = p.getIntValue("enddate");

			List<CntrInCloseDate> list = qryService.getCntrInCloseDateList(startdate, enddate);
			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 { "startdate": 20190726, "enddate": 20190726 }
	 */
	@ApiOperation(value = "船期预告", notes = "显示时间段内的船舶信息")
	@RequestMapping(value = "/sailingdatenotice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getSailingDateNoticeList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			int startdate = p.getIntValue("startdate");
			int enddate = p.getIntValue("enddate");

			List<SailingDateNotice> list = qryService.getSailingDateNoticeList(startdate, enddate);
			// SQL返回空记录集时也不报错

			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 { "cntrId": "AXIU2187556" }
	 */
	@ApiOperation(value = "进口箱海关放行信息查询", notes = "显示某集装箱的海关放行信息")
	@RequestMapping(value = "/imcustompassinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getImCustomPassInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String cntrId = p.getString("cntrId");
			if (!Utils.isCntrId(cntrId)) {
				r.setFlag(false);
				r.setErrMsg("输入的箱号 【" + cntrId + "】 不正确");
				return r;
			}

			ImCustomPassInfo cntrInfo = qryService.getImCustomPassInfo(cntrId);
			if (cntrInfo == null) {
				r.setFlag(false);
				r.setErrMsg("箱号 【" + cntrId + "】 不在场地");
			} else {
				cntrInfo.setCntrId(cntrId);
				if (!cntrInfo.getVsdr().equals("I")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 不是进口箱");
					r.setData(cntrInfo);
					return r;
				}
				if (cntrInfo.getInfe().equals("E")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 是空箱");
					r.setData(cntrInfo);
					return r;
				}
				if (!cntrInfo.getIntd().equals("W")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 是内贸箱");
					r.setData(cntrInfo);
					return r;
				}

				if (cntrInfo.getCaps() == null) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 没有海关放行信息");
					r.setData(cntrInfo);
				} else {
					if (cntrInfo.getCaps().equals("TP")) {
						cntrInfo.setIstp("是");
					} else {
						cntrInfo.setIstp("不是");
					}
					r.setFlag(true);
					r.setOutMsg("箱号 【" + cntrId + "】 海关已放行");
					r.setData(cntrInfo);
				}
			}
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 调用 { "cntrId": "MRKU3902661" }
	 */
	@ApiOperation(value = "出口箱码头放行信息查询", notes = "显示某集装箱的码头放行信息")
	@RequestMapping(value = "/exportpassinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getExPortPassInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String cntrId = p.getString("cntrId");
			if (!Utils.isCntrId(cntrId)) {
				r.setFlag(false);
				r.setErrMsg("输入的箱号 【" + cntrId + "】 不正确");
				return r;
			}

			ExPortPassInfo cntrInfo = qryService.getExPortPassInfo(cntrId);
			if (cntrInfo == null) {
				r.setFlag(false);
				r.setErrMsg("箱号 【" + cntrId + "】 不在场地");
			} else {
				cntrInfo.setCntrId(cntrId);
				if (!cntrInfo.getVsdr().equals("E")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 不是出口箱");
					r.setData(cntrInfo);
					return r;
				}
				if (cntrInfo.getInfe().equals("E")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 是空箱");
					r.setData(cntrInfo);
					return r;
				}
				if (cntrInfo.getIsportpass().equals("N")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 码头场站未放行");
					r.setData(cntrInfo);
				} else {
					r.setFlag(true);
					r.setOutMsg("箱号 【" + cntrId + "】 码头场站已放行");
					r.setData(cntrInfo);
				}
			}
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 调用 { "cntrId": "SNBU8272555" }
	 */
	@ApiOperation(value = "查验箱移箱/归位情况查询", notes = "显示某集装箱的查验移箱/归位情况")
	@RequestMapping(value = "/checkmovecntrinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getCheckMoveCtnrInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String cntrId = p.getString("cntrId");
			if (!Utils.isCntrId(cntrId)) {
				r.setFlag(false);
				r.setErrMsg("输入的箱号 【" + cntrId + "】 不正确");
				return r;
			}

			CheckMoveCtnrInfo cntrInfo = qryService.getCheckMoveCtnrInfo(cntrId);
			if (cntrInfo == null) {
				r.setFlag(false);
				r.setErrMsg("箱号 【" + cntrId + "】 不在场地");
			} else {
				cntrInfo.setCntrId(cntrId);

				if (cntrInfo.getCkstatus() == null || "1".equals(cntrInfo.getCkstatus().trim())) {
					cntrInfo.setCkstatuscn("未受理");
				} else if ("2".equals(cntrInfo.getCkstatus().trim())) {
					cntrInfo.setCkstatuscn("查验箱未到位");
				} else if ("3".equals(cntrInfo.getCkstatus().trim())) {
					cntrInfo.setCkstatuscn("查验箱已到位");
				} else {
					cntrInfo.setCkstatuscn("未知");
				}

				if (cntrInfo.getFeenum() > 0) {
					if (!cntrInfo.getCkstatus().trim().equals("3")) {
						cntrInfo.setPosstatuscn("未归位");// 已收费但移箱指令还是未到位的显示未 未归位
					} else {
						cntrInfo.setPosstatuscn("已归位");
					}
				} else {
					cntrInfo.setPosstatuscn("未归位");
				}

				if (cntrInfo.getCkno().equals("0")) {
					r.setFlag(false);
					r.setErrMsg("箱号 【" + cntrId + "】 没有查验指令");
					r.setData(cntrInfo);
				} else {
					r.setFlag(true);
					r.setData(cntrInfo);
				}
			}
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}
	/*
	 * 调用 { "vsdr": "I", "vsvy": "A90114" ,"lncd":"CMA"}
	 */
	@ApiOperation(value = "船舶列表", notes = "根据指定条件列出所有船舶")
	@RequestMapping(value = "/voyagelist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getVoyageList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String vsvy=p.getString("vsvy");
			String vsdr=p.getString("vsdr");
			String lncd=p.getString("lncd");

			List<Voyage> list = qryService.getVoyageList(vsvy,vsdr,lncd);
			// SQL返回空记录集时也不报错

			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}
}
