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

import java.util.List;

import cn.kgc.kjde1035.group1.dao.IUserDao;
import cn.kgc.kjde1035.group1.dao.UserDaoImpl;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Sysuser;

import cn.kgc.kjde1035.group1.utils.MD5Utils;

/**
 * @author 10217
 *
 */
public class UserServiceImpl implements UserService {
	IUserDao userDao = new UserDaoImpl();

	/**
	 * ×¢²á
	 */
	@Override
	public Boolean regist(Sysuser user) {
		//¼ÓÃÜ
		String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
		Integer result = userDao.userRegist(user);
		if (result > 0) {// ×¢²á³É¹¦
			return true;
		} else {// ×¢²áÊ§°Ü
			return false;
		}

	}
	/**
	 * µÇÂ¼
	 */
	@Override
	public Boolean login(Sysuser user) {
		Sysuser result = userDao.login(user);
		if(result!=null) {
			String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
			if(result.getUserPwd().equals(newPwd)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	

}
