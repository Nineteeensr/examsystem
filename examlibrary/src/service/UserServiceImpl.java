/**  
 * 
 * @Title:  UserServiceImpl.java   
 * @Package service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 10:54:44
 * @version V1.0 
 * 
 * 
 */
package service;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

/**
 * @author 10217
 *
 */
public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public Boolean login(String name, String password) {
		User result = userDao.getUserByName(name);
		if(result!=null) {
			return true;
		}else {
			return false;
		}
	}

}
