/**  
 * 
 * @Title:  UserDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 16:07:56
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
public class UserDaoImpl extends BaseDao implements UserDao {
	// ×¢²á
	@Override
	public Integer userRegist(User user) {
		String sql = "insert into `sysuser`(userName,userPwd) values(?,?)";
		Object[] params = { user.getUserName(), user.getUserPwd() };
		Integer result = this.executeUpdate(sql, params);
		return result;
	}
	//µÇÂ¼
	@Override
	public User getUserByName(String name) {
		
		return null;
	}

}
