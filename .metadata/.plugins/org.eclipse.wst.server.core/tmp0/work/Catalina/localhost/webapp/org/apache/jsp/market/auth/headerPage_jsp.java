/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2020-11-20 14:36:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.market.auth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.Member;

public final class headerPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1528341444000L));
    _jspx_dependants.put("jar:file:/I:/work2/webapp/WebContent/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323225978000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("dto.Member");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

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
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction logoutt(){\r\n");
      out.write("\t\talert('정상적으로 로그아웃 되었습니다!');\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("*{\r\n");
      out.write("margin:0;\r\n");
      out.write("padding: 0;\r\n");
      out.write("}\r\n");
      out.write(".header {\r\n");
      out.write("\tmin-width: 800px;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tbackground-color: #ffea00;\r\n");
      out.write("\tborder:1px solid #bfb6a4;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header>div {\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header>div>img {\r\n");
      out.write("\tmargin: 12px 20px;\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropbtn {\r\n");
      out.write("\twidth: 60px;\r\n");
      out.write("\theight: 102%;\r\n");
      out.write("}\r\n");
      out.write(".dropdown-content {\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tbackground-color: black;\r\n");
      out.write("\tmin-width: 240px;\r\n");
      out.write("\tbox-shadow: 0px 16px 16px 0px rgba(0, 0, 0, 0.3);\r\n");
      out.write("\tleft:-1170px;\r\n");
      out.write("\topacity:0.0;\r\n");
      out.write("\ttransition: opacity 0.1s;\r\n");
      out.write("\ttransition-timing-function:ease-in-out;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-content2, .dropdown-content2end {\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("\tfont-family: inherit;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown-content2 {\r\n");
      out.write("\tborder-right: 2px solid gray;\r\n");
      out.write("}\r\n");
      out.write(".dropbtn:hover{\r\n");
      out.write("\tbackground-color:#ababab;\r\n");
      out.write("\tborder:1px solid gray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".dropdown:hover .dropdown-content {\r\n");
      out.write("\tleft:0px;\r\n");
      out.write("\topacity: 0.9;\r\n");
      out.write("}\r\n");
      out.write(".content{\r\n");
      out.write("\tcursor:pointer;\r\n");
      out.write("\t\tcolor: #737373;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content:visited {\r\n");
      out.write("\tcolor: #737373;\r\n");
      out.write("\ttext-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".content:hover{\r\n");
      out.write("\ttext-decoration:underline;\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write(".content {\r\n");
      out.write("\tpadding: 10px 20px;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("}\r\n");
      out.write(".searchdiv {\r\n");
      out.write("\twidth: 30%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#search {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tmargin: 10px auto;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 38px;\r\n");
      out.write("\tborder: 1px solid gray;\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#searchbtn {\r\n");
      out.write("\tborder-radius: 6px;\r\n");
      out.write("\tborder: 1px solid gray;\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("\twidth: 40px;\r\n");
      out.write("\theight: 40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* 우측 */\r\n");
      out.write("#profile {\r\n");
      out.write("\tmargin-right: 10px;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#profileButton {\r\n");
      out.write("\tmargin-top: 8px;\r\n");
      out.write("\tbackground-color: #ffea00;\r\n");
      out.write("\tborder: 1px #ffea00;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".header .userstatus {\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tmargin-right: 10px;\t\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".statusbtn {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("\theight: 60px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tbackground: 0;\r\n");
      out.write("\tfont-family: NanumBarunGothic;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/*계정 드롭다운 메뉴 창 설정 */\r\n");
      out.write(".statusbtn{\r\n");
      out.write("\tmin-width:200px;\r\n");
      out.write("}\r\n");
      out.write(".statusbtn, .accountdiv{\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write(".accountdiv {\r\n");
      out.write("\tposition:absolute;\r\n");
      out.write("\tmin-width:200px;\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tdisplay:none;\r\n");
      out.write("\tborder-radius:6px;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tbox-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.2);\r\n");
      out.write("\ttop:60px;\r\n");
      out.write("}\r\n");
      out.write(".accountdiv ul li{\r\n");
      out.write("align:\"center\";\r\n");
      out.write("padding: 14px 64px;\r\n");
      out.write("list-style:none;\r\n");
      out.write("cursor:pointer;\r\n");
      out.write("}\r\n");
      out.write(".accountdiv ul li a{\r\n");
      out.write("\ttext-decoration:none;\r\n");
      out.write("\tcolor: #3d3d3d\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".userstatus:hover .accountdiv {\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write(".userstatus:hover{\r\n");
      out.write("\tbackground-color: #ffba0a;\r\n");
      out.write("}\r\n");
      out.write(".accountdiv ul li:hover{\r\n");
      out.write("\tbackground-color:#e3e1e1\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t<button class=\"dropbtn\">\r\n");
      out.write("\t\t\t\t<img src=\"/webapp/market/img/menu.png\" style=\"height: 48px;\" />\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<div class=\"dropdown-content\">\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-content2\">\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='http://www.naver.com'\"><b>Game Title: 게임 타이틀</b></li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='http://www.naver.com'\">PS5: 플레이스테이션5</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">PS4: 플레이스테이션4</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX:one 엑스박스 원</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX: 360 엑스박스 360</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX: 720 엑스박스 720</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-content2\">\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\"><b>Game Console: 게임 콘솔</b></li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">PS5: 플레이스테이션5</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">PS4: 플레이스테이션4</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX:one 엑스박스 원</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX: 360 엑스박스 360</li>\r\n");
      out.write("\t\t\t\t\t<li class='content' onclick=\"location.href='#'\">XBOX: 720 엑스박스 720</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-content2\">\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=0'\"><b>Racing Gear: 레이싱 기어</b></li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=0'\">레이싱 기기:전문가용</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=0'\">레이싱 기기:입문가용</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=1'\">Fanatec:파나텍</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=2'\">TrustMaster:트러스트 마스터</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/market/listProduct.do?kind=3'\">Logitec:로지텍</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-content2\">\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='#'\"><b>Flight Gear: 비행 기어</b></li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='#'\">비행게임 기기:추천</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='#'\">TrustMaster:트러스트 마스터</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='#'\">Logitec:로지텍</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='#'\">Flashfire:플래쉬 파이어</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<ul class=\"dropdown-content2end\">\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\"><b>Game News: 최신 소식</b></li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\">PS5: 플레이스테이션5</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\">PS4: 플레이스테이션4</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\">XBOX: one 엑스박스 원</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\">XBOX: 360 엑스박스 360</li>\r\n");
      out.write("\t\t\t\t\t<li class='content'onclick=\"location.href='/webapp/ShopController?command=category&kind=board'\">XBOX: 720 엑스박스 720</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img src=\"/webapp/market/img/nyamlogo.png\" onclick=\"location.href='/webapp/ShopController?command=category'\" style=\"cursor:pointer\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"searchdiv\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"search\" placeholder=\" 상품명을 검색하세요.\" onclick=\"\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<button id=\"searchbtn\">\r\n");
      out.write("\t\t\t\t<img src=\"/webapp/market/img/search.png\" style=\"height:34px;\" />\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"profile\">\r\n");
      out.write("\t\t\t<button id=\"profileButton\">\r\n");
      out.write("\t\t\t\t<img src=\"/webapp/market/img/profileB.png\" />\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"userstatus\">\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class='accountdiv'>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li onclick=\"location.href='/webapp/ShopController?command=order_list_menu'\">주문내역</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li onclick=\"location.href='/webapp/ShopController?command=cart_list'\">장바구니</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li onclick=\"location.href='/webapp/market/listQna.do'\">Q&A</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>계정설정</li>\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_c_005fchoose_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f0_reused = false;
    try {
      _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f0.setParent(null);
      int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
      if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      _jspx_th_c_005fchoose_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f0_reused = false;
    try {
      _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      // /market/auth/headerPage.jsp(256,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.name != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
      if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t<button class=\"statusbtn\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("님 로그인 중입니다.</button>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      _jspx_th_c_005fwhen_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    boolean _jspx_th_c_005fotherwise_005f0_reused = false;
    try {
      _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
      int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
      if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t\t<button class=\"statusbtn\" onclick=\"location.href='/webapp/ShopController?command=login'\">어서오세요! 로그인 하기 ▾</button>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      _jspx_th_c_005fotherwise_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fotherwise_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fotherwise_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fchoose_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f1 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    boolean _jspx_th_c_005fchoose_005f1_reused = false;
    try {
      _jspx_th_c_005fchoose_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fchoose_005f1.setParent(null);
      int _jspx_eval_c_005fchoose_005f1 = _jspx_th_c_005fchoose_005f1.doStartTag();
      if (_jspx_eval_c_005fchoose_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\t\t\t\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          if (_jspx_meth_c_005fwhen_005f2(_jspx_th_c_005fchoose_005f1, _jspx_page_context))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fchoose_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fchoose_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f1);
      _jspx_th_c_005fchoose_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fchoose_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fchoose_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f1_reused = false;
    try {
      _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
      // /market/auth/headerPage.jsp(272,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.name != null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
      if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<li onclick=\"location.href='/webapp/market/logout.do'\"><a onclick='logoutt()'>로그아웃</a></li>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
      _jspx_th_c_005fwhen_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f1, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    boolean _jspx_th_c_005fwhen_005f2_reused = false;
    try {
      _jspx_th_c_005fwhen_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005fwhen_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f1);
      // /market/auth/headerPage.jsp(276,6) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fwhen_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberInfo.name == null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fwhen_005f2 = _jspx_th_c_005fwhen_005f2.doStartTag();
      if (_jspx_eval_c_005fwhen_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<li onclick=\"location.href='/webapp/market/login.do'\">로그인</li>\r\n");
          out.write("\t\t\t\t\t\t\t");
          out.write("\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fwhen_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fwhen_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f2);
      _jspx_th_c_005fwhen_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fwhen_005f2, _jsp_getInstanceManager(), _jspx_th_c_005fwhen_005f2_reused);
    }
    return false;
  }
}
