package controller;

import java.util.Map;

import dao.UserDao;
import store.Component;
import store.DataBinding;
@Component("/main/findUserPW.go")
public class FindPasswordController implements Controller, DataBinding {
	private UserDao userDao;

	public FindPasswordController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String findmail = (String) model.get("findmail");
		String findname = (String) model.get("findname");
		// 입력받은 정보가 있는지 체크
		if (findmail != null &&findname != null) {
			boolean result = userDao.checkMail(findmail);
			// 메일이 존재한다면
			if (result) {
				String pw = userDao.checkName(findmail, findname);
				// 데이터가 들어갔다면
				if (pw!=null) {
					model.put("userPW", pw);
					return "/auth/FindPWPage.jsp?check=find";
				}else {
					return "/auth/FindPWPage.jsp?check=namefalse";
				}
			} else {
				return "/auth/FindPWPage.jsp?check=mailfalse";
			}
		} else {
			return "/auth/FindPWPage.jsp";
		}

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "findmail", String.class,"findname",String.class };
	}
}
