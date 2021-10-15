/**  
 * 
 * @Title:  UserDao.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 16:07:04
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import cn.kgc.kjde1035.group1.entity.User;

/**
 * @author 10217
 *
 */
public interface UserDao {
	// 注册
	public Integer userRegist(User user);
	// 根据用户名查找用户信息
	public User getUserByName(String name);
}
