<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
.titletable, .titletable2{
	border-spacing:0px;
	padding:6px;
	margin:0 auto;
	margin-top:20px;
	width:100%;
	height:100%;
	background-color: #474747;
	border-radius:6px;
	color:lightgray;
}
.titletable td,.titletable2 td{
	padding:5px 0px;
	color:lightgray;
}
.discussionbtn{
	width:3em;
	padding:4px;
	background:#474747;
	border:2px solid darkgray;
	cursor:pointer;
	border-radius:6px;
}
.discussionreplybtn{
	width:2.5em;
	padding:4px;
	background:#474747;
	border:2px solid darkgray;
	cursor:pointer;
	border-radius:6px;
}
</style>
<script type="text/javascript">
	function loginAlert(){
		var frmdiscussion = document.getElementById("discussionform");
		alert("로그인이 필요합니다!");
		frmdiscussion.action="login.go";
		frmdiscussion.submit();
	}
</script>
</head>
<body style="background-color: #1f1f1f;">
		<form method="post" id="discussionform">
			<div class="centermiddle" style="padding:120px; width:80%; height:100%; margin:0 auto;">
				<div class="centermiddle" style="padding-bottom:10px; width:100%; height:100%; margin:0 auto; display:table">
					<h1 style="color:lightgray;">문의 답변</h1>
					<hr style="margin:10px auto;">
					<input type="hidden" name="dseq" value="${discussion.dseq}"/>
					<table class="titletable">
						<tr>
							<td align="center" style="border-right:1px solid darkgray;width:10%;">문의 제목</td>
							<td colspan="100%" style="padding-left:10px;">
								<p>${qnaInfo.subject}</p>
							</td>
						</tr>
						<tr style="background-color: #474747;">
							<td align="center" style="border-right:1px solid darkgray;">작성자</td>
							<td style="padding-left:10px;">${qnaInfo.mail}</td>
							<td align="center" style="width:10%; border-right:1px solid darkgray;">작성일</td>
							<td style="padding-left:10px;">${qnaInfo.indate}</td>
						</tr>
					</table>
					<table style="margin:0 auto; width:100%; min-height:100px; height:100%; border-radius:6px; text-align:center;">
						<tr>
							<td style="padding:10px 0px;"><p align="left" style="color:lightgray;">${qnaInfo.content}</p></td>
						</tr>
						<tr>
						</tr>
					</table>
				</div>
				
				<!--댓글 div -->
					<c:choose>
					<c:when test="${qnaReple==null}">
						<hr style="margin:10px 0px;">
						<div class="centermiddle" style="width:100%; height:100%; margin:0 auto; display:table">
							<p align="center" style="padding:20px;">?!답변이 없다고요? 오류입니다!!<br>관리자에게 문의해주세요. ogu@ogu.com</p>
						</div>
					</c:when>
					<c:otherwise>
					<div class="centermiddle" style="padding:10px 0px; width:100%; height:100%; margin:0 auto; display:table">
					<hr style="margin-bottom:10px;">
						<!-- 댓글이다 -->
								<table id="titletable${qnaReple.reseq}" class="titletable" style="padding:14px;">
									<tr style="width:100%">
										<td>
											<b>Ogu 관리자</b>
											
										</td>
										<td style="float:right;">
											${qnaReple.indate}
										</td>
									</tr>
									<tr>
										<td colspan="100%" style="padding-top:10px;">${qnaReple.content}</td>
									</tr>
								</table>
					</div>
					</c:otherwise>
					</c:choose>
			</div>
		</form>
</body>
</html>