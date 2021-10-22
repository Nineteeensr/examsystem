package cn.kgc.kjde1035.group1.entity;

public class Sysrole {
	private int roleId;
	private String roleName;
	private int roleState;
	private String roleDesc;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleState() {
		return roleState;
	}

	public void setRoleState(int roleState) {
		this.roleState = roleState;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Sysrole(int roleId, String roleName, int roleState, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleState = roleState;
		this.roleDesc = roleDesc;
	}

	public Sysrole(String roleName, int roleState, String roleDesc) {
		super();
		this.roleName = roleName;
		this.roleState = roleState;
		this.roleDesc = roleDesc;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleState=" + roleState + ", roleDesc="
				+ roleDesc + "]";
	}

}
