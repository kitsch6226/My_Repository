package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/updateOrders.go")
public class OrderUpdateController implements Controller, DataBinding {
	private OrderDao orderDao;

	public OrderUpdateController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String[] gseqs = (String[]) model.get("gseq");
			// 넘겨 받은 값이 있다면
			if (gseqs != null) {
				int result = -1;
				String gseqset="";
				for (String gseq : gseqs) {
					System.out.println("오더 업데이트 컨2: "+gseq);
					gseqset += (gseq +",");
					result = orderDao.finishOrder(loginInfo.getMail(), Integer.parseInt(gseq));
					// db에 추가 되었다면
				}
				if (result >= 0) {
					return "redirect:addLibrary.go?gseq=" + gseqset;
				} else {
					return "/warning/ErrorPage.jsp";
				}
			}
			return "redirect:orders.go";
		}
		return "redirect: login.go";

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String[].class };
	}
}
