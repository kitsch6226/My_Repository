package dto;

import java.sql.Date;

public class OrderVO {
	private int oseq;
	private int gseq;
	private int wseq;
	private String mail;
	private String name;
	private String name_en;
	private String keyart;
	private String platform;
	private int Price;
	private int discountrate;
	private String specialofferyn;
	private Date indate;
	
	public int getOseq() {
		return oseq;
	}
	public OrderVO setOseq(int oseq) {
		this.oseq = oseq;
		return this;
	}
	
	public int getGseq() {
		return gseq;
	}
	public OrderVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	
	public int getWseq() {
		return wseq;
	}
	public OrderVO setWseq(int wseq) {
		this.wseq = wseq;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public OrderVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public OrderVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public String getName() {
		return name;
	}
	public OrderVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getName_en() {
		return name_en;
	}
	public OrderVO setName_en(String name_en) {
		this.name_en = name_en;
		return this;
	}
	public String getKeyart() {
		return keyart;
	}
	public OrderVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String getPlatform() {
		return platform;
	}
	public OrderVO setPlatform(String platform) {
		this.platform = platform;
		return this;
	}
	public int getPrice() {
		return Price;
	}
	public OrderVO setPrice(int price) {
		Price = price;
		return this;
	}
	
	public int getDiscountrate() {
		return discountrate;
	}
	public OrderVO setDiscountrate(int discountrate) {
		this.discountrate = discountrate;
		return this;
	}
	public String getSpecialofferyn() {
		return specialofferyn;
	}
	public OrderVO setSpecialofferyn(String specialofferyn) {
		this.specialofferyn = specialofferyn;
		return this;
	}
	
}
