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
public class PaperDaoImpl extends BaseDao implements PaperDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ѧ������Ծ��ȡ����
	 */
	@Override
	public List<Subject> subjectList(Paper paper) {
		List<Subject> subjectList = new ArrayList<Subject>();
		conn = this.getConnection();
		String sql = "SELECT subject.sid,scontent,sa,sb,sc,sd,skey FROM subject,paper WHERE paper.sid = subject.sid and paper.pname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paper.getPname());
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		} finally {
			this.closeAll(rs, conn, pstmt);
		}
		return subjectList;
	}

	/**
	 * ѧ����¼����index��ʾȫ������
	 */
	@Override
	public List<Paper> list(Integer userId) {
		List<Paper> list = new ArrayList<Paper>();
		conn = this.getConnection();
		String sql = "SELECT pname,COUNT(*) scount FROM paper WHERE pname NOT IN(SELECT pname FROM studentpaper WHERE userid = ?)GROUP BY pname ;";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPname(rs.getString("pname"));
				paper.setScount(rs.getInt("scount"));
				list.add(paper);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, pstmt);
		}
		return list;
	}

	// �����Ծ�
	@Override
	public Integer addPaper(Paper paper) {
		String sql = "INSERT INTO paper(pname,sid) SELECT ?,sid FROM subject where sstate = 1 ORDER BY rand() LIMIT ?";
		Object[] params = { paper.getPname(), paper.getScount() };
		return this.executeUpdate(sql, params);
	}

	// �鿴��������
	@Override
	public List<Subject> getSubjectListByPname(String pname) {
		List<Subject> subjectlist = new ArrayList<Subject>();
		conn = this.getConnection();
		String sql = "select subject.sid,scontent,sa,sb,sc,sd,skey from subject,paper where paper.sid=subject.sid and paper.pname=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject(rs.getInt("subject.sid"), rs.getString("scontent"), rs.getString("sa"),
						rs.getString("sb"), rs.getString("sc"), rs.getString("sd"), rs.getString("skey"));
				subjectlist.add(subject);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, pstmt);
		}
		return subjectlist;
	}

//		// ��ʾȫ���Ծ�
//		@Override
//		public List<Paper> getPaperListByPname(String pname) {
//			List<Paper> paperList = new ArrayList<Paper>();
//			conn = this.getConnection();
//			String sql = "SELECT pname,count(sid) scount FROM paper GROUP BY pname";
//			try {
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				while (rs.next()) {
//					Paper paper = new Paper(null, rs.getString("pname"), rs.getInt("scount"));
//					paperList.add(paper);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				this.closeAll(rs, conn, pstmt);
//			}
//			return paperList;
//		}

	// ɾ���Ծ�
	@Override
	public Integer delect(String pname) {
		String sql = "delete from paper where pname=?";
		Object[] params = { pname };
		return this.executeUpdate(sql, params);
	}

	/**
	 * ��ȡ���Ծ���
	 */
	@Override
	public Integer getTotalCount(String pname) {
		Integer result = 0;
		conn = this.getConnection();
		String sql = "SELECT COUNT(s.pname) c FROM (SELECT pname,COUNT(*) scount FROM paper GROUP BY pname) s";
		if (pname != null && !"".equals(pname)) {
			sql += " where pname like '%" + pname + "%'";
		}

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, pstmt);
		}
		return result;
	}

	// ��ҳ��ѯȫ���Ծ�
	@Override
	public List<Paper> getPaperListByLimit(String pname, int currentPageNo, int pageSize) {
		List<Paper> paperList = new ArrayList<Paper>();
		Paper paper = null;
		conn = this.getConnection();
		String sql = "SELECT pname,count(*) scount FROM paper ";
		if (pname != null && !"".equals(pname)) {
			sql += "where pname like '%" + pname + "%'";
		}
		sql += " group by pname limit ?,?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (currentPageNo - 1) * pageSize);
			pstmt.setInt(2, pageSize);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				paper = new Paper(rs.getString("pname"), rs.getInt("scount"));
				paperList.add(paper);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, pstmt);
		}
		return paperList;
	}
}
