package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.kgc.kjde1035.group1.entity.Clazz;
import cn.kgc.kjde1035.group1.entity.Paper;

public class LClazzDaoImpl extends BaseDao implements LClazzDao {

	@Override
	public List<Clazz> queryAllClazzByTuserId(Integer tuserid) {
		String sql = "SELECT cl.clazzid,clazzname,speciaid,tuserid,us.coun FROM clazz cl INNER JOIN (SELECT COUNT(1) coun,clazzid FROM sysuser GROUP BY clazzid) us ON us.clazzid = cl.clazzid where tuserid=?";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		List<Clazz> clazzList = new ArrayList<Clazz>();
		ResultSet rs = null;
		try {
			 ps= conn.prepareStatement(sql);
			 ps.setInt(1, tuserid);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 Clazz clazz = new Clazz();
				 clazz.setClazzId(rs.getInt("clazzid"));
				 clazz.setClazzName(rs.getString("clazzname"));
				 clazz.setSpeciaid(rs.getInt("speciaid"));
				 clazz.setTuserid(rs.getInt("tuserid"));
				 clazz.setUserCount(rs.getInt("coun"));
				 clazzList.add(clazz);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
			
		}
		return clazzList;
	}

	@Override
	public List<Clazz> queryAllClazz() {
		String sql = "SELECT cl.clazzid,clazzname,speciaid,tuserid,us.coun FROM clazz cl INNER JOIN (SELECT COUNT(1) coun,clazzid FROM sysuser GROUP BY clazzid) us ON us.clazzid = cl.clazzid";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		List<Clazz> clazzList = new ArrayList<Clazz>();
		ResultSet rs = null;
		try {
			 ps= conn.prepareStatement(sql);
			 
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 Clazz clazz = new Clazz();
				 clazz.setClazzId(rs.getInt("clazzid"));
				 clazz.setClazzName(rs.getString("clazzname"));
				 clazz.setSpeciaid(rs.getInt("speciaid"));
				 clazz.setTuserid(rs.getInt("tuserid"));
				 clazz.setUserCount(rs.getInt("coun"));
				 clazzList.add(clazz);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
			
		}
		return clazzList;
	}

	@Override
	public Integer queryCount(Integer clazzId) {
		return null;
	}

	@Override
	public List<Paper> quryPaperByClazzId(Integer clazzId) {
		String sql ="SELECT COUNT(1) coun,pname FROM (SELECT userid,pname FROM studentpaper WHERE userid IN (SELECT userid FROM sysuser WHERE clazzid = ?)GROUP BY pname,userid) a GROUP BY pname";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paper> paperList = new ArrayList<Paper>();
		try {
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, clazzId);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 Paper paper = new Paper();
				 paper.setJoinCount(rs.getInt("coun"));
				 paper.setPname(rs.getString("pname"));
				 paperList.add(paper);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
		}
		return paperList ;
	}

}
