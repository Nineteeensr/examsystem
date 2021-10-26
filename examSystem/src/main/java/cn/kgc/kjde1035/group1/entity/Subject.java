package cn.kgc.kjde1035.group1.entity;

/**
 * @author 61780
 *
 */
public class Subject {
	private Integer sid;
	private Integer randomid;
	private String scontent;
	private String sa;
	private String sb;
	private String sc;
	private String sd;
	private String skey;
	private Integer sstate;
	private String studentkey;
	private Integer speciaid;

	public Integer getSpeciaid() {
		return speciaid;
	}

	public void setSpeciaid(Integer speciaid) {
		this.speciaid = speciaid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getRandomid() {
		return randomid;
	}

	public void setRandomid(Integer randomid) {
		this.randomid = randomid;
	}

	public String getScontent() {
		return scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	public String getSa() {
		return sa;
	}

	public void setSa(String sa) {
		this.sa = sa;
	}

	public String getSb() {
		return sb;
	}

	public void setSb(String sb) {
		this.sb = sb;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public Integer getSstate() {
		return sstate;
	}

	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}

	public String getStudentkey() {
		return studentkey;
	}

	public void setStudentkey(String studentkey) {
		this.studentkey = studentkey;
	}

	public Subject(Integer sid, String scontent, String sa, String sb, String sc, String sd, String skey,
			Integer sstate) {
		super();
		this.sid = sid;
		this.scontent = scontent;
		this.sa = sa;
		this.sb = sb;
		this.sc = sc;
		this.sd = sd;
		this.skey = skey;
		this.sstate = sstate;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(String scontent, String sa, String sb, String sc, String sd, String skey, Integer sstate) {
		super();
		this.scontent = scontent;
		this.sa = sa;
		this.sb = sb;
		this.sc = sc;
		this.sd = sd;
		this.skey = skey;
		this.sstate = sstate;
	}

	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", scontent=" + scontent + ", sa=" + sa + ", sb=" + sb + ", sc=" + sc + ", sd="
				+ sd + ", skey=" + skey + ", sstate=" + sstate + "]";
	}
	public Subject(Integer sid, String scontent, String sa, String sb, String sc, String sd, String skey) {
		super();
		this.sid = sid;
		this.scontent = scontent;
		this.sa = sa;
		this.sb = sb;
		this.sc = sc;
		this.sd = sd;
		this.skey = skey;
	}
}
