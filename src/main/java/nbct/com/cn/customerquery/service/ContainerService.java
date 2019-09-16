package nbct.com.cn.customerquery.service;

import nbct.com.cn.customerquery.entity.*;
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
}
