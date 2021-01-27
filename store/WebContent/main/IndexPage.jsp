<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

.indexcenterdiv {
	width: 80%;
	height: 100%;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}

.indexcenterdiv>h3 {
	color: #f2f2f2;
	float: left;
}

.indexcenterdiv p {
	width: 100%;
	color: gray;
}

.indexcenterdiv a {
	width: 100%;
	color: #e8e8e8;
	text-decoration: none;
}
.indexcenterdiv a:hover{
	color:white;
}

.subject button {
	float: right;
	color: gray;
	padding: 6px 16px;
	border: 1px solid #ffdf52;
	border-radius: 6px;
	background-color: transparent;
	cursor: pointer;
}

.indexcenterdiv div button:focus {
	outline: none;
}

.featureddiv, .specialofferdiv, .communityrecommanddiv, .newgamediv,
	.freegamediv {
	background-color: #474747;
	overflow: hidden;
	border-radius: 6px;
}
.specialofferdiv a{
	color:lightgray;
}

.featureddiv ul {
	width: 100%;
}

.featureddiv ul li {
	list-style: none;
	display: inline-block;	
}

.newgamediv div {
	box-sizing: border-box;
	float: left;
	width: 50%;
	background-color:#474747;
}

.newgamediv h3{
	padding:10px;
	color: #f2f2f2;
}
.freegamediv{
	background-color: #474747;
	margin-top: 20px;
	width:1522px;
	height:340px;
	overflow:auto;
	display:block;
}
.freegamediv ul{
	width:2020px;
	height:302px;
}

.freegamediv li{
	list-style:none;
	float:left;
}
.freegamediv li img{
	width:24em;
	float:left;
}

.subject {
	width: 100%;
	margin-top: 20px;
	display: table;
}

.subject h3 {
	color: #f2f2f2;
	float: left;
}

.specialoffertitle {
	overflow: hidden;
	padding: 10px;
	float: left;
	width: 25%;
	box-sizing: border-box;
}

.specialoffertitle img {
	width: 100%;
	border-radius: 6px;
	cursor:pointer;
}
</style>
<script type="text/javascript">
	function detailGame(gseq){
		var frmindex = document.getElementById("indexform");
		frmindex.action="gameDetail.go?gseq="+gseq;
		frmindex.submit();
	}
	
	if(document.location.href!='http://localhost:8080/store/main/ogu.go'){
		window.location.href='ogu.go';
	};
</script>
</head>
<body style="background-color: #1f1f1f;">
<form id="indexform" method="post">
	<div class="indexcenterdiv">
	<!--광고 판  -->
		<c:choose>
			<c:when test="${adGame!=null}">
				<div class="featureddiv">
					<div style="width: 60%; height: 515px; overflow: hidden; float: left">
						<ul>
							<li><img
								src="/store/image/keyart/${adGame.keyart}"
								style="cursor:pointer; width: 100%;display:block" onclick="detailGame(${adGame.gseq})"/>
							</li>
						</ul>
					</div>
					<div style="float: left; width: 40%; height: 32em;">
						<div style="height:20em; padding: 20px;">
							<h2 style="color:#f2f2f2; overflow:hidden"><a href="javascript:void(0)" onclick="detailGame(${adGame.gseq})">${adGame.name}</a></h2>
							<hr style="margin: 10px auto;">
							<p>${adGame.content1}</p>
						</div>
						<div style="width: 90%; padding: 30px;">
							<p>
								<a href="gameDetail.go?gseq=${adGame.gseq}">▸지금 구매</a>
							</p>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="featureddiv;" style="display:block; min-height:300px; background:#474747">
					<p style=" padding:16% 0;height:100%;" align="center">이곳에 당신의 게임을 광고 해보세요!<br><br>ogu@ogu.com</p>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- 특별 할인 -->
		<div class="subject">
			<h3>특별 할인</h3>
			<button type="button" onclick="location.href='search.go?searchContent=specialOfferGame'">더 보기</button>
		</div>
		<c:choose>
			<c:when test="${specialOfferGames!=null}">
			<div class="specialofferdiv"style="background-color: transparent; margin-top: 20px;">
				<c:forEach var="specialOfferGame" items="${specialOfferGames}" end="4">		
						<div class="specialoffertitle">
							<div style="width:100%; max-height:480px;overflow:hidden; border-radius:6px;">
								<img src="/store/image/portrait/${specialOfferGame.portrait}" style="width:100%;" onclick="detailGame(${specialOfferGame.gseq})"/>
							</div>
							<div
								style="padding-top: 10px; width: 100%; height: 100px; display: table;">
								<h2 style="display: block; color: #f2f2f2; text-overflow:ellipsis; overflow:hidden; width:360px; white-space:nowrap">
									<a href="javascript:void(0)" onclick="detailGame(${specialOfferGame.gseq})">
										${specialOfferGame.name}
									</a>
								</h2>
								<p style="display: block; margin-top: 10px;">
									게임 태그:
								<c:forEach var="gameTag" items="${specialOfferGame.tag}">
									<c:if test="${gameTag != null}"><a href="search.go?searchContent=${gameTag}">#${gameTag}</a></c:if> 
								</c:forEach>
								</p>
							</div>
							<span style="float: right; color: white;">&nbsp;<f:formatNumber type="currency" value="${specialOfferGame.price2}"/>원</span> <b
								style="color: #ffea00; float: right;">${specialOfferGame.discountrate}%할인율</b>
						</div>
				</c:forEach>
			</div>
			</c:when>
			<c:otherwise>
				<div class="featureddiv;" style="display:block; min-height:300px; background:#474747">
					<p style=" padding:15% 0;height:100%;" align="center">특별 할인 게임이 없다구요...? 그거 이상한걸요?<br><br>관리자에게 신고해 주세요<br><br>ogu@ogu.com</p>
				</div>
			</c:otherwise>
		</c:choose>
		<!--커뮤니티 추천  -->
		<div class="subject">
			<h3>커뮤니티 추천</h3>
			<button type="button" onclick="detailGame(${bestReview.gseq})">더 보기</button>
		</div>
		<c:choose>
			<c:when test="${bestReview!=null}">
					<div class="communityrecommanddiv" style="background-color: #4c6175; width:100%; margin-top: 20px;">
						<div style="width: 60%; height: 515px; overflow: hidden; float: left">
							<ul>
								<li><a href="javascript:void(0)" onclick="detailGame(${bestReview.gseq})"><img
									src="/store/image/keyart/${bestReview.keyart}"
									style="width: 100%; cursor:pointer" /></a></li>
							</ul>
						</div>
						<div style="float: left; width: 40%; height: 32em;">
							<div style="width: 90%; height: 300px; margin: 20px auto;">
								<p style="color: white">"${bestReview.content}"</p>
							</div>
							<div style="width: 90%; padding: 30px;">
								<div style="float: left; border: 2px solid black; width: 113px; max-height:113px; overflow:hidden;" >
									<img src="/store/image/profile/${bestReview.image}" style="width:100%;"/>
								</div>
								<div>
									<p style="color: #f2f2f2; padding-top: 4px;">
										&nbsp;<b>${bestReview.name}</b><br>&nbsp;보유 게임: ${bestReview.gamenumb}개
									<p>
									<hr style="margin: 16px 10px;">
									<p style="color: #f2f2f2;">&nbsp;받은 추천 수 : ${bestReview.rate1}개</p>
								</div>
							</div>
						</div>
					</div>
			</c:when>
			<c:otherwise>
				<div class="featureddiv;" style="display:block; min-height:300px; background:#474747">
					<p style=" padding:14% 0;height:100%;" align="center">커뮤니티 추천 게임이 없다구요...? 그거 이상한걸요?<br><br>관리자에게 신고해 주세요<br><br>ogu@ogu.com</p>
				</div>
			</c:otherwise>
		</c:choose>
		<!--새로운 게임!  -->
		<div class="subject">
			<h3>새로운 게임</h3>
			<button type="button" onclick="location.href='search.go?searchContent=newGame'">더 보기</button>
		</div>
		<c:choose>
			<c:when test="${newGames!=null}">
				<div class="newgamediv"
						style="background-color: #474747; margin-top: 20px;">
					<c:forEach var="newGame" items="${newGames}" end="1">
							<div>
								<div style="overflow:hidden;width:100%; height:428px; margin-bottom:10px;">
									<a href="javascript:void(0)" onclick="detailGame(${newGame.gseq})" style="cursor:pointer;">
										<img src="/store/image/keyart/${newGame.keyart}" style="width: 100%;height:100%" />
									</a>
								</div>
								<h3>
									<a href="javascript:void(0)" onclick="detailGame(${newGame.gseq})" style="cursor:pointer">
										${newGame.name}
									</a>
								</h3>
								<hr style="border:1px solid gray;">
								<p style="display: block; padding: 10px;">게임 태그:
									<c:forEach var="gameTag" items="${newGame.tag}">
										<c:if test="${gameTag != null}"><a href="search.go?searchContent=${gameTag}">#${gameTag}</a></c:if> 
									</c:forEach>
								</p>
							</div>
					</c:forEach>
				</div>
			</c:when>
			<c:otherwise>
				<div class="featureddiv;" style="display:block; min-height:300px; background:#474747">
					<p style=" padding:13% 0;height:100%;" align="center">새로운 게임이 없다구요...? 그거 이상한걸요?<br><br>관리자에게 신고해 주세요<br><br>ogu@ogu.com</p>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- 이 게임은 무료입니다! -->
		<div class="subject">
			<h3>무료 게임</h3>
			<button type="button" onclick="location.href='search.go?searchContent=freeGame'">더 보기</button>
		</div>
		<div class="freegamediv">
			<c:choose>
			<c:when test="${freeGames!=null}">
				<ul>
				<c:forEach var="freeGame" items="${freeGames}" end="4">
					<li><div style="padding:10px; display:table;">
						<a href="javascript:void(0)" onclick="detailGame(${freeGame.gseq})" style="cursor:pointer">
							<img src="/store/image/keyart/${freeGame.keyart}"/>
						</a>
						</div>
						<div style="padding:10px;">
							<h3 style="color:#f2f2f2;"><a href="javascript:void(0)"onclick="detailGame(${freeGame.gseq})">${freeGame.name}</a></h3>
							<p style="display: block; color: darkgray;">게임 태그:
								<c:forEach var="gameTag" items="${freeGame.tag}">
									<c:if test="${gameTag != null}"><a href="search.go?searchContent=${gameTag}">#${gameTag}</a></c:if> 
								</c:forEach>
						</div>
					</li>
				</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
					<p style="height:100%;" align="center"><br><br><br><br><br><br>새로운 게임이 없다구요...? 그거 이상한걸요?<br><br>관리자에게 신고해 주세요<br><br>ogu@ogu.com</p>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
</form>
</body>
</html>