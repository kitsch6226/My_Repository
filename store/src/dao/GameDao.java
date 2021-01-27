package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.GameVO;
import dto.LibraryVO;
import dto.OrderVO;
import dto.WishlistVO;
import store.Component;
import store.DBAction;

@Component("gameDao")
public class GameDao {
	public int addGame(GameVO gameInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int discountrate = 100-(int)(((double)gameInfo.getPrice2()/(double)(gameInfo.getPrice1()))*100);
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("insert into game(name,content1,content2,tag,price1,price2,discountrate,platform,violence,specialofferyn,newgameyn,adgameyn,freegameyn,developer,genre)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, gameInfo.getName());
			pstmt.setString(2, gameInfo.getContent1());
			pstmt.setString(3, gameInfo.getContent2());
			pstmt.setString(4, gameInfo.getTag2());
			pstmt.setInt(5, gameInfo.getPrice1());
			pstmt.setInt(6, gameInfo.getPrice2());
			pstmt.setInt(7, discountrate);
			pstmt.setString(8, gameInfo.getPlatform());
			pstmt.setString(9, gameInfo.getViolence());
			pstmt.setString(10, gameInfo.getSpecialofferyn());
			pstmt.setString(11, gameInfo.getNewgameyn());
			pstmt.setString(12, gameInfo.getAdgameyn());
			pstmt.setString(13, gameInfo.getFreegameyn());
			pstmt.setString(14, gameInfo.getDeveloper());
			pstmt.setString(15, gameInfo.getGenre());
			int result =pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into gameimage(keyart,portrait,main) values(?,?,?)");
				pstmt.setString(1, gameInfo.getKeyart());
				pstmt.setString(2, gameInfo.getPortrait());
				pstmt.setString(3, gameInfo.getMain2());
				result = pstmt.executeUpdate();
				if(result>=0) {
					pstmt.close();
					pstmt= conn.prepareStatement("insert into gamereq(min_os,min_memory,min_storage,min_vga,min_processor,max_os,max_memory,max_storage,max_vga,max_processor)"
							+ " values(?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, gameInfo.getMin_os());
					pstmt.setString(2, gameInfo.getMin_memory());
					pstmt.setString(3, gameInfo.getMin_storage());
					pstmt.setString(4, gameInfo.getMin_vga());
					pstmt.setString(5, gameInfo.getMin_processor());
					pstmt.setString(6, gameInfo.getMax_os());
					pstmt.setString(7, gameInfo.getMax_memory());
					pstmt.setString(8, gameInfo.getMax_storage());
					pstmt.setString(9, gameInfo.getMax_vga());
					pstmt.setString(10, gameInfo.getMax_processor());
					return pstmt.executeUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int installGame(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE library SET DOWNLOADYN='y' WHERE MAIL=? AND GSEQ=?");
			pstmt.setString(1, mail);
			pstmt.setInt(2, gseq);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int updateGameNoImage(GameVO gameInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int discountrate = 100-(int)(((double)gameInfo.getPrice2()/(double)(gameInfo.getPrice1()))*100);
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE game SET name=?, content1=?, content2=?, tag=?, specialofferyn=?, freegameyn=?, newgameyn=?, adgameyn=?,price1=?,price2=?,discountrate=?,useyn=?, modidate=now() WHERE gseq=?");
			pstmt.setString(1, gameInfo.getName());
			pstmt.setString(2, gameInfo.getContent1());
			pstmt.setString(3, gameInfo.getContent2());
			pstmt.setString(4, gameInfo.getTag2());
			pstmt.setString(5, gameInfo.getSpecialofferyn());
			pstmt.setString(6, gameInfo.getFreegameyn());
			pstmt.setString(7, gameInfo.getNewgameyn());
			pstmt.setString(8, gameInfo.getAdgameyn());
			pstmt.setInt(9, gameInfo.getPrice1());
			pstmt.setInt(10, gameInfo.getPrice2());
			pstmt.setInt(11, discountrate);
			pstmt.setString(12, gameInfo.getUseyn());
			pstmt.setInt(13, gameInfo.getGseq());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int updateGame(GameVO gameInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int discountrate = 100-(int)(((double)gameInfo.getPrice2()/(double)(gameInfo.getPrice1()))*100);
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(
					"UPDATE game SET name=?, content1=?, content2=?, tag=?, specialofferyn=?, freegameyn=?, newgameyn=?, adgameyn=?,price1=?,price2=?,discountrate=?,useyn=?, modidate=now() WHERE gseq=?");
			pstmt.setString(1, gameInfo.getName());
			pstmt.setString(2, gameInfo.getContent1());
			pstmt.setString(3, gameInfo.getContent2());
			pstmt.setString(4, gameInfo.getTag2());
			pstmt.setString(5, gameInfo.getSpecialofferyn());
			pstmt.setString(6, gameInfo.getFreegameyn());
			pstmt.setString(7, gameInfo.getNewgameyn());
			pstmt.setString(8, gameInfo.getAdgameyn());
			pstmt.setInt(9, gameInfo.getPrice1());
			pstmt.setInt(10, gameInfo.getPrice2());
			pstmt.setInt(11, discountrate);
			pstmt.setString(12, gameInfo.getUseyn());
			pstmt.setInt(13, gameInfo.getGseq());
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("UPDATE gameimage SET keyart=? WHERE gseq=?");
				pstmt.setString(1, gameInfo.getKeyart());
				pstmt.setInt(2, gameInfo.getGseq());
				return pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public int deleteGame(int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE game SET useyn='n' WHERE gseq=?");
			pstmt.setInt(1, gseq);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	public ArrayList<OrderVO> selectOrdersGames(String mail) {
		ArrayList<OrderVO> ordersGames = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM ORDERS_VIEW WHERE MAIL='" + mail + "' order by INDATE desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderVO game = new OrderVO();
				//무료 게임이라면
				if(rs.getString("freegameyn").contentEquals("y")) {
					game.setOseq(rs.getInt("oseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
					.setPrice(0)
					.setKeyart(rs.getString("keyart"))
					.setIndate(rs.getDate("indate"))
					.setPlatform(rs.getString("platform"))
					.setSpecialofferyn(rs.getString("specialofferyn"))
//					.setName_en(rs.getString("name_en")).setTag_en(tag_en)
					;
					ordersGames.add(game);
				}
				// 할인중일 때
				else if (rs.getString("specialofferyn").contentEquals("y")) {
					game.setOseq(rs.getInt("oseq")).setGseq(rs.getInt("gseq")).setMail(rs.getString("mail"))
							.setName(rs.getString("name"))
//							.setName_en(rs.getString("name_en"))
							.setPrice(rs.getInt("price2")).setKeyart(rs.getString("keyart"))
							.setIndate(rs.getDate("indate")).setPlatform(rs.getString("platform"))
							.setDiscountrate(rs.getInt("discountrate"))
							.setSpecialofferyn(rs.getString("specialofferyn"));
					ordersGames.add(game);
					// 할인중이 아닐 때
				} else {
					game.setOseq(rs.getInt("oseq")).setGseq(rs.getInt("gseq")).setMail(rs.getString("mail"))
							.setName(rs.getString("name"))
//							.setName_en(rs.getString("name_en"))
							.setPrice(rs.getInt("price1")).setKeyart(rs.getString("keyart"))
							.setIndate(rs.getDate("indate")).setPlatform(rs.getString("platform"))
							.setDiscountrate(rs.getInt("discountrate"))
							.setSpecialofferyn(rs.getString("specialofferyn"));
					ordersGames.add(game);
				}
			}
			return ordersGames;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<LibraryVO> selectLibraryGamesOrderByDownload(String mail) {
		ArrayList<LibraryVO> libraryGames = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM LIBRARY_VIEW WHERE MAIL='" + mail + "' order by downloadyn desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LibraryVO game = new LibraryVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				game.setLseq(rs.getInt("lseq")).setMail(rs.getString("mail")).setGseq(rs.getInt("gseq"))
						.setName(rs.getString("name")).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setTag(tag)
//						.setTag_en(tag_en).setName_en(rs.getString("name_en"))
						.setPlaytime(rs.getTime("playtime")).setIndate(rs.getDate("indate"))
						.setPlaydate(rs.getDate("playdate")).setDownloadyn(rs.getString("downloadyn"));
				libraryGames.add(game);
			}
			return libraryGames;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<LibraryVO> selectLibraryGamesOrderByRate(String mail) {
		ArrayList<LibraryVO> libraryGames = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM LIBRARY_VIEW WHERE MAIL='" + mail + "' order by rate1-rate2 desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LibraryVO game = new LibraryVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				game.setLseq(rs.getInt("lseq")).setMail(rs.getString("mail")).setGseq(rs.getInt("gseq"))
						.setName(rs.getString("name")).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setTag(tag)
//						.setTag_en(tag_en).setName_en(rs.getString("name_en"))
						.setPlaytime(rs.getTime("playtime")).setIndate(rs.getDate("indate"))
						.setPlaydate(rs.getDate("playdate")).setDownloadyn(rs.getString("downloadyn"));
				libraryGames.add(game);
			}
			return libraryGames;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<LibraryVO> selectLibraryGamesOrderByIndate(String mail) {
		ArrayList<LibraryVO> libraryGames = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM LIBRARY_VIEW WHERE MAIL='" + mail + "' order by INDATE desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				LibraryVO game = new LibraryVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				game.setLseq(rs.getInt("lseq")).setMail(rs.getString("mail")).setGseq(rs.getInt("gseq"))
						.setName(rs.getString("name")).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setTag(tag)
//						.setTag_en(tag_en).setName_en(rs.getString("name_en"))
						.setPlaytime(rs.getTime("playtime")).setIndate(rs.getDate("indate"))
						.setPlaydate(rs.getDate("playdate")).setDownloadyn(rs.getString("downloadyn"));
				libraryGames.add(game);
			}
			return libraryGames;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<WishlistVO> selectWishlistGamesOrderByDiscount(String mail) {
		ArrayList<WishlistVO> wishlistGames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM WISHLIST_VIEW WHERE MAIL='" + mail + "' order by freegameyn desc, specialofferyn desc, discountrate desc");
			while (rs.next()) {
				WishlistVO game = new WishlistVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				
				//무료 게임이라면
				if(rs.getString("freegameyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
					.setPrice(0)
					.setKeyart(rs.getString("keyart")).setTag(tag)
					.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
					.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
					.setSpecialofferyn(rs.getString("specialofferyn"))
//					.setName_en(rs.getString("name_en")).setTag_en(tag_en)
					;
					wishlistGames.add(game);
				}
				// 할인중인 상품일 때
				else if (rs.getString("specialofferyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price2"))
							.setDiscountrate(rs.getInt("discountrate")).setKeyart(rs.getString("keyart")).setTag(tag)
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
							.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"))
//							.setName_en(rs.getString("name_en")).setTag_en(tag_en)
							;
					wishlistGames.add(game);
					// 할인중이 아닐 때
				} else {
					 
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price1"))
							.setKeyart(rs.getString("keyart")).setTag(tag)
//							.setTag_en(tag_en).setName_en(rs.getString("name_en"))
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2"))
							.setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"));
					wishlistGames.add(game);
				}
				
			}
			return wishlistGames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<WishlistVO> selectWishlistGamesOrderByIndate(String mail) {
		ArrayList<WishlistVO> wishlistGames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM WISHLIST_VIEW WHERE MAIL='" + mail + "' order by indate desc");
			while (rs.next()) {
				WishlistVO game = new WishlistVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				
				//무료 게임이라면
				if(rs.getString("freegameyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
					.setPrice(0)
					.setKeyart(rs.getString("keyart")).setTag(tag)
					.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
					.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
					.setSpecialofferyn(rs.getString("specialofferyn"))
//					.setName_en(rs.getString("name_en")).setTag_en(tag_en)
					;
					wishlistGames.add(game);
				}
				// 할인중인 상품일 때
				else if (rs.getString("specialofferyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price2"))
							.setDiscountrate(rs.getInt("discountrate")).setKeyart(rs.getString("keyart")).setTag(tag)
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
							.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"))
//							.setName_en(rs.getString("name_en")).setTag_en(tag_en)
							;
					wishlistGames.add(game);
					// 할인중이 아닐 때
				} else {
					 
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price1"))
							.setKeyart(rs.getString("keyart")).setTag(tag)
//							.setTag_en(tag_en).setName_en(rs.getString("name_en"))
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2"))
							.setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"));
					wishlistGames.add(game);
				}
				
			}
			return wishlistGames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<WishlistVO> selectWishlistGamesOrderByRate(String mail) {
		ArrayList<WishlistVO> wishlistGames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM WISHLIST_VIEW WHERE MAIL='" + mail + "' order by rate1-rate2 desc, rate1 desc");
			while (rs.next()) {
				WishlistVO game = new WishlistVO();
				String[] tag = rs.getString("tag").trim().split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				
				//무료 게임이라면
				if(rs.getString("freegameyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
					.setPrice(0)
					.setKeyart(rs.getString("keyart")).setTag(tag)
					.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
					.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
					.setSpecialofferyn(rs.getString("specialofferyn"))
//					.setName_en(rs.getString("name_en")).setTag_en(tag_en)
					;
					wishlistGames.add(game);
				}
				// 할인중인 상품일 때
				else if (rs.getString("specialofferyn").contentEquals("y")) {
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price2"))
							.setDiscountrate(rs.getInt("discountrate")).setKeyart(rs.getString("keyart")).setTag(tag)
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1"))
							.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"))
//							.setName_en(rs.getString("name_en")).setTag_en(tag_en)
							;
					wishlistGames.add(game);
					// 할인중이 아닐 때
				} else {
					
					game.setWseq(rs.getInt("wseq")).setGseq(rs.getInt("gseq")).setName(rs.getString("name"))
							.setPrice(rs.getInt("price1"))
							.setKeyart(rs.getString("keyart")).setTag(tag)
//							.setTag_en(tag_en).setName_en(rs.getString("name_en"))
							.setIndate(rs.getDate("indate")).setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2"))
							.setPlatform(rs.getString("platform")).setUserrate(userrate)
							.setSpecialofferyn(rs.getString("specialofferyn"));
					wishlistGames.add(game);
				}
				
			}
			return wishlistGames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean selectOrdersGame(int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM ORDERS_VIEW WHERE GSEQ='" + gseq + "' and MAIL='" + mail + "'");
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean selectWishlistGame(int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM WISHLIST WHERE GSEQ='" + gseq + "' and MAIL='" + mail + "'");
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean selectLibraryGame(int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM LIBRARY WHERE GSEQ='" + gseq + "' and MAIL='" + mail + "'");
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public ArrayList<GameVO> selectNewGame() {
		ArrayList<GameVO> newgames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where newgameyn='y' order by releasedate desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setGenre(rs.getString("genre")).setTag(tag).setGenre(rs.getString("genre"))
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				
				newgames.add(gameInfo);
			}
			return newgames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public ArrayList<GameVO> selectSearchManagerGame(String search) {
		ArrayList<GameVO> newgames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_Manager_VIEW where gseq like '%" + search + "%' or name like '%" + search + "%' or tag like '%" + search
					+ "%' or genre like '%" + search + "%' or developer like '%" + search + "%' order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setGenre(rs.getString("genre")).setTag(tag).setGenre(rs.getString("genre"))
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn"))
						.setFreegameyn(rs.getString("freegameyn")).setNewgameyn(rs.getString("newgameyn"))
						.setUseyn(rs.getString("useyn"))
						.setAdgameyn(rs.getString("adgameyn"))
						.setTag(tag)
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				newgames.add(gameInfo);
			}
			return newgames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	
	public ArrayList<GameVO> selectSearchGame(String search) {
		ArrayList<GameVO> newgames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where name like '%" + search + "%' or tag like '%" + search
					+ "%' or genre like '%" + search + "%' or developer like '%" + search + "%' order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn"))
						.setFreegameyn(rs.getString("freegameyn")).setNewgameyn(rs.getString("newgameyn"))
						.setAdgameyn(rs.getString("adgameyn"))
						.setTag(tag).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				newgames.add(gameInfo);
			}
			return newgames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public ArrayList<GameVO> selectFreeGame() {
		ArrayList<GameVO> freegames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where freegameyn='y' order by releasedate desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setPrice1(0)
						.setPrice2(0)
						.setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))
						.setSpecialofferyn(rs.getString("specialofferyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				freegames.add(gameInfo);
			}
			return freegames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public ArrayList<GameVO> selectSpecialOfferGame() {
		ArrayList<GameVO> specialoffergames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where specialofferyn='y' order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setGenre(rs.getString("genre")).setTag(tag).setGenre(rs.getString("genre"))
						.setRate1(rs.getInt("rate1"))
						.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				
				specialoffergames.add(gameInfo);
			}
			return specialoffergames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public ArrayList<GameVO> selectAdGame() {
		ArrayList<GameVO> specialoffergames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where adgameyn='y' order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer"))
						.setGenre(rs.getString("genre")).setTag(tag).setGenre(rs.getString("genre"))
						.setRate1(rs.getInt("rate1"))
						.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				specialoffergames.add(gameInfo);
			}
			return specialoffergames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	
	public ArrayList<GameVO> selectManagerGames() {
		ArrayList<GameVO> allgames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_MANAGER_VIEW order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setRate1(rs.getInt("rate1"))
						.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setUseyn(rs.getString("useyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))
						.setTag(tag).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				allgames.add(gameInfo);
			}
			return allgames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	
	public ArrayList<GameVO> selectGames() {
		ArrayList<GameVO> allgames = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW order by rate1 desc");
			while (rs.next()) {
				GameVO gameInfo = new GameVO();
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);
				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setRate1(rs.getInt("rate1"))
						.setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))
						.setTag(tag).setGenre(rs.getString("genre"))
						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
				
				//할인게임인지 체크
				if(rs.getString("freegameyn").contentEquals("y")) {
						gameInfo.setPrice1(0).setPrice2(0);
				}else {
					gameInfo.setPrice2(rs.getInt("price2"))
					.setDiscountrate(rs.getInt("discountrate"));
				}
				allgames.add(gameInfo);
			}
			return allgames;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public GameVO selectADGame() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW where adgameyn='y' order by rate1 desc");
			GameVO gameInfo = new GameVO();
			if (rs.next()) {
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setPrice2(rs.getInt("price2")).setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
			}
			return gameInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public GameVO selectBestGame() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW order by rate1 desc");
			GameVO gameInfo = new GameVO();
			if (rs.next()) {
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setPrice2(rs.getInt("price2")).setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
			}
			return gameInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	public GameVO selectManagerGame(int gseq) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_Manager_VIEW WHERE GSEQ='" + gseq + "'");
			GameVO gameInfo = new GameVO();
			if (rs.next()) {
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setPrice2(rs.getInt("price2")).setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))
						.setUseyn(rs.getString("useyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
			}
			return gameInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	
	
	public GameVO selectGame(int gseq) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM GAME_VIEW WHERE GSEQ='" + gseq + "'");
			GameVO gameInfo = new GameVO();
			if (rs.next()) {
				String[] tag = rs.getString("tag").trim().split(",");
				String mainImage[] = rs.getString("main").split(",");
//				String[] tag_en = rs.getString("tag_en").split(",");
				double sum = rs.getInt("rate1") + rs.getInt("rate2");
				int userrate = (int) ((((double) rs.getInt("rate1")) / sum) * 100);

				gameInfo.setGseq(rs.getInt("gseq")).setName(rs.getString("name")).setContent1(rs.getString("content1"))
						.setContent2(rs.getString("content2")).setReleasedate(rs.getDate("releasedate"))
						.setDeveloper(rs.getString("developer")).setPrice1(rs.getInt("price1"))
						.setPrice2(rs.getInt("price2")).setGenre(rs.getString("genre")).setTag(tag)
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setPlatform(rs.getString("platform"))
						.setViolence(rs.getString("violence")).setUserrate(userrate)
						.setSpecialofferyn(rs.getString("specialofferyn")).setFreegameyn(rs.getString("freegameyn"))
						.setNewgameyn(rs.getString("newgameyn")).setAdgameyn(rs.getString("adgameyn"))

						.setKeyart(rs.getString("keyart")).setPortrait(rs.getString("portrait")).setMain(mainImage)

//						.setName_en(rs.getString("name_en")).setContent1_en(rs.getString("content1_en"))
//						.setContent2_en(rs.getString("content2_en")).setGenre_en(rs.getString("genre_en"))
//						.setTag_en(tag_en)

						.setMin_memory(rs.getString("min_memory")).setMin_os(rs.getString("min_os"))
						.setMin_processor(rs.getString("min_processor")).setMin_storage(rs.getString("min_storage"))
						.setMin_vga(rs.getString("min_vga")).setMax_memory(rs.getString("max_memory"))
						.setMax_os(rs.getString("max_os")).setMax_processor(rs.getString("max_processor"))
						.setMax_storage(rs.getString("max_storage")).setMax_vga(rs.getString("max_vga"));
			}
			return gameInfo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
