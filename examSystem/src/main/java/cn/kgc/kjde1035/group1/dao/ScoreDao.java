/**  
 * 
 * @Title:  ScoreDao.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/22 14:53:32
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.util.List;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public interface ScoreDao {
	public List<Score> getClazzAvgScore(Sysuser user);
	public List<String> getClazzPaperName(Sysuser user);
	public boolean appendScore(Score score);
	public List<Score> getScoresByClazzId(Integer clazzId,String pname);
}
