package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dao.OrderDao;
import dto.GameVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addOrders.go")
public class OrderAddController implements Controller, DataBinding {
	private OrderDao orderDao;

	public OrderAddController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String[] gseqset = (String[]) model.get("gseq");
			// 넘겨 받은 값이 있다면
			if (gseqset != null) {
				int result = -1;
				for (String gseq : gseqset) {
					// 구매창에 있는지 검사
					result = orderDao.selectOrder(loginInfo.getMail(), Integer.parseInt(gseq));
					if (result >= 0) {
						return "redirect: wishlist.go?wish=already";
					} else {
						result = orderDao.addOrderList(loginInfo.getMail(), Integer.parseInt(gseq));
					}
				}
				if (result >= 0) {
					return "redirect: orders.go";
				}
			}
			return "/warning/ErrorPage.jsp";
		}
		return "redirect: login.go";

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String[].class };
	}
}
