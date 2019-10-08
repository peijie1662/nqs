package nbct.com.cn.customerquery.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.annotation.CallStatistics;
import nbct.com.cn.customerquery.annotation.NBCTWebFunction;
import nbct.com.cn.customerquery.annotation.TokenCheck;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.entity.UserPasswordChange;
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
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
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
  @TokenCheck
  @CallStatistics(NBCTWebFunction.ADDUSER)
  @ApiOperation(value = "用户新增", notes = "用户新增")
  @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult addUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    // 设置用户信息
    User user = new User();
    user.setUserId(p.getString("userId"));
    user.setUserName(p.getString("userName"));
    user.setUserType(p.getString("userType"));
    user.setTelephone(p.getString("telephone"));
    user.setAddress(p.getString("address"));
    user.setCompany(p.getString("company"));
    user.setCompanyId(p.getString("companyId"));
    user.setGroups(p.getString("groups"));
    user.setOpUser(p.getString("opUser"));
    user.setOpDate(new Date());
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
  @TokenCheck
  @CallStatistics(NBCTWebFunction.EDITUSER)
  @ApiOperation(value = "用户修改", notes = "用户信息修改")
  @RequestMapping(value = "/edituser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult editUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    User user = new User();
    user.setUserId(p.getString("userId"));
    user.setUserName(p.getString("userName"));
    user.setUserType(p.getString("userType"));
    user.setTelephone(p.getString("telephone"));
    user.setAddress(p.getString("address"));
    user.setCompany(p.getString("company"));
    user.setCompanyId(p.getString("companyId"));
    user.setGroups(p.getString("groups"));
    user.setOpUser(p.getString("opUser"));
    user.setOpDate(new Date());
    logger.info(user.toString());
    int reslut = userService.updateUser(user);

    if (reslut != 0) {
      r.setFlag(true);
      r.setOutMsg("修改用户信息成功!");
    } else {
      r.setFlag(false);
      r.setErrMsg("修改用户信息失败!找不到该用户");
    }

    return r;
  }

  /**
   * 用户修改密码
   * 
   * @param p
   * @return
   */
  @TokenCheck
  @CallStatistics(NBCTWebFunction.CHANGEPWUSER)
  @ApiOperation(value = "用户修改密码", notes = "用户修改密码")
  @RequestMapping(value = "/changepwuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult changePwUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String userId = p.getString("userId");
    String opUser = p.getString("opUser");
    String oldPassword = p.getString("oldPassword");
    String newPassword = p.getString("newPassword");
    UserPasswordChange userPasswordChange = new UserPasswordChange();
    userPasswordChange.setNewPassword(newPassword);
    userPasswordChange.setOldPassword(oldPassword);
    userPasswordChange.setUserId(userId);
    userPasswordChange.setOpUser(opUser);
    userPasswordChange.setOpDate(new Date());
    int result = userService.changeUserPassword(userPasswordChange);
    if (result != 0) {
      r.setFlag(true);
      r.setOutMsg("修改密码成功");
    } else {
      r.setFlag(false);
      r.setErrMsg("修改用户密码失败!找不到该用户或者原始密码不正确");
    }
    return r;
  }

  /**
   * 用户重置密码
   * 
   * @param p
   * @return
   */
  @TokenCheck
  @CallStatistics(NBCTWebFunction.RESETPWUSER)
  @ApiOperation(value = "用户重置密码", notes = "用户重置密码")
  @RequestMapping(value = "/resetpwuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult resetPwUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String userId = p.getString("userId");
    String opUser = p.getString("opUser");
    UserPasswordChange userPasswordChange = new UserPasswordChange();
    userPasswordChange.setNewPassword("e99a18c428cb38d5f260853678922e03");
    userPasswordChange.setOldPassword("");
    userPasswordChange.setUserId(userId);
    userPasswordChange.setOpUser(opUser);
    userPasswordChange.setOpDate(new Date());
    int result = userService.changeUserPassword(userPasswordChange);

    if (result != 0) {

      r.setFlag(true);
      r.setOutMsg("重置密码成功");
    } else {
      r.setFlag(false);
      r.setErrMsg("找不到改用户");
    }
    return r;
  }

  /**
   * 用户删除
   * 
   * @param p
   * @return
   */
  @TokenCheck
  @CallStatistics(NBCTWebFunction.DELETEUSER)
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

  /**
   * 获得单一用户信息
   * 
   * @param p
   * @return
   */
  @TokenCheck
  @CallStatistics(NBCTWebFunction.GETUSER)
  @ApiOperation(value = "获得单一用户信息", notes = "获得单一用户信息")
  @RequestMapping(value = "/getuser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public CallResult getUser(@RequestBody JSONObject p) {
    CallResult r = new CallResult();
    String userId = p.getString("userId");

    User user = userService.getUser(userId);
    if (user != null) {
      r.setFlag(true);
      JSONObject data = new JSONObject();
      data.put("user", user);
      r.setData(data);
    } else {
      r.setFlag(false);
      r.setErrMsg("找不到该用户信息");
    }
    return r;
  }

  /**
   * 获得所有用户信息
   * 
   * @return
   */
  @TokenCheck
  @CallStatistics(NBCTWebFunction.GETUSERS)
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
