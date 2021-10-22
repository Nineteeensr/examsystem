package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.SubjectDao;
import cn.kgc.kjde1035.group1.dao.SubjectDaoImpl;
import cn.kgc.kjde1035.group1.entity.Subject;

public class SubjectServiceImpl implements SubjectService {
	SubjectDao subjectDao = new SubjectDaoImpl();

	// 分页查所有试题
	@Override
	public List<Subject> getAllSubjectByLimit(String scontent, Integer currentPageNo, Integer pageSize) {

		return subjectDao.getAllSubjectByLimit(scontent, currentPageNo, pageSize);
	}

	// 查总记录数
	@Override
	public Integer getTotalCount(String scontent) {
		// TODO Auto-generated method stub

		return subjectDao.getTotalCount(scontent);
	}

	// 增加一个试题
	@Override
	public Integer addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDao.addSubject(subject);
	}

	// 修改试题
	@Override
	public Integer updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectDao.updateSubject(subject);
	}

	// 查询一个试题详情(id)
	@Override
	public Subject getSubjectBySid(Integer sid) {
		// TODO Auto-generated method stub
		return subjectDao.getSubjectBySid(sid);
	}

	// 删除试题
	@Override
	public Integer delSubject(Integer sid) {
		// TODO Auto-generated method stub
		return subjectDao.delSubject(sid);
	}

}
