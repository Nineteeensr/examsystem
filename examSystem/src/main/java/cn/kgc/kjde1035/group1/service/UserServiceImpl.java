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
	 * ע��
	 */
	@Override
	public Boolean regist(Sysuser user) {
		// ����
		String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
		user.setUserPwd(newPwd);
		Integer result = userDao.userRegist(user);
		if (result > 0) {// ע��ɹ�
			return true;
		} else {// ע��ʧ��
			return false;
		}

	}

	/**
	 * ��¼
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
	 * ��ʼ���û��б�
	 */
	@Override
	public List<SysFunction> initpage(Sysuser user) {
		return userDao.initpage(user);
	}

	/**
	 * ѧ����¼
	 */
	@Override
	public Sysuser stulogin(Sysuser user) {
		String newPwd = MD5Utils.stringToMD5(user.getUserPwd());
		user.setUserPwd(newPwd);
		return userDao.stulogin(user);
	}

	/**
	 * ϵͳ�����û�
	 */
	@Override
	public Integer add(Sysuser user) {
		return userDao.add(user);
	}

	/**
	 * ���û���
	 */
	@Override
	public Integer getTotalCount(String usname, Integer roleId, String userTrueName) {
		// TODO Auto-generated method stub
		return userDao.getTotalCount(usname, roleId, userTrueName);
	}

	/**
	 * ��ȡ�û��б�
	 */
	@Override
	public List<Sysuser> getAllUserLimit(String usname, Integer roleId, String userTrueName, Integer currentPageNo,
			Integer pageSize) {
		return userDao.getUserByLimit(usname, roleId, userTrueName, currentPageNo, pageSize);
	}

	/**
	 * ��ȡ�û���ϸ��Ϣ
	 */
	@Override
	public Sysuser detail(Sysuser user) {
		return userDao.detail(user);
	}

	/**
	 * ����Ա�޸��û�����
	 */
	@Override
	public Integer editpwd(Sysuser user) {
		return userDao.editpwd(user);
	}

	/**
	 * �޸��û�
	 */
	@Override
	public Integer edit(Sysuser user) {
		// ����
		String MD5Pwd = MD5Utils.stringToMD5(user.getUserPwd());
		user.setUserPwd(MD5Pwd);
		return userDao.edit(user);
	}

	/**
	 * �����ֻ��Ż�ȡ�û���Ϣ
	 */
	@Override
	public Sysuser findUserInfo(Sysuser user) {
		
		return userDao.findUserInfo(user);
	}
	/**
	 * ��������
	 */
	@Override
	public Integer forgetPwd(Sysuser user) {
		String MD5Pwd = MD5Utils.stringToMD5(user.getUserPwd());
		user.setUserPwd(MD5Pwd);
		return userDao.forgetPwd(user);
	}

	@Override
	public List<Sysuser> getClazzInfo() {
		// TODO Auto-generated method stub
		return userDao.getClazzInfo();
	}

}
