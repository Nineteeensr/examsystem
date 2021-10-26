/**  
 * 
 * @Title:  ScoreService.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/22 16:13:22
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface ScoreService {
	public List<Score> getClazzAvgScore(Sysuser user);
	public List<String> getClazzPaperName(Sysuser user);
	Boolean appendScore(Score score);
	List<Clazz> findClazzByTuserId(Integer tuserid);
	List<Clazz> findAllClazz();
	List<Paper> quryPaperByClazzId(Integer clazzId);
	List<Score> findScoresByClazzId(Integer clazzId, String pname);
}
