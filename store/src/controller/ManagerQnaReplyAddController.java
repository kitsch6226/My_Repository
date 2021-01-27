package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/addQnaReply.go")
public class ManagerQnaReplyAddController implements Controller, DataBinding {
	private QnaDao qnaDao;

	public ManagerQnaReplyAddController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

@Override
public String execute(Map<String, Object> model) throws Exception {
	model.put("communityTitle", "토론");
	HttpSession session = (HttpSession) model.get("session");
	User managerInfo = (User) session.getAttribute("managerInfo");
	// 로그인 체크
	if (managerInfo != null) {
		String qseq = (String)model.get("qseq");
		String content = (String)model.get("reply");
		if(qseq!=null&&content!=null) {
			System.out.println("ddd");
			int result = qnaDao.addQnaReple(Integer.parseInt(qseq), content, managerInfo.getMail());
			//db에 잘 들어갔다면
			if(result>=0) {
				result = qnaDao.updateQnaRepleYn(Integer.parseInt(qseq));
				//리플 달렸음으로 업데이트
				if(result>=0) {
					return "redirect:qna.go?qseq="+qseq;
				}
			}
		}return"/warning/ErrorPage.jsp";
	}return "redirect:login.go";
	
}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "qseq", String.class,"reply",String.class };
	}

}
