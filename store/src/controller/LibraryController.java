package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.LibraryVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/library.go")
public class LibraryController implements Controller, DataBinding {
	private GameDao gameDao;

	public LibraryController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String sort = (String) model.get("sort");

				if (sort == null||sort.contentEquals("indate")) {
					ArrayList<LibraryVO> libraryGames = gameDao.selectLibraryGamesOrderByIndate(loginInfo.getMail());
					model.put("librarySort", "최근");
					if (!libraryGames.isEmpty()) {
						model.put("libraryGames", libraryGames);
					}
					return "/main/MainPage.jsp?kind=library";
				}else if(sort.contentEquals("rate")) {
					ArrayList<LibraryVO> libraryGames = gameDao.selectLibraryGamesOrderByRate(loginInfo.getMail());
					model.put("librarySort", "평가");
					if (!libraryGames.isEmpty()) {
						model.put("libraryGames", libraryGames);
						
					}return "/main/MainPage.jsp?kind=library";
				}else if(sort.contentEquals("download")) {
					ArrayList<LibraryVO> libraryGames = gameDao.selectLibraryGamesOrderByDownload(loginInfo.getMail());
					model.put("librarySort", "설치여부");
					if (!libraryGames.isEmpty()) {
						model.put("libraryGames", libraryGames);
						
					}return "/main/MainPage.jsp?kind=library";
				}
				return "/warning/ErrorPage.jsp";
			}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "sort", String.class };
	}

}
