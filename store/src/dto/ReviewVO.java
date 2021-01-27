package dto;

import java.sql.Date;

public class ReviewVO {
	private int rseq;
	private int gseq;
	private String gname;
	private String keyart;
	private String mail;
	private String content;
	private String rate;
	private int rate1;
	private int rate2;
	private String useyn;
	private Date indate;
	private Date modidate;
	private String image;
	private String name;
	private int gamenumb;
	
	public int getRseq() {
		return rseq;
	}
	public ReviewVO setRseq(int rseq) {
		this.rseq = rseq;
		return this;
	}
	
	public int getGseq() {
		return gseq;
	}
	public ReviewVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	
	public String getGname() {
		return gname;
	}
	public ReviewVO setGname(String gname) {
		this.gname = gname;
		return this;
	}
	public String getKeyart() {
		return keyart;
	}
	public ReviewVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public ReviewVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public String getContent() {
		return content;
	}
	public ReviewVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getRate() {
		return rate;
	}
	public ReviewVO setRate(String rate) {
		this.rate = rate;
		return this;
	}
	public int getRate1() {
		return rate1;
	}
	public ReviewVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public ReviewVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public ReviewVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public ReviewVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public Date getModidate() {
		return modidate;
	}
	public ReviewVO setModidate(Date modidate) {
		this.modidate = modidate;
		return this;
	}
	public String getImage() {
		return image;
	}
	public ReviewVO setImage(String image) {
		this.image = image;
		return this;
	}
	public String getName() {
		return name;
	}
	public ReviewVO setName(String name) {
		this.name = name;
		return this;
	}
	public int getGamenumb() {
		return gamenumb;
	}
	public ReviewVO setGamenumb(int gamenumb) {
		this.gamenumb = gamenumb;
		return this;
	}
	
	
}
