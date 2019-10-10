package nbct.com.cn.customerquery.mapper.web;

import java.util.List;

import nbct.com.cn.customerquery.entity.Notice;

public interface NoticeMapper {

  /**
   * 公告新增
   */
  int addNotice(Notice notice);

  /**
   * 公告查询
   * 
   * @return
   */
  List<Notice> getNotices();
}