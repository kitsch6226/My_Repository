package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/logout.go")
public class LogoutController implements Controller,DataBinding{
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession)model.get("session");
		User userInfo = (User)session.getAttribute("loginInfo");
		//로그인 되어있는지 체크
		if(userInfo!=null) {
			session.removeAttribute("loginInfo");
			session.invalidate();		
			String delAcct = (String)model.get("delAcct");
			//탈퇴페이지에서 redirect되었다면
			System.out.println(delAcct);	
			if(delAcct!=null) {
				return "redirect:login.go?delAcct=confirm";
			}
			return "redirect:login.go";
		}
		return"redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] {"delAcct",String.class};
	}
}
