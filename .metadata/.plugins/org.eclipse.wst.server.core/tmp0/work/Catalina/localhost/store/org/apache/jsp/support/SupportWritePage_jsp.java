/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-12-01 10:14:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.support;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SupportWritePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".indexcenterdiv {\r\n");
      out.write("\twidth: 80%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmin-height:780px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tpadding: 128px 0px;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("\tcolor:lightgray;\r\n");
      out.write("\tbox-sizing:border-box;\r\n");
      out.write("}\r\n");
      out.write(".settingcenterdiv{\r\n");
      out.write("\tpadding:0;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\tpadding:20px;\r\n");
      out.write("\tmargin-top:20px;\r\n");
      out.write("\tborder-radius:6px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\tborder:none;\r\n");
      out.write("\tbackground:#474747;\r\n");
      out.write("\tcolor:lightgray;\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write(".settinginput{\r\n");
      out.write("\tpadding-top:10px;\r\n");
      out.write("\twidth:70%;\r\n");
      out.write("\toutline:none;\r\n");
      out.write("}\r\n");
      out.write(".settingp{\r\n");
      out.write("\tmargin-top:10px;\r\n");
      out.write("}\r\n");
      out.write(".supportwritetable tr td{\r\n");
      out.write("\r\n");
      out.write("\tpadding-top:5px;\r\n");
      out.write("}\r\n");
      out.write(".supportwritetable tr td input,.supportwritetable tr td select{\r\n");
      out.write("\tpadding:3px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #1f1f1f;\">\r\n");
      out.write("\t<form action=\"addQna.go\" method=\"post\">\r\n");
      out.write("\t<div class=\"indexcenterdiv\">\r\n");
      out.write("\t\t<div class=\"center\" style=\"min-height:600px\">\r\n");
      out.write("\t\t\t<div class=\"centermiddle\" style=\"padding:20px; width:80%; height:100%; margin:0 auto;\">\r\n");
      out.write("\t\t\t\t<h1>문의 등록</h1>\r\n");
      out.write("\t\t\t\t<hr style=\"margin:10px auto;\">\r\n");
      out.write("\t\t\t\t<p>관리자가 직접 문의에 답을 드립니다.</p>\r\n");
      out.write("\t\t\t\t<table class=\"supportwritetable\" style=\"padding:10px; margin:0 auto; margin-top:20px; width:100%; height:100%;background-color: #474747; border-radius:6px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width:10%\">문의 종류</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"kind\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">문의 내용을 선택해주세요</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"게임환불\">게임 환불</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"계정관련\">계정 관련</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"버그\">버그</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>제목</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" style=\"width:100%;\" name=\"subject\" placeholder=\"제목을 작성해주세요\" required/></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>내용</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t<textarea rows=\"30\"style=\"width:100%; resize:none;\" name=\"content\" placeholder=\"이곳에 내용을 적어주세요!\" required></textarea>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" style=\"float:right; margin-top:20px; padding:5px 20px;\" value=\"제 출\"/>\r\n");
      out.write("\t\t\t\t<input type=\"button\" style=\"float:left; margin-top:20px; padding:5px 20px;\" value=\"취 소\" onclick=\"location.href='javascript: history.back()'\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
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