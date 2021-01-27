<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지금 여기 오구! 게임 플랫폼</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/store/image/icon/favicon.ico" />
<style type="text/css">
*{
	padding:0;
	margin:0;
}
.censoredh1{
	font-size:3em;
	margin-bottom:20px;
	color:#f2f2f2;
	font-family:nanumsquareround, arial;
}
.censoreda:visited{
	color:gray;
}
.censoreda:link{
	color:gray;
	text-decoration:none;
}
.censoreda:hover{
	color:#c2c2c2;
}

.rightbtn{
	border-radius:6px;
	border:none;
	outline:none;
	cursor:pointer;
	background-color:darkgray;
	transition:0.2s;
}
.rightbtn:hover{
	background-color:#ffea00;
}
</style>
<script type="text/javascript">
function checkOk(){
	var detailform = document.getElementById("detailform");
	detailform.action ="censored.go";
	detailform.submit();
}
</script>
</head>
<body>
<div id="censoredbody" style="position:absolute;width:100%;height:100%; background:#1f1f1f; z-index:10;">
	<div id="censoreddiv" style="width:70%; margin:0 auto; position:absolute; left:15%; top:35%;">
		<h1 class="censoredh1"align="center" style="line-height:1.5em;">
			이 게임은 18세 미만의 사용자가 플레이 하기에<br>부적절한 내용이 있을 수 있습니다.${cookie.censoredCookie.value}
		</h1>
		<p align="center">
			<button class="rightbtn"type="button" style="padding:20px 60px; margin:20px auto;" onclick="checkOk()">
				알겠습니다.
			</button>
		</p>
		<p align="center" style="padding:20px;">
			<a class="censoreda" href="javascript:history.back()" style="font-family:nanumsquareround, arial">돌아가기</a>
		</p>
	</div>
</div>
</body>
</html>