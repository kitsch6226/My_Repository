package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.ArtworkVO;
import dto.User;
import store.Component;

@Component("/main/community.go")
public class CommunityController implements Controller {
	private CommunityDao communityDao;
	public CommunityController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "아트웍");
		ArrayList<ArtworkVO> artworks = communityDao.selectArtworks();
		// 값을 db에서 받아왔다면
		if (!artworks.isEmpty()) {
			model.put("artworks", artworks);
			
			HttpSession session = (HttpSession) model.get("session");
			User loginInfo = (User) session.getAttribute("loginInfo");
			if(loginInfo!=null) {
				//로그인한 사용자의 아트웍 게시판 좋아요,싫어요 수집
				ArrayList<ArtworkVO> artworkRates = communityDao.selectArtworkRate(loginInfo.getMail());
				//값이 있다면
				if(!artworkRates.isEmpty()) {
					model.put("artworkRates", artworkRates);
				}				
			}
		}
		return "/main/MainPage.jsp?kind=community";
	}
}
