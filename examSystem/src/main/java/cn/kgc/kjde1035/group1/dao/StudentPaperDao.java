/**  
 * 


 * @Title:  StudentPaperDao.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:35:58
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface StudentPaperDao {
	//ѧ���ύ��
	public Integer addPaper(Studentpaper studentpaper);
	//��ȡ�ܼ�¼��
	public Integer getTotalCount(String spId,Integer userId);
	//��ѯѧ�����д����б�
	public  List<Studentpaper> list(String spId,Integer userId,Integer pageNo, Integer pageSize);
}
