package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/updateDiscussionReple.go")
public class CommunityDiscussionRepleUpdateController implements Controller, DataBinding {

	private CommunityDao communityDao;

	public CommunityDiscussionRepleUpdateController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String reseq = (String) model.get("reseq");
			String dseq = (String) model.get("dseq");
			String []content = (String[]) model.get("editReplyContent");
			String repleContent = "";
			String scrollNum = (String)model.get("scrollNum");
			for (String string : content) {
				//콘텐츠 내용없음 거름
				if(!string.equals("")){
					
					repleContent = string;
					System.out.println("----------"+repleContent);
					System.out.println("----------reseq, dseq"+reseq+" , "+ dseq);
					//받은 데이터 널검사
					if (reseq != null && dseq != null) {
						int result = communityDao.updateDiscussionReple(repleContent, Integer.parseInt(reseq));
						// db에 잘 들어갔다면
						if (result >= 0) {
							return "redirect: discussionDetail.go?dseq=" + dseq+"&scrollNum="+scrollNum;
						}	
					}return "/warning/ErrorPage.jsp";
				}
			}return "redirect: discussionDetail.go?dseq=" + dseq;
		}
		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "reseq", String.class, "editReplyContent", String[].class,"dseq", String.class,"scrollNum",String.class };
	}

}
