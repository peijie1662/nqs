package nbct.com.cn.customerquery.mapper.qry;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.OrderReceive;

/**
 * @author PJ
 * @version 创建时间：2019年7月22日 上午10:45:41 类说明
 */
public interface CommonMapper {

	/**
	 * 接单公告
	 */
	List<OrderReceive> getOrderReceive(@Param("dt") int dt);

	/**
	 * 在场集卡列表
	 */
	List<YardTruckList> getYardTruckList();
}
