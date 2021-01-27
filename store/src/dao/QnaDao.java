package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.QnaVO;
import dto.ReplyVO;
import store.Component;
import store.DBAction;

@Component("qnaDao")
public class QnaDao {
	
	public ReplyVO selectQnaReple(int qseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Qna_reply where qseq=? order by INDATE desc");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new ReplyVO()
				.setQseq(rs.getInt("qseq"))
				.setQreseq(rs.getInt("qreseq"))
				.setMail(rs.getString("mail"))
				.setContent(rs.getString("content"))
				.setIndate(rs.getDate("indate"));
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
	
	public QnaVO selectUserAnsweredQseq(String mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT qseq,usercheckyn FROM qna where mail=? and replyyn='y' order by indate desc");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new QnaVO()
				.setQseq(rs.getInt("qseq"))
				.setUsercheckyn(rs.getString("usercheckyn"));
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
	
	public QnaVO selectQna(int qseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Qna where qseq=? order by INDATE desc");
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new QnaVO()
				.setSubject(rs.getString("subject"))
				.setContent(rs.getString("content"))
				.setMail(rs.getString("mail"))
				.setKind(rs.getString("kind"))
				.setQseq(rs.getInt("qseq"))
				.setReplyyn(rs.getString("replyyn"))
				.setUsercheckyn(rs.getString("usercheckyn"))
				.setIndate(rs.getDate("indate"));
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
	
	public ArrayList<QnaVO> selectQnas() {
		ArrayList<QnaVO> qnas = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM Qna order by INDATE desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				QnaVO qna = new QnaVO();
				qna.setSubject(rs.getString("subject"))
				.setContent(rs.getString("content"))
				.setMail(rs.getString("mail"))
				.setKind(rs.getString("kind"))
				.setQseq(rs.getInt("qseq"))
				.setReplyyn(rs.getString("replyyn"))
				.setUsercheckyn(rs.getString("usercheckyn"))
				.setIndate(rs.getDate("indate"));
				qnas.add(qna);
			}
			return qnas;

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
	
	public int updateQnaUserCheckYn(int qseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update qna set usercheckyn='y' where qseq=?");
			pstmt.setInt(1, qseq);
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
	
	public int updateQnaRepleYn(int qseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update qna set usercheckyn='n', replyyn='y' where qseq=?");
			pstmt.setInt(1, qseq);
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
	
	public int addQnaReple(int qseq, String content, String mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("Insert into qna_reply(MAIL,qseq,content) VALUES(?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setInt(2, qseq);
			pstmt.setString(3, content);
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

	public int addQna(String mail,String kind, String subject, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("Insert into qna(MAIL, kind, subject, content) VALUES(?,?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, kind);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
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
