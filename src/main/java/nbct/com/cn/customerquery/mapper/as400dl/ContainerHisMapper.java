package nbct.com.cn.customerquery.mapper.as400dl;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import nbct.com.cn.customerquery.entity.EmptyContainerInYardHis;

public interface ContainerHisMapper {

  /**
   * 集装箱在场空箱历史查询
   * 
   * @param dtbg 开始日期 20190801
   * @param dted 结束日期 20190830
   * @param lncd 箱主
   * @return
   */
  List<EmptyContainerInYardHis> getEmptyContainerInYardHis(@Param("dtbg") String dtbg, @Param("dted") String dted,
      @Param("lncd") String lncd);
}