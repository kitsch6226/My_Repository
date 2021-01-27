package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteArtwork.go")
public class CommunityArtworkDeleteController implements Controller, DataBinding {
	private CommunityDao communityDao;
	public CommunityArtworkDeleteController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String aseq = (String)model.get("aseq");
			//아트웍 시퀀스 aseq가 널이 아니라면
			if(aseq!=null) {
				int result = communityDao.deleteArtwork(loginInfo.getMail(), Integer.parseInt(aseq));
				//db에 잘 들어갔다면
				if(result>=0) {
					return"redirect: community.go";
				}return"/warning/ErrorPage.jsp";
			}
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "aseq", String.class};
	}
}
