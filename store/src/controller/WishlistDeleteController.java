package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.OrderDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/deleteWishlist.go")
public class WishlistDeleteController implements Controller, DataBinding {
	private OrderDao orderDao;
	public WishlistDeleteController setOrderDao(OrderDao orderDao) {
		this.orderDao=orderDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			//선택한 체크박스가 있는가 확인
			if(model.get("gseq")!=null) {
				String gseqset = (String)model.get("gseq");
				String []gseqs = gseqset.split(",");
				int result = -1;
				for (String gseq : gseqs) {
					result = orderDao.deleteWishlist(loginInfo.getMail(), Integer.parseInt(gseq));
					//db에 적용되었다면
				}
				if(result>=0) {
					return"redirect: wishlist.go";
				}else{
					return"/warning/ErrorPage.jsp";									
				}
			}return"redirect: wishlist.go";
		}
		return"redirect:login.go";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"gseq", String.class};
	}
}
