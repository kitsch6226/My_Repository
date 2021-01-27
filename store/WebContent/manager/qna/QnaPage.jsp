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
	padding: 5px 0;
	background: lightgray;
}

.communitydiscussionboard td {
	background: white;
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
	font-weight:bold;
}
</style>
<script type="text/javascript">
function loginAlert(){
	var frmartwork = document.getElementById("artworkform");
	alert("로그인이 필요합니다!");
	frmartwork.action="login.go";
	frmartwork.submit();
}
function qnaWrite(qseq){
	window.location.href="qnawri";
}
</script>
</head>
<body >
	<form id="artworkform" action="addDiscussion.go" method="post" enctype="multipart/form-data">
		<div style="box-sizing: border-box; padding:80px 0;">
			<h1 style="float:left;">
				<img src="/webapp/market/img/product.png" style="width: 1.5em" />
			</h1>
			<p style="font-size:2em; font-weight:bold; padding-top:6px; float:left">&nbsp;Qna 현황</p>
			<table class="communitydiscussionboard">
				<tr>
					<th style="width: 15%">문의 종류</th>
					<th style="width: 5%">작성자</th>
					<th style="width: 50%">제목</th>
					<th style="width: 10%">날짜</th>
					<th style="width: 10%">유저 읽음</th>
				</tr>
				<c:choose>
					<c:when test="${qnas!=null}">
						<c:forEach var="qnaInfo" items="${qnas}">
							<c:choose>
								<c:when test="${qnaInfo.replyyn eq 'n'}">
									<tr id="replyNTable">
										<c:choose>
											<c:when test="${qnaInfo.kind eq '게임환불'}">
												<tr id="refundTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
															${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:red;">[미처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
											<c:when test="${qnaInfo.kind eq '계정관련'}">
												<tr id="accountTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
														${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:red;">[미처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
											<c:when test="${qnaInfo.kind eq '버그'}">
												<tr id="bugTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
														${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:red;">[미처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
										</c:choose>
									</tr>
									<tr>
										<td colspan="100%">
											<hr style="border: 1px solid #525252;">
										</td>
									</tr>
							</c:when>
							<c:otherwise>
								<tr id="replyTable">
									<c:choose>
											<c:when test="${qnaInfo.kind eq '게임환불'}">
												<tr id="refundTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
														${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:darkgray;">[처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
											<c:when test="${qnaInfo.kind eq '계정관련'}">
												<tr id="accountTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
														${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:darkgray;">[처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
											<c:when test="${qnaInfo.kind eq '버그'}">
												<tr id="bugTable">
													<td>
														<div style="width: 80%">${qnaInfo.kind}</div>
													</td>
													<td>
														<div style="width: 100%">
														${qnaInfo.mail}
														</div>
													</td>
													<td>
														<div style="width: 80%;">
															<a href="qna.go?qseq=${qnaInfo.qseq}">
															${qnaInfo.subject}<b style="color:darkgray;">[처리]</b></a>
														</div>
													</td>
													<td>
														<div style="width: 50%">${qnaInfo.indate}</div>
													</td>
													<td>
														<div style="width: 80%">${qnaInfo.usercheckyn}</div>
													</td>
												</tr>
											</c:when>
									</c:choose>
								</tr>
								<tr>
									<td colspan="100%">
										<hr style="border: 1px solid #525252;">
									</td>
								</tr>
							</c:otherwise>
							</c:choose>
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