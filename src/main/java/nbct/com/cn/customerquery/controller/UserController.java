package nbct.com.cn.customerquery.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 用户相关操作
 * 
 * @author sdw
 * @version 2019-09-05 12:53
 * 
 */
@Api(value = "用户维护")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(Login.class);

  @Autowired
  UserService userService;

  /**
   * 新增用户
   * 
   * @param user
   * @return
   */
  @ApiOperation(value = "用户新增", notes = "用户新增")
  // @TokenCheck
  @ApiImplicitParam(name = "user", required = true, dataType = "User")
  @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult addUser(@RequestBody User user) {
    CallResult r = new CallResult();
    user.setOpDate(new Date());
    user.setPassword("e99a18c428cb38d5f260853678922e03");// 设置默认密码abc123
    logger.info(user.toString());
    userService.addUser(user);
    r.setFlag(true);
    r.setOutMsg("新增成功");
    return r;
  }

  /**
   * 用户修改
   * 
   * @param user
   * @return 密码字段不为空时,为修改秘密,只更新秘密 密码字段为空,为修改用户信息,更新用户信息不包括密码
   */
  @ApiOperation(value = "用户修改", notes = "用户信息修改")
  @ApiImplicitParam(name = "user", required = true, dataType = "User")
  @RequestMapping(value = "/edituser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult editUser(@RequestBody User user) {
    CallResult r = new CallResult();
    user.setOpDate(new Date());
    userService.updateUser(user);
    r.setFlag(true);
    if (user.getPassword().isEmpty()) {
      r.setOutMsg("修改用户信息成功");
    } else {
      r.setOutMsg("修改用户密码成功");
    }
    return r;
  }

  /**
   * 用户删除
   * 
   * @param p
   * @return
   */

  @ApiOperation(value = "用户删除", notes = "用户删除")
  @RequestMapping(value = "/deleteuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult updateUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String userId = p.getString("userId");
    userService.deleteUser(userId);
    r.setFlag(true);
    r.setOutMsg("删除用户成功");
    return r;
  }

  @ApiOperation(value = "获得单一用户信息", notes = "获得单一用户信息")
  @RequestMapping(value = "/getuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult getUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String userId = p.getString("userId");

    User user = userService.getUser(userId);
    if (user != null) {
      r.setFlag(true);
      JSONObject data = new JSONObject();
      user.setPassword("");
      data.put("user", user);
      r.setData(data);
    } else {
      r.setFlag(false);
      r.setErrMsg("找不到该用户信息");
    }
    return r;
  }

  @ApiOperation(value = "获得所有用户信息", notes = "获得所有用户信息")
  @RequestMapping(value = "/getusers", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult getUsers() {
    CallResult r = new CallResult();

    List<User> users = userService.getUsers();
    if (users.size() != 0) {
      r.setFlag(true);
      JSONObject data = new JSONObject();
      data.put("users", users);
      r.setData(data);
    } else {
      r.setFlag(false);
      r.setErrMsg("获取所有用户信息失败");
    }
    return r;
  }

}