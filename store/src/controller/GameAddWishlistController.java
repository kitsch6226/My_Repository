package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addWishlist.go")
public class GameAddWishlistController implements Controller,DataBinding{
	private OrderDao orderDao;
	public GameAddWishlistController setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession)model.get("session");
		User loginInfo = (User)session.getAttribute("loginInfo");
		//로그인했는가
		if(loginInfo!=null) {
			int gseq = (int)model.get("gseq");
			int result = orderDao.addWishList(loginInfo.getMail(), gseq);
			//db에 무사히 들어갔다면
			System.out.println(result);
			if(result>=0) {
				return"redirect: gameDetail.go?gseq="+gseq+"";
			}else {
				return "/warning/ErrorPage.jsp";	
			}
		}else{
			return "redirect:login.go";
		}
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"gseq",int.class};
	}
}
