package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��ɾ��ͨ�÷�����public int executeUpdate(String sql,Object[] params)
 * ��ȡ���Ӷ��󷽷���getConnection() �ͷ���Դ������closeAll()
 * 
 * @author 10217
 *
 */
public class BaseDao {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/exam_0720";
	// ���ݿ��¼��
	private String user = "root";
	// ���ݿ�����
	private String password = "123456";

	/**
	 * ��ȡ���Ӷ���
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
	 * �ͷ���Դ
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
	 * ��ɾ��ͨ�÷���
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
