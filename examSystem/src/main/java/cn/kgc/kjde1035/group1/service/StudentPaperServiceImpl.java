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
	 * ѧ���ύ��
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		return stupaperDao.addPaper(studentpaper);
	}

}
