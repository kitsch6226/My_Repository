package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ArtworkVO;
import dto.DiscussionVO;
import dto.ReplyVO;
import store.Component;
import store.DBAction;

@Component("communityDao")
public class CommunityDao {

	public ArrayList<ReplyVO> selectReply(int dseq) {
		ArrayList<ReplyVO> reples = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM reply where dseq=? and useyn='y' order by indate desc");
			pstmt.setInt(1, dseq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyVO reple = new ReplyVO().setDseq(rs.getInt("dseq")).setReseq(rs.getInt("reseq"))
						.setMail(rs.getString("mail")).setName(rs.getString("name")).setContent(rs.getString("content"))
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setUseyn(rs.getString("useyn"))
						.setIndate(rs.getDate("indate")).setModidate(rs.getDate("modidate"));
				reples.add(reple);
			}
			return reples;
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

	public DiscussionVO selectDiscussion(int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM discussion where dseq=? and useyn='y' order by indate desc");
			pstmt.setInt(1, dseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				DiscussionVO discussion = new DiscussionVO().setDseq(rs.getInt("dseq")).setName(rs.getString("name"))
						.setKind(rs.getString("kind")).setSubject(rs.getString("subject"))
						.setContent(rs.getString("content")).setMail(rs.getString("mail")).setRate1(rs.getInt("rate1"))
						.setRate2(rs.getInt("rate2")).setUseyn(rs.getString("useyn")).setIndate(rs.getDate("indate"))
						.setView(rs.getInt("view")).setModidate(rs.getDate("modidate"));
				if (rs.getString("image") != null) {
					String[] images = rs.getString("image").split(",");
					discussion.setImage(images);
				}
				return discussion;
			}
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

	public ArrayList<DiscussionVO> selectDiscussions() {
		ArrayList<DiscussionVO> discussions = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM discussion where useyn='y' order by indate desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DiscussionVO discussion = new DiscussionVO();
				discussion.setDseq(rs.getInt("dseq")).setName(rs.getString("name")).setKind(rs.getString("kind"))
						.setSubject(rs.getString("subject")).setContent(rs.getString("content"))
						.setMail(rs.getString("mail")).setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2"))
						.setUseyn(rs.getString("useyn")).setIndate(rs.getDate("indate")).setView(rs.getInt("view"))
						.setModidate(rs.getDate("modidate")).setReply(rs.getInt("reply"));
				discussions.add(discussion);
			}
			return discussions;

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

	public ArrayList<ArtworkVO> selectArtworkRate(String mail) {
		ArrayList<ArtworkVO> artworks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM artwork_rate where mail=?");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArtworkVO artwork = new ArtworkVO();
				artwork.setAseq(rs.getInt("aseq")).setMail(rs.getString("mail")).setRate(rs.getString("rate"));
				artworks.add(artwork);
			}
			return artworks;

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

	public ArrayList<ArtworkVO> selectArtworks() {
		ArrayList<ArtworkVO> artworks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM artwork where useyn='y' order by indate desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArtworkVO artwork = new ArtworkVO();
				artwork.setAseq(rs.getInt("aseq")).setImage(rs.getString("image")).setMail(rs.getString("mail"))
						.setRate1(rs.getInt("rate1")).setRate2(rs.getInt("rate2")).setUseyn(rs.getString("useyn"))
						.setIndate(rs.getDate("indate"));
				artworks.add(artwork);
			}
			return artworks;

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

	public int deleteArtwork(String mail, int aseq) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate("update artwork set useyn='n' where mail='" + mail + "' and aseq=" + aseq + "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return -1;
	}

	public int addArtwork(String mail, String imageName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("insert into artwork(mail,image) values(?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, imageName);
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

	public int addDiscussionReple(int dseq, String mail, String name, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("insert into reply(dseq,mail,name,content) values(?,?,?,?)");
			pstmt.setInt(1, dseq);
			pstmt.setString(2, mail);
			pstmt.setString(3, name);
			pstmt.setString(4, content);
			int result = pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt= conn.prepareStatement("update discussion set reply=reply+1 where dseq=?");
				pstmt.setInt(1, dseq);
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

	public ArrayList<DiscussionVO> selectDiscussionRate(String mail) {
		ArrayList<DiscussionVO> discussionRates = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM discussion_rate where mail=?");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DiscussionVO discussion = new DiscussionVO();
				discussion.setDseq(rs.getInt("dseq")).setMail(rs.getString("mail")).setRate(rs.getString("rate"));
				discussionRates.add(discussion);
			}
			return discussionRates;

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

	public int addDiscussionNoImage(String mail, String kind, String subject, String content, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("insert into discussion(mail,kind,subject,content,name) values(?,?,?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, kind);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, name);
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

	public int addDiscussionImage(String mail, String kind, String imageName, String subject, String content,
			String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement(
					"insert into discussion(mail,kind,subject,content,image,name) values(?,?,?,?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, kind);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, imageName);
			pstmt.setString(6, name);
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

	public int cancelReviewRateBad(String mail, int aseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update artwork set rate2=rate2-1 where aseq=?");
			pstmt.setInt(1, aseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from artwork_rate where aseq=? and mail=?");
				pstmt.setInt(1, aseq);
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

	public int cancelReviewRateGood(String mail, int aseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update artwork set rate1=rate1-1 where aseq=?");
			pstmt.setInt(1, aseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from artwork_rate where aseq=? and mail=?");
				pstmt.setInt(1, aseq);
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

	public int updateArtworkRateBad(String mail, int aseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update artwork set rate2=rate2+1 where aseq=?");
			pstmt.setInt(1, aseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into artwork_rate(aseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, aseq);
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

	public int updateArtworkRateGood(String mail, int aseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update artwork set rate1=rate1+1 where aseq=?");
			pstmt.setInt(1, aseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into artwork_rate(aseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, aseq);
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

	public int cancelDiscussionRateBad(String mail, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set rate2=rate2-1 where dseq=?");
			pstmt.setInt(1, dseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from discussion_rate where dseq=? and mail=?");
				pstmt.setInt(1, dseq);
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

	public int cancelDiscussionRateGood(String mail, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set rate1=rate1-1 where dseq=?");
			pstmt.setInt(1, dseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from discussion_rate where dseq=? and mail=?");
				pstmt.setInt(1, dseq);
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

	public ArrayList<ReplyVO> selectDiscussionRepleRate(String mail) {
		ArrayList<ReplyVO> discussionRepleRates = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM reply_rate where mail=?");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReplyVO replyRate = new ReplyVO();
				replyRate.setReseq(rs.getInt("reseq")).setMail(rs.getString("mail")).setRate(rs.getString("rate"));
				discussionRepleRates.add(replyRate);
			}
			return discussionRepleRates;

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

	public int deleteDiscussionReple(String mail, int reseq,int dseq) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("update reply set useyn='n' where mail='" + mail + "' and reseq=" + reseq + "");
			if(result>=0) {
				stmt.close();
				stmt = conn.createStatement();
				return stmt.executeUpdate("update discussion set reply=reply-1 where dseq='" + dseq + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return -1;
	}

	public int cancelDiscussionRepleRateBad(String mail, int reseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update reply set rate2=rate2-1 where reseq=?");
			pstmt.setInt(1, reseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from reply_rate where reseq=? and mail=?");
				pstmt.setInt(1, reseq);
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

	public int cancelDiscussionRepleRateGood(String mail, int reseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update reply set rate1=rate1-1 where reseq=?");
			pstmt.setInt(1, reseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("delete from reply_rate where reseq=? and mail=?");
				pstmt.setInt(1, reseq);
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

	public int updateDiscussionRepleRateBad(String mail, int reseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update reply set rate2=rate2+1 where reseq=?");
			pstmt.setInt(1, reseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into reply_rate(reseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, reseq);
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

	public int updateDiscussionRepleRateGood(String mail, int reseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update reply set rate1=rate1+1 where reseq=?");
			pstmt.setInt(1, reseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into reply_rate(reseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, reseq);
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

	public int updateDiscussionReple(String content, int reseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update reply set content=?, modidate=now() where reseq=?");
			pstmt.setString(1, content);
			pstmt.setInt(2, reseq);
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

	public int updateDiscussion(String mail,String subject, String content, String image, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set content=?, subject=?, image=?,modidate=now() where dseq=? and mail=?");
			pstmt.setString(1, content);
			pstmt.setString(2, subject);
			pstmt.setString(3, image);
			pstmt.setInt(4, dseq);
			pstmt.setString(5, mail);
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
	
	public int updateDiscussionNoImage(String mail,String subject, String content, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set content=?, subject=?,modidate=now() where dseq=? and mail=?");
			pstmt.setString(1, content);
			pstmt.setString(2, subject);
			pstmt.setInt(3, dseq);
			pstmt.setString(4, mail);
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
	
	public int deleteDiscussion(String mail, int dseq) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate("update discussion set useyn='n' where mail='" + mail + "' and dseq=" + dseq + "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return -1;
	}

	public int updateDiscussionRateBad(String mail, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set rate2=rate2+1 where dseq=?");
			pstmt.setInt(1, dseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into discussion_rate(dseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, dseq);
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

	public int updateDiscussionRateGood(String mail, int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set rate1=rate1+1 where dseq=?");
			pstmt.setInt(1, dseq);
			int result = pstmt.executeUpdate();
			if (result >= 0) {
				pstmt.close();
				pstmt = conn.prepareStatement("insert into discussion_rate(dseq,mail,rate) values(?,?,?)");
				pstmt.setInt(1, dseq);
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

	public int updateDiscussionView(int dseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update discussion set view=view+1 where dseq=?");
			pstmt.setInt(1, dseq);
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
}
