package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/userDeleteManager.go")
public class ManagerUserDeleteController implements Controller, DataBinding {
	private UserDao userDao;

	public ManagerUserDeleteController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			String num = (String) model.get("num");
			// 받아온 num값이 있다면
			if (num != null) {
				int result = userDao.deleteUser(Integer.parseInt(num));
				// db에 잘 들어갔다면
				if (result >= 0) {
					return "redirect:user.go";
				}
			}
			return "/warning/ErrorPage.jsp";
		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "num", String.class };
	}
}
