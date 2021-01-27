package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.ReviewDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/addReview.go")
public class ReviewAddController implements Controller, DataBinding {
	private ReviewDao reviewDao;
	public ReviewAddController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String gseq = (String)model.get("gseq");
			String rate = (String)model.get("rate");
			String content = (String)model.get("content");
			String scrollNum = (String)model.get("scrollNum");
			if(gseq!=null&&rate!=null&&content!=null) {
				int result = reviewDao.addReview(Integer.parseInt(gseq), loginInfo.getMail(), rate, content);
				//db에 값이 들어갔다면
				if(result>=0) {
					return"redirect:gameDetail.go?gseq="+gseq+"&scrollNum="+scrollNum;
				}return"/warning/ErrorPage.jsp";		
			}
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class, "rate",String.class, "content",String.class,"scrollNum",String.class };
	}
}
