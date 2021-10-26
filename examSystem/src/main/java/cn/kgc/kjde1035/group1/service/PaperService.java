/**  
 * 


 * 
 * 
 * @Title:  PaperService.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:18:18
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public interface PaperService {
	// ѧ������Ծ��ȡ�Ծ��ڵ���Ŀ
	public List<Subject> subjectList(Paper paper);

	// ѧ����¼����index��ʾȫ���Ծ�
	public List<Paper> list(Integer userId);

	// �����Ծ�
	public Integer addPaper(Paper paper);

	// �鿴��������
	public List<Subject> getSubjectListByPname(String pname);

	// ��ʾȫ���Ծ�
//		public List<Paper> getPaperListByPname(String pname);

	// ��ʾ�Ծ�����
	public Integer getTotalCount(String pname);

	// ��ҳ��ѯȫ���Ծ�
	public List<Paper> findPaperListByLimit(String pname, int currentPageNo, int pageSize);

	// ɾ���Ծ�
	public boolean removePaperByPname(String pname);

	
}
