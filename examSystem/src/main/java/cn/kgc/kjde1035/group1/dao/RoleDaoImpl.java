package cn.kgc.kjde1035.group1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.kgc.kjde1035.group1.entity.Sysrole;

public class RoleDaoImpl extends BaseDao implements RoleDao {

	/*
	 * 鍒嗛〉鏌ヨ瑙掕壊
	 */
	@Override
	public List<Sysrole> findRolesLimit(int currentPageNo, int pageSize) {
		String sql = "select * from sysrole limit ?,?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Sysrole> roleList = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (currentPageNo - 1) * pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			roleList = new ArrayList<Sysrole>();
			while (rs.next()) {
				Sysrole role = new Sysrole(rs.getInt("roleId"), rs.getString("roleName"), rs.getInt("roleState"),
						rs.getString("roleDesc"));
				roleList.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			this.closeAll(rs, conn, ps);
		}
		return roleList;

	}

	/*
	 * 鏌ヨ瑙掕壊鐨勬�绘暟
	 */
	public Integer getCount() {
		String sql = "select count(roleId) from sysrole";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Sysrole> roleList = null;
		Integer count = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			roleList = new ArrayList<Sysrole>();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
		}

		return count;
	}

	/*
	 * 娣诲姞瑙掕壊
	 */
	@Override
	public boolean addRole(Sysrole role) {

		// 濡傛灉鍚屽悕鐨勮鑹插凡瀛樺湪鐩存帴杩斿洖false
		if (this.isExist(role.getRoleName())) {
			return false;
		}

		String sql = "insert into sysrole (roleName, roleState, roleDesc) values(?,?,?)";
		Object[] args = { role.getRoleName(), role.getRoleState(), role.getRoleDesc() };
		int result = this.executeUpdate(sql, args);
		if (result > 0)
			return true;
		return false;
	}

	// 鍒ゆ柇瑙掕壊鏄惁宸茬粡瀛樺湪
	public Boolean isExist(String roleName) {
		String sql = "select count(roleId) from sysrole where roleName=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, roleName);
			rs = ps.executeQuery();
			while (rs.next()) {
				int result = rs.getInt(1);
				if (result > 0)
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll(rs, conn, ps);
		}
		return false;
	}

	@Override
	public Sysrole queryRoleById(Integer id) {
		String sql = "select roleId ,roleName ,roleState, roleDesc from sysrole where roleid = ?";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Sysrole(rs.getInt("roleId"), rs.getString("roleName"), rs.getInt("roleState"),
						rs.getString("roleDesc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateRoel(Sysrole role) {
		String sql = "update sysrole set rolename = ?, roleState=?,roledesc=? where roleId=?";
		Object[] args = { role.getRoleName(), role.getRoleState(), role.getRoleDesc(), role.getRoleId() };
		int result = this.executeUpdate(sql, args);
		return result > 0;
	}

	@Override
	public Set<Integer> getFunction(Integer roleId) {
		String sql = "select funid from roleright where roleid = ?";
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<Integer> funids = new HashSet<Integer>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				funids.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funids;
	}

	/**
	 * 娓呴櫎瑙掕壊鐨勬墍鏈塮unction
	 * 
	 * 
	 */
	@Override
	public void clearFunByRoleId(Integer roleId) {
		String sql = "delete FROM roleright where roleId = ?";
		Object[] args = { roleId };
		this.executeUpdate(sql, args);

	}

	public static void main(String[] args) {
		RoleDaoImpl rd = new RoleDaoImpl();
		rd.clearFunByRoleId(2);
	}

	@Override
	public Boolean setFunctoinsToRole(Set<Integer> funIdSet, Integer roleId) {
		int size = funIdSet.size();
		int sum = 0;
		for (Integer funId : funIdSet) {
			sum+=this.setFunctionToRole(funId, roleId);
		}

		return sum==size;
	}

	public Integer setFunctionToRole(Integer funId,Integer roleId) {
		String sql = "insert into roleright (funid,roleid) values(?,?)";
		Object[] args = {funId,roleId};
		int result = this.executeUpdate(sql, args);
		return result;
	}

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * RoleDaoImpl().getFunction(-1)); }
	 */

	/*
	 * public static void main(String[] args) { System.out.println(new
	 * RoleDaoImpl().queryRoleById(-1)); }
	 */

}
