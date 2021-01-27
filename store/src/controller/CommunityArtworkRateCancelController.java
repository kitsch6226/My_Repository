package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/cancelArtworkRate.go")
public class CommunityArtworkRateCancelController implements Controller, DataBinding {
	
	private CommunityDao communityDao;
	public CommunityArtworkRateCancelController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String rate = (String)model.get("artworkRatebtn");
			String aseqs = (String)model.get("aseq");
			System.out.println(rate+" , "+aseqs);
			int aseq = Integer.parseInt(aseqs);
			if(rate!=null&&rate.contentEquals("1")) {
				int result = communityDao.cancelReviewRateGood(loginInfo.getMail(), aseq);
				if(result>=0) {
					return"redirect:community.go";
				}
			}else if(rate!=null&&rate.contentEquals("2")) {
				int result = communityDao.cancelReviewRateBad(loginInfo.getMail(), aseq);
				//db에 잘들어갔다면
				if(result>=0) {
					return"redirect:community.go";
				}
			}return"/warning/ErrorPage.jsp";
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "aseq", String.class, "artworkRatebtn",String.class};
	}
}
