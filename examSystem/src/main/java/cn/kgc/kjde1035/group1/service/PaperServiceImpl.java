/**  
 * 
 * @Title:  PaperServiceImpl.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:18:34
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.IPaperDao;
import cn.kgc.kjde1035.group1.dao.PaperDaoImpl;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public class PaperServiceImpl implements PaperService {
	IPaperDao paperDao = new PaperDaoImpl();
	/**
	 * 学生点击试卷获取试卷内的错题
	 */
	@Override
	public List<Subject> subjectList(Paper paper) {
		return paperDao.subjectList(paper);
	}

}
