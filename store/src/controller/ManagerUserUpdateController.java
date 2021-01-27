package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.UserDao;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/updateUserManager.go")
public class ManagerUserUpdateController implements Controller {
	private UserDao userDao;

	public ManagerUserUpdateController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		User managerInfo = (User) session.getAttribute("managerInfo");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		// 로그인 체크
		if (managerInfo != null) {

			String savePath = "image/profile";
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			ServletContext context = (ServletContext) model.get("context");
			String uploadFilePath = context.getRealPath(savePath);
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
						new DefaultFileRenamePolicy());

				// 유저 넘버를 받았는지 체크
				if (multi.getParameter("num") != null) {
					User userInfo = userDao.selectManagerUser(multi.getParameter("num"));
					// 해당 유저가 있다면
					if (userInfo != null) {
						model.put("userInfo", userInfo);

						// 이름을 입력 받았다면
						Enumeration<?> files = multi.getFileNames();
						if (multi.getParameter("name") != null) {
							if (files.hasMoreElements()) {
								String file = (String) files.nextElement();
								String file_name = multi.getFilesystemName(file);
								// 사용자가 프로필 사진을 등록했다면
								if (file_name != null) {
									int result = userDao.userManagerUpdate(multi.getParameter("num"), file_name,
											multi.getParameter("name"), multi.getParameter("useyn"));
									// 업데이트가 db에 반영되었다면
									if (result >= 0) {
										// 파일 업로드후 기존 파일 제거
										if (multi.getParameter("originalimage") != null	&& !multi.getParameter("originalimage").equals("default_profile.png")) {
											System.out.println(file_name);
											String filePath = uploadFilePath + "\\"
													+ multi.getParameter("originalimage");
											File originalfile = new File(filePath);
											System.out.println("경로 : " + filePath);
											if (originalfile.exists()) {
												System.out.println("파일 존재함으로 삭제");
												originalfile.delete();
											}

										}
										userInfo = userDao.selectUser(multi.getParameter("num"));
										if (userInfo != null) {
											model.put("userInfo", userInfo);
											return "/manager/main/ManagerMainPage.jsp?kind=editUser&check=ok";
										}
										return "redirect: user.go";

									} else {
										return "/warning/ErrorPage.jsp";
									}
									// 프로필 사진을 등록하지 않았다면
								} else {
									int result = userDao.userManagerUpdate(multi.getParameter("num"),
											multi.getParameter("name"), multi.getParameter("useyn"));
									// 업데이트가 db에 반영되었다면
									if (result >= 0) {
										userInfo = userDao.selectUser(multi.getParameter("num"));
										if (userInfo != null) {
											model.put("userInfo", userInfo);
											return "/manager/main/ManagerMainPage.jsp?kind=editUser&check=ok";
										}
										return "redirect: user.go";
									} else {
										return "/warning/ErrorPage.jsp";
									}
								}
							}
						}
						return "/manager/main/ManagerMainPage.jsp?kind=editUser";
					}
					return "/warning/ErrorPage.jsp";
				}
				return "/manager/main/ManagerMainPage.jsp?kind=user";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return "redirect: login.go";
	}
}
