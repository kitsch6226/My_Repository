/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-10-19 02:04:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jspEx;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


		String str="Hello JSP";
		int su1 = 5, su2 = 7;
		
		public int method(){
			return su1 + su2;
		}
	
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<p>안녕하세요, JSP 페이지입니다.</p>\r\n");
      out.write("\t-JSP 기본 다루기(JSP로 시작하는 웹 프로그래밍)\r\n");
      out.write("\t인터넷을 사용하는 사용자에게 정보를 제공하기 위해서는 HTML 태그를 사용하여 웹브라우저 내에 정보를 표시하는데\r\n");
      out.write("\tJSP에서는 이러한 HTML 태그를 사용할 수 있어 웹 어플리케이션의 프레젠테이션 역할을 합니다.\r\n");
      out.write("\tJSP는 JSP에서만 사용 가능한 다양한 태그(예를 들면 스크립트릿과 같은 것 )을 이용하여 쉽게 웹 프로그래밍을 할 수 있도록 합니다.\r\n");
      out.write("\t\t\t\t\t\t\t\t <!-- %와 같은 표현   -->\r\n");
      out.write("\t컨텍스트 패스는 여러 개의 웹 애플리케이션이 WAS에서 동작할 경우 이를 구분하기 위해서 사용합니다.\r\n");
      out.write("\t이클립스가 자동으로 만들어주는 컨텍스트 패스는 프로젝트 이름과 동일합니다.\r\n");
      out.write("\t다음은 JSP를 요청하기 위한 URL입니다.(http://localhost:8080/webapp/jspEx/hello.jsp)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- ↑ 최상위 패스인 컨텍스트 패스 -->\r\n");
      out.write("\t프로젝트 생성시 입력하는 프로젝트 이름은 개발자 입장에서 개발을 위해서 생성된 파일들을 관리하기 위한 폴더이고\r\n");
      out.write("\t컨텍스트 패스는 사용자가 해당 웹 애플리케이션을 사용하기 위해서 접근하는 경로가 됩니다.\r\n");
      out.write("\t경우에 따라서는 개발자는 컨텍스트 패스 이름을 웹 프로젝트 이름과는 다른 원하는 이름으로 바꿀 수 있습니다.\r\n");
      out.write("\t\r\n");
      out.write("\tJSP는 Java Server Page의 약자로서 HTML 태그에 자바로 프로그래밍하여 브라우저에 보여주는 특별한 페이지입니다.\r\n");
      out.write("\t<!-- 자바에 의해 서버에서 만들어지는 동적 페이지다 -->\r\n");
      out.write("\t아래와 같이 HTML 태그 사이에");
 
      out.write("를 추가하려면 JSP 파일로 작성해야 합니다.\r\n");
      out.write("\t반면 JSP파일은 HTML 파이로가는 다르게 동작합니다.\r\n");
      out.write("\tHTML 파일은 확장자가 html 이고 이는 웹 브라우저 내의 번역기가 돌리는 반면 JSP 파일은 톰캣 서버가 번역하여\r\n");
      out.write("\t그 결과를 HTML 태그로 변환한 후 웹 브라우저에 내려 보내집니다.\r\n");
      out.write("\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t웹 컨테이너는 ");
 
      out.write("부분을 JSP로 인식하여 이를 해석한 후 HTML 형태로 변환.\r\n");
      out.write("\t\r\n");
      out.write("\t-JSP의 처리 과정(서블릭과 JSP)\r\n");
      out.write("\tJSP로 만들어진 예제를 보면 결과물로 놓고 보았을 때 서블릿과 별반 다른 일을 하지 않습니다.\r\n");
      out.write("\t서블릿과 JSP가 같은 일을 하기 위해 등장한 도구라면 왜 서블릿과 JSP가 둘 다 존재할까요?\r\n");
      out.write("\t자바 기반으로 웹 애플리케이션을 작성하기 위한 도구로 서블릿이 먼저 만들어짐.\r\n");
      out.write("\t하지만 서블릿은 HTML코드가 자바 코드 안에 들가는 구조\r\n");
      out.write("\t디자이너가 자바를 이해하지 못한 채 HTML 코드를 자바 형태인 서블릿에서 작성한다는 것은 거의 불가능한 일입니다.\r\n");
      out.write("\t이러한 문제점 때문에 등장한 것이 JSP (HTML, CSS 디자이너 접근가능 영역, JAVA 접근불가-> 개발자가HTML, CSS 이해 수준에서 JAVA코드 삽입)\r\n");
      out.write("\tJSP는 HTML 문서에 자바 코드가 들어가는 구조이기 때문에 서블릿보다는 JSP로 개발하는 편이 훨씬 쉽고 간단합니다.\r\n");
      out.write("\t\r\n");
      out.write("\tJSP는 서블릿보다 간편하게 웹 어플리케이션을 개발하기 위해서 등장한 것이기 때문에\r\n");
      out.write("\t웹 컨테이너는 JSP를 있는 그래도 받아들이지 못하고 이를 서블릿으로 변환한 후에 동작\r\n");
      out.write("\t\r\n");
      out.write("\t[처리과정]\r\n");
      out.write("\t개발자가 \t\t\t\t\t\t\t\t\t\t\t\t웹 컨테이너가\r\n");
      out.write("\tjsp를 작성하면 \t\t-> \t\tMYJSP.jsp\t\t ->\t\t\t서블릿으로 변환\t\t->\t\tMYJSP_jsp.java\r\n");
      out.write("\t\r\n");
      out.write("\tE:\\work2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\webapp\\org\\apache\\jsp\\jspEx\r\n");
      out.write("\t\r\n");
      out.write("\t[웹 컨테이너가 JSP를 변환하여 만들어 낸 서블릿 코드 순서]\r\n");
      out.write("\t\r\n");
      out.write("\tHttpJspBase 의 하위 클래스 생성\r\n");
      out.write("\t\t\t|\r\n");
      out.write("\t요청에 대해 반응하는 _jspService()를 만든다.\r\n");
      out.write("\t\t\t|\r\n");
      out.write("\tJSP를 작성할 때 쓰는 out과\r\n");
      out.write("\trequest와 같은 내장 객체를 선언한다.\r\n");
      out.write("\t\t\t|\r\n");
      out.write("\t내장 객체를 생성한다.\r\n");
      out.write("\t\t\t|\r\n");
      out.write("\tJSP에 있는 HTML 코드, 스크립트릿을 출력 스트림 out의 출력 메소드로 출력한다.\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t- JSP 기본 태그\r\n");
      out.write("\tHTML이나 자바스크립트에 의해 작성된 페이지들은 그 페이지를 사용하는 사용자와 상관없이 항상 동일한 내용만을 제공해주는 정적 페이지입니다.\r\n");
      out.write("\t하지만 웹 프로그램들은 사용자에 따라 서로 다른 내요잉 제공되어야 하는데 이러한 동적 페이지를 구현하기 위해서는 다음과 같이 JSP 태그를 사용해야 합니다.\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\tJSP 페이지에서는 자바를 사용하려면 특정 태그에 기술해야 합니다.\r\n");
      out.write("\t이러한 기능을 제공하는 JSP 스크립트 요소들은 서버가 인식하는 JSP 태그 중\r\n");
      out.write("\t스크립트릿(scriptlet), 선언문(delaration), 표현식(expression) 3가지가 있습니다.\r\n");
      out.write("\t<br>\r\n");
      out.write("\t[스크립트릿(scriptlet)]: 자바코드를 구현합니다.\r\n");
      out.write("\t<br>\r\n");
      out.write("\t");

		int su1 = 20;
		int su2 = 10;
		int sum = su1 + su2;
		out.println(su1 + " + " + su2 + "=" + sum);
	
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t[선언문(delaration)]: 변수 선언 및 메소드를 정의합니다.\r\n");
      out.write("\t<br>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t[표현식(expression)]: 문자열을 출력 합니다. ");
 out.println(7); 
      out.write("  \r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
