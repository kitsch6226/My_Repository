package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.UserDao;
import dto.GameVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/searchManager.go")
public class ManagerSearchController implements Controller, DataBinding {
	private GameDao gameDao;

	public ManagerSearchController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	private UserDao userDao;

	public ManagerSearchController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			String searchContent = (String) model.get("searchContent");
			// 검색 값이 있다면
			if (searchContent != null) {
				ArrayList<GameVO> searchGames = null;
				ArrayList<User> searchUsers = null;
				// 매니저 게임 탭에서 검색했다면
				if (searchContent.startsWith("Game:")) {
					String searchKeyword[] = searchContent.split("Game:");
					// 특가
					if (searchKeyword[1].contentEquals("specialoffergame") || searchKeyword[1].contentEquals("특가")
							|| searchKeyword[1].replaceAll(" ", "").contentEquals("특가게임")) {
						searchGames = gameDao.selectSpecialOfferGame();
						// 무료
					} else if (searchKeyword[1].contentEquals("freegame") || searchKeyword[1].contentEquals("무료")
							|| searchKeyword[1].replaceAll(" ", "").contentEquals("무료게임")) {
						searchGames = gameDao.selectFreeGame();
						// 신작
					} else if (searchKeyword[1].contentEquals("newgame") || searchKeyword[1].contentEquals("신작")
							|| searchKeyword[1].replaceAll(" ", "").contentEquals("신작게임")) {
						searchGames = gameDao.selectNewGame();
						// 검색어로 검색
					} else if (searchKeyword[1].contentEquals("adgame") || searchKeyword[1].contentEquals("광고")
							|| searchKeyword[1].replaceAll(" ", "").contentEquals("광고게임")) {
						searchGames = gameDao.selectAdGame();
						// 검색어로 검색
					} else if (searchKeyword[1].contentEquals("all")) {
						searchGames = gameDao.selectGames();
					} else {
						searchGames = gameDao.selectSearchManagerGame(searchKeyword[1]);
					}

					// 검색 결과가 있다면
					if (!searchGames.isEmpty()) {
						model.put("allgames", searchGames);
					} else {
						model.put("allgames", null);
					}
					model.put("searchTitle", searchKeyword[1]);
					return "/manager/main/ManagerMainPage.jsp?kind=game";
				} else if (searchContent.startsWith("User:")) {
					String searchKeyword[] = searchContent.split("User:");
					System.out.println(searchKeyword[1]);
					searchUsers = userDao.selectSearchUser(searchKeyword[1]);
					// 검색결과가 있다면
					if (!searchUsers.isEmpty()) {
						model.put("searchTitle", searchKeyword[1]);
						model.put("users", searchUsers);
					} else {
						model.put("users", null);
					}
					model.put("searchTitle", searchKeyword[1]);
					return "/manager/main/ManagerMainPage.jsp?kind=user";
				}
			}
			return "redirect:managerGame.go";
		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "searchContent", String.class };
	}
}
