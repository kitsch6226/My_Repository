package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/deleteDiscussionReple.go")
public class CommunityDiscussionRepleDeleteController implements Controller, DataBinding {

	private CommunityDao communityDao;

	public CommunityDiscussionRepleDeleteController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String reseq = (String)model.get("reseq");
			String dseq = (String)model.get("dseq");
			String scrollNum = (String)model.get("scrollNum");
			if(reseq!=null&&dseq!=null) {
				int result = communityDao.deleteDiscussionReple(loginInfo.getMail(),Integer.parseInt(reseq),Integer.parseInt(dseq));
				if(result>=0) {
					return"redirect: discussionDetail.go?dseq="+dseq+"&scrollNum="+scrollNum;
				}			
			}return "/warning/ErrorPage.jsp";	
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "reseq", String.class, "dseq", String.class,"scrollNum",String.class };
	}

}
