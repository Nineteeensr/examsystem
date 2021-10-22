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
	// 学生点击试卷获取试题
	public List<Subject> subjectList(Paper paper);

	// 学生登录后进入index页面显示全部试题
	public List<Paper> list(Paper paper);

	// zjz
	// 生成试卷
	public Integer addPaper(Paper paper);

	// 查看试题内容
	public List<Subject> getSubjectListByPname(String pname);

//		// 显示全部试卷
//		public List<Paper> getPaperListByPname(String pname);

	// 获取试题数量
	public Integer getTotalCount(String pname);

	// 查询全部试卷
	public List<Paper> getPaperListByLimit(String pname, int currentPageNo, int pageSize);

	// 删除试卷
	public Integer delect(String pname);
}
