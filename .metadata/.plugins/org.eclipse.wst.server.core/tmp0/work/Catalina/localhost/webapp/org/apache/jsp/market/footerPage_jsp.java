/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-11-18 01:48:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.market;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

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
      out.write("<style type=\"text/css\">\r\n");
      out.write(".footer{\r\n");
      out.write("margin-top: 100px;\r\n");
      out.write("min-width: 800px;\r\n");
      out.write("width: 100%;\r\n");
      out.write("background-color:#ffea00;\r\n");
      out.write("text-align: center;\r\n");
      out.write("font-family: NanumBarunGothic;\r\n");
      out.write("font-size: 14px;\r\n");
      out.write("letter-spacing:1px;\r\n");
      out.write("color: gray;\r\n");
      out.write("}\r\n");
      out.write(".div1{\r\n");
      out.write("margin:0 auto;\r\n");
      out.write("padding-top:10px;\r\n");
      out.write("}\r\n");
      out.write(".div2{\r\n");
      out.write("margin:0 auto;\r\n");
      out.write("padding-bottom:30px\r\n");
      out.write("}\r\n");
      out.write(".div1>ul{\r\n");
      out.write("margin:20px auto;\r\n");
      out.write("list-style:none;\r\n");
      out.write("}\r\n");
      out.write(".div1>ul>li{\r\n");
      out.write("padding: 0px 30px;\r\n");
      out.write("border-right: 2px solid gray;\r\n");
      out.write("display:inline;\r\n");
      out.write("}\r\n");
      out.write(".div2 a:visited, .div1 li a:visited{\r\n");
      out.write("color:#363636;\r\n");
      out.write("text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".div2 a:link, .div1 li a:link{\r\n");
      out.write("color:#363636;\r\n");
      out.write("text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write(".div2 a:hover, .div1 li a:hover{\r\n");
      out.write("color:#8A5100;\r\n");
      out.write("text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write(".bottomp{\r\n");
      out.write("padding:10px;\r\n");
      out.write("}\r\n");
      out.write("#backtotop{\r\n");
      out.write("width:100%;\r\n");
      out.write("height:40px;\r\n");
      out.write("border: 0 solid darkgray;\r\n");
      out.write("background-color: #f5b942;\r\n");
      out.write("}\r\n");
      out.write("#backtotop:hover{\r\n");
      out.write("background-color: #e0a124;\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write("#backtotop:focus{\r\n");
      out.write("outline:none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t<div>\t\r\n");
      out.write("\t<button id='backtotop' onclick=\"window.scrollTo(0,0);\">위로 돌아가기</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"div1\">\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t<li><a href=\"#\">냠냠 이용약관</a></li>\r\n");
      out.write("\t\t<li><a href=\"#\"><b>개인정보 처리 방침</b></a></li>\r\n");
      out.write("\t\t<li><a href=\"#\">법적 고지 및 주의사항</a></li>\r\n");
      out.write("\t\t<li style=\"border-right:0px;\"><a href=\"#\">입점 안내</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"div2\">\r\n");
      out.write("\t\t<p class=\"bottomp\">사업자등록번호 : 110-6226-7839 통신판매업신고번호 : 제2020-서울상봉-001호 대표 : 김성현 <a href=\"#\">사업자등록정보확인</a><br/></p>\r\n");
      out.write("\t\t<p class=\"bottomp\">주소 : 서울시 중랑구 상봉동 냠냠컴퍼니 13123 대표전화 : 1588-6226  <a href=\"#\"><b>1:1문의 바로가기</b></a> 호스팅 서비스 제공 : NyamNyam Business Platform</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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