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

import cn.kgc.kjde1035.group1.dao.UserDao;
import cn.kgc.kjde1035.group1.dao.UserDaoImpl;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysuser;

import cn.kgc.kjde1035.group1.utils.MD5Utils;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * @author 10217
 *
 */
public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	/**
	 * 注册
	 */
	@Override
	public Boolean regist(Sysuser user) {
		// 加密
		String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
		user.setUserPwd(newPwd);
		Integer result = userDao.userRegist(user);
		if (result > 0) {// 注册成功
			return true;
		} else {// 注册失败
			return false;
		}

	}

	/**
	 * 登录
	 */
	@Override
	public Sysuser login(Sysuser user) {
		Sysuser result = null;
		result = userDao.login(user);
		if (result != null) {
			String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
			if (result.getUserPwd().equals(newPwd)) {
				return result;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 初始化用户列表
	 */
	@Override
	public List<SysFunction> initpage(Sysuser user) {
		return userDao.initpage(user);
	}

	/**
	 * 学生登录
	 */
	@Override
	public Sysuser stulogin(Sysuser user) {
		return userDao.stulogin(user);
	}

	/**
	 * 系统新增用户
	 */
	@Override
	public Integer add(Sysuser user) {
		return userDao.add(user);
	}

	/**
	 * 总用户数
	 */
	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return userDao.getTotalCount();
	}

	/**
	 * 获取用户列表
	 */
	@Override
	public List<Sysuser> getAllUserLimit(Integer currentPageNo, Integer pageSize) {
		return userDao.getUserByLimit(currentPageNo, pageSize);
	}

	/**
	 * 获取用户详细信息
	 */
	@Override
	public Sysuser detail(Sysuser user) {
		return userDao.detail(user);
	}

	/**
	 * 管理员修改用户密码
	 */
	@Override
	public Integer editpwd(Sysuser user) {
		return userDao.editpwd(user);
	}
	
	/**
	 * 修改用户
	 */
	@Override
	public Integer edit(Sysuser user) {
		return userDao.edit(user);
	}

}
