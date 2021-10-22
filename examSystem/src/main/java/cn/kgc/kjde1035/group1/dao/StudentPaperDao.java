/**  
 * 


 * @Title:  StudentPaperDao.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:35:58
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Subject;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface StudentPaperDao {
	// ѧ���ύ��
	public Integer addPaper(Studentpaper studentpaper);

	public List<Studentpaper> showLimit(Integer currentPageNo, Integer pageSize, Integer userid);

	public Integer queryStudentPaperTotalCount(Integer userId);

	public Integer queryErrSubjectTotalCount(String spid, String pname, Integer userid);

	public List<Subject> queryAllErr(String spid, String pname, Integer userid, Integer currentPageNo,
			Integer pageSize);
	public Boolean addPapers(List<Studentpaper> stupList);
	public Integer queryRightSubjectTotalCount(String spid, String pname, Integer userid);
}
