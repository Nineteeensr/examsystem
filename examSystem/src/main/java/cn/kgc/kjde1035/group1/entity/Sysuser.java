package cn.kgc.kjde1035.group1.entity;
/**
 * 用户实体
 * @author Administrator
 *
 */
public class Sysuser {

	/**
	 * 注意写注�?
	 */
	private Integer userId;
	private Integer roleId;
	private String userName;
	private String userTrueName;
	private String userPwd;
	private Integer userState;
	
	private String roleName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Sysuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sysuser(Integer userId, Integer roleId, String userName, String userTrueName, String userPwd,
			Integer userState, String roleName) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.userTrueName = userTrueName;
		this.userPwd = userPwd;
		this.userState = userState;
		this.roleName = roleName;
	}

	public Sysuser(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
	

	
	
	
}
