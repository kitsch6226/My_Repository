package controller;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

import dao.GameDao;
import dto.GameVO;
import dto.User;
import store.Component;
import store.DataBinding;

@Component("/main/addGame.go")
public class ManagerGameAddController implements Controller, DataBinding {
	private GameDao gameDao;

	public ManagerGameAddController setGameDao(GameDao gameDao) {
		this.gameDao = gameDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("communityTitle", "토론");
		HttpSession session = (HttpSession) model.get("session");
		HttpServletRequest request = (HttpServletRequest) model.get("request");
		ServletContext context = (ServletContext) model.get("context");
		User managerInfo = (User) session.getAttribute("managerInfo");
		// 로그인 체크
		if (managerInfo != null) {
			MultipartParser multi = new MultipartParser(request, 5 * 1024 * 1024 * 6);
			multi.setEncoding("UTF-8");
			Part part;
			String name = "", value = "";
			String path = "";
			String tag = "";
			String main = "";
			int i = 0;
			GameVO newGameInfo = new GameVO();
			while ((part = multi.readNextPart()) != null) {
				name = part.getName();
				if (part.isParam()) {
					ParamPart ppt = (ParamPart) part;
					value = ppt.getStringValue();
					System.out.println("param[" + i + "] : name = " + name + " ; value = " + value);
					// 저장할 주소 처리
					if (name.contentEquals("Uri")) {
						if (value.contentEquals("keyart")) {
							path = "image/keyart";
						} else if (value.contentEquals("portrait")) {
							path = "image/portrait";
						} else if (value.contentEquals("main")) {
							path = "image/main";
						}
					}
					if (name.contentEquals("subject")) {
						newGameInfo.setName(value);
					}
					if (name.contentEquals("developer")) {
						newGameInfo.setDeveloper(value);
					}
					if (name.contentEquals("content1")) {
						newGameInfo.setContent1(value);
					}
					if (name.contentEquals("content2")) {
						newGameInfo.setContent2(value);
					}
					if (name.contains("genre")) {
						newGameInfo.setGenre(value);
					}
					if (name.contains("tag")) {
						tag += value + ",";
					}
					if (name.contentEquals("price1")) {
						newGameInfo.setPrice1(Integer.parseInt(value));
					}
					if (name.contentEquals("price2")) {
						newGameInfo.setPrice2(Integer.parseInt(value));
					}
					if (name.contentEquals("adgameyn")) {
						newGameInfo.setAdgameyn(value);
					}
					if (name.contentEquals("newgameyn")) {
						newGameInfo.setNewgameyn(value);
					}
					if (name.contentEquals("freegameyn")) {
						newGameInfo.setFreegameyn(value);
					}
					if (name.contentEquals("specialofferyn")) {
						newGameInfo.setSpecialofferyn(value);

					}
					if (name.contentEquals("platform")) {
						newGameInfo.setPlatform(value);

					}
					if (name.contentEquals("violence")) {
						newGameInfo.setViolence(value);

					}
					if (name.contentEquals("min-processor")) {
						newGameInfo.setMin_processor(value);

					}if (name.contentEquals("min-os")) {
						newGameInfo.setMin_os(value);

					}if (name.contentEquals("min-storage")) {
						newGameInfo.setMin_storage(value);

					}if (name.contentEquals("min-memory")) {
						newGameInfo.setMin_memory(value);

					}if (name.contentEquals("min-vga")) {
						newGameInfo.setMin_vga(value);

					}if (name.contentEquals("min-processor")) {
						newGameInfo.setMax_processor(value);

					}if (name.contentEquals("max-os")) {
						newGameInfo.setMax_os(value);

					}if (name.contentEquals("max-storage")) {
						newGameInfo.setMax_storage(value);

					}if (name.contentEquals("max-memory")) {
						newGameInfo.setMax_memory(value);

					}if (name.contentEquals("max-vga")) {
						newGameInfo.setMax_vga(value);

					}

					// 파일 저장 처리
				} else if (part.isFile()) {
					FilePart filePart = (FilePart) part;
					filePart.setRenamePolicy(new DefaultFileRenamePolicy());
					String fileName = filePart.getFileName();
					if (fileName != null) {
						System.out.println("파일이름 출력 :" + fileName);
						File saveDir = new File(context.getRealPath(path));
						if(path.equals("image/keyart")){
							newGameInfo.setKeyart(fileName);
						}
						if(path.equals("image/portrait")){
							newGameInfo.setPortrait(fileName);
						}
						if(path.equals("image/main")){
							main += fileName +",";
						}
						filePart.writeTo(saveDir);
					}

				}
			}
			newGameInfo.setMain2(main);
			newGameInfo.setTag2(tag);
			int result = gameDao.addGame(newGameInfo);
			// db에 잘 들어갔다면
			if (result >= 0) {
				return "redirect:managerGame.go";
			}
		}

		return "redirect:login.go";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "gseq", String.class };
	}

}
