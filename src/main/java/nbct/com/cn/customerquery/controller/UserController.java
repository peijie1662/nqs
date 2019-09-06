package nbct.com.cn.customerquery.controller;


import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import nbct.com.cn.customerquery.entity.CallResult;
import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 用户相关操作
 * 使用RESTful api
 * RequestMethod{
 *      GET  筛选出
 *      POST 新增
 *      PUT 修改
 *      DELETE 删除
 * }
 * @author sdw
 * @version 2019-09-05 12:53
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
     * @param user
     * @return
     */
    @ApiOperation(value = "用户新增", notes = "用户新增")
    @ApiImplicitParam(name = "user", required = true, dataType = "User")
    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public CallResult addUser(@RequestBody User user) {
        CallResult r = new CallResult();
        user.setOpDate(new Date());
        userService.addUser(user);
        r.setFlag(true);
        r.setOutMsg("新增成功");
        return r;
    }

    /**
     *用户修改
     * @param user
     * @return
     * 密码字段不为空时,为修改秘密,只更新秘密
     * 密码字段为空,为修改用户信息,更新用户信息不包括密码
     */
    @ApiOperation(value = "用户修改",notes = "用户信息修改")
    @ApiImplicitParam(name = "user", required = true,dataType = "User")
    @RequestMapping(value = "/user",method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
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
     * @param p
     * @return
     */

    @ApiOperation(value = "用户删除",notes = "用户删除")
    @RequestMapping(value="/user", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    public CallResult updateUser(@RequestBody JSONObject p) {
        CallResult r = new CallResult();
        String userId = p.getString("userId");
        userService.deleteUser(userId);
        r.setFlag(true);
        r.setOutMsg("删除用户成功");
        return r;
    }

}
