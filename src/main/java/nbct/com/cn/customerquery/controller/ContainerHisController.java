package nbct.com.cn.customerquery.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.EmptyContainerInYardHis;
import nbct.com.cn.customerquery.service.ContainerHisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "集装箱历史AS400DL库")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ContainerHisController {
  private static final Logger logger = LoggerFactory.getLogger(Login.class);

  @Autowired
  ContainerHisService containerHisService;

  @ApiOperation(value = "获得集装箱在场空箱历史", notes = "获得集装箱在场空箱历史")
  @RequestMapping(value = "/getemptycontainerinyardhis", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult getEmptyContainerInYardHis(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    JSONObject data = new JSONObject();

    String dtbg = p.getString("dtbg");
    String dted = p.getString("dted");
    String lncd = p.getString("lncd");

    List<EmptyContainerInYardHis> EmptyContainerInYardHises = containerHisService.getEmptyContainerInYardHis(dtbg, dted,
        lncd);
    if (EmptyContainerInYardHises.size() != 0) {
      r.setFlag(true);

      data.put("eCTInHis", EmptyContainerInYardHises);
      r.setData(data);
    } else {
      r.setFlag(true);
      data.put("eCTInHis", "[]");
      r.setData(data);
    }
    return r;
  }

}