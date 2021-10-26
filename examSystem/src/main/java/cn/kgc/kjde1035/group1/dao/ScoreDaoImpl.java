/**  
 * 
 * @Title:  ScoreDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/22 14:55:20
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Score;
import cn.kgc.kjde1035.group1.entity.Sysuser;

/**
 * @author 10217
 *
 */
public class ScoreDaoImpl extends BaseDao implements ScoreDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	@Override
	public List<Score> getClazzAvgScore(Sysuser user) {
		System.out.println(user.getUserId());
		List<Score> scoreList = new ArrayList<Score>();
		conn = this.getConnection();
		String sql ="SELECT AVG(totalscore) c FROM score WHERE userid IN(\r\n" + 
				"				SELECT userid FROM sysuser WHERE clazzid IN (\r\n" + 
				"						SELECT clazzid FROM clazz WHERE tuserid=?\r\n" + 
				"					)	\r\n" + 
				"				)GROUP BY pname" ;
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, user.getUserId());
			rs = p.executeQuery();
			while(rs.next()) {
				Score sc = new Score();
				sc.setAvgTotalScore(rs.getInt("c"));
				scoreList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		
			System.out.println(scoreList);
		
		
		return scoreList;
	}
	@Override
	public List<String> getClazzPaperName(Sysuser user) {
		List<String> pnList = new ArrayList<String>();
		conn = this.getConnection();
		
		String sql = "SELECT pname FROM studentpaper WHERE userid IN (\r\n" + 
				"	SELECT userid FROM sysuser WHERE clazzid IN (\r\n" + 
				"		SELECT clazzid FROM clazz WHERE tuserid=?\r\n" + 
				"	)\r\n" + 
				")GROUP BY pname";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, user.getUserId());
			rs = p.executeQuery();
			while(rs.next()) {
				String a = rs.getString("pname");
				pnList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		
		return pnList;
	}
	@Override
	public boolean appendScore(Score score) {
		String sql = "insert into score (pname,userid,totalscore) values(?,?,?)";
		Object[] params = {score.getPname(),score.getUserId(),score.getTotalScore()};
		int result = this.executeUpdate(sql, params);
		if(result>0) return true;
		return false;
	}
	@Override
	public List<Score> getScoresByClazzId(Integer clazzId, String pname) {
		String sql = "SELECT pname,username,totalscore,sc.userid FROM score sc JOIN sysuser sys ON sc.userid = sys.userid WHERE sys.userid IN(SELECT userid FROM sysuser WHERE clazzid = ?) AND pname = ?";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Score> scoreList = new ArrayList<Score>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, clazzId);
			ps.setString(2, pname);
			rs = ps.executeQuery();
			while(rs.next()) {
				Score score = new Score();
				score.setPname(rs.getString("pname"));
				score.setUserName(rs.getString("userName"));
				score.setTotalScore(rs.getInt("totalscore"));
				score.setUserId(rs.getInt("userid"));
				scoreList.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scoreList;
	}

}
