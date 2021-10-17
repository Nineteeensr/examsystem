/**  
 * 
 * @Title:  StudentPaperService.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:39:10
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import cn.kgc.kjde1035.group1.entity.Studentpaper;

/**
 * @author 10217
 *
 */
public interface StudentPaperService {
	//学生提交答案
	public Integer addPaper(Studentpaper studentpaper);
}
