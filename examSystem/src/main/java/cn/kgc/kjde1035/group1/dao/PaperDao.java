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
	// cyg
	// ѧ������Ծ��ȡ����
	public List<Subject> subjectList(Paper paper);

	// ѧ����¼�����indexҳ����ʾȫ������
	public List<Paper> list(Integer userId);

	// zjz
	// �����Ծ�
	public Integer addPaper(Paper paper);

	// �鿴��������
	public List<Subject> getSubjectListByPname(String pname);

//		// ��ʾȫ���Ծ�
//		public List<Paper> getPaperListByPname(String pname);

	// ��ȡ��������
	public Integer getTotalCount(String pname);

	// ��ѯȫ���Ծ�
	public List<Paper> getPaperListByLimit(String pname, int currentPageNo, int pageSize);

	// ɾ���Ծ�
	public Integer delect(String pname);
	
}
