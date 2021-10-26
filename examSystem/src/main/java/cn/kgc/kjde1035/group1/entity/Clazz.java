package cn.kgc.kjde1035.group1.entity;

public class Clazz {
	private Integer clazzId;
	private String clazzName;
	private Integer tuserid;
	private Integer speciaid;
	private Integer userCount;
	
	
	
	public Integer getUserCount() {
		return userCount;
	}


	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}


	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Clazz(Integer clazzId, String clazzName, Integer tuserid, Integer speciaid) {
		super();
		this.clazzId = clazzId;
		this.clazzName = clazzName;
		this.tuserid = tuserid;
		this.speciaid = speciaid;
	}
	
	


	@Override
	public String toString() {
		return "Clazz [clazzId=" + clazzId + ", clazzName=" + clazzName + ", tuserid=" + tuserid + ", speciaid="
				+ speciaid + "]";
	}
	public Integer getClazzId() {
		return clazzId;
	}
	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
	public String getClazzName() {
		return clazzName;
	}
	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}
	public Integer getTuserid() {
		return tuserid;
	}
	public void setTuserid(Integer tuserid) {
		this.tuserid = tuserid;
	}
	public Integer getSpeciaid() {
		return speciaid;
	}
	public void setSpeciaid(Integer speciaid) {
		this.speciaid = speciaid;
	}
	
	
}
