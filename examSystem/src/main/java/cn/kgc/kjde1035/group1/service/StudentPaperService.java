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
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public interface StudentPaperService {
	// ѧ���ύ��
	public Integer addPaper(Studentpaper studentpaper);

	public List<Studentpaper> showLimit(Integer currentPageNo, Integer pageSize, Integer userId);

	public Integer getPaperTotalCount(Integer userId);

	public List<Subject> findAllErr(String spid, String pname, Integer userid, Integer currentPageNo, Integer pageSize);

	public Integer ErrTotalCountInPaper(String spid, String pname, Integer userid);
	public Boolean addPapers(List<Studentpaper> stupList);
	public Integer rightTotalCountInPaper(String spid, String pname, Integer userid);
}
