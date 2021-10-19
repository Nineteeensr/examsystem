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
	 * 学生提交答案
	 */
	@Override
	public Integer addPaper(Studentpaper studentpaper) {
		conn = this.getConnection();
		String sql = "insert into studentpaper values(?,?,?,?,?,?)";
		Object[] params = {studentpaper.getSpid(),studentpaper.getUserid(),studentpaper.getSid(),studentpaper.getStudentkey(),studentpaper.getStudentstate(),studentpaper.getPname()};		
		return this.executeUpdate(sql, params);
	}
	/**
	 * 获取学生试题总记录数
	 */
	@Override
	public Integer getTotalCount(String spId,Integer userId) {
		Integer result = 0;
		conn = this.getConnection();
		String sql = "select count(1) c from studentpaper where studentstate=1  AND studentpaper.USERID=? AND spid=?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, spId);
			p.setInt(2, userId);
			rs = p.executeQuery();
			while (rs.next()) {
				result = rs.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return result;
	}
	/**
	 * 获取学生所有错题列表
	 */
	@Override
	public List<Studentpaper> list(String spId, Integer userId, Integer pageNo, Integer pageSize) {
		List<Studentpaper> list = new ArrayList<Studentpaper>();
		conn = this.getConnection();
		String sql = "SELECT subject.sid,subject.scontent,subject.sa,subject.sb,subject.sc,subject.sd,subject.skey,studentpaper.studentkey FROM studentpaper,subject where studentstate=0 AND subject.sid=studentpaper.sid AND studentpaper.USERID = ? AND spid = ?";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, userId);
			p.setString(2, spId);
			rs = p.executeQuery();
			while(rs.next()) {
				Studentpaper stu = new Studentpaper();
				Subject sub = new Subject();
				
				stu.setStudentkey(rs.getString("studentkey"));
				list.add(stu);
				
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
