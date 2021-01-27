package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.User;
import store.Component;

@Component("/main/addGamePage.go")
public class ManagerGameAddPageController implements Controller{
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			return "/manager/main/ManagerMainPage.jsp?kind=addGame";
		}
		return "redirect:login.go";
	}

}
