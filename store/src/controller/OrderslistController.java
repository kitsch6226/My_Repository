package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.OrderVO;
import dto.User;
import store.Component;

@Component("/main/orders.go")
public class OrderslistController implements Controller {
	private GameDao gameDao;
	public OrderslistController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 되어있는지 체크
		if (loginInfo != null) {
			int totalPrice = 0;
			ArrayList<OrderVO> orderInfo = gameDao.selectOrdersGames(loginInfo.getMail());
			//db에서 값을 잘 가져왔다면
			if(!orderInfo.isEmpty()) {
				//가격 총 합산 구하기
				for (OrderVO orderVO : orderInfo) {
					totalPrice+=orderVO.getPrice();
				}
				model.put("totalPrice", totalPrice);
				model.put("orderInfo", orderInfo);
				return"/main/MainPage.jsp?kind=order";
			}model.put("totalPrice", totalPrice);
			return"/main/MainPage.jsp?kind=order";
		}
		return "redirect:login.go";
	}
}
