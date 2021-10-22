package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 增删改通用方法：public int executeUpdate(String sql,Object[] params)
 * 获取连接对象方法：getConnection() 释放资源方法：closeAll()
 * 
 * @author 10217
 *
 */
public class BaseDao {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/exam";
	// 数据库登录名
	private String user = "root";
	// 数据库密码
	private String password = "980213";

	/**
	 * 获取连接对象
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param conn
	 * @param p
	 */
	public void closeAll(ResultSet rs, Connection conn, PreparedStatement p) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (p != null) {
				p.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增删改通用方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object[] params) {
		Connection conn = getConnection();
		PreparedStatement p = null;
		int result = 0;
		try {
			p = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					p.setObject(i + 1, params[i]);
				}
			}
			result = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

}
