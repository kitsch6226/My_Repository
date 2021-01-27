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

@Component("/main/accountSetting.go")
public class UserUpdateController implements Controller, DataBinding {
	private UserDao userDao;

	public UserUpdateController setUserDao(UserDao userDao) {
		this.userDao = userDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {

			String savePath = "image/profile";
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			ServletContext context = (ServletContext) model.get("context");
			String uploadFilePath = context.getRealPath(savePath);
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
						new DefaultFileRenamePolicy());
				// 이름창에 값이 있는지 확인
				if (multi.getParameter("name") != null) {
					Enumeration files = multi.getFileNames();
					if (files.hasMoreElements()) {
						String file = (String) files.nextElement();
						String file_name = multi.getFilesystemName(file);
						// 사용자가 프로필 사진을 등록했다면
						if (file_name != null) {
							int result = userDao.userUpdate(loginInfo.getMail(), file_name, multi.getParameter("name"),
									multi.getParameter("pw"));
							// 업데이트가 db에 반영되었다면
							if (result >= 0) {
								loginInfo = userDao.checkPw(loginInfo.getMail(), multi.getParameter("pw"));
								session.removeAttribute("loginInfo");
								session.setAttribute("loginInfo", loginInfo);

								if (multi.getParameter("originalimage") != null&&!multi.getParameter("originalimage").equals("default_profile.png")) {

									String filePath = uploadFilePath + "\\"	+ multi.getParameter("originalimage");
									File originalfile = new File(filePath);
									System.out.println("경로 : " + filePath);
									if (originalfile.exists()) {
										System.out.println("파일 존재함으로 삭제");
										originalfile.delete();
									}
								}
								return "/main/MainPage.jsp?kind=accountsetting&check=ok";
							} else {
								return "/warning/ErrorPage.jsp";
							}
							// 프로필 사진을 등록하지 않았다면
						} else {
							System.out.println("update:여기들어옴2222" + file_name);
							int result = userDao.userUpdate(loginInfo.getMail(), multi.getParameter("name"),
									multi.getParameter("pw"));
							// 업데이트가 db에 반영되었다면
							if (result >= 0) {
								loginInfo = userDao.checkPw(loginInfo.getMail(), multi.getParameter("pw"));
								session.removeAttribute("loginInfo");
								session.setAttribute("loginInfo", loginInfo);
								return "/main/MainPage.jsp?kind=accountsetting&check=ok";
							} else {
								return "/warning/ErrorPage.jsp";
							}
						}
					}
				}
				return "/main/MainPage.jsp?kind=accountsetting";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "useruploadInfo", User.class };
	}
}
