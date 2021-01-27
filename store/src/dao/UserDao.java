package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.User;
import store.Component;
import store.DBAction;

@Component("userDao")
public class UserDao {
	
//	public boolean checkMailVerify(String mail) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBAction.getInstance().getConnection();
//			pstmt = conn.prepareStatement("SELECT MAIL FROM USER WHERE MAIL=? and mailverify='y'");
//			pstmt.setString(1, mail);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (conn != null)
//					conn.close();
//				if (pstmt != null)
//					pstmt.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
//	}
	public ArrayList<User> selectSearchUser(String search) {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM USER where name like '%" + search + "%' or MAIL like '%" + search
					+ "%' or NUM like '%" + search + "%' order by INDATE desc");
			while (rs.next()) {
				User user = new User();
				user.setNum(rs.getInt("num"))
				.setImage(rs.getString("image"))
				.setMail(rs.getString("mail"))
				.setName(rs.getString("name"))
				.setIndate(rs.getDate("indate"))	
				.setModidate(rs.getDate("modidate"))
				.setUseyn(rs.getString("useyn"));
				users.add(user);
			}
			return users;
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
	
	public User selectManagerUser(String num) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM User where num ='"+num+"' order by indate desc");
			if (rs.next()) {
				return new User().setGamenumb(rs.getInt("gamenumb"))
				.setImage(rs.getString("image"))
				.setMail(rs.getString("mail"))
				.setName(rs.getString("name"))
				.setNum(rs.getInt("num"))
				.setIndate(rs.getDate("indate"))	
				.setModidate(rs.getDate("modidate"));
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
		return null;

	}
	
	public User selectUser(String num) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM User where useyn='y' and num ='"+num+"' order by indate desc");
			if (rs.next()) {
				return new User().setGamenumb(rs.getInt("gamenumb"))
				.setImage(rs.getString("image"))
				.setMail(rs.getString("mail"))
				.setName(rs.getString("name"))
				.setNum(rs.getInt("num"))
				.setIndate(rs.getDate("indate"))	
				.setModidate(rs.getDate("modidate"));
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
		return null;

	}
	
	public ArrayList<User> selectManagerUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM User order by indate desc");
			while (rs.next()) {
				User user = new User();
			
				user.setGamenumb(rs.getInt("gamenumb"))
				.setImage(rs.getString("image"))
				.setMail(rs.getString("mail"))
				.setName(rs.getString("name"))
				.setNum(rs.getInt("num"))
				.setIndate(rs.getDate("indate"))	
				.setUseyn(rs.getString("useyn"))
				.setModidate(rs.getDate("modidate"));
				users.add(user);
			}
			return users;
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
	
	public ArrayList<User> selectUsers() {
		ArrayList<User> users = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM User where useyn='y' order by indate desc");
			while (rs.next()) {
				User user = new User();
			
				user.setGamenumb(rs.getInt("gamenumb"))
				.setImage(rs.getString("image"))
				.setMail(rs.getString("mail"))
				.setName(rs.getString("name"))
				.setNum(rs.getInt("num"))
				.setIndate(rs.getDate("indate"))	
				.setModidate(rs.getDate("modidate"));
				users.add(user);
			}
			return users;
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
	
	public int deleteUser(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set useyn='n' WHERE num=?");
			pstmt.setInt(1, num);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public String checkName(String mail, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT PW FROM USER WHERE MAIL=? and name=? and useyn='y'");
			pstmt.setString(1, mail);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("pw");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean checkMail(String mail) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT MAIL FROM USER WHERE MAIL=? and useyn='y'");
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			//유저에서 중복 메일을 못찾았다면
			if (!rs.next()) {
				rs.close();
				pstmt.close();
				pstmt = conn.prepareStatement("SELECT MAIL FROM manager WHERE MAIL=?");// 매니저에서 한번 더 검사
				pstmt.setString(1, mail);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return true;
				}
				
			}else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public User checkManager(String mail, String pw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM Manager WHERE mail='" + mail + "' and pw='" + pw + "'");
			if (rs.next()) {
				return new User().setMseq(rs.getInt("mseq")).setMail(rs.getString("mail")).setName(rs.getString("name"))
						.setIndate(rs.getDate("indate"))
						.setModidate(rs.getDate("modidate"));
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
		return null;
	}
	
	public User checkPw(String mail, String pw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT*FROM USER WHERE mail='" + mail + "' and pw='" + pw + "'");
			if (rs.next()) {
				return new User().setNum(rs.getInt("num")).setMail(rs.getString("mail")).setName(rs.getString("name"))
						.setImage(rs.getString("image")).setIndate(rs.getDate("indate"))
						.setModidate(rs.getDate("modidate")).setPoint(rs.getInt("point"))
						.setGamenumb(rs.getInt("gamenumb"));
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
		return null;
	}

	public int userAdd(String mail, String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("Insert into User(MAIL, NAME, PW) VALUES(?,?,?)");
			pstmt.setString(1, mail);
			pstmt.setString(2, name);
			pstmt.setString(3, pw);
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
	
	public int userUpdate(String mail,String image, String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set image='"+image+"', name='"+name+"', pw='"+pw+"',modidate=NOW() where mail='"+mail+"'");
			return pstmt.executeUpdate();
		}catch(Exception e){
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
	
	public int userManagerUpdate(String num, String name,String useyn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set name='"+name+"', useyn='"+useyn+"', modidate=NOW() where num='"+num+"'");
			return pstmt.executeUpdate();
		}catch(Exception e){
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
	
	public int userManagerUpdate(String num,String image, String name,String useyn) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set name='"+name+"',image='"+image+"', useyn='"+useyn+"', modidate=NOW() where num='"+num+"'");
			return pstmt.executeUpdate();
		}catch(Exception e){
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
	
	public int userUpdate(String mail, String name, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("update user set name='"+name+"', pw='"+pw+"',modidate=NOW() where mail='"+mail+"'");
			return pstmt.executeUpdate();
		}catch(Exception e){
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
