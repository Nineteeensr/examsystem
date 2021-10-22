/**  
 * 
 * @Title:  StudentPaperServiceImpl.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:39:35
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.StudentPaperDao;
import cn.kgc.kjde1035.group1.dao.StudentPaperDaoImpl;
import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public class StudentPaperServiceImpl implements StudentPaperService {
	StudentPaperDao stupaperDao = new StudentPaperDaoImpl();

	/**
	 * ѧ���ύ��
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		return stupaperDao.addPaper(studentpaper);
	}
	@Override
	public List<Studentpaper> showLimit(Integer currentPageNo, Integer pageSize, Integer userId) {
		
		return stupaperDao.showLimit(currentPageNo, pageSize, userId);
	}
	@Override
	public Integer getPaperTotalCount(Integer userId) {
		return stupaperDao.queryStudentPaperTotalCount(userId);
	}
	@Override
	public List<Subject> findAllErr(String spid, String pname, Integer userid, Integer currentPageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		return stupaperDao.queryAllErr(spid, pname, userid,currentPageNo,pageSize);
	}
	
	//统计错题的数量
	@Override
	public Integer ErrTotalCountInPaper(String spid, String pname, Integer userid) {
		// TODO Auto-generated method stub
		return stupaperDao.queryErrSubjectTotalCount(spid, pname, userid);
	}
	
	//添加
	@Override
	public Boolean addPapers(List<Studentpaper> stupList) {
		// TODO Auto-generated method stub
		return stupaperDao.addPapers(stupList);
	}
	
	//统计对题的数量
	@Override
	public Integer rightTotalCountInPaper(String spid, String pname, Integer userid) {
		// TODO Auto-generated method stub
		return stupaperDao.queryRightSubjectTotalCount(spid, pname, userid);
	}
	



}
