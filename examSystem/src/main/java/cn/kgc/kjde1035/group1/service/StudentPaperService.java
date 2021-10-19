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

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Studentpaper;

/**
 * @author 10217
 *
 */
public interface StudentPaperService {
	//学生提交答案
	public Integer addPaper(Studentpaper studentpaper);
	//获取学生所有错题列表
	public  List<Studentpaper> list(String spId,Integer userId,Integer pageNo, Integer pageSize);
	//获取学生错题数
	public Integer getTotalCount(String spId,Integer userId);
}
