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

import cn.kgc.kjde1035.group1.entity.Studentpaper;

/**
 * @author 10217
 *
 */
public interface StudentPaperDao {
	//学生提交答案
	public Integer addPaper(Studentpaper studentpaper);
}
