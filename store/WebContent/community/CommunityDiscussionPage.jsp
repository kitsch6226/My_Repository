<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	background: gray;
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
}

.communitydiscussionboard a:link {
	color: black;
}

.communitydiscussionboard a:visited {
	color: black;
}

.communitydiscussionboard a:hover {
	color: lightgray;
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
		<div class="sortbtndiv" style="display:table; margin-top:20px; width:100%;">
			<button  class="communitysortbtn" type="button" onclick="location.href='community.go'">
				아트워크
			</button>
			<button type="button" style="border:1px solid #474747; cursor:default"disabled>
				토론
			</button>
			<button  class="communitysortbtn" type="button" onclick="location.href='review.go'">
				리뷰
			</button>
			<c:choose>
				<c:when test="${loginInfo!=null}">
					<button class="communitysortbtn" type="submit" style="float:right; margin-right: 0px;">
						의견 등록
					</button>
				</c:when>
				<c:otherwise>
					<button class="communitysortbtn" type="button" style="float:right; margin-right: 0px;" onclick="loginAlert()">
						의견 등록
					</button>
				</c:otherwise>
			</c:choose>
		</div>
		<div style="box-sizing: border-box;">
			<table class="communitydiscussionboard">
				<tr>
					<th style="width: 15%">타이틀</th>
					<th style="width: 5%">작성자</th>
					<th style="width: 50%">제목</th>
					<th style="width: 10%">추천</th>
					<th style="width: 10%">조회수</th>
					<th style="width: 10%">시간</th>
				</tr>
				<c:choose>
					<c:when test="${discussions!=null}">
						<c:forEach var="discussionInfo" items="${discussions}">
							<tr>
								<td>
									<div style="width: 80%">${discussionInfo.kind}</div>
								</td>
								<td style="color:black">
									<div style="width: 100%">
										${discussionInfo.name}
									</div>
								</td>
								<td>
									<div style="width: 80%;">
										<a href="discussionDetail.go?dseq=${discussionInfo.dseq}">${discussionInfo.subject} <b style="color:yellow;">[${discussionInfo.reply}]</b></a>
									</div>
								</td>
								<td>
									<div style="width: 50%">${discussionInfo.rate1}</div>
								</td>
								<td>
									<div style="width: 50%">${discussionInfo.view}</div>
								</td>
								<td>
									<div style="width: 80%">${discussionInfo.indate}</div>
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
							<td colspan="100%" style="padding:20px 0;">아직 등록된 내용이 없습니다. 의견을 올려보세요!</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</form>
</body>
</html>