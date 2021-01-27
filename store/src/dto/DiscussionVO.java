package dto;

import java.sql.Date;

public class DiscussionVO {
	private int dseq;
	private String kind;
	private String mail;
	private String name;
	private String []image;
	private String subject;
	private String content;
	private int reply;
	private String useyn;
	private String rate;
	private int rate1;
	private int rate2;
	private int view;
	private Date indate;
	private Date modidate;
	
	public int getDseq() {
		return dseq;
	}
	public DiscussionVO setDseq(int dseq) {
		this.dseq = dseq;
		return this;
	}
	
	public String getKind() {
		return kind;
	}
	public DiscussionVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getName() {
		return name;
	}
	public DiscussionVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public DiscussionVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	
	public String[] getImage() {
		return image;
	}
	public DiscussionVO setImage(String[] image) {
		this.image = image;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public DiscussionVO setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public DiscussionVO setContent(String content) {
		this.content = content;
		return this;
	}
	public int getReply() {
		return reply;
	}
	public DiscussionVO setReply(int reply) {
		this.reply = reply;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public DiscussionVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public int getRate1() {
		return rate1;
	}
	
	public String getRate() {
		return rate;
	}
	public DiscussionVO setRate(String rate) {
		this.rate = rate;
		return this;
	}
	public DiscussionVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public DiscussionVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public int getView() {
		return view;
	}
	public DiscussionVO setView(int view) {
		this.view = view;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public DiscussionVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public Date getModidate() {
		return modidate;
	}
	public DiscussionVO setModidate(Date modidate) {
		this.modidate = modidate;
		return this;
	}
	
}
