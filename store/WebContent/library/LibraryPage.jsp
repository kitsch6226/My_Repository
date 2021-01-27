<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
.indexcenterdiv {
	width: 80%;
	height: 100%;
	min-height:500px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}
.indexcenterdiv h1{
	float:left;
}
.indexcenterdiv b, .indexcenterdiv h1{
	color:lightgray;

}
.indexcenterdiv p{
	color:gray;
}
.indexcenterdiv a{
	color: #c2c2c2;
	text-decoration:none;
}
.indexcenterdiv button:hover{
	background:#ffea00;
	border:none;
}
.indexcenterdiv li:hover a{
	color:white;
}
.sortbtndiv{
	margin-left:20px;
	float:left;
}
.sortlist{
	float:left;
	padding:10px;
	width:6%;
	border-radius:6px;
	background:#474747;
	display:none;
	position:absolute;
	box-shadow: 0px 3px 6px 3px rgba(0, 0, 0, 0.7);
}
.sortlist li{
	color:gray;
	padding:10px 0px;
	text-align:center;
	list-style:none;
}
.sortbtn{
	width:100%;
	height:3.2em;
	color:lightgray;
	padding:10px 20px;
	border:1px solid #ffea00;
	border-radius:6px;
	background:transparent;
	outline:none;
}
.sortbtndiv:hover .sortlist{
	display:block;
}
.sortbtn:hover{
	background:#ffea00;
	color:black;
}

.librarycenterdiv{
	width:100%;
	display:table;
	box-sizing:border-box;
}
.librarygamediv{
	margin:0px 15px;
	margin-bottom:20px;
	width:18%;
	float:left;
	max-height:485px;
}
.librarygamediv button{
	padding:10px 20px;
	border:none;
	width:100%;
	margin-top:10px;
	cursor:pointer;
}
</style>
<script type="text/javascript">
function installGame(gseq){
	window.location.href="gameInstall.go?gseq="+gseq;
}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<c:if test="${param.library eq 'added'}">
		<script type="text/javascript">
			alert("게임이 라이브러리에 추가 되었습니다!");
		</script>
	</c:if>
	<div class="indexcenterdiv">
		<div style="display:table; width:100%; padding-bottom:20px">
			<h1>라이브러리</h1>
			<div class="sortbtndiv">
				<input class="sortbtn" type="button" value="정렬 기준 : ${librarySort}"/>
				<div class="sortlist">
					<ul>
						<li><a href="library.go?sort=indate">최근</a></li>
						<li><a href="library.go?sort=rate">평가</a></li>
						<li><a href="library.go?sort=download">설치여부</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="librarycenterdiv">
		
		<c:choose> 
			<c:when test="${libraryGames!=null}">
				<c:forEach var="gameInfo" items="${libraryGames}">
					<div class="librarygamediv">
						<div style="width:100%; overflow:hidden; height:365px;">
							<img src="/store/image/portrait/${gameInfo.portrait}" style="cursor:pointer; width:100%" onclick="location.href='gameDetail.go?gseq=${gameInfo.gseq}'"/>
						</div>
						<div style="padding-top:10px;">
							<b>${gameInfo.name}</b>
							<p style="margin:10px 0;">
								<b>게임 장르<br></b>
									${gameInfo.genre}
							</p>
							<c:if test="${gameInfo.downloadyn eq 'n'}">
								<button onclick="installGame(${gameInfo.gseq})">설치하기</button>
							</c:if>
							<c:if test="${gameInfo.downloadyn eq 'y'}">
								<button>시작하기</button>
							</c:if>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise> 
				<p align="center" style="margin-top:10%; color:#c2c2c2"><b>아직 구매한 게임이 없어요! 마음에 드는 게임을 찾아보세요.</b></p>
			</c:otherwise>
		</c:choose>
		
		</div>
	</div>
</body>
</html>