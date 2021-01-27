package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import store.Component;
import store.DBAction;

@Component("orderDao")
public class OrderDao {
	public int addLibrary(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("INSERT INTO Library(mail,gseq) VALUES(?,?)");
			pstmt.setString(1, mail);
			pstmt.setInt(2, gseq);
			int result =  pstmt.executeUpdate();
			if(result>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("UPDATE USER SET GAMENUMB=GAMENUMB+1 where mail=?");
				pstmt.setString(1, mail);
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

	public int finishOrder(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("UPDATE Orders SET RESULT='2' WHERE MAIL=? AND GSEQ=?");
			pstmt.setString(1, mail);
			pstmt.setInt(2, gseq);
			if(pstmt.executeUpdate()>=0) {
				pstmt.close();
				pstmt = conn.prepareStatement("UPDATE WISHLIST SET RESULT='2' WHERE MAIL=? AND GSEQ=?");
				pstmt.setString(1, mail);
				pstmt.setInt(2, gseq);
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

	public int deleteOrder(String mail, int oseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("delete from Orders where mail=? and oseq=?");
			pstmt.setString(1, mail);
			pstmt.setInt(2, oseq);
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

	public int deleteWishlist(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("delete from WISHLIST where mail=? and gseq=?");
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

	public int addWishList(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("INSERT INTO WISHLIST(mail,gseq) VALUES(?,?)");
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

	public int addOrderList(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("INSERT INTO Orders(mail,gseq) VALUES(?,?)");
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

	public int selectOrder(String mail, int gseq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("select mail from Orders where mail=? and gseq=?");
			pstmt.setString(1, mail);
			pstmt.setInt(2, gseq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
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
