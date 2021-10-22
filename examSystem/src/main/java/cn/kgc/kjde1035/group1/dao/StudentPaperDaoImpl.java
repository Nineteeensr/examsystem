/**  
 * 
 * @Title:  StudentPaperDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/17 09:36:18
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

import cn.kgc.kjde1035.group1.entity.Studentpaper;
import cn.kgc.kjde1035.group1.entity.Subject;

/**
 * @author 10217
 *
 */
public class StudentPaperDaoImpl extends BaseDao implements StudentPaperDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;

	/**
	 * ѧ���ύ��
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		conn = this.getConnection();
		String sql = "insert into studentpaper() values(?,?,?,?,?,?)";
		Object[] params = { studentpaper.getSpid(), studentpaper.getUserid(), studentpaper.getSid(),
				studentpaper.getStudentkey(), studentpaper.getStudentstate(), studentpaper.getPname() };
		return this.executeUpdate(sql, params);
	}
	@Override
	public List<Studentpaper> showLimit(Integer currentPageNo, Integer pageSize, Integer userId) {
		String sql = "SELECT userid,spid, stu.pname,COUNT(spid) errCount,cou totalCount FROM  studentpaper stu JOIN (SELECT COUNT(pid) cou ,pname FROM paper GROUP BY pname) pa  ON stu.pname = pa.pname WHERE studentstate=0 AND userId=? GROUP BY spid, stu.pname";
		conn = this.getConnection();
		List<Studentpaper> stupList = new ArrayList<Studentpaper>();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, userId);
			/*
			 * ps.setInt(2, (currentPageNo - 1) * pageSize); ps.setInt(3, pageSize);
			 */
			rs = p.executeQuery();
			while (rs.next()) {
				Studentpaper sp = new Studentpaper();
				sp.setSpid(rs.getString("spid"));
				sp.setUserid(rs.getInt("userid"));
				sp.setPname(rs.getString("pname"));
				sp.setErrorcount(rs.getInt("errCount"));
				sp.setRightcount(rs.getInt("totalCount") - rs.getInt("errCount"));
				stupList.add(sp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}
		return stupList;
	}

	@Override
	public Integer queryStudentPaperTotalCount(Integer userId) {
		String sql = "select count(1) from (SELECT spid,pname FROM studentpaper WHERE userid=? GROUP BY pname,spid) a";
		conn = this.getConnection();
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, userId);
			rs = p.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}
		return 0;
	}

	@Override
	public List<Subject> queryAllErr(String spid, String pname, Integer userid, Integer currentPageNo,
			Integer pageSize) {
		String sql = "SELECT sub.sid,scontent,sa,sb,sc,sd,skey,sstate,stu.studentkey,stu.studentstate FROM `subject` sub RIGHT JOIN (SELECT sid, studentkey, studentstate FROM studentpaper WHERE spid=? AND pname = ? AND userid = ? and studentstate=0 ) stu ON stu.sid=sub.sid";
		conn = this.getConnection();
		List<Subject> subList = new ArrayList<Subject>();
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, spid);
			p.setString(2, pname);
			p.setInt(3, userid);
			/*
			 * ps.setInt(4, (currentPageNo-1)*pageSize); ps.setInt(5, pageSize);
			 */
			rs = p.executeQuery();
			while (rs.next()) {
				Subject sub = new Subject();
				sub.setSid(rs.getInt("sid"));
				sub.setScontent(rs.getString("scontent"));
				sub.setSa(rs.getString("sa"));
				sub.setSb(rs.getString("sb"));
				sub.setSc(rs.getString("sc"));
				sub.setSd(rs.getString("sd"));
				sub.setSkey(rs.getString("skey"));
				sub.setStudentkey(rs.getString("studentkey"));
				subList.add(sub);
			}
			return subList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return null;
	}

	@Override
	public Integer queryErrSubjectTotalCount(String spid, String pname, Integer userid) {
		String sql = "SELECT COUNT(1) errcount FROM studentpaper WHERE spid=? AND userid=? AND pname=? and studentstate=0";
		conn = this.getConnection();
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, spid);
			p.setInt(2, userid);
			p.setString(3, pname);
			rs = p.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}
		return 0;
	}
	
	@Override
	public Integer queryRightSubjectTotalCount(String spid, String pname, Integer userid) {
		String sql = "SELECT COUNT(1) errcount FROM studentpaper WHERE spid=? AND userid=? AND pname=? AND studentstate=1";
		conn = this.getConnection();
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, spid);
			p.setInt(2, userid);
			p.setString(3, pname);
			rs = p.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}
		return 0;
	}
	
	
	@Override
	public Boolean addPapers(List<Studentpaper> stupList) {
		int sum = 0;
		for (Studentpaper studentPaper : stupList) {
			sum++;
			this.addPaper(studentPaper);
		}
		return sum==stupList.size();
	}
}
