package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteOrders.go")
public class OrderDeleteController implements Controller, DataBinding {
	private OrderDao orderDao;
	public OrderDeleteController setOrderDao(OrderDao orderDao) {
		this.orderDao=orderDao;
		return this;
	}
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			//선택한 체크박스가 있는가 확인
			if(model.get("oseq")!=null) {
				String oseqset[] = (String[])model.get("oseq");
				int result=-1;
				for (String oseq : oseqset) {
					result = orderDao.deleteOrder(loginInfo.getMail(), Integer.parseInt(oseq));
					//db에 적용되었다면
				}
				if (result >= 0) {
					return "redirect: orders.go";
				} else {
					return "/warning/ErrorPage.jsp";
				}
			}return"redirect: orders.go";
		}
		return"redirect:login.go";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"oseq", String[].class};
	}
}
