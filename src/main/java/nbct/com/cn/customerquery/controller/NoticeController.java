package nbct.com.cn.customerquery.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.CallStatistics;
import nbct.com.cn.customerquery.annotation.NBCTWebFunction;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.Notice;
import nbct.com.cn.customerquery.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "公告维护")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class NoticeController {

  @Autowired
  NoticeService noticeService;

  /**
   * 公告新增
   * 
   * @param p
   * @return
   */

  @TokenCheck
  @CallStatistics(NBCTWebFunction.UPDATENOTICE)
  @ApiOperation(value = "公告更新", notes = "公告更新")
  @RequestMapping(value = "/updatenotice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult updateNotice(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String content = p.getString("content");
    String dttr = p.getString("dttr");
    // 写公告信息
    Notice notice = new Notice();
    notice.setContent(content);
    notice.setDttr(dttr);
    int count = noticeService.updateNotice(notice);
    if (count < 1) {
      r.setFlag(false);
      r.setErrMsg("添加公告失败");
    } else {
      r.setFlag(true);
      r.setOutMsg("添加公告成功");
    }
    return r;
  }

  /**
   * 获得所有公告
   * 
   * @return
   */
  @CallStatistics(NBCTWebFunction.GETNOTICES)
  @ApiOperation(value = "获得公告", notes = "获得公告")
  @RequestMapping(value = "/getnotices", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult getNotices() {
    CallResult r = new CallResult();
    List<Notice> notices = noticeService.getNotices();
    if (notices.size() != 0) {
      r.setFlag(true);
      JSONObject data = new JSONObject();
      data.put("notices", notices);
      r.setData(data);
    } else {
      r.setFlag(false);
      r.setErrMsg("获取所有公告信息失败");
    }
    return r;
  }

}