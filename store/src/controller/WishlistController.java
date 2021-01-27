package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.User;
import dto.WishlistVO;
import store.Component;
import store.DataBinding;

@Component("/main/wishlist.go")
public class WishlistController implements Controller,DataBinding{
	private GameDao gameDao;
	public WishlistController setGameDao(GameDao gameDao) {
		this.gameDao=gameDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object>model)throws Exception{
		HttpSession session = (HttpSession)model.get("session");
		User userInfo = (User)session.getAttribute("loginInfo");
		//로그인 되어있는지 체크
		if(userInfo!=null) {
			String sort = (String) model.get("sort");
			if(sort==null||sort.equals("indate")) {
				ArrayList<WishlistVO> wishlistGames = gameDao.selectWishlistGamesOrderByIndate(userInfo.getMail());
				model.put("wishlistSort", "최근");
				if(!wishlistGames.isEmpty()) {
					model.put("wishlistGames", wishlistGames);
				}
				return "/main/MainPage.jsp?kind=wishlist";
			}else if(sort.equals("rate")) {
				ArrayList<WishlistVO> wishlistGames = gameDao.selectWishlistGamesOrderByRate(userInfo.getMail());
				model.put("wishlistSort", "평가");
				if(!wishlistGames.isEmpty()) {
					model.put("wishlistGames", wishlistGames);
				}
				return "/main/MainPage.jsp?kind=wishlist";
			}else if(sort.equals("discount")) {
				ArrayList<WishlistVO> wishlistGames = gameDao.selectWishlistGamesOrderByDiscount(userInfo.getMail());
				model.put("wishlistSort", "할인율");
				if(!wishlistGames.isEmpty()) {
					model.put("wishlistGames", wishlistGames);
				}
				return "/main/MainPage.jsp?kind=wishlist";
			}return"/warning/ErrorPage.jsp";
		}
		return"redirect:login.go";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] { "sort", String.class };
	}

}
