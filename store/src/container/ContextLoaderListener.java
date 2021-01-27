package container;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import controller.ApplicationContext;

//WebListener 애노테이션을 사용하여 톰캣 서버에게 listener클래스임을 알려주고 인터페이스 구현
@WebListener
public class ContextLoaderListener implements ServletContextListener{
	
	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			System.out.println("콘텍스트로더리스너 시작\n");
			ServletContext sc = event.getServletContext();
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			System.out.println("콘텍스트로더리스너 propertiesPath: "+ propertiesPath);
			applicationContext = new ApplicationContext(propertiesPath);
			System.out.println("콘텍스트로더리스너 끝");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}
	
}
