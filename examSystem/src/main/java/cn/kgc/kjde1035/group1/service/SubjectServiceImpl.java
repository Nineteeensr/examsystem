package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.SubjectDao;
import cn.kgc.kjde1035.group1.dao.SubjectDaoImpl;
import cn.kgc.kjde1035.group1.entity.Subject;

public class SubjectServiceImpl implements SubjectService {
	SubjectDao subjectDao = new SubjectDaoImpl();

	// ��ҳ����������
	@Override
	public List<Subject> getAllSubjectByLimit(String scontent, Integer currentPageNo, Integer pageSize) {

		return subjectDao.getAllSubjectByLimit(scontent, currentPageNo, pageSize);
	}

	// ���ܼ�¼��
	@Override
	public Integer getTotalCount(String scontent) {
		// TODO Auto-generated method stub

		return subjectDao.getTotalCount(scontent);
	}

	// ����һ������
	@Override
	public Integer addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDao.addSubject(subject);
	}
	
	
	

	// �޸�����
	@Override
	public Integer updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDao.updateSubject(subject);
	}

	// ��ѯһ����������(id)
	@Override
	public Subject getSubjectBySid(Integer sid) {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectBySid(sid);
	}

	// ɾ������
	@Override
	public Integer delSubject(Integer sid) {
		// TODO Auto-generated method stub
		return subjectDao.delSubject(sid);
	}

	@Override
	public Integer addSubjects(List<Subject> subList) {
		int result = 0;
		for (Subject subject : subList) {
			result += this.addSubject(subject);
		}
		return result;
	}

}
