/**  
 * 
 * @Title:  PaperDao.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:26:59
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public interface PaperDao {
	//ѧ������Ծ��ȡ����
	public List<Subject> subjectList(Paper paper);
	//ѧ����¼�����indexҳ����ʾȫ������
	public List<Paper> list(Paper paper);
	
}
