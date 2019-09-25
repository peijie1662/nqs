package nbct.com.cn.customerquery.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.sql.visitor.functions.Substring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.entity.*;
import nbct.com.cn.customerquery.service.ContainerService;
import nbct.com.cn.customerquery.utils.Utils;

import java.util.Map;

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
	 * 调用 { "vsdr": "I", "vsvy": "JK044N" ,"lncd":"COS"}
	 */
	//TODO 可能的优化：列出7天内航次时考虑该航次的进截箱关联箱主
	//SELECT * FROM SYVSLPP WHERE CDTYLP='LNCD' AND VSCDLP='XFEIZ' AND VYIMLP='JK044N'
	@ApiOperation(value = "船舶列表", notes = "根据指定条件列出所有船舶")
	@RequestMapping(value = "/voyagelist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getVoyageList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			//lncd=""&vsvy=""返回7天内出口航次
			String vsvy=Utils.getFillStr(p.getString("vsvy"),"R",20," ");
			String vsdr=p.getString("vsdr");
			String lncd=Utils.getFillStr(p.getString("lncd"),"R",3," ");

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
	 * 调用(CMA下属船公司ANL) {"vscd":"XFEIZ","vsdr":"I","vsvy":"JK044N","lncd":"CMA","ordertype":"PORT"}
	 * 该功能仅支持 船公司进行查询，必须传入箱主代码
	 */
	@ApiOperation(value = "船公司进口箱清单", notes = "根据航次和箱主列出该航次下箱主所属的所有进口箱")
	@RequestMapping(value = "/imcontainerlist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getImContainerList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String vscd=Utils.getFillStr(p.getString("vscd"),"R",5," ");
			String vsvy=Utils.getFillStr(p.getString("vsvy"),"R",20," ");
			String vsdr=p.getString("vsdr");
			String lncd=Utils.getFillStr(p.getString("lncd"),"R",3," ");

			//排序方式：空，默认ISPASS/PORT港口/LNCD箱主/CTSZ尺寸/ISPASS按扣留/放行
			String ordertype=p.getString("ordertype");

			int ct20=0;
			int ct40=0;
			int teu=0;
			String ctsz;

			List<ImContainer> list = containerService.getImContainerList(vscd,vsvy,vsdr,lncd,ordertype);

			if(list!=null){
				for(int i=0;i<list.size();i++){
					ctsz=list.get(i).getCtsz();
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
				r.setData(jo);
			}

			r.setFlag(true);

		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 {"vscd":"OOLCA","vsdr":"E","vsvy":"066E","usertype":"H","caag":"CNC","ordertype":"PORT"}
	 * 调用 {"vscd":"XMZ78","vsdr":"E","vsvy":"813N","usertype":"V","lncd":"OOL","ordertype":"PORT"}
	 * {"vscd":"OOLTP","vsdr":"E","vsvy":"035E","usertype":"V","lncd":"CMA","ordertype":"PORT"}
	 * 该功能支持 船公司/货代进行查询，必须传入用户类型V/H和箱主/货代代码
	 */
	@ApiOperation(value = "船公司/货代出口箱清单", notes = "根据航次和箱主/货代列出该航次下箱主/货代所属的所有出口箱")
	@RequestMapping(value = "/excontainerlist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getExContainerList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String vscd=Utils.getFillStr(p.getString("vscd"),"R",5," ");
			String vsvy=Utils.getFillStr(p.getString("vsvy"),"R",20," ");
			String vsdr=p.getString("vsdr");
			String lncd=Utils.getFillStr(p.getString("lncd"),"R",3," ");
			String usertype=p.getString("usertype");
			String caag=Utils.getFillStr(p.getString("caag"),"R",6," ");
			//排序方式：空，默认ISPASS/PORT港口/LNCD箱主/CTSZ尺寸/ISPASS按扣留/放行
			String ordertype=p.getString("ordertype");

			int rnum=0;//放行箱量
			int hnum=0;//未放行箱量
			int znum=0;//国际中转箱量
			int bnum=0;//内支线中转箱量
			String isPass,ints;
			JSONObject jo=new JSONObject();

			//未装船列表
			List<ExContainer> list1 = containerService.getExContainerListInYard(vscd,vsvy,vsdr,usertype,lncd,caag,ordertype);

			if(list1!=null){
				for(int i=0;i<list1.size();i++){
					isPass=list1.get(i).getIsportpass();
					ints=list1.get(i).getInts();
					if("R".equals(isPass)){
						rnum++;
					}else{
						hnum++;
					}

					if("Z".equals(ints)){
						znum++;
					}
					if("B".equals(ints)){
						bnum++;
					}
				}
				jo.put("list1",list1);
			}else{
				jo.put("list1",null);
			}
			JSONObject jot1=new JSONObject();
			jot1.put("rnum",rnum);
			jot1.put("hnum",hnum);
			jot1.put("znum",znum);
			jot1.put("bnum",bnum);
			jo.put("total1",jot1);

			//已装船列表
			List<ExContainer> list2 = containerService.getExContainerListInShip(vscd,vsvy,vsdr,usertype,lncd,caag,ordertype);
			znum=0;
			bnum=0;

			if(list2!=null){
				for(int i=0;i<list2.size();i++){
					ints=list2.get(i).getInts();

					if("Z".equals(ints)){
						znum++;
					}
					if("B".equals(ints)){
						bnum++;
					}
				}
				jo.put("list2",list2);
			}else{
				jo.put("list2",null);
			}
			JSONObject jot2=new JSONObject();
			jot2.put("znum",znum);
			jot2.put("bnum",bnum);
			jo.put("total2",jot2);

			r.setData(jo);
			r.setFlag(true);

		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 { "caag": "CNC", "ordertype": "PORT"}
	 */
	@ApiOperation(value = " 货代在场出口箱列表", notes = "根据货代列出该货代的在场的出口箱")
	@RequestMapping(value = "/exyardcontainerlist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getExYardContainerListByCaag(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		try {
			String caag=Utils.getFillStr(p.getString("caag"),"R",6," ");
			//排序方式：空，默认ISPASS/PORT港口/CNTRID箱号/VSVY船名航次/CTSZ尺寸/ISPASS按扣留/放行
			String ordertype=p.getString("ordertype");

			int rNum=0;//放行数量
			int hNum=0;//扣留数量

			List<Container> list = containerService.getExYardContainerListByCaag(caag,ordertype);

			if(list!=null){
				for(int i=0;i<list.size();i++){
					if("R".equals(list.get(i).getIsportpass())){
						rNum++;
					}else{
						hNum++;
					}
				}

				JSONObject jo=new JSONObject();
				jo.put("list",list);

				JSONObject jot=new JSONObject();
				jot.put("rnum",rNum);
				jot.put("hnum",hNum);
				jo.put("total",jot);
				r.setData(jo);
			}
			r.setFlag(true);

		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
		}
		return r;
	}

	/*
	 * 调用 {"cntrid": "OOLU1448337"}
	 */
	@ApiOperation(value = "在场单箱信息", notes = "在场单箱信息查询")
	@RequestMapping(value = "/yardcontainerinfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getYardContainerInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		Map<String,String> map = Utils.breakCntr(p.getString("cntrid"));
		try {
			Container c = containerService.getYardContainerInfo(map.get("ctpf"),map.get("ctnr"),map.get("ctck"));
			r.setFlag(true);
			r.setData(c);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 调用 {"accd": "C","jbnr": "33270803","jbns": "1"}
	 */
	@ApiOperation(value = "单箱历史详情", notes = "按作业号查看单箱历史信息详情")
	@RequestMapping(value = "/containerhisdetail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getContainerHisInfo(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		String accd=p.getString("accd");
		String jbnr=p.getString("jbnr");
		String jbns=p.getString("jbns");
		try {
			ContainerHis c = containerService.getContainerHisInfo(accd,jbnr,jbns);
			r.setFlag(true);
			r.setData(c);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 调用 {"cntrid": "OOLU1448337"}
	 */
	@ApiOperation(value = "单箱历史列表", notes = "查看单箱历史列表")
	@RequestMapping(value = "/containerhislist", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getContainerHisList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		Map<String,String> map = Utils.breakCntr(p.getString("cntrid"));
		try {
			List<ContainerHis> c = containerService.getContainerHisList(map.get("ctpf"),map.get("ctnr"),map.get("ctck"));
			r.setFlag(true);
			r.setData(c);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}

	/*
	 * 调用 {"accd": "C","jbnr": "33270803","jbns": "1"}
	 */
	@ApiOperation(value = "某一单箱历史对应的提单信息列表", notes = "单箱某一历史记录对应的提单信息列表")
	@RequestMapping(value = "/containerhiscabl", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public CallResult getBLList(@RequestBody JSONObject p) {
		CallResult r = new CallResult();
		String accd=p.getString("accd");
		String jbnr=p.getString("jbnr");
		String jbns=p.getString("jbns");
		try {
			List<BLInfo> c = containerService.getBLList(accd,jbnr,jbns);
			r.setFlag(true);
			r.setData(c);
		} catch (Exception e) {
			r.setFlag(false);
			r.setErrMsg(e.getMessage());
			e.printStackTrace();
		}
		return r;
	}
}
