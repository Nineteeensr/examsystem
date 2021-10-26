/**  
 * 
 * @Title:  ScoreServiceImpl.java   
 * @Package cn.kgc.kjde1035.group1.service   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/22 16:13:50
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.service;

import java.util.List;

import cn.kgc.kjde1035.group1.dao.LClazzDaoImpl;
import cn.kgc.kjde1035.group1.dao.ScoreDao;
import cn.kgc.kjde1035.group1.dao.ScoreDaoImpl;
import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public class ScoreServiceImpl implements ScoreService {
	ScoreDao scoreDao = new ScoreDaoImpl();
	@Override
	public List<Score> getClazzAvgScore(Sysuser user) {
		
		return scoreDao.getClazzAvgScore(user);
	}
	@Override
	public List<String> getClazzPaperName(Sysuser user) {
		
		return scoreDao.getClazzPaperName(user);
	}
	@Override
	public Boolean appendScore(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.appendScore(score);
	}
	@Override
	public List<Clazz> findClazzByTuserId(Integer tuserid) {
		return new LClazzDaoImpl().queryAllClazzByTuserId(tuserid);
	}
	@Override
	public List<Clazz> findAllClazz() {
		// TODO Auto-generated method stub
		return new LClazzDaoImpl().queryAllClazz();
	}
	@Override
	public List<Paper> quryPaperByClazzId(Integer clazzId) {
		// TODO Auto-generated method stub
		return new LClazzDaoImpl().quryPaperByClazzId(clazzId);
	}
	@Override
	public List<Score> findScoresByClazzId(Integer clazzId, String pname) {
		// TODO Auto-generated method stub
		return scoreDao.getScoresByClazzId(clazzId, pname);
	}

}
