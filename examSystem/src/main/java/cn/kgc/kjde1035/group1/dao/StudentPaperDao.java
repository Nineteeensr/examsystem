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
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface StudentPaperDao {
	//学生提交答案
	public Integer addPaper(Studentpaper studentpaper);
	//获取总记录数
	public Integer getTotalCount(String spId,Integer userId);
	//查询学生所有错题列表
	public  List<Studentpaper> list(String spId,Integer userId,Integer pageNo, Integer pageSize);
}
