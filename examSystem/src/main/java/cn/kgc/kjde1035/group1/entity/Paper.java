package cn.kgc.kjde1035.group1.entity;

public class Paper {
	private String pname;
	private Integer sid;
	private Integer scount;
	private Integer pid;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getScount() {
		return scount;
	}
	public void setScount(Integer scount) {
		this.scount = scount;
	}
	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paper(String pname, Integer sid, Integer scount, Integer pid) {
		super();
		this.pname = pname;
		this.sid = sid;
		this.scount = scount;
		this.pid = pid;
	}
	
}
