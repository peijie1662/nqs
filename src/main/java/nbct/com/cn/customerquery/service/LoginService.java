package nbct.com.cn.customerquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.entity.UserLoginInfo;
import nbct.com.cn.customerquery.mapper.web.LoginMapper;

/**
 * 用户登录
 * 
 * @author PJ
 * @version 创建时间：2019年7月6日 下午7:58:16
 */
@Service
public class LoginService {

  @Autowired
  LoginMapper loginMapper;

  public User findUserById(String userId, String password) {
    return loginMapper.findUserById(userId, password);
  }

  public void userLoginInfo(UserLoginInfo uli) {
    loginMapper.userLoginInfo(uli);
  }
}
