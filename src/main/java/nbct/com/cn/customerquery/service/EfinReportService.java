package nbct.com.cn.customerquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.EfinReport;
import nbct.com.cn.customerquery.entity.EfinReportFile;
import nbct.com.cn.customerquery.mapper.web.EfinReportMapper;

/**
 * @author sdw
 * @version 20190923
 */
@Service
public class EfinReportService {

  @Autowired
  EfinReportMapper efinReportMapper;

  /**
   * 获得文件列表信息
   * 
   * @param fnPyCocd
   * @param dtbg
   * @return
   */
  public List<EfinReport> getEfinReport(String fnPyCocd, String dtbg) {
    return efinReportMapper.getEfinReport(fnPyCocd, dtbg);
  }

  /**
   * 获得下载的文件数据
   * 
   * @param fnPyCocd
   * @param skey
   * @return
   */
  public EfinReportFile getEfinReportFile(String fnPyCocd, String skey) {
    return efinReportMapper.getEfinReportFile(fnPyCocd, skey);
  }
}
