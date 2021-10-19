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

import java.sql.SQLException;
import java.util.List;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * @author 10217
 *
 */
public interface UserDao {
	// 注册
	public Integer userRegist(Sysuser user);

	// 登录
	public Sysuser login(Sysuser user);

	// 初始化用户功能列表
	public List<SysFunction> initpage(Sysuser user);

	// 学生登录
	public Sysuser stulogin(Sysuser user);

	// 新增用户
	public Integer add(Sysuser user);

	// 获取用户列表
	public List<Sysuser> getUserByLimit(String usname,Integer roleId,String userTrueName,Integer pageNo, Integer pageSize);

	// 获取总用户数
	public Integer getTotalCount(String usname,Integer roleId,String userTrueName);

	// 获取用户详细信息
	public Sysuser detail(Sysuser user);
	
	// 修改用户密码
	public Integer editpwd(Sysuser user);
	
	// 修改用户
	public Integer edit(Sysuser user);
}
