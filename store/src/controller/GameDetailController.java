package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.ReviewDao;
import dao.UserDao;
import dto.GameVO;
import dto.ReviewVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/gameDetail.go")
public class GameDetailController implements Controller,DataBinding{
	private GameDao gameDao;
	public GameDetailController setGameDao(GameDao gameDao) {
		this.gameDao=gameDao;
		return this;
	}
	private ReviewDao reviewDao;
	public GameDetailController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession)model.get("session");
		User loginInfo = (User)session.getAttribute("loginInfo");
		String gseq = (String)model.get("gseq");
		String scrollNum = (String)model.get("scrollNum");
		//커뮤니티 리뷰 페이지로 분기
		if(gseq==null||gseq.equals("")||gseq.equals("null")) {
			return"/warning/ErrorPage.jsp";
		}
		GameVO gameInfo = gameDao.selectGame(Integer.parseInt(gseq));
		//db에 게임 정보가 있다면
		if(gameInfo!=null) {
			model.put("gameInfo", gameInfo);
			ArrayList<ReviewVO> gameReviews = reviewDao.selectReviews(Integer.parseInt(gseq));
			//해당 게임에 리뷰가 있다면
			if(!gameReviews.isEmpty()) {
				model.put("gameReviews", gameReviews);
			}
			//로그인을 했다면
			if(loginInfo!=null) {
				ArrayList<ReviewVO> gameReviewsRate = reviewDao.selectReviewsRate(loginInfo.getMail());
				//해당 게임 리뷰에 대한 유저의 좋아요,싫어요 가 있다면
				if(!gameReviewsRate.isEmpty()) {
					model.put("gameReviewsRate", gameReviewsRate);
				}
				boolean result = gameDao.selectLibraryGame(Integer.parseInt(gseq),loginInfo.getMail());
				//라이브러리에 게임이 있다면
				if(result==true) {
					model.put("libraryyn", "y");
					boolean result2 = reviewDao.checkReview(Integer.parseInt(gseq),loginInfo.getMail());
					//작성자가 해당 게임에 작성한 리뷰가 있는지 체크
					if(result2==true) {
						model.put("reviewExist","y");
					}
				}else {
					result = gameDao.selectOrdersGame(Integer.parseInt(gseq), loginInfo.getMail());
					//결제 항목에 게임이 있다면
					if(result==true) {
						model.put("orderyn", "y");
					}else {
						result = gameDao.selectWishlistGame(Integer.parseInt(gseq),loginInfo.getMail());
						//위시리스트에 게임이 있다면
						if(result==true) {
							model.put("wishlistyn", "y");
							return"/main/MainPage.jsp?kind=gamedetail";	
						}else {
							return"/main/MainPage.jsp?kind=gamedetail";				
						}		
					}
							
				}
			}return"/main/MainPage.jsp?kind=gamedetail";
		}		
		return"/warning/ErrorPage.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"gseq",String.class,"reviewcheck",String.class,"scrollNum",String.class};
	}
}
