package dto;

import java.sql.Date;

public class User {
	private int num;
	private int mseq;
	private String name;
	private String mail;
	private String pw;
	private String image;
	private int point;
	private String useyn;
	private int gamenumb;
	private Date indate;
	private Date modidate;
	
	
	public int getNum() {
		return num;
	}
	public User setNum(int num) {
		this.num = num;
		return this;
	}
	
	public int getMseq() {
		return mseq;
	}
	public User setMseq(int mseq) {
		this.mseq = mseq;
		return this;
	}
	public String getName() {
		return name;
	}
	public User setName(String name) {
		this.name = name;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public User setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public String getPw() {
		return pw;
	}
	public User setPw(String pw) {
		this.pw = pw;
		return this;
	}
	public String getImage() {
		return image;
	}
	public User setImage(String image) {
		this.image = image;
		return this;
	}
	public int getPoint() {
		return point;
	}
	public User setPoint(int point) {
		this.point = point;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public User setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	
	public int getGamenumb() {
		return gamenumb;
	}
	public User setGamenumb(int gamenumb) {
		this.gamenumb = gamenumb;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public User setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public Date getModidate() {
		return modidate;
	}
	public User setModidate(Date modidate) {
		this.modidate = modidate;
		return this;
	}
}
