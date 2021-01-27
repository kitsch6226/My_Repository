package dto;

import java.sql.Date;
import java.sql.Time;

public class LibraryVO {
	private int lseq;
	private String mail;
	private int gseq;
	private String name;
	private String name_en;
	private String keyart;
	private String portrait;
	private String version;
	private String downloadyn;
	private String genre;
	private String []tag;
	private String []tag_en;
	private Time playtime;
	private Date indate;
	private Date playdate;
	
	public int getLseq() {
		return lseq;
	}
	public LibraryVO setLseq(int lseq) {
		this.lseq = lseq;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public LibraryVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public int getGseq() {
		return gseq;
	}
	public LibraryVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	
	public String getName() {
		return name;
	}
	public LibraryVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getName_en() {
		return name_en;
	}
	public LibraryVO setName_en(String name_en) {
		this.name_en = name_en;
		return this;
	}
		
	public String getGenre() {
		return genre;
	}
	public LibraryVO setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String getKeyart() {
		return keyart;
	}
	public LibraryVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String getPortrait() {
		return portrait;
	}
	public LibraryVO setPortrait(String portrait) {
		this.portrait = portrait;
		return this;
	}
	public String[] getTag_en() {
		return tag_en;
	}
	public LibraryVO setTag_en(String []tag_en) {
		this.tag_en = tag_en;
		return this;
	}
	public String getVersion() {
		return version;
	}
	public LibraryVO setVersion(String version) {
		this.version = version;
		return this;
	}
	public String getDownloadyn() {
		return downloadyn;
	}
	public LibraryVO setDownloadyn(String downloadyn) {
		this.downloadyn = downloadyn;
		return this;
	}
	public String[] getTag() {
		return tag;
	}
	public LibraryVO setTag(String []tag) {
		this.tag = tag;
		return this;
	}
	public Time getPlaytime() {
		return playtime;
	}
	public LibraryVO setPlaytime(Time playtime) {
		this.playtime = playtime;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public LibraryVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public Date getPlaydate() {
		return playdate;
	}
	public LibraryVO setPlaydate(Date playdate) {
		this.playdate = playdate;
		return this;
	}
	
	
}
