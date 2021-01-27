package dto;

import java.sql.Date;

public class ReplyVO {
	private int dseq;
	private int reseq;
	private int qseq;
	private int qreseq;
	private String mail;
	private String name;
	private String content;
	private String rate;
	private int rate1;
	private int rate2;
	private String useyn;
	private Date indate;
	private Date modidate;
	
	public int getRseq() {
		return dseq;
	}
	public ReplyVO setDseq(int dseq) {
		this.dseq = dseq;
		return this;
	}
	public int getReseq() {
		return reseq;
	}
	public ReplyVO setReseq(int reseq) {
		this.reseq = reseq;
		return this;
	}
	
	public int getQseq() {
		return qseq;
	}
	public ReplyVO setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public int getQreseq() {
		return qreseq;
	}
	public ReplyVO setQreseq(int qreseq) {
		this.qreseq = qreseq;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public ReplyVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public ReplyVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getContent() {
		return content;
	}
	public ReplyVO setContent(String content) {
		this.content = content;
		return this;
	}
	
	public String getRate() {
		return rate;
	}
	public ReplyVO setRate(String rate) {
		this.rate = rate;
		return this;
	}
	public int getDseq() {
		return dseq;
	}
	public int getRate1() {
		return rate1;
	}
	public ReplyVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public ReplyVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public ReplyVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public ReplyVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public Date getModidate() {
		return modidate;
	}
	public ReplyVO setModidate(Date modidate) {
		this.modidate = modidate;
		return this;
	}
}
