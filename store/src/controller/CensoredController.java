package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import store.Component;
import store.DataBinding;

@Component("/main/censored.go")
public class CensoredController implements Controller,DataBinding{
	@Override
	public String execute(Map<String,Object>model) {
		String gseq = (String)model.get("gseq");
		if(gseq!=null) {
			HttpSession session = (HttpSession) model.get("session");
			session.setAttribute("censored", "confirm");
			return"redirect:gameDetail.go?gseq="+gseq;
		}
		return"/warning/ErrorPage.jsp";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"gseq",String.class};
	}
}
