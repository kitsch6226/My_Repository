package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dao.UserDao;
import dto.QnaVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/login.go")
public class LoginController implements Controller, DataBinding {
	private UserDao userDao;

	public LoginController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User userInfo = (User) model.get("userInfo");
		// 인풋 입력 값 존재 체크
		if (userInfo.getMail() != null && userInfo.getPw()!=null) {
			User manager = userDao.checkManager(userInfo.getMail(), userInfo.getPw());
			//매니저 체크
			if(manager!=null) {
				session.setAttribute("managerInfo", manager);
				return "redirect: managerGame.go";
			}
			boolean result2 = userDao.checkMail(userInfo.getMail());
			// mail,탈퇴 체크
			if (result2) {
//					boolean result1 = userDao.checkMailVerify(userInfo.getMail());
//					// 메일 인증 여부 체크
//					if (result1) {
				User loginUser = userDao.checkPw(userInfo.getMail(), userInfo.getPw());
				// password 체크
				if (loginUser != null) {
					session = (HttpSession) model.get("session");
					session.setAttribute("loginInfo", loginUser);
					return "redirect:ogu.go";
					// 비밀번호가 없다면
				} else {
					return "/auth/LoginPage.jsp?check=pwfalse";
				}
				// 메일 미 인증이라면
//					}else {
//						return "/auth/LoginPage.jsp?check=verifyfalse";
//					}
				// 메일이 없다면
			} else {
				return "/auth/LoginPage.jsp?check=mailfalse";
			}
		}

		return "/auth/LoginPage.jsp";

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "userInfo", User.class};
	}
}
