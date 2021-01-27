package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.QnaDao;
import dto.QnaVO;
import dto.ReplyVO;
import dto.User;
import store.Component;
import store.DataBinding;
@Component("/main/checkQna.go")
public class SupportQnaDetailController implements Controller, DataBinding {
	private QnaDao qnaDao;

	public SupportQnaDetailController setQnaDao(QnaDao qnaDao) {
		this.qnaDao = qnaDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String qseq = (String)model.get("qseq");
			if(qseq!=null) {
				QnaVO qnaInfo = qnaDao.selectQna(Integer.parseInt(qseq));
				//해당 qseq의 문의가 존재 한다면
				if(qnaInfo!=null) {
					model.put("qnaInfo", qnaInfo);
					ReplyVO qnaReple = qnaDao.selectQnaReple(Integer.parseInt(qseq));
					//해당 문의에 대한 리플 불러오기
					if(qnaReple!=null) {
						model.put("qnaReple", qnaReple);
						int result = qnaDao.updateQnaUserCheckYn(Integer.parseInt(qseq));
						//유저 읽음 처리가 되었는지
						if(result>=0) {
							return "/main/MainPage.jsp?kind=supportqnadetail"; //qna리플 정보까지 있어야 보냄							
						}
					}
				}return "redirect:support.go?check=false";
				
			}
		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "qseq", String.class };
	}
}
