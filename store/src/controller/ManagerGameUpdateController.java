package controller;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GameDao;
import dto.DiscussionVO;
import dto.GameVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/updateGame.go")
public class ManagerGameUpdateController implements Controller, DataBinding {
	private GameDao gameDao;

	public ManagerGameUpdateController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			String gseq = (String) model.get("gseq");
			// gseq를 받아왔는지 확인
			if (gseq != null) {
				GameVO gameInfo = gameDao.selectManagerGame(Integer.parseInt(gseq));
				// 받아온 게임 값이 잘 있는지 체크
				if (gameInfo.getPortrait() != null) {
					model.put("gameInfo", gameInfo);
					return "/manager/main/ManagerMainPage.jsp?kind=editGame";
				}
				return "/warning/ErrorPage.jsp";
			} else {
				String savePath = "image/keyart";
				int uploadFileSizeLimit = 5 * 1024 * 1024;
				String encType = "UTF-8";
				ServletContext context = (ServletContext) model.get("context");
				String uploadFilePath = context.getRealPath(savePath);
				try {
					MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType,
							new DefaultFileRenamePolicy());
					String gameName = multi.getParameter("subject");
					String content1 = multi.getParameter("content1");
					String content2 = multi.getParameter("content2");
					String gseqs = multi.getParameter("gseq");
					String price1 = multi.getParameter("price1");
					String price2 = multi.getParameter("price2");
					String tag = multi.getParameter("tag1").trim() + " , " + multi.getParameter("tag2").trim() + " , "
							+ multi.getParameter("tag3").trim() + " , " + multi.getParameter("tag4").trim();
					String specialofferyn = multi.getParameter("specialofferyn");
					String freegameyn = multi.getParameter("freegameyn");
					String newgameyn = multi.getParameter("newgameyn");
					String adgameyn = multi.getParameter("adgameyn");
					String useyn = multi.getParameter("useyn");
					// 모든 값이 입력되었는지 확인
					if (gameName != null&content1!=null&&content2!=null&&
						gseqs!=null&&specialofferyn!=null&&freegameyn!=null&&
						newgameyn!=null&&adgameyn!=null&&
						price1!=null&&price2!=null) {
						GameVO gameInfo = new GameVO().setName(gameName).setContent1(content1).setContent2(content2).setGseq(Integer.parseInt(gseqs))
											.setPrice1(Integer.parseInt(price1)).setPrice2(Integer.parseInt(price2)).setTag2(tag)
											.setSpecialofferyn(specialofferyn).setFreegameyn(freegameyn).setAdgameyn(adgameyn).setNewgameyn(newgameyn)
											.setUseyn(useyn);
						Enumeration<?> files = multi.getFileNames();
						if (files.hasMoreElements()) {
							String file = (String) files.nextElement();
							String file_name = multi.getFilesystemName(file);
							// 사용자가 키아트 사진을 등록했다면
							if (file_name != null) {
								int result = gameDao.updateGame(gameInfo);
								// 업데이트가 db에 반영되었다면
								if (result >= 0) {
									
									// 원본이미지의 값을 받아왔다면
									if (multi.getParameter("originalimage") != null) {
										String filePath = uploadFilePath + "\\" + multi.getParameter("originalimage");
										File originalfile = new File(filePath);
										// 경로에 오리지널 키아트가 존재하면 삭제시키기
										if (originalfile.exists()) {
											System.out.println("-----"+filePath);
											System.out.println("파일 존재함으로 삭제");
											originalfile.delete();
										}
									}
									return "redirect: managerGame.go";
								} else {
									return "/warning/ErrorPage.jsp";
								}
								// 키아트 사진을 등록하지 않았다면
							} else {
								int result = gameDao.updateGameNoImage(gameInfo);
								// 업데이트가 db에 반영되었다면
								if (result >= 0) {
									return "redirect: managerGame.go";
								} else {
									return "/warning/ErrorPage.jsp";
								}
							}
						}
					}
					return "/warning/ErrorPage.jsp";
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		return "redirect: login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class };
	}

}
