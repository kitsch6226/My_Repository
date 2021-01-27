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

@Component("/main/addArtwork.go")
public class CommunityArtworkAddController implements Controller {
	private CommunityDao communityDao;

	public CommunityArtworkAddController setCommunityDao(CommunityDao communityDao) {
		this.communityDao = communityDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "아트웍");
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		User loginInfo = (User) session.getAttribute("loginInfo");
		// 로그인 체크
		if (loginInfo != null) {
			String savePath = "image/artwork";
			int uploadFileSizeLimit = 5 * 1024 * 1024;
			String encType = "UTF-8";
			ServletContext context = (ServletContext) model.get("context");
			String uploadFilePath = context.getRealPath(savePath);
			try {
				MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
						new DefaultFileRenamePolicy());
				Enumeration files = multi.getFileNames();
				if (files.hasMoreElements()) {
					String file = (String) files.nextElement();
					String file_name = multi.getFilesystemName(file);
					// 사용자가 사진을 등록했다면
					if (file_name != null) {
						int result = communityDao.addArtwork(loginInfo.getMail(), file_name);
						// db에 잘 들어갔는지
						if (result >= 0) {
							return "redirect:community.go";
						}return "/warning/ErrorPage.jsp";	
					}
				}
				// 사진을 등록하지 않았다면
				return "/main/MainPage.jsp?kind=community&sort=artworkwrite";// 작성 페이지로 보내기
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "/warning/ErrorPage.jsp";

		}
		return "redirect: login.go";
	}
}
