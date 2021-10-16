/**  
 * 
 * @Title:  UserDaoImpl.java   
 * @Package cn.kgc.kjde1035.group1.dao   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/13 16:07:56
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
import cn.kgc.kjde1035.group1.entity.Sysrole;
import cn.kgc.kjde1035.group1.entity.Sysuser;


/**
 * @author 10217
 *
 */
public class UserDaoImpl extends BaseDao implements IUserDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;
	// 注册
	@Override
	public Integer userRegist(Sysuser user) {
		String sql = "insert into `sysuser`(userName,userPwd) values(?,?)";
		Object[] params = { user.getUserName(), user.getUserPwd() };
		Integer result = this.executeUpdate(sql, params);
		return result;
	}
	/**
	 * 登录
	 */
	@Override
	public Sysuser login(Sysuser user) {
		conn = this.getConnection();
		String sql = "SELECT USERID,A.ROLEID,USERNAME,USERPWD,USERTRUENAME,USERSTATE," + 
				"B.ROLENAME FROM SYSUSER A " + 
				 "INNER JOIN SYSROLE B ON A.ROLEID=B.ROLEID " + 
				 "WHERE USERSTATE=1 AND USERNAME=? AND USERPWD=? ";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, user.getUserName());
			p.setString(2, user.getUserPwd());
			rs = p.executeQuery();
			while(rs.next()) {
				user = new Sysuser();
				user.setUserId(rs.getInt("userId"));
				user.setRoleId(rs.getInt("roleId"));
				user.setUserName(rs.getString("userName"));
				user.setUserTrueName(rs.getString("userTrueName"));
				user.setUserState(rs.getInt("userState"));
				user.setRoleName(rs.getString("roleName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, conn, p);
		}
		
		return user;
	}
	
//	/**
//	 * 查询所有试卷信息
//	 */
//	@Override
//	public List<Paper> getAllPaperInfo() {
//		List<Paper> paperList = new ArrayList<Paper>();
//		conn = this.getConnection();
//		String sql = "select pname,sid,count(*) scount from paper";
//		try {
//			p = conn.prepareStatement(sql);
//			rs = p.executeQuery();
//			while(rs.next()) {
//				Paper paper = new Paper();
//				paper.setPname(rs.getString("pname"));
//				paper.setSid(rs.getInt("sid"));
//				paper.setScount(rs.getInt("scount"));
//				paperList.add(paper);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			this.closeAll(rs, conn, p);
//		}
//		
//		return paperList;
//	}

}
