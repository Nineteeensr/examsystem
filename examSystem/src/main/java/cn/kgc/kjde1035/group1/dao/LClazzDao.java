package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Paper;

public interface LClazzDao {
	List<Clazz> queryAllClazzByTuserId(Integer Userid);
	List<Clazz> queryAllClazz();
	Integer queryCount(Integer clazzId);
	List<Paper> quryPaperByClazzId(Integer clazzId);
}
