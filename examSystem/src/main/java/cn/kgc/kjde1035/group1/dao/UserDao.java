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
	// ע��
	public Integer userRegist(Sysuser user);

	// ��¼
	public Sysuser login(Sysuser user);

	// ��ʼ���û������б�
	public List<SysFunction> initpage(Sysuser user);

	// ѧ����¼
	public Sysuser stulogin(Sysuser user);

	// �����û�
	public Integer add(Sysuser user);

	// ��ȡ�û��б�
	public List<Sysuser> getUserByLimit(String usname, Integer roleId, String userTrueName, Integer pageNo,
			Integer pageSize);

	// ��ȡ���û���
	public Integer getTotalCount(String usname, Integer roleId, String userTrueName);

	// ��ȡ�û���ϸ��Ϣ
	public Sysuser detail(Sysuser user);

	// �޸��û�����
	public Integer editpwd(Sysuser user);

	// �޸��û�
	public Integer edit(Sysuser user);

	// ͨ���ֻ��Ų�ѯ�û���Ϣ
	public Sysuser findUserInfo(Sysuser user);

	// ��������
	public Integer forgetPwd(Sysuser user);
	
	public List<Sysuser> getClazzInfo();
}
