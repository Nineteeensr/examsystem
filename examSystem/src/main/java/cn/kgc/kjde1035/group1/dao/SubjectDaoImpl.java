package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kgc.kjde1035.group1.entity.Subject;

public class SubjectDaoImpl implements SubjectDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BaseDao bd = new BaseDao();

	// sid查询试题
	@Override
	public Subject getSubjectBySid(Integer sid) {
		Subject subject = null;
		conn = bd.getConnection();
		String sql = "SELECT sid,scontent,sa,sb,sc,sd,skey,sstate FROM SUBJECT WHERE sid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subject = new Subject(rs.getInt("sid"), rs.getString("scontent"), rs.getString("sa"),
						rs.getString("sb"), rs.getString("sc"), rs.getString("sd"), rs.getString("skey"),
						rs.getInt("sstate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll(rs, conn, pstmt);
		}
		return subject;
	}

	// 增加试题
	@Override
	public Integer addSubject(Subject subject) {

		String sql = "INSERT INTO SUBJECT(scontent,sa,sb,sc,sd,skey,sstate) VALUES(?,?,?,?,?,?,?)";
		Object[] params = { subject.getScontent(), subject.getSa(), subject.getSb(), subject.getSc(), subject.getSd(),
				subject.getSkey(), subject.getSstate() };
		return bd.executeUpdate(sql, params);
	}

	// 删除试题
	@Override
	public Integer delSubject(Integer sid) {
		String sql = "DELETE FROM SUBJECT WHERE sid=?";
		Object[] params = { sid };
		return bd.executeUpdate(sql, params);
	}

	// sid修改某个试题
	@Override
	public Integer updateSubject(Subject subject) {
		String sql = "UPDATE SUBJECT SET scontent=?,sa=?,sb=?,sc=?,sd=?,skey=?,sstate=? WHERE sid=?";
		Object[] params = { subject.getScontent(), subject.getSa(), subject.getSb(), subject.getSc(), subject.getSd(),
				subject.getSkey(), subject.getSstate(), subject.getSid() };
		return bd.executeUpdate(sql, params);
	}

	// 分页查询全部试题

	@Override
	public List<Subject> getAllSubjectByLimit(String scontent, Integer currentPageNo, Integer pageSize) {
		List<Subject> subjectList = new ArrayList<Subject>();
		Subject subject = null;

		conn = bd.getConnection();
		String sql = "SELECT sid,scontent,sa,sb,sc,sd,skey,sstate FROM SUBJECT ";
		if (scontent != null) {
			sql += "WHERE scontent LIKE '%" + scontent + "%'";
		}
		sql += " limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, currentPageNo);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				subject = new Subject(rs.getInt("sid"), rs.getString("scontent"), rs.getString("sa"),
						rs.getString("sb"), rs.getString("sc"), rs.getString("sd"), rs.getString("skey"),
						rs.getInt("sstate"));
				subjectList.add(subject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bd.closeAll(rs, conn, pstmt);
		}
		return subjectList;
	}

//	//总记录数
//	@Override
//	public Integer totalCount() {
//		Integer totalCount=0;
//		conn=bd.getConnection();		
//		String sql="SELECT COUNT(1) c FROM SUBJECT";
//		try {
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				totalCount=rs.getInt("c");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			DBUtils.closeAll(rs, pstmt, conn);
//		}
//		
//		return totalCount;
//	}

	@Override
	public Integer getTotalCount(String scontent) {
		Integer result = 0;
		String sql = "SELECT COUNT(1) c FROM SUBJECT";
		if (scontent != null) {
			sql += " WHERE scontent LIKE '%" + scontent + "%'";
		}
		conn = bd.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
