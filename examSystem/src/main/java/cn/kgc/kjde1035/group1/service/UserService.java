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
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface UserService {
	// ע��
	public Boolean regist(Sysuser user);
	//��¼
	public Boolean login(Sysuser user);
}
