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
	// ע��
	public Integer userRegist(Sysuser user);
	// �����û��������û���Ϣ
	public Sysuser login(Sysuser user);
	/*
	 * //��ѯ�����Ծ���Ϣ public List<Paper> getAllPaperInfo();
	 */
}
