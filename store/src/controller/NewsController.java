package controller;

import java.util.ArrayList;
import java.util.Map;

import dao.NewsDao;
import dto.NewsVO;
import store.Component;

@Component("/main/news.go")
public class NewsController implements Controller{
	private NewsDao newsDao;
	public  NewsController setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		ArrayList<NewsVO> newss = newsDao.selectNews();
		// 값을 db에서 받아왔다면
		if (!newss.isEmpty()) {
			model.put("newss", newss);
			return "/main/MainPage.jsp?kind=news";
		}return"/warning/ErrorPage.jsp";
	}
}

