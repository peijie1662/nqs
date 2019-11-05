package nbct.com.cn.customerquery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.Notice;
import nbct.com.cn.customerquery.mapper.web.NoticeMapper;

@Service
public class NoticeService {

  @Autowired
  NoticeMapper noticeMapper;

  /**
   * 修改公告
   * 
   * @param notice
   * @return
   */
  public int updateNotice(Notice notice) {
    return noticeMapper.updateNotice(notice);
  }

  /**
   * 获得公告
   * 
   * @return
   */
  public List<Notice> getNotices() {
    return noticeMapper.getNotices();
  }
}