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

.titletable, .titletable2 {
	border-spacing: 0px;
	padding: 6px;
	margin: 0 auto;
	margin-top: 20px;
	width: 100%;
	height: 100%;
	background-color: #c2c2c2;
	border-radius: 6px;
}

.titletable td, .titletable2 td {
	padding: 5px 0px;
}

.discussionbtn {
	width: 3em;
	padding: 4px;
	background: #474747;
	border: 2px solid darkgray;
	cursor: pointer;
	border-radius: 6px;
}

.discussionreplybtn {
	width: 2.5em;
	padding: 4px;
	background: #474747;
	border: 2px solid darkgray;
	cursor: pointer;
	border-radius: 6px;
}
</style>
<script type="text/javascript">
	function loginAlert(){
		var frmqnadetail = document.getElementById("QnaDetailform");
		alert("로그인이 필요합니다!");
		frmqnadetail.action="login.go";
		frmqnadetail.submit();
	}
	function qnaReple(qseq){
		var frmqnadetail = document.getElementById("QnaDetailform");
		frmqnadetail.action="addQnaReply.go?qseq="+qseq
		frmqnadetail.submit();
	}
	function deleteReply(reseq){
		if(confirm("정말 삭제하시겠어요?")){
			var frmqnadetail = document.getElementById("QnaDetailform");
			frmqnadetail.action="deleteDiscussionReple.go?reseq="+reseq;
			frmqnadetail.submit();	
		}
	}
	function deleteQna(qna){
		if(confirm("정말 삭제하시겠어요?")){
			var frmqnadetail = document.getElementById("QnaDetailform");
			frmqnadetail.action="deleteDiscussion.go?dseq="+dseq;
			frmqnadetail.submit();				
		}
	}
</script>
</head>
<body>
	<form method="post" id="QnaDetailform">
		<div class="center" style="min-height: 600px; padding: 80px;">
			<div class="centermiddle"
				style="padding-bottom: 10px; width: 100%; height: 100%; margin: 0 auto; display: table">
				<div style="display: table;">
					<h1 style="float: left;">
						<img src="/webapp/market/img/product.png" style="width: 1.5em" />
					</h1>
					<p
						style="font-size: 2em; font-weight: bold; padding-top: 6px; float: left">&nbsp;Qna
						상세</p>
					<br>
				</div>
				<hr style="margin: 10px auto;">
				<input type="hidden" name="dseq" value="${qnaInfo.qseq}" />
				<table class="titletable">
					<tr>
						<td align="center"
							style="border-right: 1px solid darkgray; width: 10%;">제 목</td>
						<td colspan="100%" style="padding-left: 10px;">
							<p>${qnaInfo.subject}</p>
						</td>
					</tr>
					<tr style="background-color: #c2c2c2;">
						<td align="center" style="border-right: 1px solid darkgray;">작성자</td>
						<td style="padding-left: 10px;">${qnaInfo.mail}</td>
						<td align="center"
							style="width: 10%; border-right: 1px solid darkgray;">작성일</td>
						<td style="padding-left: 10px;">${qnaInfo.indate}</td>
					</tr>
				</table>
				<table
					style="margin: 0 auto; width: 100%; min-height: 100px; height: 100%; border-radius: 6px; text-align: center;">
					<tr>
						<td style="padding: 10px 0px;"><p align="left">${qnaInfo.content}</p></td>
					</tr>
					<tr>
					</tr>
				</table>
				<hr>
				<%-- <c:if test="${managerInfo!=null}">
					<input type="button"
						style="float: right; margin-top: 10px; padding: 5px 20px;"
						value="삭 제" onclick="delQna(${qnaInfo.qseq})" />
				</c:if> --%>
				<input type="button"
					style="float: left; margin-top: 10px; padding: 5px 20px;"
					value="목 록" onclick="location.href='qna.go'" />
			</div>

			<!--댓글 작성란-->
			<c:if test="${qnaReple==null}">
				<c:choose>
					<c:when test="${managerInfo!=null}">
						<div class="centermiddle"
							style="width: 100%; height: 100%; margin: 0 auto; display: table">
							<hr style="margin-bottom: 10px;">
							<h3>답변 작성</h3>
							<table class="titletable">
								<tr>
									<td>내 용</td>
								</tr>
								<tr>
									<td colspan="100%" style="padding-top: 10px;"><textarea
											name="reply" id="reply" maxlength="2000" rows="5" style="width: 100%; resize: none;"
											placeholder="진상 있으면 관리자에게 보고하세요^^" required></textarea></td>
								</tr>
							</table>
							<button name="replybtn" type="button"
								style="float: right; margin-top: 10px; padding: 5px 20px;"
								onclick="qnaReple(${qnaInfo.qseq})">작 성</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="centermiddle"
							style="width: 100%; height: 100%; margin: 0 auto; display: table">
							<hr style="margin-bottom: 10px;">
							<p align="center" style="padding: 20px;">매니저님 로그인 후 답변을
								달아주세요!</p>
						</div>
					</c:otherwise>
				</c:choose>
			</c:if>
			<!--댓글 있는지 테스트 -->
			<c:choose>
				<c:when test="${qnaReple==null}">
					<hr style="margin: 10px 0px;">
					<div class="centermiddle"
						style="width: 100%; height: 100%; margin: 0 auto; display: table">
						<p align="center" style="padding: 20px;">아직 미처리 문의입니다! 답변을
							달아주세요!</p>
					</div>
				</c:when>
				<c:otherwise>
					<div class="centermiddle"
						style="padding: 10px 0px; width: 100%; height: 100%; margin: 0 auto; display: table">
						<hr style="margin-bottom: 10px;">
						<!-- 댓글이다 -->
						<table id="titletable${qnaReple.reseq}" class="titletable"
							style="padding: 14px;">
							<tr style="width: 100%">
								<td><b>오구 관리자</b></td>
								<td style="float: right;">${qnaReple.indate}</td>
							</tr>
							<tr>
								<td colspan="100%" style="padding-top: 10px;">${qnaReple.content}</td>
							</tr>
						</table>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>