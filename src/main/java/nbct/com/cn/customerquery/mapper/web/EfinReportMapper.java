package nbct.com.cn.customerquery.mapper.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.EfinReport;
import nbct.com.cn.customerquery.entity.EfinReportFile;

/**
 * @author SDW
 * @version 20190923 08:47
 */

public interface EfinReportMapper {
  /**
   * 获得对账单数据
   * 
   * @param fnPyCocd
   * @param dtbg
   * @return
   */
  List<EfinReport> getEfinReport(@Param("fnPyCocd") String fnPyCocd, @Param("dtbg") String dtbg);

  /**
   * 获得下载数据
   * 
   * @param skey
   * @param fnPyCocd
   * @return
   */
  EfinReportFile getEfinReportFile(@Param("fnPyCocd") String fnPyCocd, @Param("skey") String skey);
}