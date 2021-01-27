package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteGame.go")
public class ManagerGameDeleteController implements Controller, DataBinding {
	private GameDao gameDao;

	public ManagerGameDeleteController setGameDao(GameDao gameDao) {
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
			String gseq = (String) model.get("gseq");
			// 검색 값이 있다면
			if (gseq != null) {
				int result = gameDao.deleteGame(Integer.parseInt(gseq));
				//db에 값이 잘 들어갔다면
				if(result>=0) {
					return"redirect:managerGame.go";
				}return"/warning/ErrorPage.jsp";
			}
			
		}return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class };
	}
}
