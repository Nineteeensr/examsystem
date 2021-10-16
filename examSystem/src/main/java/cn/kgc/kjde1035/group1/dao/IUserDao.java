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

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Sysuser;


/**
 * @author 10217
 *
 */
public interface IUserDao {
	// 注册
	public Integer userRegist(Sysuser user);
	// 根据用户名查找用户信息
	public Sysuser login(Sysuser user);
	/*
	 * //查询所有试卷信息 public List<Paper> getAllPaperInfo();
	 */
}
