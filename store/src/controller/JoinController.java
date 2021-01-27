package controller;

import java.util.Map;

import dao.UserDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/userAdd.go")
public class JoinController implements Controller, DataBinding {
	private UserDao userDao;

	public JoinController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		User userAddInfo = (User) model.get("User");
		// 입력받은 정보가 있는지 체크
		if (userAddInfo.getMail() != null && userAddInfo.getPw() != null && userAddInfo.getName() != null) {
			boolean result = userDao.checkMail(userAddInfo.getMail());
			System.out.println(userAddInfo.getMail());
			System.out.println(result);
			// 메일 중복이 아니라면
			if (!result) {
				int result2 = userDao.userAdd(userAddInfo.getMail(), userAddInfo.getName(), userAddInfo.getPw());
				// 데이터가 들어갔다면
				if (result2 >= 0) {
					return "redirect:../main/login.go?welcome=new";
				}else {
					model.put("userAddInfo", userAddInfo);
					return "/member/JoinPage.jsp?check=fail";
				}
			} else {
				model.put("userAddInfo", userAddInfo);
				return "/member/JoinPage.jsp?check=mailfalse";
			}
		} else {
			return "/member/JoinPage.jsp";
		}

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "User", User.class };
	}
}
