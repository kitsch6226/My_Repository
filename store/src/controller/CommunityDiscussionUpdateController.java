package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.CommunityDao;
import dto.DiscussionVO;
import dto.User;
import store.Component;

@Component("/main/updateDiscussion.go")
public class CommunityDiscussionUpdateController implements Controller {
	private CommunityDao communityDao;

	public CommunityDiscussionUpdateController setCommunityDao(CommunityDao communityDao) {
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
			;
			String savePath = "image/discussion";
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			ServletContext context = (ServletContext) model.get("context");
			String uploadFilePath = context.getRealPath(savePath);
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
						new DefaultFileRenamePolicy());
				Enumeration<?> files = multi.getFileNames();
				// dseq값을 받아온다.
				String dseqs = multi.getParameter("dseq");
				if (dseqs != null) {
					int dseq = Integer.parseInt(dseqs);
					DiscussionVO discussion = communityDao.selectDiscussion(dseq);
					// 해당 dseq를 가진 게시물이 있다면
					if (discussion != null) {
						model.put("discussion", discussion);
						// 제목란에 내용이 입력되었는지
						if (multi.getParameter("content") != null) {
							if (files.hasMoreElements()) {
								//파일1
								String file = (String) files.nextElement();
								String file_name = multi.getFilesystemName(file);
								//파일2
								String file2 = (String) files.nextElement();
								String file_name2 = multi.getFilesystemName(file2);
								// 사용자가 사진을 하나라도 등록했다면
								if (file_name != null || file_name2 != null) {
									// 두 파일 다 올렸다면
									int result = -1;
									if (file_name != null && file_name2 != null) {
										String imageName = file_name + "," + file_name2;
										result = communityDao.updateDiscussion(loginInfo.getMail(),
												multi.getParameter("subject"), multi.getParameter("content"), imageName,
												dseq);
										// 두 번째 파일만 올렸다면
									} else if (file_name == null && file_name2 != null) {
										String imageName = file_name2;
										result = communityDao.updateDiscussion(loginInfo.getMail(),
												multi.getParameter("subject"), multi.getParameter("content"), imageName,
												dseq);
										// 첫 번째 파일만 올렸다면
									} else if (file_name != null && file_name2 == null) {
										String imageName = file_name;
										result = communityDao.updateDiscussion(loginInfo.getMail(),
												multi.getParameter("subject"), multi.getParameter("content"), imageName,
												dseq);
									}
									// db에 잘 들어갔다면
									if (result >= 0) {

										if (multi.getParameterValues("originalimage") != null) {
											for (int i = 0; i < multi.getParameterValues("originalimage").length; i++) {
												String filePath = uploadFilePath + "\\"
														+ multi.getParameterValues("originalimage")[i];
												File originalfile = new File(filePath);
												System.out.println("경로 : " + filePath);
												if (originalfile.exists()) {
													System.out.println("파일 존재함으로 삭제");
													originalfile.delete();
												}
											}
										}
										return "redirect:discussionDetail.go?dseq=" + dseq;
									}
									return "/warning/ErrorPage.jsp";
								// 사진을 등록하지 않았다면
								} else {
									int result = communityDao.updateDiscussionNoImage(loginInfo.getMail(),
											multi.getParameter("subject"), multi.getParameter("content"), dseq);
									// db에 잘 들어갔는지
									if (result >= 0) {
										return "redirect:discussionDetail.go?dseq=" + dseq;
									}
									return "/warning/ErrorPage.jsp";
								}
							}
						}
					}
				}
				return "/main/MainPage.jsp?kind=community&sort=discussionupdate";// 작성 페이지로 보내기

			} catch (Exception e) {
				e.printStackTrace();
				return "/warning/ErrorPage.jsp";
			}

		}
		return "redirect:login.go";
	}

}