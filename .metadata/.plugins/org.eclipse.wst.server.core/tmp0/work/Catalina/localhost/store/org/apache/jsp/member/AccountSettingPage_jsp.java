/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-12-06 12:51:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AccountSettingPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/I:/work2/store/WebContent/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323225978000L));
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1605833312000L));
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
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tpadding: 128px 0px;\r\n");
      out.write("\tdisplay: table;\r\n");
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
      out.write("\tmargin-top:10px;\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\twidth:70%;\r\n");
      out.write("\toutline:none;\r\n");
      out.write("}\r\n");
      out.write(".settingp{\r\n");
      out.write("\tmargin-top:20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction fileCheck(file1){  \t  // 사이즈체크\r\n");
      out.write("\t\tvar pathpoint1 = file1.value.lastIndexOf('.');\r\n");
      out.write("\t\tvar filepoint1 = file1.value.substring(pathpoint1+1,file1.length);\r\n");
      out.write("\t\tvar filetype1=filepoint1.toLowerCase();\r\n");
      out.write("\t\r\n");
      out.write("\t    var maxSize  = 5 * 1024 * 1024    //5MB\r\n");
      out.write("\t    var fileSize1 = 0;\r\n");
      out.write("\t    var fileSize2 = 0;\r\n");
      out.write("\t// 브라우저 확인\r\n");
      out.write("\tvar browser=navigator.appName;\r\n");
      out.write("\t// 익스플로러일 경우\r\n");
      out.write("\tif (browser==\"Microsoft Internet Explorer\")\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tvar oas = new ActiveXObject(\"Scripting.FileSystemObject\");\r\n");
      out.write("\t\tif(file1!=null){\r\n");
      out.write("\t\tfileSize1 = oas.getFile( file1.value ).size;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t// 익스플로러가 아닐경우\r\n");
      out.write("\telse\r\n");
      out.write("\t{\t\r\n");
      out.write("\t\tif(file1.value!=''){\r\n");
      out.write("\t\t\tfileSize1 = file1.files[0].size;\r\n");
      out.write("\t\t\tif(filetype1=='jpg'||filetype1=='gif'||filetype1=='png'||filetype1=='jpeg'||filetype1=='bmp')\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\talert(\"이미지 파일만 첨부 가능합니다.\");\r\n");
      out.write("\t\t        return;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t    if(fileSize1 > maxSize)\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t        alert(\"첨부파일 사이즈는 5MB 이내로 등록 가능합니다.\");\r\n");
      out.write("\t\t        return;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    if(file1.value.length>50){\r\n");
      out.write("\t\t    \talert(\"파일 이름이 너무 길어요... 경로 포함 최대 50자!\");\r\n");
      out.write("\t\t    \treturn;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tvar accountInput1 = document.getElementById(\"accountName\");\r\n");
      out.write("\tvar accountInput2 = document.getElementById(\"accountpw\");\r\n");
      out.write("\tif(accountInput1.value==''||accountInput1.value==null){\r\n");
      out.write("\t\talert(\"이름을 입력해 주세요!\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(accountInput2.value==''||accountInput2.value==null){\r\n");
      out.write("\t\talert(\"비밀번호를 입력해 주세요!\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\tif(chk(/(?=^\\S{8,30}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$/,accountInput2)){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"비밀번호 양식을 지켜주세요!\\n영문 대소,특수문자 포함 최소 8자 최대 30자 공백없음\");\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction chk(re, e){\r\n");
      out.write("\t\tif(re.test(e.value)){\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("    document.accountSettingForm.submit();\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction deleteAccount(){\r\n");
      out.write("\t\tif(confirm(\"탈퇴하면 현재 라이브러리에 있는 게임이 사라지고\\n다시 이용할 수 없게 됩니다.\\n그래도 탈퇴 하시겠어요?\")){\r\n");
      out.write("\t\t\t document.accountSettingForm.encoding=\"application/x-www-form-urlencoded\";\r\n");
      out.write("\t\t\t document.accountSettingForm.action=\"accountDelete.go\";\r\n");
      out.write("\t\t\t document.accountSettingForm.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body style=\"background-color: #1f1f1f;\">\r\n");
      out.write("\t<form name=\"accountSettingForm\" action=\"accountSetting.go\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t<div class=\"indexcenterdiv\">\r\n");
      out.write("\t\t\t<h1 style=\"color:lightgray;\">계정 설정</h1>\r\n");
      out.write("\t\t\t<div class=\"settingcenterdiv\">\r\n");
      out.write("\t\t\t\t<p>프로필 이미지</p>\r\n");
      out.write("\t\t\t\t<div style=\"width:100%; display:table;\">\r\n");
      out.write("\t\t\t\t\t<div style=\"width:10%; float:left\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"originalimage\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"overflow:hidden; margin-top:20px; max-height:150px;border-radius:6px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<img src=\"/store/image/profile/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.image}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" style=\"width:100%;\" ondragstart=\"return false;\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"image\" accept=\".jpg,.png\" style=\"float:left; margin-left:40px; margin-top:145px;\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<p class=\"settingp\">프로필 이름</p>\r\n");
      out.write("\t\t\t\t\t<input class=\"settinginput\" name=\"name\" id=\"accountName\"type=\"text\" pattern=\"[가-힣a-zA-Z]{2,10}\"\r\n");
      out.write("\t\t\t\t\tmaxlength=\"10\" title=\"영문/한글 10자 이내\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"프로필 이름\" required/>\r\n");
      out.write("\t\t\t\t\t<p class=\"settingp\">비밀번호</p>\r\n");
      out.write("\t\t\t\t\t<input class=\"settinginput\" name=\"pw\" id=\"accountpw\" type=\"password\" placeholder=\"변경할 비밀번호 혹은 현재 비밀번호\"\r\n");
      out.write("\t\t\t\t\tpattern=\"(?=^\\S{8,30}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"\r\n");
      out.write("\t\t\t\t\ttitle=\"영문 대소,특수문자 포함 최소 8자 최대 30자 공백없음\" maxlength=\"30\" required/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"button\" style=\"margin-top:30px; padding:10px 20px;\" onclick=\"fileCheck(this.form.image)\">수정하기</button>\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
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
      // /member/AccountSettingPage.jsp(123,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.check eq 'ok'}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t<script>\r\n");
          out.write("\t\t\t\talert('정보 변경이 완료 되었습니다!')\r\n");
          out.write("\t\t\t</script>\r\n");
          out.write("\t\t");
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
      // /member/AccountSettingPage.jsp(152,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo!=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<button type=\"button\" style=\"margin-top:30px;float:right; padding:10px 20px;background:transparent;border:1px solid #1c1c1c; outline:none; color:#7c7c7c\" onclick=\"deleteAccount()\">탈퇴하기</button>\r\n");
          out.write("\t\t\t\t");
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
}
