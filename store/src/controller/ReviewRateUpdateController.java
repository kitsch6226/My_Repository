package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/updateReviewRate.go")
public class ReviewRateUpdateController implements Controller, DataBinding {
	private ReviewDao reviewDao;

	public ReviewRateUpdateController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String rate = (String) model.get("reviewbtn");
			String rseq = (String) model.get("rseq");
			String gseq = (String) model.get("gseq");
			String scrollNum = (String) model.get("scrollNum");
			// rseq값이 넘어왔다면
			if (rseq != null) {
				// 누른 버튼이 좋아요 라면
				if (rate != null && rate.contentEquals("1")) {
					int result2 = reviewDao.updateReviewRateGood(loginInfo.getMail(), Integer.parseInt(rseq));
					// result
					if (result2 >= 0) {
						return "redirect:gameDetail.go?gseq=" + gseq + "&scrollNum=" + scrollNum;
					}

					// 누른 버튼이 싫어요 라면
				} else if (rate != null && rate.contentEquals("2")) {
					int result2 = reviewDao.updateReviewRateBad(loginInfo.getMail(), Integer.parseInt(rseq));
					// result
					if (result2 >= 0) {
						return "redirect:gameDetail.go?gseq=" + gseq + "&scrollNum=" + scrollNum;
					}
				} else {

				}
			}return "/warning/ErrorPage.jsp";
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "rseq", String.class, "reviewbtn", String.class, "gseq", String.class, "scrollNum",
				String.class };
	}
}
