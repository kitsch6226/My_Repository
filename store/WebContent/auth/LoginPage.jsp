<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>지금 여기 오구! 로그인 페이지</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/store/image/icon/favicon.ico" />
<script type="text/javascript">
	
</script>
<style>
* {
	margin: 0;
	padding: 0;
}

.top {
	margin: 0px auto;
	height: 54px;
}

.top>p>img {
	display: block;
	height: 40px;
}

.center {
	margin: 0 auto; height : 400px;
	display: table;
	height: 400px;
}

.falsebox {
	margin: 10px auto;
	width: 396px;
	height: 100px;
	border: 2px solid #eb3636;
	border-radius: 6px;
}

.falsebox p {
	font-family background-color: red;
	width: 70%;
	margin: 16px auto;
}

#p1 b {
	font-fmaily: NanumBarunGothic;
	font-size: 20px;
	color: #eb3636;
}
#p2{
	color:#c2c2c2;
}

.centerbox {
	width: 400px;
	height: 100%;
	margin: 0 auto;
	border-radius: 8px;
	background-color: #303030;
	display: table;
}

.loginbox1 {
	width: 340px;
	height: 160px;
	margin: 20px auto;
	font-size: 16px;
	font-family: Arial;
	font-weight: normal;
}

.loginbox1 input {
	width: 100%;
	height: 32px;
	border: none;
	border-radius: 3px;
	background-color: #474747;
	outline: none;
	color:#c2c2c2;
}

.loginbox1 input:focus {
	background-color: #9c9c9c;
	color:black;
}

.loginbox2 {
	margin: 0 auto;
	width: 340px;
	height: 92px;
}

.loginbox2>p {
	font-size: 14px;
	margin: 20px auto;
}

.loginbox2>p>input {
	width: 340px;
	height: 34px;
	background-color: #ffea00;
	border: 1px solid #a68200;
	border-radius: 3px;
}

.loginbox3 {
	margin: 20px auto;
	width: 340px;
}

.loginbox3>p {
	font-family: arial;
	font-size: 14px;
	color: gray;
	margin: 10px auto;
}

.loginbox3>p>input {
	width: 340px;
	height: 34px;
	outline: none;
	color: gray;
	border: none;
	border-radius: 3px;
	background-color: #474747;
	cursor: pointer;
}

a:link {
	color: gray;
	text-decoration: none;
}

a:visited {
	color: gray;
	text-decoration: none;
}

.bottom>p {
	padding: 20px;
	color: gray;
	font-family: arial;
	font-size: 14px;
	letter-spacing: 1px;
}
</style>
</head>
<body style="background-color: #1f1f1f;">
	<!-- 로그인 페이지로 넘어오기 전 페이지를 세션에 저장해서 ShoploginAction 에서 다시 호출 -->
	<%
		String url = request.getHeader("referer");
		session.setAttribute("previousPage", url);
	%>
	<c:if test="${param.delAcct eq 'confirm'}">
		<script type="text/javascript">
			alert("탈퇴 되었습니다~ 다음에 또 봐요!");
		</script>
	</c:if>
	<form action="login.go" method="post">
		<!-- <form action="/webapp/ControllerServlet?command=login" method="post"> -->
		<div class="aligndiv" style="padding: 30px; display:table; margin:0 auto;">
			<div class="top">
				<p align="center">
					<img src="/store/image/icon/ogulogo.png" onclick='location.href="ogu.go"'
						style="cursor: pointer;" />
				</p>
			</div>
			<c:if test="${param.check eq 'verifyfalse'}">
				<div class="falsebox">
					<p id="p1">
						<b>문제가 발생했어요!</b>
					</p>
					<p id="p2">메일 인증이 완료되지 않았습니다!</p>
				</div>
			</c:if>
			<c:if test="${param.check eq 'logout'}">
				<script type="text/javascript">
					alert("로그아웃 되었습니다!");
				</script>
			</c:if>
			<!-- 가입하고 왔다면 -->
			<%
				String welcome = (String) request.getParameter("welcome");
			%>
			<%
				if (welcome == null) {
			%>
			<%
				} else if(welcome.equals("new")) {
			%>
			<script>
				alert('Welcome to Join Ogu!')
			</script>
			<%
				}
			%>
			<!-- 로그인 체크 박스 -->
			<%
				String check = request.getParameter("check");
				//String check = (String)request.getAttribute("check");
				if (check == null) {
				} else if (check.equals("mailfalse")) {
			%>
			<div class="falsebox">
				<p id="p1">
					<b>문제가 발생했어요!</b>
				</p>
				<p id="p2">해당하는 아이디를 찾을 수 없습니다.</p>
			</div>
			<%
				} else if (check.equals("pwfalse")) {
			%>
			<div class="falsebox">
				<p id="p1">
					<b>문제가 발생했어요!</b>
				</p>
				<p id="p2">비밀번호를 확인해 주세요.</p>
			</div>
			<%
				}
			%>

			<div class="center">
				<div class="centerbox">
					<table class="loginbox1">
						<tr>
							<td colspan="2"
								style="font-size: 26px; font-weight: bold; color: #c2c2c2;">Sign-In</td>
						</tr>
						<tr align="center">
							<td>
								<input type="email" name="mail" placeholder=" Mail" 
								onkeyup="this.value=this.value.replace(	, '');" maxlength="106" style="text-transform: lowercase"/>
							</td>
						</tr>
						<tr align="center">
							<td><input type="password" name="pw" placeholder=" Password" maxlength="30"/></td>
						</tr>
					</table>
					<div class="loginbox2">
						<p>
							<input type="submit" name="submit" value="로그인" />
						<p>
						<p>
							<a href="findUserPW.go">▶비밀번호를 잊으셨어요?</a>
						</p>
					</div>
					<div class="loginbox3">
						<p align="center">
							<b>───── OGU 회원이 아니세요? ─────</b>
						</p>
						<p>
							<input type="button" name="join" value="OGU 계정 만들기" onclick='location.href="userAdd.go"' />
						</p>
					</div>
					<div class="bottom">
						<p align="center">ⓒ2020 OGU.com INC. or its affiliates.</p>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>