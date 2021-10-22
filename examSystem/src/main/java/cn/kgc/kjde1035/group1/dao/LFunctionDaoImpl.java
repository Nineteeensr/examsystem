package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.kgc.kjde1035.group1.entity.SysFunction;


public class LFunctionDaoImpl extends BaseDao implements LFunctionDao {

	@Override
	public List<SysFunction> queryAllFun() {
		String sql = "select funid,funname,funurl,funpid,funstate from sysfunction";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SysFunction> funList = new ArrayList<SysFunction>();
		Connection conn = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while (rs.next()) {
				SysFunction fun = new SysFunction();
				fun.setFunid(rs.getInt("funId"));
				fun.setFunname(rs.getString("funname"));
				fun.setFunurl(rs.getString("funurl"));
				fun.setFunstate(rs.getInt("funstate"));
				fun.setFunpid(rs.getInt("funpid"));
				funList.add(fun);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
		}
	
		return funList;
	}
	

}
