package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.GameVO;
import dto.User;
import store.Component;

@Component("/main/managerGame.go")
public class ManagerGameController implements Controller {
	private GameDao gameDao;

	public ManagerGameController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			ArrayList<GameVO> allgames = gameDao.selectManagerGames();
			if (allgames != null) {
				model.put("allgames", allgames);
			}
			return "/manager/main/ManagerMainPage.jsp";
		}return "redirect: login.go";
	}

}
