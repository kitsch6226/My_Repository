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
.artworkdiv {
	background: #474747;
	width: 24%;
	margin-top: 20px;
	margin-right: 10px;
	border-radius: 6px;
	overflow:hidden;
}

.artworkcontentdiv {
	position: relative;
	overflow: hidden;
	width: 340px;
	height: 200px;
	margin: 0px auto;
}

.artworkcontentdiv img {
	width: 100%;
	cursor: pointer;
	transition: 0.3s;
}

.artworkcontentdiv img:hover {
	opacity: 0.3;
}

.overlay {
	cursor: pointer;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	height: 100%;
	width: 100%;
	opacity: 0;
	transition: .5s ease;
	background-color: black;
}

.artworkcontentdiv:hover .overlay {
	opacity: 0.8;
}

.text {
	color: white;
	font-size: 20px;
	position: absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
	text-align: center;
}

.artworkratebtn {
	width: 3em;
	padding: 4px;
	background: #474747;
	border: 2px solid darkgray;
	cursor: pointer;
	border-radius: 6px;
	margin-left: 20px;
	float: left;
}

.artworkdiv {
	float: left;
}
</style>
<script type="text/javascript">
	function newframe(image) {
		window.open('/store/image/artwork/' + image);
	}
	function loginAlert(){
		var frmartwork = document.getElementById("artworkform");
		alert("로그인이 필요합니다!");
		frmartwork.action="login.go";
		frmartwork.submit();
	}
	function artworkRate(aseq,artworkRatebtn){
		var frmartwork = document.getElementById("artworkform");
		frmartwork.action="updateArtworkRate.go?aseq="+aseq+"&artworkRatebtn="+artworkRatebtn;
		frmartwork.encoding="application/x-www-form-urlencoded";
		frmartwork.submit();
	}
	function cancelRate(aseq,artworkRatebtn){
		var frmartwork = document.getElementById("artworkform");
		frmartwork.action="cancelArtworkRate.go?aseq="+aseq+"&artworkRatebtn="+artworkRatebtn;
		frmartwork.submit();
	}
	function delArtwork(aseq){
		if(confirm("정말 삭제하시겠어요?")){
			var frmartwork = document.getElementById("artworkform");
			frmartwork.action="deleteArtwork.go?aseq="+aseq;
			frmartwork.submit();
		}
	}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<form id="artworkform" action="addArtwork.go" enctype="multipart/form-data" method="post">
		<div class="sortbtndiv" style="display:table; margin-top:20px; width:100%;">
			<button type="button" onclick="location.href='community.go'" style="border:1px solid #474747; cursor:default"disabled>
				아트워크
			</button>
			<button class="communitysortbtn" type="button" onclick="location.href='discussion.go'">
				토론
			</button>
			<button class="communitysortbtn" type="button" onclick="location.href='review.go'">
				리뷰
			</button>
			<c:choose>
				<c:when test="${loginInfo!=null}">
					<button class="communitysortbtn" type="submit" style="float:right; margin-right: 0px;">
						작품 등록
					</button>
				</c:when>
				<c:otherwise>
					<button class="communitysortbtn" type="button" style="float:right; margin-right: 0px;" onclick="loginAlert()">
						작품 등록
					</button>
				</c:otherwise>
			</c:choose>
		</div>
		<c:choose>
			<c:when test="${artworks!=null}">
			
				<c:forEach var="artworkInfo" items="${artworks}">
					<div class="artworkdiv">
						<div class="artworkcontentdiv">
							<p style="height:240px; overflow:hidden">
							<img src="/store/image/artwork/${artworkInfo.image}"	style="width: 100%;">
							</p>
							<div class="overlay" onclick="newframe('${artworkInfo.image}')">
								<div class="text">확대 하기</div>
							</div>
						</div>
						<div style="padding: 10px 0; display: table; width:95%;">
						<c:choose>
						
							<c:when test="${loginInfo!=null}">
								<c:choose>
									<c:when test="${artworkRates!=null}">
										<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
										<c:forEach var="artworkRate" items="${artworkRates}">
											<c:if test="${artworkRate.aseq==artworkInfo.aseq}">
												<c:set var="correctAseq" value="${artworkRate.rate}"/>
											</c:if>
										</c:forEach>
										<c:choose>
											<c:when test="${correctAseq eq '1'}">
												<c:set var="correctAseq" value="null"/>
												<button type="button" class="artworkratebtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="cancelRate(${artworkInfo.aseq},1)">
													좋아요 취소
												</button>
											</c:when>
											<c:when test="${correctAseq eq '2'}">
												<c:set var="correctAseq" value="null"/>
												<button type="button" class="artworkratebtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="cancelRate(${artworkInfo.aseq},2)">
													싫어요 취소
												</button>
											</c:when>
											<c:otherwise>
												<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate1" style="margin-left: 10px;"onclick="artworkRate(${artworkInfo.aseq},1)">
													<img src="/store/image/icon/rate_good.png"
														style="background: transparent; width: 100%" />
												</button>
												<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate2" style="margin-left: 20px;"onclick="artworkRate(${artworkInfo.aseq},2)">
													<img src="/store/image/icon/rate_bad.png"
														style="background: transparent; width: 100%" />
												</button>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate1" style="margin-left: 10px;"onclick="artworkRate(${artworkInfo.aseq},1)">
											<img src="/store/image/icon/rate_good.png"
												style="background: transparent; width: 100%" />
										</button>
										<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate2" style="margin-left: 20px;"onclick="artworkRate(${artworkInfo.aseq},2)">
											<img src="/store/image/icon/rate_bad.png"
												style="background: transparent; width: 100%" />
										</button>
									</c:otherwise>
								</c:choose>
								<p style="float: left; margin-left: 10px; margin-top: 10px;">
									<b>${artworkInfo.rate1}개의 추천</b>
								</p>
								<c:if test="${loginInfo.mail==artworkInfo.mail}">
									<button class="artworkratebtn" style="padding:11px 0;width:5em;float:right; color:lightgray"  onclick="delArtwork(${artworkInfo.aseq})">
										삭제하기
									</button>
								</c:if>
							</c:when>
							<c:otherwise>
								<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate1" style="margin-left: 10px;"onclick="loginAlert()">
									<img src="/store/image/icon/rate_good.png"
										style="background: transparent; width: 100%" />
								</button>
								<button class="artworkratebtn" name="artworkRatebtn" type="button" value="rate2" style="margin-left: 20px;"onclick="loginAlert()">
									<img src="/store/image/icon/rate_bad.png"
										style="background: transparent; width: 100%" />
								</button>
								<p style="float: left; margin-left: 10px; margin-top: 10px;">
									<b>${artworkInfo.rate1}개의 추천</b>
								</p>
							</c:otherwise>
							
						</c:choose>
						</div>
					</div>
				</c:forEach>
				
			</c:when>
			<c:otherwise>
				<p align="center" style="padding-top:10%;"><b>아직 아무 게시글이 없네요.. 작품을 자랑해 보세요!</b></p>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>