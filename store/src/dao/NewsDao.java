package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.LibraryVO;
import dto.NewsVO;
import store.Component;
import store.DBAction;

@Component("newsDao")
public class NewsDao {
	public ArrayList<NewsVO> selectNews() {
		ArrayList<NewsVO> newss = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT*FROM news_VIEW order by INDATE desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NewsVO news = new NewsVO();
				news.setNseq(rs.getInt("nseq")).setName(rs.getString("name")).setGseq(rs.getInt("gseq")).setKind(rs.getString("kind"))
						.setKeyart(rs.getString("keyart")).setSubject(rs.getString("subject"))
						.setContent(rs.getString("content")).setIndate(rs.getDate("indate"));
				newss.add(news);
			}
			return newss;

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

}
