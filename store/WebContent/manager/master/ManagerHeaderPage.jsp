<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="dto.Member"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutt() {
		alert('정상적으로 로그아웃 되었습니다!');
	};
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.header {
	position:fixed;
	width:100%;
	min-width: 800px;
	height: 60px;
	background-color: #f2f2f2;
	border-bottom: 1px solid #1f1f1f;
}

.header>div {
	height: 100%;
	margin: 0 auto;
	float: left;
}

.header>div>img {
	margin: 12px 20px;
	display: inline;
	height: 40px;
}

.menudiv {
	height: 100%;
}

.menudiv button {
	font-size: 1em;
	margin: 0;
	padding: 0 30px;
	height: 100%;
	outline: none;
	color: #1f1f1f;
	cursor: pointer;
	border: transparent;
	background-color: transparent;
	box-sizing: border-box;
	display: block;
	float: left;
	border-bottom: 0px solid #1f1f1f;
	transition: 0.2s;
}

.menudiv button p {
	position: sticky;
}

.menudiv button:hover {
	border-bottom: 5px solid #1f1f1f;
	color: black;
}
/* 우측 */
#profile {
	padding: 0 20px;
	height: 60px;
	float: right;
}

#profileButton {
	margin-top: 18px;
	background-color: transparent;
	border: 1px #ffea00;
}

.header .userstatus, .header .langdiv {
	height: 60px;
	margin-right: 10px;
	float: right;
}

/*계정 드롭다운 메뉴 창 설정 */
.statusbtn {
	float: right;
	height: 60px;
	border: none;
	background: 0;
	font-family: NanumBarunGothic;
	font-size: 16px;
	cursor: pointer;
	min-width: 200px;
	color: #1f1f1f;
	display: block;
}
.userstatus:hover {
	background-color: #474747;
}
.userstatus:hover .statusbtn{
	color: #f2f2f2;
}
.accountdiv ul li:hover {
	color: white;
}

.userstatus:hover .accountdiv {
	display: block;
}

/*언어 설정 드롭다운  */
.langdiv, .languagebtn {
	display: block;
}

.languagediv {
	position: absolute;
	min-width: 130px;
	float: right;
	display: none;
	border-radius: 6px;
	background-color: #f2f2f2;
	box-shadow: 0px 2px 4px 0px rgba(0, 0, 0, 0.5);
	top: 58px;
	overflow:hidden;
}

.languagebtn {
	height: 100%;
	padding: 0 20px;
	color: #1f1f1f;
	background-color: transparent;
	border: transparent;
	outline: none;
	font-size: 1em;
	cursor: pointer;
}
/*공통 */
.accountdiv ul li, .languagediv ul li {
	text-align: center;
	margin: 0 auto;
	padding: 14px 30px;
	list-style: none;
	cursor: pointer;
	color: #1f1f1f;
}

.accountdiv ul li a, .languagediv ul li a {
	text-decoration: none;
	color: #3d3d3d;
}

.langdiv:hover .languagediv {
	display: block;
}

.langdiv ul li:hover {
	color: white;
	background: #474747;
}

</style>
</head>
<body>
	<div style="width:100%; position:fixed; display:table;z-index:9999">
		<div class="header">
			<div>
				<img src="/store/image/icon/ogulogo_inversion.png"
					onclick="location.href='managerGame.go'"
					style="cursor: pointer" />
			</div>
			<div class="menudiv">
				<button type="button" onclick="location.href='managerGame.go'">
					<p>게임</p>
				</button>
				<button type="button" onclick="location.href='user.go'">
					<p>멤버</p>
				</button>
				<button type="button" onclick="location.href='qna.go'">
					<p>QnA</p>
				</button>
			</div>
			<div class="userstatus">
				<%-- el과 jstl의 사용으로 주석처리! 따로 값을 받아올 필요가 없다! 
				<%!HttpSession session;%>
				<%
				session = request.getSession();
				Member member = (Member) session.getAttribute("member");
													
					if (member != null) {%> --%>
				<c:choose>
					<c:when test="${managerInfo.name != null}">
						<button class="statusbtn" onclick="location.href='logout.go'">${managerInfo.name} 매니저님 로그인 중입니다.</button>
					</c:when>
					<c:otherwise>
						<%-- <%} else { %> --%>
						<button class="statusbtn"
							onclick="location.href='login.go'">어서오세요!
							로그인 하기 </button>
					</c:otherwise>
					<%-- <%} %> --%>
				</c:choose>
			</div>
			<div id="profile">
				<button id="profileButton">
					<img src="/store/image/icon/status_inversion.png" style="width: 1.5em" />
				</button>
			</div>
<!-- 			<div class="langdiv">
				<button class="languagebtn">
					<p>Language ▾</p>
				</button>
				<div class="languagediv">
					<ul>
						<li
							onclick="location.href='/webapp/ShopController?command=order_list_menu'">ENGLISH</li>
						<li
							onclick="location.href='/webapp/ShopController?command=cart_list'">한국어</li>
					</ul>
				</div>
			</div> -->
		</div>
	</div>
</body>
</html>