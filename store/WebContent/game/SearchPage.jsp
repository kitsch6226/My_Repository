<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
.indexcenterdiv {
	width: 80%;
	height: 100%;
	min-height:750px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
	color:lightgray;
	box-sizing:border-box;
}
.sortbtndiv button{
	margin-right:20px;
	padding:10px 20px;
	color: lightgray;
	border:1px solid #ffea00;
	border-radius:6px;
	background-color:#1f1f1f;
	cursor:pointer;
	outline:none;
}
.communitysortbtn:hover{
	background:#ffea00;
	color: black;
}
.communitydiscussionboard {
	border-radius: 6px;
	overflow: hidden;
	margin-top: 20px;
	text-align: center;
	width: 100%;
	border: 1ps solid black;
	border-collapse: collapse;
	border-spacing: 0px solid black;
}

.communitydiscussionboard th {
	color:black;
	padding: 2px 0;
	background: darkgray;
}

.communitydiscussionboard td {
	background: #474747;

}

.communitydiscussionboard td div {
	padding: 4px 0;
	margin: 0 auto;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.communitydiscussionboard a {
	text-decoration: none;
	color: lightgray;
}

.communitydiscussionboard a:link {
	color: lightgray;
}

.communitydiscussionboard a:visited {
	color: lightgray;
}

.communitydiscussionboard a:hover {
	color: white;
}
</style>
<script type="text/javascript">
function loginAlert(){
	var frmartwork = document.getElementById("artworkform");
	alert("로그인이 필요합니다!");
	frmartwork.action="login.go";
	frmartwork.submit();
}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<form id="artworkform" action="addDiscussion.go" method="post" enctype="multipart/form-data">
		<div class="indexcenterdiv">
			<div class="sortbtndiv" style="display:table; margin-top:20px; width:100%;">
				<h1>${Title}</h1><c:if test="${searchTitle!=null}"><b> 검색어 : ${searchTitle}</b></c:if>
			</div>
			<div style="box-sizing: border-box;">
				<table class="communitydiscussionboard">
					<tr>
						<th colspan="2" style="width: 40%">타이틀</th>
						<th style="width: 15%">가격</th>
						<th style="width: 15%">유저평가</th>
						<th style="width: 10%">추천 수</th>
						<th style="width: 10%">장르</th>
					</tr>
					<c:choose>
						<c:when test="${searchGames!=null}">
							<c:forEach var="searchGame" items="${searchGames}">
								<tr>
									<td style="width:10%;">
										<div style="padding-left:20px;">
										<img src="/store/image/keyart/${searchGame.keyart}" style="width:100%;cursor:pointer" onclick="location.href='gameDetail.go?gseq=${searchGame.gseq}'"/>
										</div>
									</td>
									<td>
										<div style="width: 100%">
											<a href="gameDetail.go?gseq=${searchGame.gseq}">${searchGame.name}</a>
										</div>
									</td>
									<td>
										<div style="width: 80%;">
											<c:choose>
												<c:when test="${searchGame.freegameyn eq 'y'}">
													<b style="color:#ffea00; font-size:1em; padding:10px; overflow:hidden; background:#1f1f1f; margin-right:10px;border-radius:8px;">
														이 게임은 무료에요!
													</b>
												</c:when>
												<c:when test="${searchGame.specialofferyn eq 'y'}">
													<b style="color:#ffea00; font-size:1em; padding:10px; overflow:hidden; background:#1f1f1f; margin-right:10px;border-radius:8px;">
														-${searchGame.discountrate}%
													</b>
													<f:formatNumber value="${searchGame.price2}" type="currency"/>원
												</c:when>
												<c:when test="${searchGame.specialofferyn eq 'n'}">
													<b><f:formatNumber value="${searchGame.price1}" type="currency"/>원</b>
												</c:when>
											</c:choose>
										</div>
									</td>
									<td>
										<div style="width: 80%;">
											<c:choose>
												<c:when test="${searchGame.userrate > '90'}">
													꼭 해봐야 함&nbsp;
												</c:when>
												<c:when test="${searchGame.userrate <='90' and searchGame.userrate > '70'}">
													완전 재밌는 게임&nbsp;
												</c:when>
												<c:when test="${searchGame.userrate <= '70' and searchGame.userrate > '50'}">
													꽤 괜찮은 편&nbsp;
												</c:when>
												<c:when test="${searchGame.rate1+searchGame.rate2 == 0}">
													평가가 존재하지 않음&nbsp;
												</c:when>
												<c:otherwise>
													문제가 있음&nbsp;
													</c:otherwise> 
											</c:choose>
										</div>
									</td>
									<td>
										<div style="width: 50%">${searchGame.rate1}</div>
									</td>
									<td>
										<div style="width: 50%">
										<a href="search.go?searchContent=${searchGame.genre}">${searchGame.genre}</a>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="100%">
										<hr style="border: 1px solid darkgray;">
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="100%" style="padding:20px 0;">해당 검색결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</form>
</body>
</html>