package controller;

import java.util.ArrayList;
import java.util.Map;

import dao.CommunityDao;
import dto.DiscussionVO;
import store.Component;
@Component("/main/discussion.go")
public class CommunityDiscussionController implements Controller {
	private CommunityDao communityDao;
	public CommunityDiscussionController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		ArrayList<DiscussionVO> discussions = communityDao.selectDiscussions();
		//토론이 있다면
		if(!discussions.isEmpty()) {
			model.put("discussions", discussions);
		}return"/main/MainPage.jsp?kind=community&sort=discussion";
	}

}
