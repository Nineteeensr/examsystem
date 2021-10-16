/**  
 * 
 * @Title:  PaperService.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:18:18
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;



import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public interface PaperService {
	public List<Subject> subjectList(Paper paper);
}
