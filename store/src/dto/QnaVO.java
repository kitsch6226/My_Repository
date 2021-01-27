package dto;

import java.sql.Date;

public class QnaVO {
	private int qseq;
	private String kind;
	private String mail;
	private String subject;
	private String content;
	private String replyyn;
	private String usercheckyn;
	private Date indate;
	
	public int getQseq() {
		return qseq;
	}
	public QnaVO setQseq(int qseq) {
		this.qseq = qseq;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public QnaVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	
	public String getMail() {
		return mail;
	}
	public QnaVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public QnaVO setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public QnaVO setContent(String content) {
		this.content = content;
		return this;
	}
	public String getReplyyn() {
		return replyyn;
	}
	public QnaVO setReplyyn(String replyyn) {
		this.replyyn = replyyn;
		return this;
	}
	public String getUsercheckyn() {
		return usercheckyn;
	}
	public QnaVO setUsercheckyn(String usercheckyn) {
		this.usercheckyn = usercheckyn;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public QnaVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	
	
}
