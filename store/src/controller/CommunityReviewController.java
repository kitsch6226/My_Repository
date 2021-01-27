package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.ReviewVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/review.go")
public class CommunityReviewController implements Controller{
	private ReviewDao reviewDao;
	public CommunityReviewController setreviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "리뷰");
		ArrayList<ReviewVO> reviews = reviewDao.selectReviews();
		//리뷰가 있다면
		if(!reviews.isEmpty()) {
			model.put("reviews", reviews);
			HttpSession session = (HttpSession) model.get("session");
			User loginInfo = (User) session.getAttribute("loginInfo");
			// 로그인 체크
			if (loginInfo != null) {
				ArrayList<ReviewVO> reviewRates = reviewDao.selectReviewsRate(loginInfo.getMail());
				//로그인한 유저의 리뷰 평가가 있다면
				if(!reviewRates.isEmpty()) {
					model.put("reviewRates", reviewRates);
				}
			}
		}return"/main/MainPage.jsp?kind=community&sort=review";
	}
}
