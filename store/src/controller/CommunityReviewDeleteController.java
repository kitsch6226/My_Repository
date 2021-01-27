package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteReviewCommunity.go")
public class CommunityReviewDeleteController implements Controller, DataBinding {
	private ReviewDao reviewDao;

	public CommunityReviewDeleteController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String rate = (String)model.get("reviewbtn");
			String rseq = (String)model.get("rseq");
			String gseq = (String)model.get("gseq");
			String scrollNum = (String)model.get("scrollNum");
			//rseq값이 잘 넘어왔다면
			if(rseq!=null) {
				//긍정리뷰를 지운다면
				if(rate.contentEquals("1")) {
					int result = reviewDao.deleteGoodReview(Integer.parseInt(rseq),Integer.parseInt(gseq), loginInfo.getMail());
					//db에 무사히 들어갔다면
					if(result>=0) {
						return"redirect: review.go?scrollNum="+scrollNum;
					}
				//부정리뷰를 지운다면
				}else if(rate.contentEquals("2")) {
					int result = reviewDao.deleteBadReview(Integer.parseInt(rseq),Integer.parseInt(gseq),  loginInfo.getMail());
					//db에 무사히 들어갔다면
					if(result>=0) {
						return"redirect: review.go?scrollNum="+scrollNum;
					}
				}
			}return"/warning/ErrorPage.jsp";
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "rseq", String.class, "gseq", String.class,"reviewbtn",String.class,"scrollNum",String.class };
	}
}