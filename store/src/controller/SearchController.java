package controller;

import java.util.ArrayList;
import java.util.Map;

import dao.GameDao;
import dto.GameVO;
import store.Component;
import store.DataBinding;

@Component("/main/search.go")
public class SearchController implements Controller,DataBinding{
	private GameDao gameDao;
	public SearchController setGameDao(GameDao gameDao) {
		this.gameDao=gameDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		String searchContent = (String)model.get("searchContent");
		//검색 값이 있다면
		if(searchContent!=null) {
			ArrayList<GameVO> searchGames = null;
			//특가
			if(searchContent.contentEquals("specialOfferGame")||searchContent.contentEquals("특가")||searchContent.replaceAll(" ","").contentEquals("특가게임")||searchContent.contentEquals("할인")) {
				model.put("Title", "특별 할인 게임");
				searchGames = gameDao.selectSpecialOfferGame();
			//무료
			}else if(searchContent.contentEquals("freeGame")||searchContent.contentEquals("무료")||searchContent.replaceAll(" ","").contentEquals("무료게임")) {
				model.put("Title", "무료 게임");
				searchGames = gameDao.selectFreeGame();
			//신작
			}else if(searchContent.contentEquals("newGame")||searchContent.contentEquals("신작")||searchContent.replaceAll(" ","").contentEquals("신작게임")) {
				model.put("Title", "신작 게임");
				searchGames =gameDao.selectNewGame();
			//검색어로 검색
			}else if(searchContent.contentEquals("All")){
				model.put("Title", "모든 게임");
				searchGames = gameDao.selectGames();
			}
			else {
				model.put("Title", "게임 목록");
				model.put("searchTitle", searchContent);
				searchGames = gameDao.selectSearchGame(searchContent);				
			}
			//검색 결과가 있다면
			if(!searchGames.isEmpty()) {
				model.put("searchGames", searchGames);
			}
			return"/main/MainPage.jsp?kind=search";
		}
		return"redirect:ogu.go";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"searchContent",String.class};
	}
}
