/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2021-01-26 14:52:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1605833312000L));
    _jspx_dependants.put("jar:file:/I:/project/OGU_GamePlatform/store/WebContent/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323225978000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head> \r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>지금 여기 오구! 로그인 페이지</title>\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\"\r\n");
      out.write("\thref=\"/store/image/icon/favicon.ico\" />\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".top {\r\n");
      out.write("\tmargin: 0px auto;\r\n");
      out.write("\theight: 54px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".top>p>img {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".center {\r\n");
      out.write("\tmargin: 0 auto; height : 400px;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("\theight: 400px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".falsebox {\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("\twidth: 396px;\r\n");
      out.write("\theight: 100px;\r\n");
      out.write("\tborder: 2px solid #eb3636;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".falsebox p {\r\n");
      out.write("\tfont-family background-color: red;\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\tmargin: 16px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#p1 b {\r\n");
      out.write("\tfont-fmaily: NanumBarunGothic;\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tcolor: #eb3636;\r\n");
      out.write("}\r\n");
      out.write("#p2{\r\n");
      out.write("\tcolor:#c2c2c2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".centerbox {\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tborder-radius: 8px;\r\n");
      out.write("\tbackground-color: #303030;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox1 {\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("\theight: 160px;\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tfont-family: Arial;\r\n");
      out.write("\tfont-weight: normal;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox1 input {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 32px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("\tbackground-color: #474747;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tcolor:#c2c2c2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox1 input:focus {\r\n");
      out.write("\tbackground-color: #9c9c9c;\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox2 {\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("\theight: 92px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox2>p {\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox2>p>input {\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("\theight: 34px;\r\n");
      out.write("\tbackground-color: #ffea00;\r\n");
      out.write("\tborder: 1px solid #a68200;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox3 {\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox3>p {\r\n");
      out.write("\tfont-family: arial;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: gray;\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".loginbox3>p>input {\r\n");
      out.write("\twidth: 340px;\r\n");
      out.write("\theight: 34px;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("\tcolor: gray;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tborder-radius: 3px;\r\n");
      out.write("\tbackground-color: #474747;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link {\r\n");
      out.write("\tcolor: gray;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:visited {\r\n");
      out.write("\tcolor: gray;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bottom>p {\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("\tcolor: gray;\r\n");
      out.write("\tfont-family: arial;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tletter-spacing: 1px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #1f1f1f;\">\r\n");
      out.write("\t<!-- 로그인 페이지로 넘어오기 전 페이지를 세션에 저장해서 ShoploginAction 에서 다시 호출 -->\r\n");
      out.write("\t");

		String url = request.getHeader("referer");
		session.setAttribute("previousPage", url);
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<form action=\"login.go\" method=\"post\">\r\n");
      out.write("\t\t<!-- <form action=\"/webapp/ControllerServlet?command=login\" method=\"post\"> -->\r\n");
      out.write("\t\t<div class=\"aligndiv\" style=\"padding: 30px; display:table; margin:0 auto;\">\r\n");
      out.write("\t\t\t<div class=\"top\">\r\n");
      out.write("\t\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t\t<img src=\"/store/image/icon/ogulogo.png\" onclick='location.href=\"ogu.go\"'\r\n");
      out.write("\t\t\t\t\t\tstyle=\"cursor: pointer;\" />\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<!-- 가입하고 왔다면 -->\r\n");
      out.write("\t\t\t");

				String welcome = (String) request.getParameter("welcome");
			
      out.write("\r\n");
      out.write("\t\t\t");

				if (welcome == null) {
			
      out.write("\r\n");
      out.write("\t\t\t");

				} else if(welcome.equals("new")) {
			
      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\talert('Welcome to Join Ogu!')\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t<!-- 로그인 체크 박스 -->\r\n");
      out.write("\t\t\t");

				String check = request.getParameter("check");
				//String check = (String)request.getAttribute("check");
				if (check == null) {
				} else if (check.equals("mailfalse")) {
			
      out.write("\r\n");
      out.write("\t\t\t<div class=\"falsebox\">\r\n");
      out.write("\t\t\t\t<p id=\"p1\">\r\n");
      out.write("\t\t\t\t\t<b>문제가 발생했어요!</b>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p id=\"p2\">해당하는 아이디를 찾을 수 없습니다.</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");

				} else if (check.equals("pwfalse")) {
			
      out.write("\r\n");
      out.write("\t\t\t<div class=\"falsebox\">\r\n");
      out.write("\t\t\t\t<p id=\"p1\">\r\n");
      out.write("\t\t\t\t\t<b>문제가 발생했어요!</b>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t<p id=\"p2\">비밀번호를 확인해 주세요.</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t<div class=\"centerbox\">\r\n");
      out.write("\t\t\t\t\t<table class=\"loginbox1\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"font-size: 26px; font-weight: bold; color: #c2c2c2;\">Sign-In</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" name=\"mail\" placeholder=\" Mail\" \r\n");
      out.write("\t\t\t\t\t\t\t\tonkeyup=\"this.value=this.value.replace(\t, '');\" maxlength=\"106\" style=\"text-transform: lowercase\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"pw\" placeholder=\" Password\" maxlength=\"30\"/></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<div class=\"loginbox2\">\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" name=\"submit\" value=\"로그인\" />\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"findUserPW.go\">▶비밀번호를 잊으셨어요?</a>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"loginbox3\">\r\n");
      out.write("\t\t\t\t\t\t<p align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<b>───── OGU 회원이 아니세요? ─────</b>\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" name=\"join\" value=\"OGU 계정 만들기\" onclick='location.href=\"userAdd.go\"' />\r\n");
      out.write("\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\t\t\t\t<p align=\"center\">ⓒ2020 OGU.com INC. or its affiliates.</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /auth/LoginPage.jsp(159,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.delAcct eq 'confirm'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<script type=\"text/javascript\">\r\n");
          out.write("\t\t\talert(\"탈퇴 되었습니다~ 다음에 또 봐요!\");\r\n");
          out.write("\t\t</script>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /auth/LoginPage.jsp(173,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.check eq 'verifyfalse'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<div class=\"falsebox\">\r\n");
          out.write("\t\t\t\t\t<p id=\"p1\">\r\n");
          out.write("\t\t\t\t\t\t<b>문제가 발생했어요!</b>\r\n");
          out.write("\t\t\t\t\t</p>\r\n");
          out.write("\t\t\t\t\t<p id=\"p2\">메일 인증이 완료되지 않았습니다!</p>\r\n");
          out.write("\t\t\t\t</div>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f2_reused = false;
    try {
      _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f2.setParent(null);
      // /auth/LoginPage.jsp(181,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.check eq 'logout'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
      if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<script type=\"text/javascript\">\r\n");
          out.write("\t\t\t\t\talert(\"로그아웃 되었습니다!\");\r\n");
          out.write("\t\t\t\t</script>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      _jspx_th_c_005fif_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f2_reused);
    }
    return false;
  }
}