/**  
 * 
 * @Title:  UserServiceImpl.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 16:10:11
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import cn.kgc.kjde1035.group1.dao.UserDao;
import cn.kgc.kjde1035.group1.dao.UserDaoImpl;
import cn.kgc.kjde1035.group1.entity.User;
import cn.kgc.kjde1035.group1.utils.MD5Utils;

/**
 * @author 10217
 *
 */
public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	/**
	 * ×¢²á
	 */
	@Override
	public Boolean regist(User user) {
		//¼ÓÃÜ
		String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
		Integer result = userDao.userRegist(user);
		if (result > 0) {// ×¢²á³É¹¦
			return true;
		} else {// ×¢²áÊ§°Ü
			return false;
		}

	}
	

}
