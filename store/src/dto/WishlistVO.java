package dto;

import java.sql.Date;

public class WishlistVO {
	private int wseq;
	private int gseq;
	private String mail;
	private String name;
	private String name_en;
	private String keyart;
	private String []tag;
	private String []tag_en;
	private Date indate;
	private int Price;
	private int discountrate;
	private int rate1;
	private int rate2;
	private int userrate;
	private String specialofferyn;
	private String platform;
	
	public int getWseq() {
		return wseq;
	}
	public WishlistVO setWseq(int wseq) {
		this.wseq = wseq;
		return this;
	}
	public int getGseq() {
		return gseq;
	}
	public WishlistVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	public String getMail() {
		return mail;
	}
	public WishlistVO setMail(String mail) {
		this.mail = mail;
		return this;
	}
	public String getName() {
		return name;
	}
	public WishlistVO setName(String name) {
		this.name = name;
		return this;
	}
	public String getName_en() {
		return name_en;
	}
	public WishlistVO setName_en(String name_en) {
		this.name_en = name_en;
		return this;
	}
	public String getKeyart() {
		return keyart;
	}
	public WishlistVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String[] getTag() {
		return tag;
	}
	public WishlistVO setTag(String []tag) {
		this.tag = tag;
		return this;
	}
	
	public String[] getTag_en() {
		return tag_en;
	}
	public WishlistVO setTag_en(String[] tag_en) {
		this.tag_en = tag_en;
		return this;
	}
	public Date getIndate() {
		return indate;
	}
	public WishlistVO setIndate(Date indate) {
		this.indate = indate;
		return this;
	}
	public int getPrice() {
		return Price;
	}
	public WishlistVO setPrice(int price) {
		Price = price;
		return this;
	}
	public int getDiscountrate() {
		return discountrate;
	}
	public WishlistVO setDiscountrate(int discountrate) {
		this.discountrate = discountrate;
		return this;
	}
	public int getRate1() {
		return rate1;
	}
	public WishlistVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public WishlistVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public int getUserrate() {
		return userrate;
	}
	public WishlistVO setUserrate(int userrate) {
		this.userrate = userrate;
		return this;
	}
	public String getSpecialofferyn() {
		return specialofferyn;
	}
	public WishlistVO setSpecialofferyn(String specialofferyn) {
		this.specialofferyn = specialofferyn;
		return this;
	}
	public String getPlatform() {
		return platform;
	}
	public WishlistVO setPlatform(String platform) {
		this.platform = platform;
		return this;
	}
	
}
