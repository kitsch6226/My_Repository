package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import container.ContextLoaderListener;
import store.DataBinding;
import store.ServletRequestDataBinder;


@SuppressWarnings("serial")
@WebServlet("*.go")
public class DispatcherServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("디스패처클래스 시작");
		String servletPath = request.getServletPath();
		System.out.println("디스패처클래스 서블릿패스: "+servletPath);
		try {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
			HashMap<String,Object>model = new HashMap<String,Object>();
			model.put("session", request.getSession());			
			//파일 업로드를 위해 put
			ServletContext context = getServletContext();
			model.put("request", request);
			model.put("context", context);			
			Controller controller = (Controller)ctx.getBean(servletPath);			
			System.out.println("디스패처클래스 컨트롤러: "+controller);
			//데이터바인딩을 구현했다면
			if(controller instanceof DataBinding) {
				prepareRequestData(request,model,(DataBinding)controller);		
			}
			String viewUrl = controller.execute(model);
			for(String key : model.keySet()) {
				System.out.println("dispatcher--------"+key+" , "+ model.keySet());
				request.setAttribute(key, model.get(key));
			}
			
			response.setHeader("Expires", "Wed, 2 June 1993 12:00:00 GMT"); 
			response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0"); 
			response.setHeader("Pragma", "no-cache");
			
			//페이지 컨트롤러 실행		 			
			if(viewUrl.startsWith("redirect:")) {
				System.out.println("디스패처클래스 redirect");
				response.sendRedirect(viewUrl.substring(9));
			}else {
				System.out.println("디스패처클래스 include");
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}			
			System.out.println("디스패처클래스 끝\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void prepareRequestData(HttpServletRequest request,HashMap<String,Object>model,DataBinding dataBinding)throws Exception{
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		
		for(int i = 0; i<dataBinders.length; i+=2) {
			dataName = (String)dataBinders[i];
			dataType = (Class<?>)dataBinders[i+1];
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			//넵 ㅠ
			//각 컨트롤러에서 필요한 데이터를 모델로 넣어줌
			model.put(dataName, dataObj);
		}
	}
}
