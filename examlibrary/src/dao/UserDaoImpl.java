/**  
 * 
 * @Title:  UserDaoImpl.java   
 * @Package dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 10:50:33
 * @version V1.0 
 * 
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

/**
 * @author 10217
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	
	//µÇÂ¼
	@Override
	public User getUserByName(String name) {
		User user = null;
		conn = this.getConnection();
		String sql = "select id,name,password from `user` where name=?";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, name);
			rs = p.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		return user;
	}

}
