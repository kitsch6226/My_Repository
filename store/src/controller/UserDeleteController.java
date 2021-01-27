package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/accountDelete.go")
public class UserDeleteController implements Controller, DataBinding {
	private UserDao userDao;

	public UserDeleteController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String num = (String)model.get("num");
			//받아온 num값이 있다면
			if(num!=null) {
				int result = userDao.deleteUser(Integer.parseInt(num));
					//db에 잘 들어갔다면
					if(result>=0) {
						return "redirect:logout.go?delAcct=confirm";	
					}
			}return "/warning/ErrorPage.jsp";
		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "num", String.class };
	}
}
