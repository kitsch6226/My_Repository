package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.OrderDao;
import dto.GameVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addWishlist.go")
public class WishlistAddController implements Controller, DataBinding {
	private OrderDao orderDao;

	public WishlistAddController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String gseq = (String)model.get("gseq");
			if(gseq!=null) {
				int result=orderDao.addWishList(loginInfo.getMail(), Integer.parseInt(gseq));
				if(result>=0) {
					return"redirect:gameDetail.go?gseq="+gseq+"";
				}
			}return"/warning/ErrorPage.jsp";
		}
		return"redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class };
	}

}
