package nbct.com.cn.customerquery.mapper.qry;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.OrderReceive;
import nbct.com.cn.customerquery.entity.YardTruck;
import nbct.com.cn.customerquery.entity.CntrInCloseDate;
import nbct.com.cn.customerquery.entity.SailingDateNotice;

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
	List<YardTruck> getYardTruckList();

	/**
	 * 集装箱进箱截箱时间公告
	 */
	List<CntrInCloseDate> getCntrInCloseDateList(@Param("startdate") int startdate,@Param("enddate") int enddate);

	/**
	 * 船舶预告
	 * 此处是接口文件，函数名与XML文件设置一致
	 */
	List<SailingDateNotice> getSailingDateNotices(@Param("startdate") int startdate,@Param("enddate") int enddate);
}
