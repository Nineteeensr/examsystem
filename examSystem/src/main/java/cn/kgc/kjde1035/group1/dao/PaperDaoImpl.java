/**  
 * 
 * @Title:  PaperDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/15 15:27:54
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

import cn.kgc.kjde1035.group1.entity.Paper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public class PaperDaoImpl extends BaseDao implements PaperDao{
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	/**
	 * 学生点击试卷获取试题
	 */
	@Override
	public List<Subject> subjectList(Paper paper) {
		List<Subject> subjectList = new ArrayList<Subject>();
		conn = this.getConnection();
		String sql = "SELECT subject.sid,scontent,sa,sb,sc,sd,skey FROM subject,paper WHERE paper.sid = subject.sid and paper.pname = ?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, paper.getPname());
			rs = p.executeQuery();
			while(rs.next()) {
				Subject subject = new Subject();
				subject.setSid(rs.getInt("sid"));
				subject.setScontent(rs.getString("scontent"));
				subject.setSa(rs.getString("sa"));
				subject.setSb(rs.getString("sb"));
				subject.setSc(rs.getString("sc"));
				subject.setSd(rs.getString("sd"));
				subject.setSkey(rs.getString("skey"));
				subjectList.add(subject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		return subjectList;
	}
	/**
	 * 学生登录进入index显示全部试题
	 */
	@Override
	public List<Paper> list(Paper paper) {
		List<Paper> list = new ArrayList<Paper>();
		conn = this.getConnection();
		String sql = "SELECT pname,count(*) scount FROM paper GROUP BY pname";
		try {
			p = conn.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()) {
				paper = new Paper();
				paper.setPname(rs.getString("pname"));
				paper.setScount(rs.getInt("scount"));
				list.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		return list;
	}
	
}
