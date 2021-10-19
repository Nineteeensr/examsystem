/**  
 * 
 * @Title:  UserService.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 16:05:56
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * @author 10217
 *
 */
public interface UserService {
	// 注册
	public Boolean regist(Sysuser user);

	// 登录
	public Sysuser login(Sysuser user);

	// 初始化用户列表
	public List<SysFunction> initpage(Sysuser user);

	// 学生登录
	public Sysuser stulogin(Sysuser user);

	// 系统新增用户
	public Integer add(Sysuser user);

	// 获取用户列表
	public List<Sysuser> getAllUserLimit(String usname,Integer roleId,String userTrueName,Integer currentPageNo, Integer pageSize);

	// 获取总用户数
	public Integer getTotalCount(String usname,Integer roleId,String userTrueName);

	// 获取用户详细信息
	public Sysuser detail(Sysuser user);
	
	// 修改用户密码
	public Integer editpwd(Sysuser user);
	
	// 修改用户
	public Integer edit(Sysuser user);
}
