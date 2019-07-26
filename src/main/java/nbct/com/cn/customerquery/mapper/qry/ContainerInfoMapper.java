package nbct.com.cn.customerquery.mapper.qry;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.ContainerInfo;

/**
 * @author PJ
 * @version 创建时间：2019年7月25日 下午3:08:30
 */
public interface ContainerInfoMapper {

	/**
	 * 单箱主信息
	 */
	ContainerInfo getMainContainerInfo(@Param("cntrId") String cntrId);

	/**
	 * 单箱海关放行信息
	 */
	String getCustomRelease(@Param("vscd") String vscd, @Param("vsvy") String vsvy, @Param("vsdr") String vsdr,
			@Param("cntrId") String cntrId);

	/**
	 * 单箱码头放行信息
	 */
	String getTerminalRelease(@Param("vscd") String vscd, @Param("vsvy") String vsvy, @Param("cntrId") String cntrId);

	/**
	 * 单箱提单信息
	 */
	String getCabl(@Param("vscd") String vscd, @Param("vsvy") String vsvy, @Param("vsdr") String vsdr,
			@Param("cntrId") String cntrId);
	
	/**
	 * VGM信息
	 */
	ContainerInfo getVgm(@Param("vscd") String vscd, @Param("vsvy") String vsvy, @Param("vsdr") String vsdr,
			@Param("cntrId") String cntrId);

}
