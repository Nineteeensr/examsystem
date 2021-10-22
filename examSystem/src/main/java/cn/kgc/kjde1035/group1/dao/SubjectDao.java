package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Subject;

public interface SubjectDao {
//增加一个试题
	public Integer addSubject(Subject subject);

//分页查询
	public List<Subject> getAllSubjectByLimit(String scontent, Integer currentPageNo, Integer pageSize);

//修改试题
	public Integer updateSubject(Subject subject);

//查询一个试题详情(id)
	public Subject getSubjectBySid(Integer sid);

//删除试题	
	public Integer delSubject(Integer sid);

////总记录数
//public Integer totalCount();
//模糊查询

//模糊查询的总记录数
	public Integer getTotalCount(String scontent);
}
