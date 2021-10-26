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
	public Integer getClazzId() {
		return clazzId;
	}

	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}

	private Integer roleId;
	private String userName;
	private String usertruename;
	private String userPwd;
	private Integer userState;
	private Integer clazzId;
	private String clazzName;

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	private String rolename;
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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
			Integer userState, String rolename, String phone) {
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

	public Sysuser(String userName, String userPwd, String phone) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.phone = phone;
	}

	public Sysuser(String userPwd, String usertruename, Integer userState, String phone, Integer roleId) {
		super();
		this.userPwd = userPwd;
		this.usertruename = usertruename;
		this.userState = userState;
		this.phone = phone;
		this.roleId = roleId;
	}
	public Sysuser(String userPwd, String usertruename, Integer userState, String phone, Integer roleId,Integer clazzId) {
		super();
		this.userPwd = userPwd;
		this.usertruename = usertruename;
		this.userState = userState;
		this.phone = phone;
		this.roleId = roleId;
		this.clazzId=clazzId;
	}
}
