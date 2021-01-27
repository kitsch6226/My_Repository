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
.customerreview{
	padding:0;
	overflow:hidden;
	padding:20px;
	margin-top:20px;
	border-radius:6px;
	overflow:hidden;
	border:none;
	background:#474747;
	color:lightgray;
	display:block;
}
.customerreview div, customerreview b{
	float:left;
}
.customerreview input{
	width:2em;
	height:2em;
}
.customerreviewrightdiv button{
	width:3em;
	padding:4px;
	background:#474747;
	border:2px solid darkgray;
	cursor:pointer;
	border-radius:6px;
}
</style>
<script type="text/javascript">
function loginAlert(){
	alert("로그인이 필요합니다!");
	window.location.href="login.go";
}
function reviewRate(rseq,reviewbtn){
	var frmcommuReview = document.getElementById("communityreviewForm");
	frmcommuReview.action="updateCommunityReviewRate.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&scrollNum="+document.scrollingElement.scrollTop;
	frmcommuReview.submit();
}
function cancelRate(rseq,reviewbtn){
	var frmcommuReview = document.getElementById("communityreviewForm");
	frmcommuReview.action="cancelCommunityReviewRate.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&scrollNum="+document.scrollingElement.scrollTop;
	frmcommuReview.submit();
}
function delReivew(rseq,reviewbtn,gseq){
	var frmcommuReview = document.getElementById("communityreviewForm");
	frmcommuReview.action="deleteReviewCommunity.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&gseq="+gseq+"&scrollNum="+document.scrollingElement.scrollTop;
	frmcommuReview.submit();
}
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

</script>
</head>
<body style="background-color: #1f1f1f;">
<form id="communityreviewForm" method="post">
		<div class="sortbtndiv" style="display:table; margin-top:20px;">
			<button  class="communitysortbtn" type="button" onclick="location.href='community.go'">
				아트워크
			</button>
			<button class="communitysortbtn" type="button" onclick="location.href='discussion.go'">
				토론${scrollNum}
			</button>
			<button type="button" style="border:1px solid #474747; cursor:default"disabled>
				리뷰
			</button>
		</div>
		<c:if test="${reviews!=null}">
			<c:forEach var="review" items="${reviews}">
				<c:choose>
				<c:when test="${review.rate eq'1'}">
					<div class="customerreview">
						<div class="customerreviewleftdiv" style=" width:30%;float:left;">
							<div style="width:420px; padding-right:20px;">
								<img src="/store/image/keyart/${review.keyart}" style="width:100%;cursor:pointer" onclick="location.href='gameDetail.go?gseq=${review.gseq}'"/>
							</div>
							<div style="margin-top:20px;">
								<div style="box-sizing:border-box;width:100px; height:100px;border:1px solid black; overflow:hidden; float:left">
									<img src="/store/image/profile/${review.image}" style="width:100%;" ondragstart="return false;"/>
								</div>
								<div style="margin-left:20px;">
									<h2>${review.name }</h2>
									<p style="margin-top:20px;">보유 게임 : ${review.gamenumb}개</p>
								</div>
							</div>
						</div>
						<div class="customerreviewrightdiv" style="width:70%; background:#525252">
							<div style="padding:20px; width:90%">
									<p style="background:#3f3f3f; padding:10px;">
										<b>
											${review.gname}
										</b>
									</p>
								<div style="margin-top:10px;">
									<img src="/store/image/icon/rate_good.png" style="float:left;"/>
									<b style="float:left; font-size:2em; margin-top:10px;">&nbsp;추천 합니다.</b>
								</div>
								<div style="width:100%; margin:20px 0;">
									<hr>
								</div>
								<div style="float:left;">
									<p>${review.content}
									 </p>
								</div>
								<div style="width:100%;  margin:20px 0;">
									<hr>
								</div>
								
								<c:choose>
									<c:when test="${loginInfo!=null}">
										<div style="float:left; width:100%;">
											<c:choose>
												<c:when test="${reviewRates!=null}">
													<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
													<c:forEach var="reviewRate" items="${reviewRates}">
														<c:if test="${reviewRate.rseq==review.rseq}">
															<c:set var="correctRseq" value="${reviewRate.rate}"/>
														</c:if>
													</c:forEach>
													<c:choose>
														<c:when test="${correctRseq eq '1'}">
															<c:set var="correctRseq" value="null"/>
															<button type="button" name='reviewbtn' style="color:gray; width:100px;outline:none;"onclick="cancelRate(${review.rseq},1)">
																좋아요 취소
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:when>
														<c:when test="${correctRseq eq '2'}">
															<c:set var="correctRseq" value="null"/>
															<button type="button" name='reviewbtn' style="color:gray; width:100px;outline:none;"onclick="cancelRate(${review.rseq},2)">
																싫어요 취소
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:when>
														<c:otherwise>
															<button type="button" name='reviewbtn' onclick="reviewRate(${review.rseq},1)">
																<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
															</button>
															<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="reviewRate(${review.rseq},2)">
																<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:otherwise>
													</c:choose>
													
												</c:when>
												<c:otherwise>
													<button type="button" name='reviewbtn' onclick="reviewRate(${review.rseq},1)">
														<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
													</button>
													<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="reviewRate(${review.rseq},2)">
														<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
													</button>
													<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
												</c:otherwise>
											</c:choose>
											<%--로그인한 계정이 리뷰를 작성한 계저잉라면  --%>
											<c:if test="${loginInfo.mail==review.mail}">
												<button type="button" class='deletereviewbtn'
													style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
													onclick="delReivew(${review.rseq},1,${review.gseq})">리뷰 삭제</button>
											</c:if>
										</div>
									</c:when>
									<c:otherwise>
										<div style="float:left; width:100%">
											<button type="button" name='reviewbtn' onclick="loginAlert()">
												<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
											</button>
											<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="loginAlert()">
												<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
											</button>
											<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:when>
				<%-- 부정 리뷰 --%>
				<c:otherwise>
					<div class="customerreview">
						<div class="customerreviewleftdiv" style=" width:30%;float:left;">
							<div style="width:420px; padding-right:20px;">
								<img src="/store/image/keyart/${review.keyart}" style="width:100%;cursor:pointer" onclick="location.href='gameDetail.go?gseq=${review.gseq}'"/>
							</div>
							<div style="margin-top:20px;">
								<div style="box-sizing:border-box;width:100px; height:100px;border:1px solid black; overflow:hidden; float:left">
									<img src="/store/image/profile/${review.image}" style="width:100%;" ondragstart="return false;"/>
								</div>
								<div style="margin-left:20px;">
									<h2>${review.name }</h2>
									<p style="margin-top:20px;">보유 게임 : ${review.gamenumb}개</p>
								</div>
							</div>
						</div>
						<div class="customerreviewrightdiv" style="width:70%; background:#525252">
							<div style="padding:20px; width:90%">
									<p style="background:#3f3f3f; padding:10px;">
										<b>
											${review.gname}
										</b>
									</p>
								<div style="margin-top:10px;">
								<img src="/store/image/icon/rate_bad.png" style="float:left"/>
											<b style="float:left; font-size:2em; margin-top:10px;">&nbsp;추천하지 않아요.</b>
								</div>
								<div style="width:100%; margin:20px 0;">
									<hr>
								</div>
								<div style="float:left;">
									<p>${review.content}
									 </p>
								</div>
								<div style="width:100%;  margin:20px 0;">
									<hr>
								</div>
								<c:choose>
									<c:when test="${loginInfo!=null}">
										<div style="float:left; width:100%;">
											<c:choose>
												<c:when test="${reviewRates!=null}">
													<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
													<c:forEach var="reviewRate" items="${reviewRates}">
														<c:if test="${reviewRate.rseq==review.rseq}">
															<c:set var="correctRseq" value="${reviewRate.rate}"/>
														</c:if>
													</c:forEach>
													<c:choose>
														<c:when test="${correctRseq eq '1'}">
															<c:set var="correctRseq" value="null"/>
															<button type="button" name='reviewbtn' style="color:gray; width:100px;outline:none;"onclick="cancelRate(${review.rseq},1)">
																좋아요 취소
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:when>
														<c:when test="${correctRseq eq '2'}">
															<c:set var="correctRseq" value="null"/>
															<button type="button" name='reviewbtn' style="color:gray; width:100px;outline:none;"onclick="cancelRate(${review.rseq},2)">
																싫어요 취소
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:when>
														<c:otherwise>
															<button type="button" name='reviewbtn' onclick="reviewRate(${review.rseq},1)">
																<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
															</button>
															<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="reviewRate(${review.rseq},2)">
																<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
															</button>
															<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
														</c:otherwise>
													</c:choose>
												
												</c:when>
												<c:otherwise>
													<button type="button" name='reviewbtn' onclick="reviewRate(${review.rseq},1)">
														<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
													</button>
													<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="reviewRate(${review.rseq},2)">
														<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
													</button>
													<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
												</c:otherwise>
											</c:choose>
											<%--로그인한 계정이 리뷰를 작성한 계저잉라면  --%>
											<c:if test="${loginInfo.mail==review.mail}">
												<button type="button" class='deletereviewbtn'
													style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
													onclick="delReivew(${review.rseq},2,${review.gseq})">리뷰 삭제</button>
											</c:if>
										</div>
									</c:when>
									<c:otherwise>
										<div style="float:left; width:100%">
											<button type="button" name='reviewbtn' onclick="loginAlert()">
												<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
											</button>
											<button type="button" name='reviewbtn' style="margin-left:20px;"onclick="loginAlert()">
												<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
											</button>
											<b style="margin-left:20px;">${review.rate1}명이 좋아요를 눌렀어요.</b>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:if>
		<c:if test="${reviews==null}">
			<div class="customerreview">
				<p align="center">아직 등록된 리뷰가 없네요... 게임을 사고 리뷰를 남겨볼까요?</p>
			</div>
		</c:if>
		<c:if test="${param.scrollNum != null}">
			<script type="text/javascript">
				var scrollY = getParameterByName('scrollNum');
				window.scrollTo({top:scrollY, behavior:'auto'});
			</script>
		</c:if>
	</form>
</body>
</html>