package controller;

import java.util.Map;

import store.Component;

@Component("/main/support.go")
public class SupportController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		return"/main/MainPage.jsp?kind=support";
	}
}
