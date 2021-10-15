/**  
 * 
 * @Title:  User.java   
 * @Package entity   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/14 10:44:36
 * @version V1.0 
 * 
 * 
 */
package entity;

/**
 * @author 10217
 *
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private Integer age;
	private String sex;
	private String nickName;
	private String userType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String password, Integer age, String sex, String nickName, String userType) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.nickName = nickName;
		this.userType = userType;
	}
	
}
