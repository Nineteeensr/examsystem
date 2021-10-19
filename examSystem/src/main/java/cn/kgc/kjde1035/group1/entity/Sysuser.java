package cn.kgc.kjde1035.group1.entity;

/**
 * 用户实体
 * 
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
	private String usertruename;
	private String userPwd;
	private Integer userState;

	private String rolename;
	private Integer phone;
	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

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

	public String getUsertruename() {
		return usertruename;
	}

	public void setUsertruename(String usertruename) {
		this.usertruename = usertruename;
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

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Sysuser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Sysuser(Integer userId, Integer roleId, String userName, String usertruename, String userPwd,
			Integer userState, String rolename, Integer phone) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.usertruename = usertruename;
		this.userPwd = userPwd;
		this.userState = userState;
		this.rolename = rolename;
		this.phone = phone;
	}

	public Sysuser(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Sysuser(String userName, String userPwd, Integer phone) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	public Sysuser( String userPwd, String usertruename, Integer userState, Integer phone,Integer roleId) {
		super();
		this.userPwd = userPwd;
		this.usertruename = usertruename;
		this.userState = userState;
		this.phone = phone;
		this.roleId = roleId;
	}
	
}
