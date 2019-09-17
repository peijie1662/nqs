package nbct.com.cn.customerquery.controller;

import com.alibaba.druid.sql.visitor.functions.Substring;
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
import nbct.com.cn.customerquery.service.*;

import java.security.PrivateKey;
import java.util.List;

/**
* @author PJ 
* @version 创建时间：2019年7月26日 下午12:39:44
*/
@Api(value = "Container查询")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ContainerController {
	
	@Autowired
	ContainerService containerService;

	@ApiOperation(value = "单箱信息", notes = "单箱信息查询")
	@RequestMapping(value = "/containerinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getContainerInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		String cntrId = p.getString("cntrId");
		try {
			ContainerInfo ci = containerService.getContainerInfo(cntrId);			
			r.setFlag(true);
			r.setData(ci);
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

			List<Voyage> list = containerService.getVoyageList(vsvy,vsdr,lncd);
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
	 * 调用 { "vscd":"YMPIN","vsdr": "I", "vsvy": "148E" ,"lncd":"YML"}
	 */
	@ApiOperation(value = "进口箱清单", notes = "根据航次和箱主列出所有该航次下所有的进口箱")
	@RequestMapping(value = "/imcontainerlist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getImContainerList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String vscd=p.getString("vscd");
			String vsvy=p.getString("vsvy");
			String vsdr=p.getString("vsdr");
			String lncd=p.getString("lncd");

			int ct20=0;
			int ct40=0;
			int teu=0;
			String ctsz;

			List<ImContainer> list = containerService.getImContainerList(vscd,vsvy,vsdr,lncd);

			for(int i=0;i<list.size();i++){
				ctsz=list.get(i).getCtszst();
				if(ctsz.startsWith("2")){
					ct20++;
				}
				if(ctsz.startsWith("4")){
					ct40++;
				}
			}
			teu=ct20+ct40*2;

			JSONObject jo=new JSONObject();
			jo.put("list",list);

			JSONObject jot=new JSONObject();
			jot.put("ct20",ct20);
			jot.put("ct40",ct40);
			jot.put("teu",teu);
			jo.put("total",jot);

			r.setFlag(true);
			r.setData(jo);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}
}
