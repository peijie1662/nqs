package nbct.com.cn.customerquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.EmptyContainerInYardHis;
import nbct.com.cn.customerquery.mapper.as400dl.*;
import java.util.List;

/**
 * as400DL庫中歷史查詢
 */
@Service
public class ContainerHisService {

  @Autowired
  ContainerHisMapper containerHisMapper;

  /**
   * 
   * @param dtbg
   * @param dted
   * @param lncd
   * @return
   */
  public List<EmptyContainerInYardHis> getEmptyContainerInYardHis(String dtbg, String dted, String lncd) {
    return containerHisMapper.getEmptyContainerInYardHis(dtbg, dted, lncd);
  }

}