package dto;

import java.sql.Date;

public class GameVO {
	private int gseq;
	private String name;
	private String version;
	private String content1;
	private String content2;
	private String developer;
	private int discountrate;
	private int price1;
	private int price2;
	private String genre;
	private String []tag;
	private String tag2;//게임 추가를 위함
	private int userrate;
	private int rate1;
	private int rate2;
	private String platform;
	private String violence;
	private Date releasedate;
	private Date modidate;
	private String useyn;
	private String specialofferyn;
	private String newgameyn;
	private String freegameyn;
	private String adgameyn;
	
	private String name_en;
	private String content1_en;
	private String content2_en;
	private String genre_en;
	private String []tag_en;
	
	private String keyart;
	private String portrait;
	private String []main;
	private String main2;//게임 추가를 위함
	
	private String min_os;
	private String min_memory;
	private String min_processor;
	private String min_vga;
	private String min_storage;
	private String max_os;
	private String max_memory;
	private String max_processor;
	private String max_vga;
	private String max_storage;

	public int getGseq() {
		return gseq;
	}
	public GameVO setGseq(int gseq) {
		this.gseq = gseq;
		return this;
	}
	public String getName() {
		return name;
	}
	public GameVO setName(String name) {
		this.name = name;
		return this;
	}
	
	public int getDiscountrate() {
		return discountrate;
	}
	public GameVO setDiscountrate(int discountrate) {
		this.discountrate = discountrate;
		return this;
	}
	public String getVersion() {
		return version;
	}
	public GameVO setVersion(String version) {
		this.version = version;
		return this;
	}
	public String getContent1() {
		return content1;
	}
	public GameVO setContent1(String content1) {
		this.content1 = content1;
		return this;
	}
	public String getContent2() {
		return content2;
	}
	public GameVO setContent2(String content2) {
		this.content2 = content2;
		return this;
	}
	public String getDeveloper() {
		return developer;
	}
	public GameVO setDeveloper(String developer) {
		this.developer = developer;
		return this;
	}
	public int getPrice1() {
		return price1;
	}
	public GameVO setPrice1(int price1) {
		this.price1 = price1;
		return this;
	}
	public int getPrice2() {
		return price2;
	}
	public GameVO setPrice2(int price2) {
		this.price2 = price2;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public GameVO setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String[] getTag() {
		return tag;
	}
	public GameVO setTag(String []tag) {
		this.tag = tag;
		return this;
	}
	
	public String getTag2() {
		return tag2;
	}
	public GameVO setTag2(String tag2) {
		this.tag2 = tag2;
		return this;
	}
	public int getUserrate() {
		return userrate;
	}
	public GameVO setUserrate(int userrate) {
		this.userrate = userrate;
		return this;
	}
	public int getRate1() {
		return rate1;
	}
	public GameVO setRate1(int rate1) {
		this.rate1 = rate1;
		return this;
	}
	public int getRate2() {
		return rate2;
	}
	public GameVO setRate2(int rate2) {
		this.rate2 = rate2;
		return this;
	}
	public String getPlatform() {
		return platform;
	}
	public GameVO setPlatform(String platform) {
		this.platform = platform;
		return this;
	}
	public String getViolence() {
		return violence;
	}
	public GameVO setViolence(String violence) {
		this.violence = violence;
		return this;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public GameVO setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
		return this;
	}
	public Date getModidate() {
		return modidate;
	}
	public GameVO setModidate(Date modidate) {
		this.modidate = modidate;
		return this;
	}
	
	public String getUseyn() {
		return useyn;
	}
	public GameVO setUseyn(String useyn) {
		this.useyn = useyn;
		return this;
	}
	public String getSpecialofferyn() {
		return specialofferyn;
	}
	public GameVO setSpecialofferyn(String specialofferyn) {
		this.specialofferyn = specialofferyn;
		return this;
	}
	public String getNewgameyn() {
		return newgameyn;
		
	}
	public GameVO setNewgameyn(String newgameyn) {
		this.newgameyn = newgameyn;
		return this;
	}
	public String getFreegameyn() {
		return freegameyn;
	}
	public GameVO setFreegameyn(String freegameyn) {
		this.freegameyn = freegameyn;
		return this;
	}
	
	public String getAdgameyn() {
		return adgameyn;
	}
	public GameVO setAdgameyn(String adgameyn) {
		this.adgameyn = adgameyn;
		return this;
	}
	//-----------------------------------------en
	public String getName_en() {
		return name_en;
	}
	public GameVO setName_en(String name_en) {
		this.name_en = name_en;
		return this;
	}
	public String getContent1_en() {
		return content1_en;
	}
	public GameVO setContent1_en(String content1_en) {
		this.content1_en = content1_en;
		return this;
	}
	public String getContent2_en() {
		return content2_en;
	}
	public GameVO setContent2_en(String content2_en) {
		this.content2_en = content2_en;
		return this;
	}
	public String getGenre_en() {
		return genre_en;
	}
	public GameVO setGenre_en(String genre_en) {
		this.genre_en = genre_en;
		return this;
	}
	public String[] getTag_en() {
		return tag_en;
	}
	public GameVO setTag_en(String []tag_en) {
		this.tag_en = tag_en;
		return this;
	}
//	---------------------------------------- image
	public String getKeyart() {
		return keyart;
	}
	public GameVO setKeyart(String keyart) {
		this.keyart = keyart;
		return this;
	}
	public String getPortrait() {
		return portrait;
	}
	public GameVO setPortrait(String portrait) {
		this.portrait = portrait;
		return this;
	}
	public String[] getMain() {
		return main;
	}
	public GameVO setMain(String []main) {
		this.main = main;
		return this;
	}
	
	public String getMain2() {
		return main2;
	}
	public GameVO setMain2(String main2) {
		this.main2 = main2;
		return this;
	}
	//	-------------------------------------- requirement
	public String getMin_os() {
		return min_os;
	}
	public GameVO setMin_os(String min_os) {
		this.min_os = min_os;
		return this;
	}
	public String getMin_memory() {
		return min_memory;
	}
	public GameVO setMin_memory(String min_memory) {
		this.min_memory = min_memory;
		return this;
	}
	public String getMin_processor() {
		return min_processor;
	}
	public GameVO setMin_processor(String min_processor) {
		this.min_processor = min_processor;
		return this;
	}
	public String getMin_vga() {
		return min_vga;
	}
	public GameVO setMin_vga(String min_vga) {
		this.min_vga = min_vga;
		return this;
	}
	public String getMin_storage() {
		return min_storage;
	}
	public GameVO setMin_storage(String min_storage) {
		this.min_storage = min_storage;
		return this;
	}
	public String getMax_os() {
		return max_os;
	}
	public GameVO setMax_os(String max_os) {
		this.max_os = max_os;
		return this;
	}
	public String getMax_memory() {
		return max_memory;
	}
	public GameVO setMax_memory(String max_memory) {
		this.max_memory = max_memory;
		return this;
	}
	public String getMax_processor() {
		return max_processor;
	}
	public GameVO setMax_processor(String max_processor) {
		this.max_processor = max_processor;
		return this;
	}
	public String getMax_vga() {
		return max_vga;
	}
	public GameVO setMax_vga(String max_vga) {
		this.max_vga = max_vga;
		return this;
	}
	public String getMax_storage() {
		return max_storage;
	}
	public GameVO setMax_storage(String max_storage) {
		this.max_storage = max_storage;
		return this;
	}
	

}
