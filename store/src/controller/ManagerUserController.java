package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;
import store.Component;
@Component("/main/user.go")
public class ManagerUserController implements Controller{
	private UserDao userDao;

	public ManagerUserController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			ArrayList<User>users = userDao.selectManagerUsers();
			//유저 정보가 있다면
			if(!users.isEmpty()) {
				model.put("users", users);
				return "/manager/main/ManagerMainPage.jsp?kind=user";
			}return"/warning/ErrorPage.jsp";
		}
		return "redirect:login.go";

	}
}
