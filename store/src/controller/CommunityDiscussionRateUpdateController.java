package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/discussionRate.go")
public class CommunityDiscussionRateUpdateController implements Controller, DataBinding {

	private CommunityDao communityDao;

	public CommunityDiscussionRateUpdateController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String rate = (String) model.get("ratebtn");
			String dseqs = (String) model.get("dseq");
			String scrollNum = (String) model.get("scrollNum");
			int dseq = Integer.parseInt(dseqs);
			// 좋아요 버튼이라면
			if (rate != null && rate.contentEquals("1")) {
				int result = communityDao.updateDiscussionRateGood(loginInfo.getMail(), dseq);
				if (result >= 0) {
					return "redirect:discussionDetail.go?dseq=" + dseq + "&scrollNum=" + scrollNum;
				}
				// 싫어요 버튼이라면
			} else if (rate != null && rate.contentEquals("2")) {
				int result = communityDao.updateDiscussionRateBad(loginInfo.getMail(), dseq);
				// db에 잘들어갔다면
				if (result >= 0) {
					return "redirect:discussionDetail.go?dseq=" + dseq + "&scrollNum=" + scrollNum;
				}
			}
			return "/warning/ErrorPage.jsp";
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "dseq", String.class, "ratebtn", String.class, "scrollNum", String.class };
	}
}
