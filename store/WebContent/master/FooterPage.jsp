<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin:0;
padding:0;
}
.footer{
min-width: 800px;
width: 100%;
background-color:#424242;
text-align: center;
font-family: NanumBarunGothic;
font-size: 14px;
letter-spacing:1px;
color: #8f8f8f;
}
.div1{
margin:0 auto;
padding-top:10px;
}
.div2{
margin:0 auto;
padding-bottom:30px
}
.div1>ul{
margin:20px auto;
list-style:none;
}
.div1>ul>li{
padding: 0px 30px;
border-right: 2px solid gray;
display:inline;
}
.div2 a:visited, .div1 li a:visited{
color:lightgray;
text-decoration: none;
}
.div2 a:link, .div1 li a:link{
color:#c4c4c4;
text-decoration: none;
}
.div2 a:hover, .div1 li a:hover{
color:#ffdf52;
text-decoration: underline;
}
.bottomp{
padding:10px;
}
#backtotop{
color:#f2f2f2;
width:100%;
height:40px;
border:3px solid #f2f2f2;
background-color: #424242;
transition:0.3s;
}
#backtotop:hover{
border: 3px solid #ffdf52;
cursor:pointer;
}
#backtotop:focus{
outline:none;
}
</style>
<script type="text/javascript">
function loginAlert() {
	alert("로그인이 필요합니다!");
	window.location.href = "login.go";
}
</script>
</head>
<body>
<div class="footer">
	<div>	
	<button id='backtotop' onclick="window.scrollTo(0,0);">위로 돌아가기</button>
	</div>
	<div class="div1">
		<ul>
		<li><a href="support.go">OGU 이용약관</a></li>
		<li><a href="support.go"><b>개인정보 처리 방침</b></a></li>
		<li><a href="support.go">법적 고지 및 주의사항</a></li>
		<li style="border-right:0px;"><a href="support.go">입점 안내</a></li>
		</ul>
	</div>
	<div class="div2">
		<p class="bottomp">사업자등록번호 : 110-6226-7839 통신판매업신고번호 : 제2020-서울상봉-001호 대표 : 김성현 <a href="#">사업자등록정보확인</a><br/></p>
		<p class="bottomp">주소 : 서울시 중랑구 상봉동 냠냠컴퍼니 13123 대표전화 : 1588-6226
		<c:choose>
			<c:when test="${loginInfo!=null}">
				<a href="addQna.go"><b>1:1문의 바로가기</b></a> 
			</c:when>
			<c:otherwise>
				<a href="javascript:void(0)"onclick="loginAlert()"><b>1:1문의 바로가기</b></a> 
			</c:otherwise>
		</c:choose>
		호스팅 서비스 제공 : OGU Business Platform</p>
	</div>
</div>
</body>
</html>