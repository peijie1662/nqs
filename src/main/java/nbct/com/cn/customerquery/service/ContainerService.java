package nbct.com.cn.customerquery.service;

import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import nbct.com.cn.customerquery.entity.*;
import oracle.net.nl.NLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nbct.com.cn.customerquery.mapper.qry.ContainerInfoMapper;
import nbct.com.cn.customerquery.mapper.qry.VoyageContainerMapper;

import java.util.List;

/**
 * @author PJ
 * @version 创建时间：2019年7月26日 下午12:35:16
 */
@Service
public class ContainerService {

	@Autowired
	ContainerInfoMapper ciMapper;

	@Autowired
	VoyageContainerMapper vcMapper;

	/**
	 * 单箱主信息
	 */
	public ContainerInfo getContainerInfo(String cntrId) {
		ContainerInfo ci = ciMapper.getMainContainerInfo(cntrId);
		// 1.海关放行
		String customRelease = this.getCustomRelease(ci.getCurvscd(), ci.getCurvsvy(), ci.getCurvsdr(), ci.getCntrId());
		if (customRelease == null) {
			ci.setCustomRelease("N");
		} else {
			ci.setCustomRelease("Y");
		}
		// 2.出口箱码头放行
		if ("E".equals(ci.getCurvsdr())) {
			String terminalRelease = this.getTerminalRelease(ci.getCurvscd(), ci.getCurvsvy(), ci.getCntrId());
			if (terminalRelease == null) {
				ci.setTerminalRelease("N");
			} else {
				ci.setTerminalRelease("Y");
			}
		} else {
			ci.setTerminalRelease(" ");
		}
		// 3.提单
		String cabl = this.getCabl(ci.getCurvscd(), ci.getCurvsvy(), ci.getCurvsdr(), ci.getCntrId());
		if (cabl == null) {
			ci.setCabl(" ");
		} else {
			ci.setCabl(cabl);
		}
		// 4.VGM
		ContainerInfo tc = ciMapper.getVgm(ci.getCurvscd(), ci.getCurvsvy(), ci.getCurvsdr(), ci.getCntrId());
		if (tc != null) {
			ci.setWeighingWayVGM(tc.getWeighingWayVGM());
			ci.setWeightVGM(tc.getWeightVGM());
			ci.setSignVGM(tc.getSignVGM());
		}
		return ci;
	}

	/**
	 * 单箱海关放行信息
	 */
	public String getCustomRelease(String vscd, String vsvy, String vsdr, String cntrId) {
		return ciMapper.getCustomRelease(vscd, vsvy, vsdr, cntrId);
	}

	/**
	 * 单箱码头放行信息
	 */
	public String getTerminalRelease(String vscd, String vsvy, String cntrId) {
		return ciMapper.getTerminalRelease(vscd, vsvy, cntrId);
	}

	/**
	 * 提单
	 */
	public String getCabl(String vscd, String vsvy, String vsdr, String cntrId) {
		return ciMapper.getCabl(vscd, vsvy, vsdr, cntrId);
	}

	/**
	 * VGM
	 */
	public ContainerInfo getVgm(String vscd, String vsvy, String vsdr, String cntrId) {
		return ciMapper.getVgm(vscd, vsvy, vsdr, cntrId);
	}

	/**
	 * 航次列表
	 */
	public List<Voyage> getVoyageList(String vsvy, String vsdr, String lncd){
		return vcMapper.getVoyageList(vsvy,vsdr,lncd);

/*    List<Voyage> list = commonMapper.getVoyageList(vsvy,vsdr,lncd);
    for(Voyage v:list){
      v.setCnnmvr();
    }
    return list;*/
	}

	/**
	 * 船公司进口箱清单
	 */
	public List<ImContainer> getImContainerList(String vscd,String vsvy, String vsdr, String lncd,String ordertype){
		String crcd="";
		String plncd="";

		//船舶经营人

		if ("YLIAN".equals(vscd)){
			if(vsvy.trim().matches("2*N")){
				crcd="FDS";
			}
			if(vsvy.trim().matches("4*N")){
				crcd="MAR";
			}
		}else{
			crcd=vcMapper.getCrcd(vscd);
		}

		//船舶经营人的母公司代码
		if(!"".equals(crcd)){
			plncd=vcMapper.getParentLncd(crcd);
		}

		//传入的船舶的经营人=传入的箱主 或 传入的船舶的经营人的母公司=传入的箱主 或 传入的箱主=YYY
		if((crcd.equals(lncd))||(plncd!=null&&plncd.equals(lncd))||"YYY".equals(lncd)){
			return vcMapper.getImContainerList(vscd,vsvy,vsdr,"",ordertype);
		}else {
			if(lncd!=null&&lncd!=""){
				return vcMapper.getImContainerList(vscd,vsvy,vsdr,lncd,ordertype);
			}else{//lncd="",不能查询
				return null;
			}
		}
	}

	/**
	 * 船公司/货代出口箱清单-未装船
	 */
	public List<ExContainer> getExContainerListInYard(String vscd,String vsvy, String vsdr, String usertype, String lncd, String caag,String ordertype){
		String crcd="";
		String plncd="";

		if("V".equals(usertype)){//船公司
			//船舶经营人
			if ("YLIAN".equals(vscd)){
				if(vsvy.trim().matches("2*N")){
					crcd="FDS";
				}
				if(vsvy.trim().matches("4*N")){
					crcd="MAR";
				}
			}else{
				crcd=vcMapper.getCrcd(vscd);
			}

			//船舶经营人的母公司代码
			if(!"".equals(crcd)){
				plncd=vcMapper.getParentLncd(crcd);
			}
			//传入的船舶的经营人=传入的箱主 或 传入的船舶的经营人的母公司=传入的箱主 或 传入的箱主=YYY
			if((crcd.equals(lncd))||(plncd!=null&&plncd.equals(lncd))||"YYY".equals(lncd)){
				return vcMapper.getExContainerListInYard(vscd,vsvy,vsdr,usertype,"","",ordertype);
			}else {
				if(lncd!=null&&lncd!=""){
					return vcMapper.getExContainerListInYard(vscd,vsvy,vsdr,usertype,lncd,"",ordertype);
				}else{//lncd="",不能查询
					return null;
				}
			}
		}
		else if("H".equals(usertype)){//货代
			if("YYY".equals(caag)){
				return vcMapper.getExContainerListInYard(vscd,vsvy,vsdr,usertype,"","",ordertype);
			}else{
				if(caag!=null&&caag!=""){
					return vcMapper.getExContainerListInYard(vscd,vsvy,vsdr,usertype,"",caag,ordertype);
				}else{//caag="",不能查询
					return null;
				}
			}

		}else{
			return null;
		}
	}

	/**
	 * 船公司/货代出口箱清单-已装船
	 */
	public List<ExContainer> getExContainerListInShip(String vscd,String vsvy, String vsdr, String usertype, String lncd, String caag,String ordertype){
		String crcd="";
		String plncd="";

		if("V".equals(usertype)){//船公司
			//船舶经营人
			if ("YLIAN".equals(vscd)){
				if(vsvy.trim().matches("2*N")){
					crcd="FDS";
				}
				if(vsvy.trim().matches("4*N")){
					crcd="MAR";
				}
			}else{
				crcd=vcMapper.getCrcd(vscd);
			}

			//船舶经营人的母公司代码
			if(!"".equals(crcd)){
				plncd=vcMapper.getParentLncd(crcd);
			}
			//传入的船舶的经营人=传入的箱主 或 传入的船舶的经营人的母公司=传入的箱主 或 传入的箱主=YYY
			if((crcd.equals(lncd))||(plncd!=null&&plncd.equals(lncd))||"YYY".equals(lncd)){
				return vcMapper.getExContainerListInShip(vscd,vsvy,vsdr,usertype,"","",ordertype);
			}else {
				if(lncd!=null&&lncd!=""){
					return vcMapper.getExContainerListInShip(vscd,vsvy,vsdr,usertype,lncd,"",ordertype);
				}else{//lncd="",不能查询
					return null;
				}
			}
		}
		else if("H".equals(usertype)){//货代
			if("YYY".equals(caag)){
				return vcMapper.getExContainerListInShip(vscd,vsvy,vsdr,usertype,"","",ordertype);
			}else{
				if(caag!=null&&caag!=""){
					return vcMapper.getExContainerListInShip(vscd,vsvy,vsdr,usertype,"",caag,ordertype);
				}else{//caag="",不能查询
					return null;
				}
			}

		}else{
			return null;
		}
	}

	/**
	 *货代在场出口箱
	 */
	public List<Container> getExYardContainerListByCaag(String caag, String ordertype) {
		return vcMapper.getExYardContainerListByCaag(caag, ordertype);
	}

}
