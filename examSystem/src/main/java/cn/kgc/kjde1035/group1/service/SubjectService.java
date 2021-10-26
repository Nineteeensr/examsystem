package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Subject;

public interface SubjectService {

	// ����һ������
	public Integer addSubject(Subject subject);

	// ��ҳ��ѯ
	public List<Subject> getAllSubjectByLimit(String scontent, Integer currentPageNo, Integer pageSize);

	// �޸�����
	public Integer updateSubject(Subject subject);

	// ��ѯһ����������(id)
	public Subject getSubjectBySid(Integer sid);

	// ɾ������
	public Integer delSubject(Integer sid);

	//// �ܼ�¼��
	// public Integer totalCount();
	// ģ����ѯ

	// ģ����ѯ���ܼ�¼��
	public Integer getTotalCount(String scontent);
	
	
	public Integer addSubjects(List<Subject> subList);
}
