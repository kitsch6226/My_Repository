<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.indexcenterdiv {
	width: 80%;
	height: 100%;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}

.sortdiv {
	color: gray;
}

.sortdiv a {
	color: gray;
}

.sortdiv a:link {
	text-decoration: none;
}

.simpleinformationdiv, .orderdiv {
	background: #474747;
	border-radius: 6px;
	overflow: hidden;
}

.simpleinformationrightdiv p {
	margin: 20px 0;
	color: lightgray;
}

.simpleinformationrightdiv b, .simpleinformationrightdiv a {
	color: gray;
}

.simpleinformationrightdiv a {
	color: lightgray;
}

.simpleinformationrightdiv a:link {
	text-decoration: none;
}

.simpleinformationrightdiv a:hover {
	color: #ffdf52;
}

.orderdiv h2 {
	color: #f2f2f2;
}

.orderdiv button {
	border-radius: 6px;
	border: 1px solid black;
	outline: none;
	cursor: pointer;
	padding: 14px 24px;
	float: right;
}

.orderbtn {
	margin-left: 10px;
	background: #ffdd00;
}

.orderbtn:hover {
	background: #ffeb6b;
}

.aboutgame {
	margin-top: 20px;
}

.systemrequirement, .supportlanguage, .customerreview, .customerreview2
	{
	padding: 20px;
	margin-top: 20px;
	border-radius: 6px;
	overflow: hidden;
	border: none;
	background: #474747;
	color: lightgray;
	display: block;
}

.systemrequirement div {
	width: 50%;
	float: left;
}

.systemrequirement p {
	margin-top: 30px;
}

.systemrequirement p b {
	color: gray;
}

.supportlanguage table {
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}

.supportlanguage table td, .supportlanguage table th {
	padding: 6px;
	border: 1px solid #f2f2f2;
}

.customerreview, .customerreview2 {
	padding: 0;
	overflow: hidden;
}

.customerreview div, customerreview b, .customerreview2 div,
	customerreview2 b {
	float: left;
}

.customerreview input, .customerreview2 input {
	width: 2em;
	height: 2em;
}

.customerreviewrightdiv button {
	width: 3em;
	padding: 4px;
	background: #474747;
	border: 2px solid darkgray;
	cursor: pointer;
	border-radius: 6px;
}

.subject {
	width: 100%;
	margin-top: 40px;
	display: table;
	color: lightgray;
}

.subject h1, .sortdiv h1 {
	padding: 10px 0;
	color: #f2f2f2;
}

.subject a {
	color: gray;
}

.subject a:link {
	color: gray;
	text-decoration: none;
	transition: 0.3s;
}

.subject a:hover {
	color: lightgray;
}
</style>
<script type="text/javascript">
	function wishlistGo(){
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="addWishlist.go";
		frmdetail.submit();
	}
	function loginAlert(){
		var frmdetail = document.getElementById("detailform");
		alert("로그인이 필요합니다!");
		frmdetail.action="login.go";
		frmdetail.submit();
	}
	function reviewAdd(rseq){
		var writeContent = document.getElementById("reviewWriteContent");
		if(writeContent.value==null||writeContent.value==""){
			alert("리뷰 내용을 작성해 주세요!");
			return;
		}
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="addReview.go?scrollNum="+document.scrollingElement.scrollTop;;
		frmdetail.submit();
	}
	function reviewRate(rseq,reviewbtn){
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="updateReviewRate.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdetail.submit();
	}
	function rateView(numb){
		var cr1 = document.getElementsByClassName("customerreview1");
		var cr2 = document.getElementsByClassName("customerreview2"); 
		if(numb==1){
			for(var i=0; i<cr1.length;i++){
			cr1[i].style.display="block";				
			}
			for(var i=0; i<cr2.length;i++){
			cr2[i].style.display="block";				
			}
		}else if(numb==2){
			for(var i=0; i<cr1.length;i++){
				cr1[i].style.display="block";				
			}
			for(var i=0; i<cr2.length;i++){
				cr2[i].style.display="none";				
			}
		}else{
			for(var i=0; i<cr1.length;i++){
				cr1[i].style.display="none";				
				}
			for(var i=0; i<cr2.length;i++){
				cr2[i].style.display="block";				
			}
		}
	}
	
	function cancelRate(rseq,reviewbtn){
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="cancelReviewRate.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdetail.submit();
	}
	function delReivew(rseq,reviewbtn){
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="deleteReview.go?rseq="+rseq+"&reviewbtn="+reviewbtn+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdetail.submit();
	}
	function gameSearchGo(searchContent){
		var frmdetail = document.getElementById("detailform");
		frmdetail.action="search.go?searchContent="+searchContent;
		frmdetail.submit();
	}
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	function showReview(){
		var scrollY = document.getElementById("movehere").offsetTop;
		window.scrollTo({top:scrollY-140, behavior:'smooth'});
	}
</script>
</head>

<body style="background-color: #1f1f1f;">
	<form id="detailform" action="addOrders.go" method="post">
	<input type="hidden" name="gseq" value="${gameInfo.gseq}" />
	<c:choose>
		<%-- 18세 게임이면 --%>
		<c:when test="${gameInfo.violence eq '18'}">
			<c:choose>
			<c:when test="${censored ne 'confirm'}">
				<jsp:include page="../warning/CensoredPage.jsp"/>
			</c:when>
			<c:otherwise>
					<c:if test="${param.check eq 'added'}">
						<script type="text/javascript">
							alert("장바구니에 상품이 추가 되었습니다!");
						</script>
					</c:if>
					<div id="visibleDiv">
					<div class="indexcenterdiv">
						<div class="sortdiv">
							<a href="search.go?searchContent=All">모든 게임</a>&nbsp;>&nbsp;<a
								href="javascript:void(0)"
								onclick="gameSearchGo('${gameInfo.genre}')">${gameInfo.genre}</a>&nbsp;>&nbsp;${gameInfo.name}
							<h1>${gameInfo.name}</h1>
						</div>
						<div class="simpleinformationdiv">
							<div style="width: 60%; height: 515px; overflow: hiden; float: left">
								<img src="/store/image/keyart/${gameInfo.keyart}"
									style="width: 100%; display: block" />
							</div>
							<div class="simpleinformationrightdiv"
								style="float: left; width: 40%; height: 32em;">
								<div style="height: 20em; padding: 20px;">
									<div
										style="overflow: hidden; height: 220px; border: 1px solid black;">
										<img src="/store/image/main/${gameInfo.main[0]}"
											style="width: 100%" />
									</div>
									<p>
										<b>게임 평가 : </b>
										<c:choose>
			
											<c:when test="${gameInfo.userrate > '90'}">
												<a href="javascript:void(0)" onclick="showReview()">
													꼭 해봐야 함&nbsp;
												</a>
											</c:when>
											<c:when
												test="${gameInfo.userrate <='90' and gameInfo.userrate > '70'}">
												<a href="javascript:void(0)" onclick="showReview()">
													완전 재밌는 게임&nbsp;
												</a>
											</c:when>
											<c:when
												test="${gameInfo.userrate <= '70' and gameInfo.userrate > '50'}">
												<a href="javascript:void(0)" onclick="showReview()">
													꽤 괜찮은 편&nbsp;
												</a>
											</c:when>
											<c:when test="${gameInfo.rate1+gameInfo.rate2 == 0}">
												<a href="javascript:void(0)" onclick="showReview()">
													평가가 존재하지 않음&nbsp;
												</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="showReview()">
													문제가 있음&nbsp;
													</a>
											</c:otherwise>
										</c:choose>
										<b>(${gameInfo.rate1+gameInfo.rate2} 개의 평가)</b>
									<p>
									<p>
										<b>출시 날짜 : </b>${gameInfo.releasedate}
									<p>
									<p>
										<b>개발사 : </b><a href="javascript:void(0)"
											onclick="gameSearchGo('${gameInfo.developer}')">${gameInfo.developer}</a>
									</p>
									<p>
										<b>웅영 체제 : </b>
										<c:choose>
											<c:when test="${gameInfo.platform eq '1'}">
											윈도우
										</c:when>
											<c:when test="${gameInfo.platform eq '1,2'}">
											윈도우, 맥
										</c:when>
											<c:when test="${gameInfo.platform eq '2'}">
											맥
										</c:when>
											<c:otherwise>
											기타 플랫폼
										</c:otherwise>
										</c:choose>
									</p>
									<p>
										<b>태그: </b>
										<c:forEach var="gameTag" items="${gameInfo.tag}">
											<c:if test="${gameTag != null}">
												<a href="javascript:void(0)"
													onclick="gameSearchGo('${gameTag}')">#${gameTag}</a>
											</c:if>
										</c:forEach>
									</p>
								</div>
							</div>
						</div>
						<div class="orderdiv" style="margin: 20px auto; padding: 20px;">
							<h2 style="float: left; padding-top: 6px;">${gameInfo.name}
								구매하기</h2>
								
							<c:choose>
								<%-- 로그인 했을 때 결제 버튼창--%>
								<c:when test="${loginInfo.mail!=null}">
									<c:choose>
										<c:when test="${libraryyn eq 'y'}">
											<button class="orderbtn" type="button"
												onclick="location.href='library.go'">구매 함 라이브러리로 이동</button>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${orderyn eq 'y'}">
													<button class="orderbtn" type="button"
														onclick="location.href='orders.go'">결제 대기중 결제하기</button>
												</c:when>
												<c:otherwise>
													<c:choose>
														<%-- 찜목록에 있는가? --%>
														<c:when test="${wishlistyn eq 'y'}">
															<c:choose>
																<c:when test="${gameInfo.freegameyn eq 'y'}">
																	<button class="orderbtn" type="submit">무료 지금 구매</button>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<%-- 할인 중인가? --%>
																		<c:when test="${gameInfo.specialofferyn eq 'y'}">
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price2}"
																					type="currency" />
																				원 지금 구매
																			</button>
																		</c:when>
																		<%-- 할인 아닐 때 --%>
																	<c:otherwise>
																		<button class="orderbtn" type="submit">
																			<f:formatNumber value="${gameInfo.price1}"
																				type="currency" />
																			원 지금 구매
																		</button>
																	</c:otherwise>
																	</c:choose>
																</c:otherwise>
															</c:choose>
															<button class="wishlistbtn"
															style="background: #darkgray; cursor: default;"
															type="button" disabled>
																이미 찜함
															</button>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${gameInfo.freegameyn ne 'y'}">
																	<c:choose>
																		<%-- 할인 중인가? --%>
																		<c:when test="${gameInfo.specialofferyn eq 'y'}">
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price2}"
																					type="currency" />
																				원 지금 구매
																			</button>
																			<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">찜 하기
																			</button>
																		</c:when>
																		<%-- 할인 아닐 때 --%>
																		<c:otherwise>
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price1}"
																					type="currency" />
																				원 지금 구매
																			</button>
																			<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">
																				찜 하기
																			</button>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<button class="orderbtn" type="submit">무료 지금 구매</button>
																	<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">찜 하기
																	</button>
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:when>
								<%--로그인 안했을 때  --%>
								<c:otherwise>
									<c:choose>
										<c:when test="${gameInfo.freegameyn ne 'y'}">
											<c:choose>
												<%-- 할인 중인가? --%>
												<c:when test="${gameInfo.specialofferyn eq 'y'}">
													<button class="orderbtn" type="button" onclick="loginAlert()">
														<f:formatNumber value="${gameInfo.price2}" type="currency" />
														원 지금 구매
													</button>
													<button class="wishlistbtn" type="button"
																				onclick="loginAlert()">찜 하기</button>
												</c:when>
												<%-- 할인 아닐 때 --%>
												<c:otherwise>
													<button class="orderbtn" type="button" onclick="loginAlert()">
														<f:formatNumber value="${gameInfo.price1}" type="currency" />
														원 지금 구매
													</button>
													<button class="wishlistbtn" type="button"
																				onclick="loginAlert()">찜 하기</button>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<button class="orderbtn" type="button" onclick="loginAlert()">무료
												지금 구매</button>
											<button class="wishlistbtn" type="button" onclick="loginAlert()">찜 하기
											</button>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
			
						</div>
						<!-- 게임에 관하여  -->
						<div class="subject">
							<h2>게임에 관하여</h2>
						</div>
						<div class="aboutgame">
							<c:forEach var="mainimage" items="${gameInfo.main}">
								<div style="width: 30%; margin: 10px; overflow: hidden;">
									<img src="/store/image/main/${mainimage}" style="width: 100%;" />
								</div>
							</c:forEach>
							<p style="color: #c2c2c2;">${gameInfo.content2}</p>
						</div>
						<div class="subject">
							<h2>시스템 요구 사항</h2>
						</div>
						<div class="systemrequirement">
							<div>
								<h2>최소 사양</h2>
								<hr style="margin-top: 20px;">
								<p>
									<b>OS : </b>${gameInfo.min_os}</p>
								<p>
									<b>Processor : </b>${gameInfo.min_processor}</p>
								<p>
									<b>Memory : </b>${gameInfo.min_memory}</p>
								<p>
									<b>Graphic : </b>${gameInfo.min_vga}</p>
								<p>
									<b>Storage : </b>${gameInfo.min_storage}</p>
							</div>
							<div>
								<h2>권장 사양</h2>
								<hr style="margin-top: 20px;">
								<p>
									<b>OS : </b>${gameInfo.max_os}</p>
								<p>
									<b>Processor : </b>${gameInfo.max_processor}</p>
								<p>
									<b>Memory : </b>${gameInfo.max_memory}</p>
								<p>
									<b>Graphic : </b>${gameInfo.max_vga}</p>
								<p>
									<b>Storage : </b>${gameInfo.max_storage}</p>
							</div>
						</div>
						<!--지원 언어 -->
						<div class="subject">
							<h2>지원 언어</h2>
						</div>
						<div class="supportlanguage">
							<table>
								<tr>
									<th style="width: 15%;">Language</th>
									<th style="width: 25%;">Voice</th>
									<th style="width: 25%;">UI</th>
									<th style="width: 25%;">Subtitle</th>
								</tr>
								<tr>
									<td>KR</td>
									<td>O</td>
									<td>O</td>
									<td>O</td>
								</tr>
								<tr>
									<td>EN</td>
									<td>O</td>
									<td>O</td>
									<td>O</td>
								</tr>
							</table>
						</div>
						
						
						<div class="subject">
							<h2 id="movehere">고객 리뷰</h2>
						</div>
						<div class="customerreview">
							<div style="width: 60%;">
								<div style="padding: 20px;">
									<p>종합 평가</p>
									<p style="margin-top: 20px;">
										<b style="font-size: 2em;"> <c:choose>
												<c:when test="${gameInfo.userrate > '90'}">
												꼭 해봐야 함
											</c:when>
												<c:when
													test="${gameInfo.userrate <='90' and gameInfo.userrate > '70'}">
												완전 재밌는 게임
											</c:when>
												<c:when
													test="${gameInfo.userrate <= '70' and gameInfo.userrate > '50'}">
												꽤 괜찮은 편
											</c:when>
												<c:when test="${gameInfo.rate1+gameInfo.rate2 == '0'}">
												평가가 존재하지 않음
											</c:when>
												<c:otherwise>
												문제가 있음
											</c:otherwise>
											</c:choose>
										</b>&nbsp;&nbsp;(총 ${gameInfo.rate1+gameInfo.rate2}개의 평가)
									</p>
								</div>
							</div>
							<div style="width: 40%; height: 124px; background: #525252;">
								<div style="padding: 20px;">
									<p>평가 유형</p>
									<p style="margin-top: 20px;">
										<input name="reviewcheck" type="radio" value="rate1"
											onclick="rateView(1)" checked="checked" /> <b
											style="font-size: 2em; margin-left: 10px;">전체</b> <input
											name="reviewcheck" type="radio" value="rate2"
											style="margin-left: 20px;" onclick="rateView(2)" /> <b
											style="font-size: 2em; margin-left: 10px;">긍정적</b> <input
											name="reviewcheck" type="radio" value="rate3"
											style="margin-left: 20px;" onclick="rateView(3)" /> <b
											style="font-size: 2em; margin-left: 10px;">부정적</b>
									</p>
								</div>
							</div>
						</div>
						<c:choose>
							<c:when test="${loginInfo==null}">
								<div class="customerreview" style="padding: 20px;">
									<p align="center">로그인 후 리뷰를 남겨보세요!</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:choose>
									<%-- 라이브러리에 있는가 --%>
									<c:when test="${libraryyn eq 'y'}">
										<c:choose>
											<%--리뷰를 작성하였는가--%>
											<c:when test="${reviewExist eq 'y'}">
												<div class="customerreview" style="padding: 20px;">
													<p align="center">이미 리뷰를 작성하였습니다.</p>
												</div>
											</c:when>
											<c:otherwise>
												<div class="customerreview" style="padding: 20px;">
													<h3>리뷰 작성</h3>
													<p style="margin: 20px 0px;">
														<input name="rate" type="radio" value="1"
															style="width: 1.5em;" checked="checked" /><b
															style="font-size: 26px; margin-left: 20px;">재미있어요!</b> <input
															name="rate" type="radio" value="2"
															style="width: 1.5em; margin-left: 20px;" /><b
															style="font-size: 26px; margin-left: 20px;">재미없어요..</b>
													</p>
													<textarea name="content" id="reviewWriteContent" rows="10" maxlength="1000"
														style="width: 100%;"></textarea>
													<button type="button"
														style="margin-top: 20px; padding: 10px 20px; float: right;"
														onclick="reviewAdd()">작성완료</button>
												</div>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<div class="customerreview" style="padding: 20px;">
											<p align="center">게임을 보유하지 않아 리뷰를 쓸 수 없습니다.</p>
										</div>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
			
						<c:choose>
							<%--게임에 리뷰가 있다면?--%>
							<c:when test="${gameReviews!=null}">
								<c:forEach var="reviewInfo" items="${gameReviews}">
									<c:choose>
										<%--긍정리뷰라면--%>
										<c:when test="${reviewInfo.rate eq'1'}">
											<div class="customerreview1" id="gameReview${reviewInfo.rseq}">
												<div class="customerreview">
													<div class="customerreviewleftdiv"
														style="width: 30%; float: left;">
														<div style="padding: 20px;">
															<div
																style="box-sizing: border-box; width: 100px; height: 100px; border: 1px solid black; overflow: hidden; float: left">
																<img src="/store/image/profile/${reviewInfo.image}"
																	style="width: 100%;" ondragstart="return false;" />
															</div>
															<div style="margin-left: 20px;">
																<h2>${reviewInfo.name}</h2>
																<p style="margin-top: 20px;">보유 게임 :
																	${reviewInfo.gamenumb}개</p>
															</div>
														</div>
													</div>
													<div class="customerreviewrightdiv"
														style="width: 70%; background: #525252">
														<div style="padding: 20px; width: 90%">
															<div>
																<img src="/store/image/icon/rate_good.png"
																	style="float: left" /> <b
																	style="float: left; font-size: 2em; margin-top: 10px;">&nbsp;추천
																	합니다.</b>
															</div>
															<div style="width: 100%; margin: 20px 0;">
																<hr>
															</div>
															<div style="float: left;">
																<p>${reviewInfo.content}</p>
															</div>
															<div style="width: 100%; margin: 20px 0;">
																<hr>
															</div>
			
															<c:choose>
																<c:when test="${loginInfo!=null}">
																	<div style="float: left; width: 100%;">
																		<c:choose>
																			<c:when test="${gameReviewsRate!=null}">
																				<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
																				<c:forEach var="reviewRate" items="${gameReviewsRate}">
																					<c:if test="${reviewRate.rseq==reviewInfo.rseq}">
																						<c:set var="correctRseq" value="${reviewRate.rate}" />
																					</c:if>
																				</c:forEach>
																				<c:choose>
																					<c:when test="${correctRseq eq '1'}">
																						<c:set var="correctRseq" value="null" />
																						<button type="button" name='reviewbtn'
																							style="color: gray; width: 100px; outline: none;"
																							onclick="cancelRate(${reviewInfo.rseq},1)">
																							좋아요 취소</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:when>
																					<c:when test="${correctRseq eq '2'}">
																						<c:set var="correctRseq" value="null" />
																						<button type="button" name='reviewbtn'
																							style="color: gray; width: 100px; outline: none;"
																							onclick="cancelRate(${reviewInfo.rseq},2)">
																							싫어요 취소</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:when>
																					<c:otherwise>
																						<button type="button" name='reviewbtn'
																							onclick="reviewRate(${reviewInfo.rseq},1)">
																							<img src="/store/image/icon/rate_good.png"
																								style="background: transparent; width: 100%" />
																						</button>
																						<button type="button" name='reviewbtn'
																							style="margin-left: 20px;"
																							onclick="reviewRate(${reviewInfo.rseq},2)">
																							<img src="/store/image/icon/rate_bad.png"
																								style="background: transparent; width: 100%" />
																						</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:otherwise>
																				</c:choose>
			
																			</c:when>
																			<c:otherwise>
																				<button type="button" name='reviewbtn'
																					onclick="reviewRate(${reviewInfo.rseq},1)">
																					<img src="/store/image/icon/rate_good.png"
																						style="background: transparent; width: 100%" />
																				</button>
																				<button type="button" name='reviewbtn'
																					style="margin-left: 20px;"
																					onclick="reviewRate(${reviewInfo.rseq},2)">
																					<img src="/store/image/icon/rate_bad.png"
																						style="background: transparent; width: 100%" />
																				</button>
																				<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																					좋아요를 눌렀어요.</b>
																			</c:otherwise>
																		</c:choose>
																		<!--로그인한 계정이 리뷰를 작성한 계정이라면  -->
																		<c:if test="${loginInfo.mail==reviewInfo.mail}">
																			<button type="button" class='deletereviewbtn'
																				style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
																				onclick="delReivew(${reviewInfo.rseq},1)">리뷰 삭제
																			</button>
																		</c:if>
																	</div>
																</c:when>
																<c:otherwise>
																	<div style="float: left;">
																		<button type="button" name='reviewbtn'
																			onclick="loginAlert()">
																			<img src="/store/image/icon/rate_good.png"
																				style="background: transparent; width: 100%" />
																		</button>
																		<button type="button" name='reviewbtn'
																			style="margin-left: 20px;" onclick="loginAlert()">
																			<img src="/store/image/icon/rate_bad.png"
																				style="background: transparent; width: 100%" />
																		</button>
																		<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																			좋아요를 눌렀어요.</b>
																	</div>
																</c:otherwise>
															</c:choose>
			
														</div>
													</div>
												</div>
											</div>
										</c:when>
			
										<%--부정리뷰라면--%>
										<c:otherwise>
											<div id="customerreview2" class="customerreview2">
												<div class="customerreviewleftdiv" id="gameReview${reviewInfo.rseq}"
													style="width: 30%; float: left;">
													<div style="padding: 20px;">
														<img src="/store/image/profile/${reviewInfo.image}"
															style="width: 100px; max-height: 100px; overflow: hidden; border: 1px solid black; float: left"
															ondragstart="return false;" />
														<div style="margin-left: 20px;">
															<h2>${reviewInfo.name}</h2>
															<p style="margin-top: 20px;">보유 게임 :
																${reviewInfo.gamenumb}개</p>
														</div>
													</div>
												</div>
												<div class="customerreviewrightdiv"
													style="width: 70%; background: #525252">
													<div style="padding: 20px; width: 90%">
														<div>
															<img src="/store/image/icon/rate_bad.png"
																style="float: left" /> <b
																style="float: left; font-size: 2em; margin-top: 10px;">&nbsp;추천하지
																않아요.</b>
														</div>
														<div style="width: 100%; margin: 20px 0;">
															<hr>
														</div>
														<div style="float: left;">
															<p>${reviewInfo.content}</p>
														</div>
														<div style="width: 100%; margin: 20px 0;">
															<hr>
														</div>
			
														<c:choose>
															<c:when test="${loginInfo!=null}">
																<div style="float: left; width: 100%;">
																	<c:choose>
																		<c:when test="${gameReviewsRate!=null}">
																			<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
																			<c:forEach var="reviewRate" items="${gameReviewsRate}">
																				<c:if test="${reviewRate.rseq==reviewInfo.rseq}">
																					<c:set var="correctRseq" value="${reviewRate.rate}" />
																				</c:if>
																			</c:forEach>
			
																			<c:choose>
																				<c:when test="${correctRseq eq '1'}">
																					<c:set var="correctRseq" value="null" />
																					<button type="button" name='reviewbtn'
																						style="color: gray; width: 100px; outline: none;"
																						onclick="cancelRate(${reviewInfo.rseq},1)">
																						좋아요 취소</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:when>
																				<c:when test="${correctRseq eq '2'}">
																					<c:set var="correctRseq" value="null" />
																					<button type="button" name='reviewbtn'
																						style="color: gray; width: 100px; outline: none;"
																						onclick="cancelRate(${reviewInfo.rseq},2)">
																						싫어요 취소</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:when>
			
																				<c:otherwise>
																					<button type="button" name='reviewbtn'
																						onclick="reviewRate(${reviewInfo.rseq},1)">
																						<img src="/store/image/icon/rate_good.png"
																							style="background: transparent; width: 100%" />
																					</button>
																					<button type="button" name='reviewbtn'
																						style="margin-left: 20px;"
																						onclick="reviewRate(${reviewInfo.rseq},2)">
																						<img src="/store/image/icon/rate_bad.png"
																							style="background: transparent; width: 100%" />
																					</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:otherwise>
																			</c:choose>
			
																		</c:when>
																		<c:otherwise>
																			<button type="button" name='reviewbtn'
																				onclick="reviewRate(${reviewInfo.rseq},1)">
																				<img src="/store/image/icon/rate_good.png"
																					style="background: transparent; width: 100%" />
																			</button>
																			<button type="button" name='reviewbtn'
																				style="margin-left: 20px;"
																				onclick="reviewRate(${reviewInfo.rseq},2)">
																				<img src="/store/image/icon/rate_bad.png"
																					style="background: transparent; width: 100%" />
																			</button>
																			<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																				좋아요를 눌렀어요.</b>
																		</c:otherwise>
																	</c:choose>
																	<!--로그인한 계정이 리뷰를 작성한 계저잉라면  -->
																	<c:if test="${loginInfo.mail==reviewInfo.mail}">
																		<button type="button" class='deletereviewbtn'
																			style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
																			onclick="delReivew(${reviewInfo.rseq},2)">리뷰 삭제</button>
																	</c:if>
																</div>
															</c:when>
															<c:otherwise>
																<div style="float: left;">
																	<button type="button" name='reviewbtn'
																		onclick="loginAlert()">
																		<img src="/store/image/icon/rate_good.png"
																			style="background: transparent; width: 100%" />
																	</button>
																	<button type="button" name='reviewbtn'
																		style="margin-left: 20px;" onclick="loginAlert()">
																		<img src="/store/image/icon/rate_bad.png"
																			style="background: transparent; width: 100%" />
																	</button>
																	<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																		좋아요를 눌렀어요.</b>
																</div>
															</c:otherwise>
														</c:choose>
			
													</div>
												</div>
											</div>
										</c:otherwise>
			
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="customerreview" style="padding: 20px;">
									<p align="center">아직 사용자들이 남긴 리뷰가 없습니다..</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					</div>
					<c:if test="${param.scrollNum != null}">
						<script type="text/javascript">
							var scrollY = getParameterByName('scrollNum');
							window.scrollTo({top:scrollY, behavior:'auto'});
						</script>
					</c:if>
				</c:otherwise>	
			</c:choose>
		</c:when>
		<%-- 18세 게임이 아니면 --%>
		<c:otherwise>
					<c:if test="${param.check eq 'added'}">
						<script type="text/javascript">
							alert("장바구니에 상품이 추가 되었습니다!");
						</script>
					</c:if>
					<div id="visibleDiv">
					<div class="indexcenterdiv">
						<div class="sortdiv">
							<a href="search.go?searchContent=All">모든 게임</a>&nbsp;>&nbsp;<a
								href="javascript:void(0)"
								onclick="gameSearchGo('${gameInfo.genre}')">${gameInfo.genre}</a>&nbsp;>&nbsp;${gameInfo.name}
							<h1>${gameInfo.name}</h1>
						</div>
						<div class="simpleinformationdiv">
							<div style="width: 60%; height: 515px; overflow: hiden; float: left">
								<img src="/store/image/keyart/${gameInfo.keyart}"
									style="width: 100%; display: block" />
							</div>
							<div class="simpleinformationrightdiv"
								style="float: left; width: 40%; height: 32em;">
								<div style="height: 20em; padding: 20px;">
									<div
										style="overflow: hidden; height: 220px; border: 1px solid black;">
										<img src="/store/image/main/${gameInfo.main[0]}"
											style="width: 100%" />
									</div>
									<p>
										<b>게임 평가 : </b>
										<c:choose>
			
											<c:when test="${gameInfo.userrate > '90'}">
												<a href="javascript:void(0)" onclick="showReview()">꼭 해봐야 함&nbsp;</a>
											</c:when>
											<c:when
												test="${gameInfo.userrate <='90' and gameInfo.userrate > '70'}">
												<a href="javascript:void(0)" onclick="showReview()">완전 재밌는 게임&nbsp;</a>
											</c:when>
											<c:when
												test="${gameInfo.userrate <= '70' and gameInfo.userrate > '50'}">
												<a href="javascript:void(0)" onclick="showReview()">꽤 괜찮은 편&nbsp;</a>
											</c:when>
											<c:when test="${gameInfo.rate1+gameInfo.rate2 == 0}">
												<a href="javascript:void(0)" onclick="showReview()">평가가 존재하지 않음&nbsp;</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0)" onclick="showReview()">문제가 있음&nbsp;</a>
											</c:otherwise>
										</c:choose>
										<b>(${gameInfo.rate1+gameInfo.rate2} 개의 평가)</b>
									<p>
									<p>
										<b>출시 날짜 : </b>${gameInfo.releasedate}
									<p>
									<p>
										<b>개발사 : </b><a href="javascript:void(0)"
											onclick="gameSearchGo('${gameInfo.developer}')">${gameInfo.developer}</a>
									</p>
									<p>
										<b>웅영 체제 : </b>
										<c:choose>
											<c:when test="${gameInfo.platform eq '1'}">
											윈도우
										</c:when>
											<c:when test="${gameInfo.platform eq '1,2'}">
											윈도우, 맥
										</c:when>
											<c:when test="${gameInfo.platform eq '2'}">
											맥
										</c:when>
											<c:otherwise>
											기타 플랫폼
										</c:otherwise>
										</c:choose>
									</p>
									<p>
										<b>태그: </b>
										<c:forEach var="gameTag" items="${gameInfo.tag}">
											<c:if test="${gameTag != null}">
												<a href="javascript:void(0)"
													onclick="gameSearchGo('${gameTag}')">#${gameTag}</a>
											</c:if>
										</c:forEach>
									</p>
								</div>
							</div>
						</div>
						<div class="orderdiv" style="margin: 20px auto; padding: 20px;">
							<h2 style="float: left; padding-top: 6px;">${gameInfo.name}
								구매하기</h2>
							<%-- 결제 버튼창 분기 --%>
							<c:choose>
								<%-- 로그인 했을 때 결제 버튼창--%>
								<c:when test="${loginInfo.mail!=null}">
									<c:choose>
										<c:when test="${libraryyn eq 'y'}">
											<button class="orderbtn" type="button"
												onclick="location.href='library.go'">구매 함 라이브러리로 이동</button>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${orderyn eq 'y'}">
													<button class="orderbtn" type="button"
														onclick="location.href='orders.go'">결제 대기중 결제하기</button>
												</c:when>
												<c:otherwise>
													<c:choose>
														<%-- 찜목록에 있는가? --%>
														<c:when test="${wishlistyn eq 'y'}">
															<c:choose>
																<c:when test="${gameInfo.freegameyn eq 'y'}">
																	<button class="orderbtn" type="submit">무료 지금 구매</button>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<%-- 할인 중인가? --%>
																		<c:when test="${gameInfo.specialofferyn eq 'y'}">
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price2}"
																					type="currency" />
																				원 지금 구매
																			</button>
																		</c:when>
																		<%-- 할인 아닐 때 --%>
																	<c:otherwise>
																		<button class="orderbtn" type="submit">
																			<f:formatNumber value="${gameInfo.price1}"
																				type="currency" />
																			원 지금 구매
																		</button>
																	</c:otherwise>
																	</c:choose>
																</c:otherwise>
															</c:choose>
															<button class="wishlistbtn"
															style="background: #darkgray; cursor: default;"
															type="button" disabled>
																이미 찜함
															</button>
														</c:when>
														<c:otherwise>
															<c:choose>
																<c:when test="${gameInfo.freegameyn ne 'y'}">
																	<c:choose>
																		<%-- 할인 중인가? --%>
																		<c:when test="${gameInfo.specialofferyn eq 'y'}">
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price2}"
																					type="currency" />
																				원 지금 구매
																			</button>
																			<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">찜 하기
																			</button>
																		</c:when>
																		<%-- 할인 아닐 때 --%>
																		<c:otherwise>
																			<button class="orderbtn" type="submit">
																				<f:formatNumber value="${gameInfo.price1}"
																					type="currency" />
																				원 지금 구매
																			</button>
																			<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">
																				찜 하기
																			</button>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<button class="orderbtn" type="submit">무료 지금 구매</button>
																	<button class="wishlistbtn" type="button"
																				onclick="wishlistGo()">찜 하기
																	</button>
																</c:otherwise>
															</c:choose>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>
								</c:when>
								<%--로그인 안했을 때  --%>
								<c:otherwise>
									<c:choose>
										<c:when test="${gameInfo.freegameyn ne 'y'}">
											<c:choose>
												<%-- 할인 중인가? --%>
												<c:when test="${gameInfo.specialofferyn eq 'y'}">
													<button class="orderbtn" type="button" onclick="loginAlert()">
														<f:formatNumber value="${gameInfo.price2}" type="currency" />
														원 지금 구매
													</button>
													<button class="wishlistbtn" type="button"
																				onclick="loginAlert()">찜 하기</button>
												</c:when>
												<%-- 할인 아닐 때 --%>
												<c:otherwise>
													<button class="orderbtn" type="button" onclick="loginAlert()">
														<f:formatNumber value="${gameInfo.price1}" type="currency" />
														원 지금 구매
													</button>
													<button class="wishlistbtn" type="button"
																				onclick="loginAlert()">찜 하기</button>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<button class="orderbtn" type="button" onclick="loginAlert()">무료
												지금 구매</button>
											<button class="wishlistbtn" type="button" onclick="loginAlert()">찜 하기
											</button>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
			
						</div>
						<!-- 게임에 관하여  -->
						<div class="subject">
							<h2>게임에 관하여</h2>
						</div>
						<div class="aboutgame">
							<c:forEach var="mainimage" items="${gameInfo.main}">
								<div style="width: 30%; margin: 10px; overflow: hidden;">
									<img src="/store/image/main/${mainimage}" style="width: 100%;" />
								</div>
							</c:forEach>
							<p style="color: #c2c2c2;">${gameInfo.content2}</p>
						</div>
						<div class="subject">
							<h2>시스템 요구 사항</h2>
						</div>
						<div class="systemrequirement">
							<div>
								<h2>최소 사양</h2>
								<hr style="margin-top: 20px;">
								<p>
									<b>OS : </b>${gameInfo.min_os}</p>
								<p>
									<b>Processor : </b>${gameInfo.min_processor}</p>
								<p>
									<b>Memory : </b>${gameInfo.min_memory}</p>
								<p>
									<b>Graphic : </b>${gameInfo.min_vga}</p>
								<p>
									<b>Storage : </b>${gameInfo.min_storage}</p>
							</div>
							<div>
								<h2>권장 사양</h2>
								<hr style="margin-top: 20px;">
								<p>
									<b>OS : </b>${gameInfo.max_os}</p>
								<p>
									<b>Processor : </b>${gameInfo.max_processor}</p>
								<p>
									<b>Memory : </b>${gameInfo.max_memory}</p>
								<p>
									<b>Graphic : </b>${gameInfo.max_vga}</p>
								<p>
									<b>Storage : </b>${gameInfo.max_storage}</p>
							</div>
						</div>
						<!--지원 언어 -->
						<div class="subject">
							<h2>지원 언어</h2>
						</div>
						<div class="supportlanguage">
							<table>
								<tr>
									<th style="width: 15%;">Language</th>
									<th style="width: 25%;">Voice</th>
									<th style="width: 25%;">UI</th>
									<th style="width: 25%;">Subtitle</th>
								</tr>
								<tr>
									<td>KR</td>
									<td>O</td>
									<td>O</td>
									<td>O</td>
								</tr>
								<tr>
									<td>EN</td>
									<td>O</td>
									<td>O</td>
									<td>O</td>
								</tr>
							</table>
						</div>
						
						
						<div id="movehere" class="subject">
							<h2>고객 리뷰</h2>
						</div>
						<div class="customerreview">
							<div style="width: 60%;">
								<div style="padding: 20px;">
									<p>종합 평가</p>
									<p style="margin-top: 20px;">
										<b style="font-size: 2em;"> <c:choose>
												<c:when test="${gameInfo.userrate > '90'}">
												꼭 해봐야 함
											</c:when>
												<c:when
													test="${gameInfo.userrate <='90' and gameInfo.userrate > '70'}">
												완전 재밌는 게임
											</c:when>
												<c:when
													test="${gameInfo.userrate <= '70' and gameInfo.userrate > '50'}">
												꽤 괜찮은 편
											</c:when>
												<c:when test="${gameInfo.rate1+gameInfo.rate2 == '0'}">
												평가가 존재하지 않음
											</c:when>
												<c:otherwise>
												문제가 있음
											</c:otherwise>
											</c:choose>
										</b>&nbsp;&nbsp;(총 ${gameInfo.rate1+gameInfo.rate2}개의 평가)
									</p>
								</div>
							</div>
							<div style="width: 40%; height: 124px; background: #525252;">
								<div style="padding: 20px;">
									<p>평가 유형</p>
									<p style="margin-top: 20px;">
										<input name="reviewcheck" type="radio" value="rate1"
											onclick="rateView(1)" checked="checked" /> <b
											style="font-size: 2em; margin-left: 10px;">전체</b> <input
											name="reviewcheck" type="radio" value="rate2"
											style="margin-left: 20px;" onclick="rateView(2)" /> <b
											style="font-size: 2em; margin-left: 10px;">긍정적</b> <input
											name="reviewcheck" type="radio" value="rate3"
											style="margin-left: 20px;" onclick="rateView(3)" /> <b
											style="font-size: 2em; margin-left: 10px;">부정적</b>
									</p>
								</div>
							</div>
						</div>
						<c:choose>
							<c:when test="${loginInfo==null}">
								<div class="customerreview" style="padding: 20px;">
									<p align="center">로그인 후 리뷰를 남겨보세요!</p>
								</div>
							</c:when>
							<c:otherwise>
								<c:choose>
									<%-- 라이브러리에 있는가 --%>
									<c:when test="${libraryyn eq 'y'}">
										<c:choose>
											<%--리뷰를 작성하였는가--%>
											<c:when test="${reviewExist eq 'y'}">
												<div class="customerreview" style="padding: 20px;">
													<p align="center">이미 리뷰를 작성하였습니다.</p>
												</div>
											</c:when>
											<c:otherwise>
												<div class="customerreview" style="padding: 20px;">
													<h3>리뷰 작성</h3>
													<p style="margin: 20px 0px;">
														<input name="rate" type="radio" value="1"
															style="width: 1.5em;" checked="checked" /><b
															style="font-size: 26px; margin-left: 20px;">재미있어요!</b> <input
															name="rate" type="radio" value="2"
															style="width: 1.5em; margin-left: 20px;" /><b
															style="font-size: 26px; margin-left: 20px;">재미없어요..</b>
													</p>
													<textarea name="content" id="reviewWriteContent" rows="10" maxlength="1000"
														style="width: 100%;"></textarea>
													<button type="button"
														style="margin-top: 20px; padding: 10px 20px; float: right;"
														onclick="reviewAdd()">작성완료</button>
												</div>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<div class="customerreview" style="padding: 20px;">
											<p align="center">게임을 보유하지 않아 리뷰를 쓸 수 없습니다.</p>
										</div>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
			
						<c:choose>
							<%--게임에 리뷰가 있다면?--%>
							<c:when test="${gameReviews!=null}">
								<c:forEach var="reviewInfo" items="${gameReviews}">
									<c:choose>
										<%--긍정리뷰라면--%>
										<c:when test="${reviewInfo.rate eq'1'}">
											<div class="customerreview1" id="gameReview${reviewInfo.rseq}">
												<div class="customerreview">
													<div class="customerreviewleftdiv"
														style="width: 30%; float: left;">
														<div style="padding: 20px;">
															<div
																style="box-sizing: border-box; width: 100px; height: 100px; border: 1px solid black; overflow: hidden; float: left">
																<img src="/store/image/profile/${reviewInfo.image}"
																	style="width: 100%;" ondragstart="return false;" />
															</div>
															<div style="margin-left: 20px;">
																<h2>${reviewInfo.name}</h2>
																<p style="margin-top: 20px;">보유 게임 :
																	${reviewInfo.gamenumb}개</p>
															</div>
														</div>
													</div>
													<div class="customerreviewrightdiv"
														style="width: 70%; background: #525252">
														<div style="padding: 20px; width: 90%">
															<div>
																<img src="/store/image/icon/rate_good.png"
																	style="float: left" /> <b
																	style="float: left; font-size: 2em; margin-top: 10px;">&nbsp;추천
																	합니다.</b>
															</div>
															<div style="width: 100%; margin: 20px 0;">
																<hr>
															</div>
															<div style="float: left;">
																<p>${reviewInfo.content}</p>
															</div>
															<div style="width: 100%; margin: 20px 0;">
																<hr>
															</div>
			
															<c:choose>
																<c:when test="${loginInfo!=null}">
																	<div style="float: left; width: 100%;">
																		<c:choose>
																			<c:when test="${gameReviewsRate!=null}">
																				<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
																				<c:forEach var="reviewRate" items="${gameReviewsRate}">
																					<c:if test="${reviewRate.rseq==reviewInfo.rseq}">
																						<c:set var="correctRseq" value="${reviewRate.rate}" />
																					</c:if>
																				</c:forEach>
																				<c:choose>
																					<c:when test="${correctRseq eq '1'}">
																						<c:set var="correctRseq" value="null" />
																						<button type="button" name='reviewbtn'
																							style="color: gray; width: 100px; outline: none;"
																							onclick="cancelRate(${reviewInfo.rseq},1)">
																							좋아요 취소</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:when>
																					<c:when test="${correctRseq eq '2'}">
																						<c:set var="correctRseq" value="null" />
																						<button type="button" name='reviewbtn'
																							style="color: gray; width: 100px; outline: none;"
																							onclick="cancelRate(${reviewInfo.rseq},2)">
																							싫어요 취소</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:when>
																					<c:otherwise>
																						<button type="button" name='reviewbtn'
																							onclick="reviewRate(${reviewInfo.rseq},1)">
																							<img src="/store/image/icon/rate_good.png"
																								style="background: transparent; width: 100%" />
																						</button>
																						<button type="button" name='reviewbtn'
																							style="margin-left: 20px;"
																							onclick="reviewRate(${reviewInfo.rseq},2)">
																							<img src="/store/image/icon/rate_bad.png"
																								style="background: transparent; width: 100%" />
																						</button>
																						<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																							좋아요를 눌렀어요.</b>
																					</c:otherwise>
																				</c:choose>
			
																			</c:when>
																			<c:otherwise>
																				<button type="button" name='reviewbtn'
																					onclick="reviewRate(${reviewInfo.rseq},1)">
																					<img src="/store/image/icon/rate_good.png"
																						style="background: transparent; width: 100%" />
																				</button>
																				<button type="button" name='reviewbtn'
																					style="margin-left: 20px;"
																					onclick="reviewRate(${reviewInfo.rseq},2)">
																					<img src="/store/image/icon/rate_bad.png"
																						style="background: transparent; width: 100%" />
																				</button>
																				<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																					좋아요를 눌렀어요.</b>
																			</c:otherwise>
																		</c:choose>
																		<!--로그인한 계정이 리뷰를 작성한 계정이라면  -->
																		<c:if test="${loginInfo.mail==reviewInfo.mail}">
																			<button type="button" class='deletereviewbtn'
																				style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
																				onclick="delReivew(${reviewInfo.rseq},1)">리뷰 삭제
																			</button>
																		</c:if>
																	</div>
																</c:when>
																<c:otherwise>
																	<div style="float: left;">
																		<button type="button" name='reviewbtn'
																			onclick="loginAlert()">
																			<img src="/store/image/icon/rate_good.png"
																				style="background: transparent; width: 100%" />
																		</button>
																		<button type="button" name='reviewbtn'
																			style="margin-left: 20px;" onclick="loginAlert()">
																			<img src="/store/image/icon/rate_bad.png"
																				style="background: transparent; width: 100%" />
																		</button>
																		<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																			좋아요를 눌렀어요.</b>
																	</div>
																</c:otherwise>
															</c:choose>
			
														</div>
													</div>
												</div>
											</div>
										</c:when>
			
										<%--부정리뷰라면--%>
										<c:otherwise>
											<div id="customerreview2" class="customerreview2">
												<div class="customerreviewleftdiv" id="gameReview${reviewInfo.rseq}"
													style="width: 30%; float: left;">
													<div style="padding: 20px;">
														<img src="/store/image/profile/${reviewInfo.image}"
															style="width: 100px; max-height: 100px; overflow: hidden; border: 1px solid black; float: left"
															ondragstart="return false;" />
														<div style="margin-left: 20px;">
															<h2>${reviewInfo.name}</h2>
															<p style="margin-top: 20px;">보유 게임 :
																${reviewInfo.gamenumb}개</p>
														</div>
													</div>
												</div>
												<div class="customerreviewrightdiv"
													style="width: 70%; background: #525252">
													<div style="padding: 20px; width: 90%">
														<div>
															<img src="/store/image/icon/rate_bad.png"
																style="float: left" /> <b
																style="float: left; font-size: 2em; margin-top: 10px;">&nbsp;추천하지
																않아요.</b>
														</div>
														<div style="width: 100%; margin: 20px 0;">
															<hr>
														</div>
														<div style="float: left;">
															<p>${reviewInfo.content}</p>
														</div>
														<div style="width: 100%; margin: 20px 0;">
															<hr>
														</div>
			
														<c:choose>
															<c:when test="${loginInfo!=null}">
																<div style="float: left; width: 100%;">
																	<c:choose>
																		<c:when test="${gameReviewsRate!=null}">
																			<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
																			<c:forEach var="reviewRate" items="${gameReviewsRate}">
																				<c:if test="${reviewRate.rseq==reviewInfo.rseq}">
																					<c:set var="correctRseq" value="${reviewRate.rate}" />
																				</c:if>
																			</c:forEach>
			
																			<c:choose>
																				<c:when test="${correctRseq eq '1'}">
																					<c:set var="correctRseq" value="null" />
																					<button type="button" name='reviewbtn'
																						style="color: gray; width: 100px; outline: none;"
																						onclick="cancelRate(${reviewInfo.rseq},1)">
																						좋아요 취소</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:when>
																				<c:when test="${correctRseq eq '2'}">
																					<c:set var="correctRseq" value="null" />
																					<button type="button" name='reviewbtn'
																						style="color: gray; width: 100px; outline: none;"
																						onclick="cancelRate(${reviewInfo.rseq},2)">
																						싫어요 취소</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:when>
			
																				<c:otherwise>
																					<button type="button" name='reviewbtn'
																						onclick="reviewRate(${reviewInfo.rseq},1)">
																						<img src="/store/image/icon/rate_good.png"
																							style="background: transparent; width: 100%" />
																					</button>
																					<button type="button" name='reviewbtn'
																						style="margin-left: 20px;"
																						onclick="reviewRate(${reviewInfo.rseq},2)">
																						<img src="/store/image/icon/rate_bad.png"
																							style="background: transparent; width: 100%" />
																					</button>
																					<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																						좋아요를 눌렀어요.</b>
																				</c:otherwise>
																			</c:choose>
			
																		</c:when>
																		<c:otherwise>
																			<button type="button" name='reviewbtn'
																				onclick="reviewRate(${reviewInfo.rseq},1)">
																				<img src="/store/image/icon/rate_good.png"
																					style="background: transparent; width: 100%" />
																			</button>
																			<button type="button" name='reviewbtn'
																				style="margin-left: 20px;"
																				onclick="reviewRate(${reviewInfo.rseq},2)">
																				<img src="/store/image/icon/rate_bad.png"
																					style="background: transparent; width: 100%" />
																			</button>
																			<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																				좋아요를 눌렀어요.</b>
																		</c:otherwise>
																	</c:choose>
																	<!--로그인한 계정이 리뷰를 작성한 계저잉라면  -->
																	<c:if test="${loginInfo.mail==reviewInfo.mail}">
																		<button type="button" class='deletereviewbtn'
																			style="color: lightgray; float: right; width: 15%; outline: none; padding: 10px 20px;"
																			onclick="delReivew(${reviewInfo.rseq},2)">리뷰 삭제</button>
																	</c:if>
																</div>
															</c:when>
															<c:otherwise>
																<div style="float: left;">
																	<button type="button" name='reviewbtn'
																		onclick="loginAlert()">
																		<img src="/store/image/icon/rate_good.png"
																			style="background: transparent; width: 100%" />
																	</button>
																	<button type="button" name='reviewbtn'
																		style="margin-left: 20px;" onclick="loginAlert()">
																		<img src="/store/image/icon/rate_bad.png"
																			style="background: transparent; width: 100%" />
																	</button>
																	<b style="margin-left: 20px;">${reviewInfo.rate1}명이
																		좋아요를 눌렀어요.</b>
																</div>
															</c:otherwise>
														</c:choose>
			
													</div>
												</div>
											</div>
										</c:otherwise>
			
									</c:choose>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="customerreview" style="padding: 20px;">
									<p align="center">아직 사용자들이 남긴 리뷰가 없습니다..</p>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
					</div>
					<c:if test="${param.scrollNum != null}">
						<script type="text/javascript">
							var scrollY = getParameterByName('scrollNum');
							window.scrollTo({top:scrollY, behavior:'auto'});
						</script>
					</c:if>
				</c:otherwise>	
	
		</c:choose>
	</form>
</body>
</html>