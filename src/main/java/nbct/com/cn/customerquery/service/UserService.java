package nbct.com.cn.customerquery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nbct.com.cn.customerquery.entity.User;
import nbct.com.cn.customerquery.entity.UserPasswordChange;
import nbct.com.cn.customerquery.mapper.web.UserMapper;
import java.util.List;

/**
 * 用户新增\用户信息修改
 *
 * @author sdw
 * @version 创建时间：2019年9月5日 12:47
 */

@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  /**
   * 新增用户
   * 
   * @param user
   */
  public void addUser(User user) {
    userMapper.addUser(user);
  }

  /**
   * 用户信息修改
   * 
   * @param user
   */
  public int updateUser(User user) {
    return userMapper.updateUser(user);
  }

  /**
   * 用户删除
   * 
   * @param userId
   */
  public void deleteUser(String userId) {
    userMapper.deleteUser(userId);
  }

  /**
   * 获得用户信息
   * 
   * @param userId
   * @return
   */
  public User getUser(String userId) {
    return userMapper.getUser(userId);
  }

  /**
   * 获得所有用户信息
   * 
   * @return
   */
  public List<User> getUsers() {
    return userMapper.getUsers();
  }

  /**
   * 修改密码
   * 
   * @param userPasswordChange
   * @return
   */
  public int changeUserPassword(UserPasswordChange userPasswordChange) {
    return userMapper.changeUserPassword(userPasswordChange);
  }
}