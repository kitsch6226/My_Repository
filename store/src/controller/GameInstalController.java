package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GameDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/gameInstall.go")
public class GameInstalController implements Controller,DataBinding{
	private GameDao gameDao;
	public GameInstalController setGameDao(GameDao gameDao) {
		this.gameDao=gameDao;
		return this;
	}
	
	@Override
	public String execute(Map<String,Object>model)throws Exception{
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String gseq = (String)model.get("gseq");
			//gseq값을 잘 받아왔다면
			if(gseq!=null) {
				int result = gameDao.installGame(loginInfo.getMail(), Integer.parseInt(gseq));
				//db에 들어갔다면
				if(result>=0) {
					return"redirect:library.go";
				}				
			}return"redirect:library.go";
		}
		return"redirect:login.go";
	}
	@Override
	public Object[] getDataBinders() {
		return new Object[] {"gseq",String.class};
	}
}
