package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.QnaDao;
import dao.ReviewDao;
import dto.GameVO;
import dto.QnaVO;
import dto.ReviewVO;
import dto.User;
import store.Component;

@Component("/main/ogu.go")
public class MainController implements Controller {
	private GameDao gameDao;

	public MainController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	private ReviewDao reviewDao;

	public MainController setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
		return this;
	}
	
	private QnaDao qnaDao;

	public MainController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			// 표시해줘야 할 알림(유저가 확인하지 않은 qna답변정보) 메시지가 있는가
			QnaVO qnaInfo = qnaDao.selectUserAnsweredQseq(loginInfo.getMail());
			// 잘 받아 왔다면
			if (qnaInfo != null) {
//				model.put("answeredQnaInfo", qnaInfo);
				session.removeAttribute("answeredQnaInfo");	
				session.setAttribute("answeredQnaInfo", qnaInfo);
			}
		}
		GameVO adGame = gameDao.selectADGame();
		ReviewVO bestReview = reviewDao.selectBestReview();
		ArrayList<GameVO> specialOfferGames = gameDao.selectSpecialOfferGame();
		ArrayList<GameVO> freeGames = gameDao.selectFreeGame();
		ArrayList<GameVO> newGames = gameDao.selectNewGame();
		if (adGame != null && adGame.getName() != null) {
			model.put("adGame", adGame);
		}
		if (bestReview != null && bestReview.getGname() != null) {
			model.put("bestReview", bestReview);
		}
		if (!specialOfferGames.isEmpty()) {
			model.put("specialOfferGames", specialOfferGames);
		}
		if (!freeGames.isEmpty()) {
			model.put("freeGames", freeGames);
		}
		if (!newGames.isEmpty()) {
			model.put("newGames", newGames);
		}
		return "/main/MainPage.jsp";
	}
}
