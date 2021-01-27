package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ReviewVO;
import store.Component;
import store.DBAction;

@Component("reviewDao")
public class ReviewDao {
	
	public boolean checkReview(int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs=stmt.executeQuery("select gseq from review_view where mail='"+mail+"' and gseq="+gseq+"");
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}return false;
	}
	
	public int deleteBadReview(int rseq,int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			int result =  stmt.executeUpdate("update review set useyn='n' where mail='"+mail+"' and rseq="+rseq+"");
			if(result>=0) {
				stmt.close();
				stmt = conn.createStatement();
				return stmt.executeUpdate("update game set rate2=rate2-1 where gseq='"+gseq+"'");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}return -1;
	}
	
	public int deleteGoodReview(int rseq,int gseq, String mail) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			int result =  stmt.executeUpdate("update review set useyn='n' where mail='"+mail+"' and rseq="+rseq+"");
			if(result>=0) {
				stmt.close();
				stmt = conn.createStatement();
				return stmt.executeUpdate("update game set rate1=rate1-1 where gseq='"+gseq+"'");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}return -1;
	}
	
	public ReviewVO selectBestReview() {
		ReviewVO review = new ReviewVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Review_view where rate='1' order by rate1-rate2 desc");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				review
				.setRseq(rs.getInt("rseq"))
				.setGseq(rs.getInt("gseq"))
				.setGname(rs.getString("gname"))
				.setKeyart(rs.getString("keyart"))
				.setMail(rs.getString("mail"))
				.setContent(rs.getString("content"))
				.setRate(rs.getString("rate"))
				.setRate1(rs.getInt("rate1"))
				.setRate2(rs.getInt("rate2"))
				.setUseyn(rs.getString("useyn"))
				.setIndate(rs.getDate("indate"))
				.setModidate(rs.getDate("modidate"))
				.setName(rs.getString("name"))
				.setImage(rs.getString("image"))
				.setGamenumb(rs.getInt("gamenumb"));
			}
			return review;

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
	
	public ArrayList<ReviewVO> selectReviews() {
		ArrayList<ReviewVO> gameReviews = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Review_view order by INDATE desc, rate1 desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review
				.setRseq(rs.getInt("rseq"))
				.setGseq(rs.getInt("gseq"))
				.setGname(rs.getString("gname"))
				.setKeyart(rs.getString("keyart"))
				.setMail(rs.getString("mail"))
				.setContent(rs.getString("content"))
				.setRate(rs.getString("rate"))
				.setRate1(rs.getInt("rate1"))
				.setRate2(rs.getInt("rate2"))
				.setUseyn(rs.getString("useyn"))
				.setIndate(rs.getDate("indate"))
				.setModidate(rs.getDate("modidate"))
				.setName(rs.getString("name"))
				.setImage(rs.getString("image"))
				.setGamenumb(rs.getInt("gamenumb"));
				gameReviews.add(review);
			}
			return gameReviews;

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
	
	public ArrayList<ReviewVO> selectReviewsRate(String mail) {
		ArrayList<ReviewVO> gameReviewRates = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Review_rate WHERE  mail=?");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review
				.setRseq(rs.getInt("rseq"))
				.setMail(rs.getString("mail"))	
				.setRate(rs.getString("rate"));
				gameReviewRates.add(review);
			}
			return gameReviewRates;

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
	
	public ArrayList<ReviewVO> selectReviews(int gseq) {
		ArrayList<ReviewVO> gameReviews = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Review_view WHERE gseq=? order by INDATE desc");
			pstmt.setInt(1, gseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewVO review = new ReviewVO();
				review
				.setRseq(rs.getInt("rseq"))
				.setGseq(rs.getInt("gseq"))
				.setMail(rs.getString("mail"))
				.setContent(rs.getString("content"))
				.setRate(rs.getString("rate"))
				.setRate1(rs.getInt("rate1"))
				.setRate2(rs.getInt("rate2"))
				.setUseyn(rs.getString("useyn"))
				.setIndate(rs.getDate("indate"))
				.setModidate(rs.getDate("modidate"))
				.setName(rs.getString("name"))
				.setImage(rs.getString("image"))
				.setGamenumb(rs.getInt("gamenumb"));
				gameReviews.add(review);
			}
			return gameReviews;

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

	public int addReview(int gseq, String mail, String rate, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("insert into review(gseq,mail,rate,content) values(?,?,?,?)");
			pstmt.setInt(1, gseq);
			pstmt.setString(2, mail);
			pstmt.setString(3, rate);
			pstmt.setString(4, content);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				//긍정 리뷰라면
				if(rate.contentEquals("1")) {
					pstmt = conn.prepareStatement("update game set rate1=rate1+1 where gseq=?");
					pstmt.setInt(1, gseq);
				//부정 리뷰라면
				}else {
					pstmt = conn.prepareStatement("update game set rate2=rate2+1 where gseq=?");
					pstmt.setInt(1, gseq);
				}
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
	
	public int cancelReviewRateBad(String mail, int rseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update review set rate2=rate2-1 where rseq=?");
			pstmt.setInt(1, rseq);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from review_rate where rseq=? and mail=?");
				pstmt.setInt(1, rseq);
				pstmt.setString(2, mail);
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
	
	public int cancelReviewRateGood(String mail, int rseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update review set rate1=rate1-1 where rseq=?");
			pstmt.setInt(1, rseq);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from review_rate where rseq=? and mail=?");
				pstmt.setInt(1, rseq);
				pstmt.setString(2, mail);
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
	
	public int updateReviewRateBad(String mail, int rseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update review set rate2=rate2+1 where rseq=?");
			pstmt.setInt(1, rseq);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into review_rate(rseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, rseq);
				pstmt.setString(2, mail);
				pstmt.setString(3, "2");
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

	public int updateReviewRateGood(String mail, int rseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update review set rate1=rate1+1 where rseq=?");
			pstmt.setInt(1, rseq);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into review_rate(rseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, rseq);
				pstmt.setString(2, mail);
				pstmt.setString(3, "1");
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
}
