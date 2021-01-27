package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dto.QnaVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addQna.go")
public class SupportQnaAddController implements Controller, DataBinding {
	private QnaDao qnaDao;

	public SupportQnaAddController setQnaDaoDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			QnaVO qna = (QnaVO) model.get("Qna");
			// 전달받은 사용자 qna에 제목이 있었는가
			System.out.println(qna.getSubject());
			if (qna.getSubject() != null && qna.getContent()!=null&&qna.getKind()!=null) {
				int result = qnaDao.addQna(loginInfo.getMail(), qna.getKind(), qna.getSubject(), qna.getContent());
				// db에 잘 들어 갔다면
				if (result >= 0) {
					return "redirect: support.go?check=added";
				}
				return "/warning/ErrorPage.jsp";
			}
			return "/main/MainPage.jsp?kind=supportone";
		}return"redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "Qna", QnaVO.class };
	}
}