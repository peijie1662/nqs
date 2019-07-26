package nbct.com.cn.customerquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.OrderReceive;
import nbct.com.cn.customerquery.entity.YardTruck;
import nbct.com.cn.customerquery.service.QryService;

/**
 * @author PJ
 * @version 创建时间：2019年7月22日 上午10:54:36 类说明
 */
@Api(value = "QRY查询")
@RestController
public class CommonQryController {

	@Autowired
	QryService qryService;

	// @TokenCheck
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

	@ApiOperation(value = "在场集卡列表", notes = "在场集卡列表")
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

}
