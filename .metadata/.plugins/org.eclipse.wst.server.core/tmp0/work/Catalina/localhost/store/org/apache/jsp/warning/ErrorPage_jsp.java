/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-11-25 01:50:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.warning;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ErrorPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>지금 여기 오구! 게임 플랫폼</title>\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\"\r\n");
      out.write("\thref=\"/store/image/icon/favicon.ico\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("*{\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\tmargin:0;\r\n");
      out.write("}\r\n");
      out.write(".censoredh1{\r\n");
      out.write("\tfont-size:3em;\r\n");
      out.write("\tmargin-bottom:20px;\r\n");
      out.write("\tcolor:#f2f2f2;\r\n");
      out.write("\tfont-family:nanumsquareround, arial;\r\n");
      out.write("}\r\n");
      out.write(".censoreda:visited{\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("}\r\n");
      out.write(".censoreda:link{\r\n");
      out.write("\tcolor:gray;\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("}\r\n");
      out.write(".censoreda:hover{\r\n");
      out.write("\tcolor:#c2c2c2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".rightbtn{\r\n");
      out.write("\tborder-radius:6px;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("\toutline:none;\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("\tbackground-color:darkgray;\r\n");
      out.write("\ttransition:0.2s;\r\n");
      out.write("}\r\n");
      out.write(".rightbtn:hover{\r\n");
      out.write("\tbackground-color:#ffea00;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #1f1f1f;\">\r\n");
      out.write("\t<div style=\"width:70%; margin:0 auto; position:absolute; left:15%; top:30%;\">\r\n");
      out.write("\t\t<h1 class=\"censoredh1\"align=\"center\" style=\"line-height:1.5em;\">\r\n");
      out.write("\t\t\t궁금한게 많은 당신!<br>404에러를 만났군요?\r\n");
      out.write("\t\t</h1>\r\n");
      out.write("\t\t<p align=\"center\" style=\"padding:20px;\">\r\n");
      out.write("\t\t\t<a class=\"censoreda\" href=\"javascript:history.back()\" style=\"font-family:nanumsquareround, arial\">돌아가기</a>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t</div>\r\n");
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