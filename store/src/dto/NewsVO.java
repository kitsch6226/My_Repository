package dto;

import java.sql.Date;

public class NewsVO {
	private int nseq;
	private int gseq;
	private String name;
	private String kind;
	private String keyart;
	private String subject;
	private String content;
	private Date indate;
	
	public int getNseq() {
		return nseq;
	}
	public NewsVO setNseq(int nseq) {
		this.nseq = nseq;
		return this;
	}
	public int getGseq() {
		return gseq;
	}
	public NewsVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public NewsVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getKind() {
		return kind;
	}
	public NewsVO setKind(String kind) {
		this.kind = kind;
		return this;
	}
	public String getKeyart() {
		return keyart;
	}
	public NewsVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String getSubject() {
		return subject;
	}
	public NewsVO setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public String getContent() {
		return content;
	}
	public NewsVO setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public NewsVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
}
