package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addLibrary.go")
public class LibraryAddController implements Controller, DataBinding {
	private OrderDao orderDao;

	public LibraryAddController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String gseqset = (String) model.get("gseq");
			//gseq값을 넘겨받았는가
			if (gseqset != null) {
				String[] gseqs = gseqset.split(",");
				int result = -1;
				for (String gseq : gseqs) {
					result = orderDao.addLibrary(loginInfo.getMail(), Integer.parseInt(gseq));
					//db에 무사히 들어갔다면
				}
				if(result>=0) {
					return"redirect:library.go?library=added";
				}
				return "/warning/ErrorPage.jsp";
			}
			
		}return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class };
	}

}
