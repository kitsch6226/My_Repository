/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-12-04 04:45:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.community;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CommunityDiscussionWritePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tpadding: 128px 0px;\r\n");
      out.write("\tdisplay: table;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".settingcenterdiv {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tbackground: #474747;\r\n");
      out.write("\tcolor: lightgray;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".settinginput {\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\twidth: 70%;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".settingp {\r\n");
      out.write("\tmargin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction fileCheck(file1, file2) { // 사이즈체크\r\n");
      out.write("\t\tvar pathpoint1 = file1.value.lastIndexOf('.');\r\n");
      out.write("\t\tvar filepoint1 = file1.value.substring(pathpoint1 + 1, file1.length);\r\n");
      out.write("\t\tvar filetype1 = filepoint1.toLowerCase();\r\n");
      out.write("\r\n");
      out.write("\t\tvar pathpoint2 = file2.value.lastIndexOf('.');\r\n");
      out.write("\t\tvar filepoint2 = file2.value.substring(pathpoint2 + 1, file2.length);\r\n");
      out.write("\t\tvar filetype2 = filepoint2.toLowerCase();\r\n");
      out.write("\r\n");
      out.write("\t\tvar maxSize = 5 * 1024 * 1024 //5MB\r\n");
      out.write("\t\tvar fileSize1 = 0;\r\n");
      out.write("\t\tvar fileSize2 = 0;\r\n");
      out.write("\t\t// 브라우저 확인\r\n");
      out.write("\t\tvar browser = navigator.appName;\r\n");
      out.write("\t\t// 익스플로러일 경우\r\n");
      out.write("\t\tif (browser == \"Microsoft Internet Explorer\") {\r\n");
      out.write("\t\t\tvar oas = new ActiveXObject(\"Scripting.FileSystemObject\");\r\n");
      out.write("\t\t\tif (file1 != null) {\r\n");
      out.write("\t\t\t\tfileSize1 = oas.getFile(file1.value).size;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t// 익스플로러가 아닐경우\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\tvar kind = document.getElementById(\"discussionwritekind\");\r\n");
      out.write("\t\t\tvar subject = document.getElementById(\"discussionwritesubject\");\r\n");
      out.write("\t\t\tvar content = document.getElementById(\"discussionwritecontent\");\r\n");
      out.write("\t\t\tif (kind.value == null || kind.value == '') {\r\n");
      out.write("\t\t\t\talert(\"게임 종류를 선택해 주세요!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else if (subject.value == null || subject.value == ''\r\n");
      out.write("\t\t\t\t\t|| content.value == null || content.value == '') {\r\n");
      out.write("\t\t\t\talert(\"제목, 내용을 모두 채워주세요!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else if (subject.value.length > 50 || content.value.length > 900) {\r\n");
      out.write("\t\t\t\talert(\"제목은 50자 내용은 900자 까지입니다!\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (file1.value != '') {\r\n");
      out.write("\t\t\t\t\tfileSize1 = file1.files[0].size;\r\n");
      out.write("\t\t\t\t\tif (filetype1 == 'jpg' || filetype1 == 'gif' || filetype1 == 'png'\r\n");
      out.write("\t\t\t\t\t\t|| filetype1 == 'jpeg' || filetype1 == 'bmp') {\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\talert(\"이미지 파일만 첨부 가능합니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif (fileSize1 > maxSize) {\r\n");
      out.write("\t\t\t\t\t\talert(\"첨부파일 사이즈는 5MB 이내로 등록 가능합니다.\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tif (file1.value.length > 150) {\r\n");
      out.write("\t\t\t\t\t\talert(\"파일 이름이 너무 길어요... 각각 최대 150자!\");\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (file2.value != '') {\r\n");
      out.write("\t\t\t\tfileSize2 = file2.files[0].size;\r\n");
      out.write("\t\t\t\tif (filetype1 == 'jpg' || filetype2 == 'gif' || filetype2 == 'png'\r\n");
      out.write("\t\t\t\t\t|| filetype2 == 'jpeg' || filetype2 == 'bmp') {\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"이미지 파일만 첨부 가능합니다.\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (fileSize2 > maxSize) {\r\n");
      out.write("\t\t\t\t\talert(\"첨부파일 사이즈는 5MB 이내로 등록 가능합니다.\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (file2.value.length > 150) {\r\n");
      out.write("\t\t\t\t\talert(\"파일 이름이 너무 길어요... 각각 최대 150자!\");\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.discussionWriteForm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form action=\"addDiscussion.go\" method=\"post\" name=\"discussionWriteForm\"\r\n");
      out.write("\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<div class=\"center\" style=\"min-height: 600px\">\r\n");
      out.write("\t\t\t<div class=\"centermiddle\"\r\n");
      out.write("\t\t\t\tstyle=\"padding: 20px; width: 80%; height: 100%; margin: 0 auto;\">\r\n");
      out.write("\t\t\t\t<h1>의견 등록</h1>\r\n");
      out.write("\t\t\t\t<hr style=\"margin: 10px auto;\">\r\n");
      out.write("\t\t\t\t<p>타인을 향한 비방과 욕설등은 제제를 받을 수 있습니다.</p>\r\n");
      out.write("\t\t\t\t<table\r\n");
      out.write("\t\t\t\t\tstyle=\"padding: 10px; margin: 0 auto; margin-top: 20px; width: 100%; height: 100%; background-color: #474747; border-radius: 6px;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 2%;\">게임 종류</td>\r\n");
      out.write("\t\t\t\t\t\t<td><select id=\"discussionwritekind\" name=\"kind\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"\">게임을 선택해 주세요.</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"사이버펑크 2077\">사이버펑크 2077</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"카르토\">카르토</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"풋볼매니저 2021\">풋볼매니저 2021</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"히트맨\">히트맨3</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"할로우나이트\">할로우나이트</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"기타\">기타</option>\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 10%; padding-top: 10px;\">제목</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" style=\"width: 100%;\" name=\"subject\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"discussionwritesubject\" placeholder=\"제목을 작성해주세요\" required /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"width: 10%; padding-top: 10px;\">이미지</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"file\" name=\"discussionImage1\" maxlength=\"30\"\r\n");
      out.write("\t\t\t\t\t\t\taccept=\".gif, .jpg, .png\" /></td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"file\" name=\"discussionImage2\" maxlength=\"30\"\r\n");
      out.write("\t\t\t\t\t\t\taccept=\".gif, .jpg, .png\" /></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td style=\"padding-top: 10px;\">내용</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"100%\" style=\"padding-top: 10px;\"><textarea\r\n");
      out.write("\t\t\t\t\t\t\t\trows=\"30\" style=\"width: 100%; resize: none;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"discussionwritecontent\" name=\"content\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"이곳에 내용을 적어주세요!\" required></textarea></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<input type=\"button\"\r\n");
      out.write("\t\t\t\t\tstyle=\"float: right; margin-top: 20px; padding: 5px 20px;\"\r\n");
      out.write("\t\t\t\t\tvalue=\"제 출\"\r\n");
      out.write("\t\t\t\t\tonclick=\"fileCheck(this.form.discussionImage1,this.form.discussionImage2)\" />\r\n");
      out.write("\t\t\t\t<input type=\"button\"\r\n");
      out.write("\t\t\t\t\tstyle=\"float: left; margin-top: 20px; padding: 5px 20px;\"\r\n");
      out.write("\t\t\t\t\tvalue=\"목 록\" onclick=\"location.href='javascript: history.back()'\" />\r\n");
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
}