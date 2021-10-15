/**  
 * 
 * @Title:  UserDao.java   
 * @Package dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 10:49:10
 * @version V1.0 
 * 
 * 
 */
package dao;

import entity.User;

/**
 * @author 10217
 *
 */
public interface UserDao {
	//µÇÂ¼
	public User getUserByName(String name);
}
