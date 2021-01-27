package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.CommunityDao;
import dto.ArtworkVO;
import dto.DiscussionVO;
import dto.ReplyVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/discussionDetail.go")
public class CommunityDiscussionDetailController implements Controller, DataBinding {
	private CommunityDao communityDao;

	public CommunityDiscussionDetailController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		String dseq = (String)model.get("dseq");
		if(dseq!=null) {
			int result = communityDao.updateDiscussionView(Integer.parseInt(dseq));
			//의견의 view가 올라갔다면
			if(result>=0) {
				DiscussionVO discussion = communityDao.selectDiscussion(Integer.parseInt(dseq));
				//커뮤니티 특정 토론의 정보를 잘 받아왔다면
				if(discussion!=null) {
					model.put("discussion", discussion);
					HttpSession session = (HttpSession) model.get("session");
					User loginInfo = (User) session.getAttribute("loginInfo");
					//로그인 했다면
					if(loginInfo!=null) {
						//로그인한 사용자의 토론 게시글 좋아요,싫어요 여부수집
						ArrayList<DiscussionVO> discussionRates = communityDao.selectDiscussionRate(loginInfo.getMail());
						//값이 있다면
						if(!discussionRates.isEmpty()) {
							System.out.println("fff");
							model.put("discussionRates", discussionRates);
						}
						ArrayList<ReplyVO> discussionRepleRates = communityDao.selectDiscussionRepleRate(loginInfo.getMail());
						//로그인한 사용자의 토론 게시글 리플 좋아요,싫어요 여부수집
						if(!discussionRepleRates.isEmpty()) {
							System.out.println("ddd");
							model.put("discussionRepleRates", discussionRepleRates);
						}
					}		
					ArrayList<ReplyVO> reples = communityDao.selectReply(Integer.parseInt(dseq));
					//게시글에 리플이 있다면
					if(!reples.isEmpty()) {
						model.put("reples", reples);
					}
					return "/main/MainPage.jsp?kind=community&sort=discussiondetail";
				}
			}
		}return "/warning/ErroPage.jsp";	
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "dseq", String.class};
	}
}