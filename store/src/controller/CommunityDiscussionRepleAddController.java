package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/addDiscussionReple.go")
public class CommunityDiscussionRepleAddController implements Controller,DataBinding {
	private CommunityDao communityDao;

	public CommunityDiscussionRepleAddController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String dseq = (String)model.get("dseq");
			//dseq를 받아왔다면
			if(dseq!=null) {
				String content = (String)model.get("reply");
				//리플 내용이 있다면
				if(content!=null) {
					int result = communityDao.addDiscussionReple(Integer.parseInt(dseq), loginInfo.getMail(), loginInfo.getName(), content);
					if(result>=0) {
						String scrollNum = (String)model.get("scrollNum");
						return"redirect: discussionDetail.go?dseq="+dseq+"&scrollNum="+scrollNum;
					}
				}
			}return "/warning/ErrorPage.jsp";
		}
		return "redirect: login.go";
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] { "dseq", String.class,"reply",String.class,"scrollNum",String.class};
	}
}
