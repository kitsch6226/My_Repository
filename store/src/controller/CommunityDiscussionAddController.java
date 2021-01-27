package controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.CommunityDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addDiscussion.go")
public class CommunityDiscussionAddController implements Controller, DataBinding {
	private CommunityDao communityDao;

	public CommunityDiscussionAddController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String savePath = "image/discussion";
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			ServletContext context = (ServletContext) model.get("context");
			String uploadFilePath = context.getRealPath(savePath);
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
						new DefaultFileRenamePolicy());
				Enumeration files = multi.getFileNames();
				// 제목란에 내용이 입력되었는지
				if (multi.getParameter("subject") != null) {

					if (files.hasMoreElements()) {
						String file = (String) files.nextElement();
						String file_name = multi.getFilesystemName(file);

						String file2 = (String) files.nextElement();
						String file_name2 = multi.getFilesystemName(file2);
						if (file_name != null || file_name2 != null) {
							if(file_name2==null) {
								file_name2="";
							}
							String imageName = file_name + "," + file_name2;
							// 사용자가 사진을 등록했다면
								int result = communityDao.addDiscussionImage(loginInfo.getMail(),
										multi.getParameter("kind"), imageName, multi.getParameter("subject"),
										multi.getParameter("content"), loginInfo.getName());
								// db에 잘 들어갔는지
								if (result >= 0) {
									return "redirect:discussion.go";
								}
								return "/warning/ErrorPage.jsp";
								// 사진을 등록하지 않았다면
						} else {
							int result = communityDao.addDiscussionNoImage(loginInfo.getMail(),
									multi.getParameter("kind"), multi.getParameter("subject"),
									multi.getParameter("content"), loginInfo.getName());
							// db에 잘 들어갔는지
							if (result >= 0) {
								return "redirect:discussion.go";
							}
							return "/warning/ErrorPage.jsp";
						}
					}
				}
				return "/main/MainPage.jsp?kind=community&sort=discussionwrite";// 작성 페이지로 보내기

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "/warning/ErrorPage.jsp";

		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "subject", String.class, "content", String.class };
	}
}
