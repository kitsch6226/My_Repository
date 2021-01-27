package controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dto.QnaVO;
import dto.ReplyVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/qna.go")
public class ManagerQnaController implements Controller, DataBinding {
	private QnaDao qnaDao;

	public ManagerQnaController setQnaDao(QnaDao qnaDao) {
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
			String qseq = (String) model.get("qseq");
			ArrayList<QnaVO> qnas = qnaDao.selectQnas();
			//qna가 있다면
			if (qnas != null) {
				model.put("qnas", qnas);
				//qna상세 페이지로 갈것인지 분기
				if (qseq != null) {
					QnaVO qnaInfo = qnaDao.selectQna(Integer.parseInt(qseq));
					model.put("qnaInfo", qnaInfo);
					//db에서 값을 잘 받아왔다면
					if(qnaInfo!=null) {
						ReplyVO qnaReple = qnaDao.selectQnaReple(Integer.parseInt(qseq));
						model.put("qnaReple", qnaReple);
					}return"/manager/main/ManagerMainPage.jsp?kind=qnaDetail";
				}
			}return "/manager/main/ManagerMainPage.jsp?kind=qna";				
		}
		return "redirect:login.go";

	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "qseq", String.class};
	}

}
