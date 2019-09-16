package nbct.com.cn.customerquery.service;

import java.util.List;

import nbct.com.cn.customerquery.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.mapper.qry.CommonMapper;
import nbct.com.cn.customerquery.mapper.qry.YardContainerMapper;

/**
 * @author PJ
 * @version 创建时间：2019年7月9日 上午9:08:22
 */
@Service
public class QryService {

  @Autowired
  YardContainerMapper yardContainerMapper;

  @Autowired
  CommonMapper commonMapper;

  //
  public List<Container> getYardContainers() {
    return yardContainerMapper.getYardContainers();
  };

  public List<OrderReceive> getOrderReceives(int dt) {
    return commonMapper.getOrderReceive(dt);
  }

  public List<YardTruck> getYardTruckList() {
    return commonMapper.getYardTruckList();
  }

  public List<CntrInCloseDate> getCntrInCloseDateList(int startdate, int enddate) {
    return commonMapper.getCntrInCloseDateList(startdate, enddate);
  }

  public List<SailingDateNotice> getSailingDateNoticeList(int startdate, int enddate) {
    return commonMapper.getSailingDateNotices(startdate, enddate);
  }

  public ImCustomPassInfo getImCustomPassInfo(String cntrId) {
    return commonMapper.getImCustomPassInfo(cntrId);
  }

  public ExPortPassInfo getExPortPassInfo(String cntrId) {
    return commonMapper.getExPortPassInfo(cntrId);
  }

  public CheckMoveCtnrInfo getCheckMoveCtnrInfo(String cntrId) {
    return commonMapper.getCheckMoveCtnrInfo(cntrId);
  }

}
