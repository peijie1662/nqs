package nbct.com.cn.customerquery.controller;

import java.util.List;


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

/**
 * @author PJ
 * @version 创建时间：2019年7月22日 上午10:54:36 类说明
 * 调用路径：http://localhost:8864/swagger-ui.html
 */
@Api(value = "QRY查询")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CommonQryController {

	@Autowired
	QryService qryService;

	// @TokenCheck
/*
调用
{
  "dt": 20190726
}
 */

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
调用
{
  "startdate": 20190726,
  "enddate": 20190726
}
 */
	@ApiOperation(value = "集装箱进箱截箱时间公告", notes = "显示进箱截箱时间段在设定范围内的船舶信息")
	@RequestMapping(value = "/cntrinclosedate", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getCntrInCloseDateList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			int startdate = p.getIntValue("startdate");
			int enddate = p.getIntValue("enddate");

			List<CntrInCloseDate> list = qryService.getCntrInCloseDateList(startdate,enddate);
			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
调用
{
  "startdate": 20190726,
  "enddate": 20190726
}
 */
	@ApiOperation(value = "船期预告", notes = "显示时间段内的船舶信息")
	@RequestMapping(value = "/sailingdatenotice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getSailingDateNoticeList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			int startdate = p.getIntValue("startdate");
			int enddate = p.getIntValue("enddate");

			List<SailingDateNotice> list = qryService.getSailingDateNoticeList(startdate,enddate);
			//SQL返回空记录集时也不报错

			r.setFlag(true);
			r.setData(list);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}
}
