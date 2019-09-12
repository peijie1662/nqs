package nbct.com.cn.customerquery.mapper.web;

import nbct.com.cn.customerquery.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author sdw
 * @version 创建时间:2019-07-06 12:37
 */

public interface UserMapper {
  /**
   * 用户新增
   */
  void addUser(User user);

  /**
   * 用户信息修改
   */
  void updateUser(User user);

  /**
   * 用户删除
   */
  void deleteUser(@Param("userId") String userId);

  /**
   * 获得用户信息
   */
  User getUser(@Param("userId") String userId);

  /**
   * 获得所有用户信息
   * 
   * @return
   */
  List<User> getUsers();

}