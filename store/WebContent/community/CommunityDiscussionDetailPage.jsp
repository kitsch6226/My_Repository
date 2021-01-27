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
}
.titletable td,.titletable2 td{
	padding:5px 0px;
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
	function discussionReple(dseq){
		var writeContent = document.getElementById("replyWriteContent");
		if(writeContent.value==null||writeContent.value==""){
			alert("댓글 내용을 작성해 주세요!");
			return;
		}
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="addDiscussionReple.go?dseq="+dseq+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdiscussion.submit();
	}
	function discussionRate(dseq,ratebtn){
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="discussionRate.go?dseq="+dseq+"&ratebtn="+ratebtn+"&scrollNum="+document.scrollingElement.scrollTop;;
		frmdiscussion.submit();	
	}
	function discussionCancelRate(dseq,ratebtn){
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="cancelDiscussionRate.go?dseq="+dseq+"&ratebtn="+ratebtn+"&scrollNum="+document.scrollingElement.scrollTop;;
		frmdiscussion.submit();	
	}
	
	function discussionRepleRate(reseq,ratebtn){
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="discussionRepleRate.go?reseq="+reseq+"&ratebtn="+ratebtn+"&scrollNum="+document.scrollingElement.scrollTop;;
		frmdiscussion.submit();	
	}
	function discussionRepleCancelRate(reseq,ratebtn){
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="cancelDiscussionRepleRate.go?reseq="+reseq+"&ratebtn="+ratebtn+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdiscussion.submit();	
	}
	function showEditReply(numb){
		var repleTableId = "titletable"+numb
		var repleEditTableId = "titletableEdit"+numb
		var reply = document.getElementById(repleTableId);
		var replyEdit = document.getElementById(repleEditTableId);
		if(reply.style.display=="none"){
			reply.style.display="table";
		}else{
			reply.style.display="none"
		}
		if(replyEdit.style.display=="table"){
			replyEdit.style.display="none";
		}else{
			replyEdit.style.display="table";
		}
	}
	//리플 수정
	function editReply(reseq){
		var thisReple = 'editReplyContent'+reseq;
		var editReple = document.getElementById('editReplyContent'+reseq);
		var editReples = document.getElementsByName("editReplyContent");

		//alert(editReples.length);
		for(var i=0;i<editReples.length;i++){
			//alert("순서대로 아이디: "+thisReple+" : "+editReples[i].id+" , "+editReples[i].value);
			if(editReples[i].id==thisReple){
				//alert("계속");
			}else{
				//alert("지움");
				editReples[i].value="";
			}
		}
		
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="updateDiscussionReple.go?reseq="+reseq+"&scrollNum="+document.scrollingElement.scrollTop;
		frmdiscussion.submit();
	}
	function deleteReply(reseq){
		if(confirm("정말 삭제하시겠어요?")){
			var frmdiscussion = document.getElementById("discussionform");
			frmdiscussion.action="deleteDiscussionReple.go?reseq="+reseq+"&scrollNum="+document.scrollingElement.scrollTop;
			frmdiscussion.submit();	
		}
	}
	function deleteDiscussion(dseq){
		if(confirm("정말 삭제하시겠어요?")){
			var frmdiscussion = document.getElementById("discussionform");
			frmdiscussion.action="deleteDiscussion.go?dseq="+dseq;
			frmdiscussion.submit();				
		}
	}
	function discussionUpdate(dseq){
		var frmdiscussion = document.getElementById("discussionform");
		frmdiscussion.action="updateDiscussion.go?dseq="+dseq;
		frmdiscussion.encoding="multipart/form-data";
		frmdiscussion.submit();	
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
		<form method="post" id="discussionform">
			<div class="center" style="min-height:600px">
				<div class="centermiddle" style="padding-bottom:10px; width:100%; height:100%; margin:0 auto; display:table">
					<hr style="margin:10px auto;">
					<input type="hidden" name="dseq" value="${discussion.dseq}"/>
					<table class="titletable">
						<tr>
							<td align="center" style="border-right:1px solid darkgray;width:10%;">제 목</td>
							<td colspan="100%" style="padding-left:10px;">
								<p>${discussion.subject}</p>
							</td>
						</tr>
						<tr style="background-color: #474747;">
							<td align="center" style="border-right:1px solid darkgray;">작성자</td>
							<td style="padding-left:10px;">${discussion.name}</td>
							<td align="center" style="width:10%; border-right:1px solid darkgray;">작성일</td>
							<td style="padding-left:10px;">${discussion.indate}</td>
						</tr>
						<tr>
							<td align="center" style="border-right:1px solid darkgray;">
								조회수
							</td>
							<td style="padding-left:10px;">
								${discussion.view}
							</td>
						</tr>
					</table>
					<table style="margin:0 auto; width:100%; min-height:100px; height:100%; border-radius:6px; text-align:center;">
						<c:if test="${discussion.image[0] != ''}">
							<c:forEach var="discussionImage" items="${discussion.image}">
								<tr>
									<td style="padding:10px 0px; width:5%;">
										<img src="/store/image/discussion/${discussionImage}" style="width:25%; float:left"/>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<tr>
							<td style="padding:10px 0px;"><p align="left">${discussion.content}</p></td>
						</tr>
						<tr>
						</tr>
					</table>
					<c:choose>
						<c:when test="${loginInfo!=null}">
							<c:choose>
									<c:when test="${discussionRates!=null}">
										<!-- 여기가 중요 여기서 해당 리뷰에 대한 평가가 있었는지 체크해준다. -->
										<c:forEach var="discussionRate" items="${discussionRates}">
											<c:if test="${discussionRate.dseq==discussion.dseq}">
												<c:set var="correctDseq" value="${discussionRate.rate}"/>
											</c:if>
										</c:forEach>
										<c:choose>
											<c:when test="${correctDseq eq '1'}">
												<c:set var="correctDseq" value="null"/>
												<div style="display:table;margin: 0 auto;">
													<button type="button" class="discussionbtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="discussionCancelRate(${discussion.dseq},1)">
														좋아요 취소
													</button>
												</div>
											</c:when>
											<c:when test="${correctDseq eq '2'}">
												<c:set var="correctDseq" value="null"/>
												<div style="display:table; margin: 0 auto;">
													<button type="button" class="discussionbtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="discussionCancelRate(${discussion.dseq},2)">
														싫어요 취소
													</button>
												</div>
											</c:when>
											<c:otherwise>
												<div style="display:table; margin: 0 auto;">
													<button class="discussionbtn" type="button" onclick="discussionRate(${discussion.dseq},1)">
														<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
													</button>
													<button class="discussionbtn" type="button" style="margin-left:20px;" onclick="discussionRate(${discussion.dseq},2)">
														<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
													</button>
												</div>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<div style="display:table; margin: 0 auto;">
											<button class="discussionbtn" type="button" onclick="discussionRate(${discussion.dseq},1)">
												<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
											</button>
											<button class="discussionbtn" type="button" style="margin-left:20px;" onclick="discussionRate(${discussion.dseq},2)">
												<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
											</button>
										</div>
									</c:otherwise>
							</c:choose>
						</c:when>
						<c:otherwise>
							<div style="display:table; margin: 0 auto;">
								<button class="discussionbtn" type="button" onclick="loginAlert()">
									<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
								</button>
								<button class="discussionbtn" type="button" style="margin-left:20px;" onclick="loginAlert()">
									<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
								</button>
							</div>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${discussion.rate1 == 0}">
							<p style="display:table; margin:20px auto;"><b>아직 좋아요가 없어요... 의견에 반응을 보여주세요!</b></p>
						</c:when>
						<c:otherwise>
							<p style="display:table; margin:20px auto;"><b>${discussion.rate1}</b>명이 좋아요를 눌렀어요.</p>
						</c:otherwise>
					</c:choose>
					<hr>
					<c:if test="${discussion.mail==loginInfo.mail}">
					<input type="button" style="float:right; margin-top:10px; margin-left:10px; padding:5px 20px;" value="수 정" onclick="discussionUpdate(${discussion.dseq})"/>
					<input type="button" style="float:right; margin-top:10px; padding:5px 20px;" value="삭 제" onclick="deleteDiscussion(${discussion.dseq})"/>
					</c:if>
					<input type="button" style="float:left; margin-top:10px; padding:5px 20px;" value="목 록" onclick="location.href='discussion.go'"/>
				</div>
				
				<!--댓글 div -->
				<c:choose>
					<c:when test="${loginInfo != null}">
						<div class="centermiddle" style="width:100%; height:100%; margin:0 auto; display:table">
							<hr style="margin-bottom:10px;">
							<h3>의견 작성</h3>
							<table class="titletable">
								<tr>
									<td>내 용</td>
								</tr>
								<tr>
									<td colspan="100%"  style="padding-top:10px;">
										<textarea name="reply" id="replyWriteContent"rows="5"style="width:100%; resize:none;" placeholder="상대방을 향한 무분별한 인신공격, 욕설은 자제해주세요." required></textarea>
									</td>
								</tr>
							</table>
							<button name="replybtn" type="button" style="float:right; margin-top:10px; padding:5px 20px;" onclick="discussionReple(${discussion.dseq})">작 성</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="centermiddle" style="width:100%; height:100%; margin:0 auto; display:table">
							<hr style="margin-bottom:10px;">
							<p align="center" style="padding:20px;">로그인 후 의견을 달아보세요!</p>
						</div>
					</c:otherwise>
				</c:choose>	
					<c:choose>
					<c:when test="${reples==null}">
						<hr style="margin:10px 0px;">
						<div class="centermiddle" style="width:100%; height:100%; margin:0 auto; display:table">
							<p align="center" style="padding:20px;">조용하네요... 의견을 달아보세요!</p>
						</div>
					</c:when>
					<c:otherwise>
					<div class="centermiddle" style="padding:10px 0px; width:100%; height:100%; margin:0 auto; display:table">
					<hr style="margin-bottom:10px;">
						<!-- 댓글이다 -->
						<c:forEach var="reply" items="${reples}">
								
								<!--수정창 -->
								<table id="titletableEdit${reply.reseq}" class="titletable2" style="display:none; padding:14px;">
									<tr>
										<td>
											<b>${reply.name}</b>
										</td>
									</tr>
									<tr>
										<td>
											<textarea name="editReplyContent" id="editReplyContent${reply.reseq}" rows="5"style="width:100%; resize:none;" placeholder="상대방을 향한 무분별한 인신공격, 욕설은 자제해주세요.">${reply.content}</textarea>
										</td>
									</tr>
									<tr>
										<td>
											<button style="padding:6px 20px;float:right; margin-left:20px" type="button" onclick="editReply(${reply.reseq})">수 정</button>
											<button style="padding:6px 20px;float:right" type="button" onclick="showEditReply(${reply.reseq})">취 소</button>
										</td>
									</tr>
								</table>
								
								
								<table id="titletable${reply.reseq}" class="titletable" style="padding:14px;">
									<tr style="width:100%">
										<td>
											<b>${reply.name}</b>
											
										</td>
										<td style="float:right;">
											${reply.indate}
										</td>
										<c:if test="${reply.modidate!=null}">
											<td style="float:right; color:yellow; margin-right:20px;">
												수정된 리플 ${reply.modidate}
											</td>
										</c:if>
									</tr>
									<tr>
										<td colspan="100%" style="padding-top:10px;">${reply.content}</td>
									</tr>
									<tr>
										<td colspan="100%" style="padding-top:10px;">
											<c:if test="${reply.mail==loginInfo.mail}">
											<button type="button" style="float:right; padding:6px; margin-left:10px;"onclick="showEditReply(${reply.reseq})">수정</button>
											<button type="button" style="float:right; margin-left:20px; padding:6px;"onclick="deleteReply(${reply.reseq})">삭제</button>
											</c:if>			
											<div style="float:right; margin: 0 auto;">
											<b style="float:left; margin-right:20px; padding-top:12px;">${reply.rate1}개 의 좋아요</b>
												<c:choose>
													<c:when test="${loginInfo!=null}">	
															<c:choose>
																<c:when test="${discussionRepleRates!=null}">
																	<!-- 여기가 중요 여기서 해당 리플에 대한 평가가 있었는지 체크해준다. -->
																	<c:forEach var="discussionRepleRate" items="${discussionRepleRates}">
																		<c:if test="${discussionRepleRate.reseq==reply.reseq}">
																			<c:set var="correctReseq" value="${discussionRepleRate.rate}"/>
																		</c:if>
																	</c:forEach>
																	<c:choose>
																		<c:when test="${correctReseq eq '1'}">
																			<c:set var="correctReseq" value="null"/>
																			<div style="display:table; margin: 0 auto;float:right">
																				<button type="button" class="discussionreplybtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="discussionRepleCancelRate(${reply.reseq},1)">
																					좋아요 취소
																				</button>
																			</div>
																		</c:when>
																		<c:when test="${correctReseq eq '2'}">
																			<c:set var="correctReseq" value="null"/>
																			<div style="display:table; margin: 0 auto;float:right">
																				<button type="button" class="discussionreplybtn" style="color:gray; padding:10px;width:100px;outline:none;"onclick="discussionRepleCancelRate(${reply.reseq},2)">
																					싫어요 취소
																				</button>
																			</div>
																		</c:when>
																		<c:otherwise>
																			<div style="display:table; margin: 0 auto;float:right">
																				<button class="discussionreplybtn" type="button" onclick="discussionRepleRate(${reply.reseq},1)">
																					<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
																				</button>
																				<button class="discussionreplybtn" type="button" style="margin-left:20px;" onclick="discussionRepleRate(${reply.reseq},2)">
																					<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
																				</button>
																			</div>
																		</c:otherwise>
																	</c:choose>
																</c:when>
																<c:otherwise>
																	<div style="display:table; margin: 0 auto;float:right">
																		<button class="discussionreplybtn" type="button" onclick="discussionRepleRate(${reply.reseq},1)">
																			<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
																		</button>
																		<button class="discussionreplybtn" type="button" style="margin-left:20px;" onclick="discussionRepleRate(${reply.reseq},2)">
																			<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
																		</button>
																	</div>
																</c:otherwise>
														</c:choose>
													</c:when>
													<c:otherwise>
															<button class="discussionreplybtn" type="button" onclick="loginAlert()">
																<img src="/store/image/icon/rate_good.png" style="background:transparent;width:100%"/>
															</button>
															<button class="discussionreplybtn" type="button" style="margin:0px 10px;" onclick="loginAlert()">
																<img src="/store/image/icon/rate_bad.png" style="background:transparent; width:100%"/>
															</button>
													</c:otherwise>
												</c:choose>
												
											</div>
										</td>
									</tr>
								</table>
						</c:forEach>
					</div>
					</c:otherwise>
					</c:choose>
			</div>
			<c:if test="${param.scrollNum != null}">
				<script type="text/javascript">
					var scrollY = getParameterByName('scrollNum');
					window.scrollTo({top:scrollY, behavior:'auto'});
				</script>
			</c:if>
		</form>
</body>
</html>