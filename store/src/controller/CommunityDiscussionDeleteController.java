package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteDiscussion.go")
public class CommunityDiscussionDeleteController implements Controller, DataBinding {
	private CommunityDao communityDao;
	public CommunityDiscussionDeleteController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String dseq = (String)model.get("dseq");
			//아트웍 시퀀스 aseq가 널이 아니라면
			if(dseq!=null) {
				int result = communityDao.deleteDiscussion(loginInfo.getMail(), Integer.parseInt(dseq));
				//db에 잘 들어갔다면
				if(result>=0) {
					return"redirect: discussion.go";
				}return"/warning/ErrorPage.jsp";
			}
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "dseq", String.class};
	}
}