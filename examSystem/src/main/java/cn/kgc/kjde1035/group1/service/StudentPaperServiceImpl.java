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

/**
 * @author 10217
 *
 */
public class StudentPaperServiceImpl implements StudentPaperService {
	StudentPaperDao stupaperDao = new StudentPaperDaoImpl(); 
	/**
	 * 学生提交答案
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		return stupaperDao.addPaper(studentpaper);
	}
	@Override
	public List<Studentpaper> list(String spId, Integer userId, Integer pageNo, Integer pageSize) {
		
		return stupaperDao.list(spId, userId, pageNo, pageSize);
	}
	@Override
	public Integer getTotalCount(String spId, Integer userId) {
		// TODO Auto-generated method stub
		return stupaperDao.getTotalCount(spId, userId);
	}

}
