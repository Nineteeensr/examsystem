/**  
 * 
 * @Title:  PaperServiceImpl.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:18:34
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.PaperDao;
import cn.kgc.kjde1035.group1.dao.PaperDaoImpl;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public class PaperServiceImpl implements PaperService {
	PaperDao pd = new PaperDaoImpl();

	/**
	 * ѧ������Ծ��ȡ�Ծ��ڵ���Ŀ
	 */
	@Override
	public List<Subject> subjectList(Paper paper) {
		return pd.subjectList(paper);
	}

	@Override
	public List<Paper> list(Integer userId) {
		return pd.list(userId);
	}

	// �����Ծ�
	@Override
	public Integer addPaper(Paper paper) {
		// TODO Auto-generated method stub
		return pd.addPaper(paper);
	}

	// ��ѯȫ���Ծ�
	@Override
	public List<Paper> findPaperListByLimit(String pname, int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		return pd.getPaperListByLimit(pname, currentPageNo, pageSize);
	}

	// �鿴��������
	@Override
	public List<Subject> getSubjectListByPname(String pname) {
		// TODO Auto-generated method stub
		return pd.getSubjectListByPname(pname);
	}

//		// ��ʾȫ���Ծ�
//		@Override
//		public List<Paper> getPaperListByPname(String pname) {
//			// TODO Auto-generated method stub
//			return pd.getPaperListByPname(pname);
//		}

	// ��ʾ�Ծ�����
	public Integer getTotalCount(String pname) {
		return pd.getTotalCount(pname);
	}

	// ɾ���Ծ�
	public boolean removePaperByPname(String pname) {
		Integer result = pd.delect(pname);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}
