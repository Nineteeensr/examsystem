/**  
 * 
 * @Title:  score.java   
 * @Package cn.kgc.kjde1035.group1.entity   
 * @Description:TODO()   
 * @author: CuiYuanGeng    
 * @date://2021/10/22 14:30:49
 * @version V1.0 
 * 
 * 
 */
package cn.kgc.kjde1035.group1.entity;

/**
 * @author 10217
 *
 */
public class Score {
	private Integer userId;
	private Integer totalScore;
	private Integer avgTotalScore;
	private String pname;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getAvgTotalScore() {
		return avgTotalScore;
	}
	public void setAvgTotalScore(Integer avgTotalScore) {
		this.avgTotalScore = avgTotalScore;
	}
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(Integer userId, Integer totalScore, Integer avgTotalScore, String pname) {
		super();
		this.userId = userId;
		this.totalScore = totalScore;
		this.avgTotalScore = avgTotalScore;
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Score [userId=" + userId + ", totalScore=" + totalScore + ", avgTotalScore=" + avgTotalScore
				+ ", pname=" + pname + "]";
	}
	
	
}
