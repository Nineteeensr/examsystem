package cn.kgc.kjde1035.group1.entity;

public class User {
	private Integer userId;
	private Integer roleId;
	private String userName;
	private String userPwd;
	private String userTrueName;
	private Integer UserState;
	private Integer phone;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public int getUserState() {
		return UserState;
	}

	public void setUserState(int userState) {
		UserState = userState;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int roleId, String userName, String userPwd, String userTrueName, int userState) {
		super();
		this.roleId = roleId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTrueName = userTrueName;
		UserState = userState;
	}

	public User(int userId, int roleId, String userName, String userPwd, String userTrueName, int userState) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userTrueName = userTrueName;
		UserState = userState;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setUserState(Integer userState) {
		UserState = userState;
	}

	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
}
