package dto;

import java.sql.Date;

public class ArtworkVO {
	private int aseq;
	private String image;
	private String mail;
	private String rate;
	private int rate1;
	private int rate2;
	private Date indate;
	private String useyn;
	
	public int getAseq() {
		return aseq;
	}
	public ArtworkVO setAseq(int aseq) {
		this.aseq = aseq;
		return this;
	}
	public String getImage() {
		return image;
	}
	public ArtworkVO setImage(String image) {
		this.image = image;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public ArtworkVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	
	public String getRate() {
		return rate;
	}
	public ArtworkVO setRate(String rate) {
		this.rate = rate;
		return this;
	}
	public int getRate1() {
		return rate1;
	}
	public ArtworkVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public ArtworkVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public ArtworkVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public String getUseyn() {
		return useyn;
	}
	public ArtworkVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	
	
	
}
