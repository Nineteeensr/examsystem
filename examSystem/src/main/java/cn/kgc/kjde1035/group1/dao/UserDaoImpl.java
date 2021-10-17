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
import cn.kgc.kjde1035.group1.entity.SysFunction;
import cn.kgc.kjde1035.group1.entity.Sysrole;
import cn.kgc.kjde1035.group1.entity.Sysuser;
import cn.kgc.kjde1035.group1.utils.PageLimitUtil;

/**
 * @author 10217
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	Connection conn = null;
	PreparedStatement p = null;
	ResultSet rs = null;

	/**
	 * ע��
	 */
	@Override
	public Integer userRegist(Sysuser user) {
		String sql = "insert into `sysuser`(userName,userPwd) values(?,?)";
		Object[] params = { user.getUserName(), user.getUserPwd() };
		Integer result = this.executeUpdate(sql, params);
		return result;
	}

	/**
	 * ��¼
	 */
	@Override
	public Sysuser login(Sysuser user) {
		conn = this.getConnection();
		String sql = "SELECT USERID,A.ROLEID,USERNAME,USERPWD,USERTRUENAME,USERSTATE," + "B.ROLENAME FROM SYSUSER A "
				+ "INNER JOIN SYSROLE B ON A.ROLEID=B.ROLEID " + "WHERE USERSTATE=1 AND USERNAME=? ";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, user.getUserName());
			rs = p.executeQuery();
			while (rs.next()) {
				user = new Sysuser();
				user.setUserId(rs.getInt("userId"));
				user.setRoleId(rs.getInt("roleId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setUsertruename(rs.getString("usertruename"));
				user.setUserState(rs.getInt("userState"));
				user.setRolename(rs.getString("rolename"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return user;
	}

	/**
	 * ��ʼ���û������б�
	 */
	@Override
	public List<SysFunction> initpage(Sysuser user) {
		List<SysFunction> list = new ArrayList<SysFunction>();
		conn = this.getConnection();
		if (user.getRoleId().equals(-1)) {
			String sql = "SELECT A.FUNID,A.FUNNAME,A.FUNURL,A.FUNPID FROM SYSFUNCTION A WHERE A.FUNSTATE=1";
			try {
				p = conn.prepareStatement(sql);
				rs = p.executeQuery();
				while (rs.next()) {
					SysFunction sysFun = new SysFunction();
					sysFun.setFunid(rs.getInt("funid"));
					sysFun.setFunname(rs.getString("funname"));
					sysFun.setFunurl(rs.getString("funurl"));
					sysFun.setFunpid(rs.getInt("funpid"));
					list.add(sysFun);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.closeAll(rs, conn, p);
			}

		} else {
			String sql = "SELECT A.FUNID,A.FUNNAME,A.FUNURL,A.FUNPID FROM SYSFUNCTION A "
					+ "INNER JOIN ROLERIGHT B ON A.FUNID=B.FUNID WHERE B.ROLEID=? AND A.FUNSTATE=1";
			try {
				p = conn.prepareStatement(sql);
				p.setInt(1, user.getRoleId());
				rs = p.executeQuery();
				while (rs.next()) {
					SysFunction sysFun = new SysFunction();
					sysFun.setFunid(rs.getInt("funid"));
					sysFun.setFunname(rs.getString("funname"));
					sysFun.setFunurl(rs.getString("funurl"));
					sysFun.setFunpid(rs.getInt("funpid"));
					list.add(sysFun);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				this.closeAll(rs, conn, p);
			}
		}
		return list;
	}

	/**
	 * ѧ����¼
	 */
	@Override
	public Sysuser stulogin(Sysuser user) {
		conn = this.getConnection();
		String sql = "SELECT USERID,A.ROLEID,USERNAME,USERPWD,USERTRUENAME,USERSTATE, " + "B.ROLENAME FROM SYSUSER A "
				+ "INNER JOIN SYSROLE B ON A.ROLEID=B.ROLEID " + "WHERE USERSTATE=1 AND USERNAME=? AND USERPWD=? ";
		try {
			p = conn.prepareStatement(sql);
			p.setString(1, user.getUserName());
			p.setString(2, user.getUserPwd());
			rs = p.executeQuery();
			while (rs.next()) {
				user = new Sysuser();
				user.setUserId(rs.getInt("userId"));
				user.setRoleId(rs.getInt("roleId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setUsertruename(rs.getString("usertruename"));
				user.setUserState(rs.getInt("userState"));
				user.setRolename(rs.getString("rolename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return user;
	}

	/**
	 * ϵͳ�����û�
	 */
	@Override
	public Integer add(Sysuser user) {
		String sql = "INSERT INTO SYSUSER(ROLEID,USERNAME,USERPWD,USERTRUENAME,USERSTATE) " + "VALUES (?,?,?,?,?)";
		Object[] params = { user.getRoleId(), user.getUserName(), user.getUserPwd(), user.getUsertruename(),
				user.getUserState() };
		return this.executeUpdate(sql, params);
	}

	/**
	 * ��ȡ�û��б�
	 * 
	 * @throws SQLException
	 */
	@Override
	public List<Sysuser> getUserByLimit(Integer pageNo, Integer pageSize) {
		List<Sysuser> userList = new ArrayList<Sysuser>();
		conn = this.getConnection();
		String sql = "select USERID,ROLEID,USERNAME,USERTRUENAME,USERSTATE from SYSUSER limit ?,?";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, (pageNo - 1) * pageSize);
			p.setInt(2, pageSize);
			rs = p.executeQuery();
			while (rs.next()) {
				Sysuser user = new Sysuser();
				user.setUserId(rs.getInt("userId"));
				user.setRoleId(rs.getInt("roleId"));
				user.setUserName(rs.getString("userName"));
				user.setUsertruename(rs.getString("usertruename"));
				user.setUserState(rs.getInt("userState"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}

		return userList;
	}

	/**
	 * ��ȡ���û���
	 */
	@Override
	public Integer getTotalCount() {
		Integer result = 0;
		conn = this.getConnection();
		String sql = "select count(1) c from sysuser";
		try {
			p = conn.prepareStatement(sql);
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
	 * ��ȡ�û���ϸ��Ϣ
	 */
	@Override
	public Sysuser detail(Sysuser user) {
		conn = this.getConnection();
		String sql = "SELECT * FROM SYSUSER WHERE USERID=?";
		try {
			p = conn.prepareStatement(sql);
			p.setInt(1, user.getUserId());
			rs = p.executeQuery();
			while (rs.next()) {
				user = new Sysuser();
				user.setUserId(rs.getInt("userId"));
				user.setRoleId(rs.getInt("roleId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setUsertruename(rs.getString("usertruename"));
				user.setUserState(rs.getInt("userState"));
				user.setRolename(rs.getString("rolename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, p);
		}
		return user;
	}
	
	/**
	 * �޸��û�����
	 */
	@Override
	public Integer editpwd(Sysuser user) {
		String sql = "UPDATE SYSUSER SET USERPWD=? WHERE USERID=?";
		Object[] params = {user.getUserId(),user.getUserPwd()};
		return this.executeUpdate(sql, params);
	}
	
	/**
	 * �޸��û�
	 */
	@Override
	public Integer edit(Sysuser user) {
		String sql = "UPDATE SYSUSER SET ROLEID=?,USERNAME=?,"
				+ "USERPWD=?,USERTRUENAME=?,USERSTATE=? WHERE USERID=?";
		Object[] params = {user.getRoleId(),user.getUserName(),user.getUserPwd(),user.getUsertruename(),user.getUserState(),user.getUserId()};
		return this.executeUpdate(sql, params);
	}

}
