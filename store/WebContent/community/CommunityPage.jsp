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
.indexcenterdiv {
	width: 80%;
	height: 100%;
	min-height:780px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
	color:lightgray;
	box-sizing:border-box;
}
</style>
</head>
<body style="background-color: #1f1f1f;">
	<div class="indexcenterdiv">
		<h1 style="color:lightgray;">커뮤니티 : ${communityTitle}</h1>
		
		<c:if test="${param.sort eq 'artwork' or param.sort eq null}">
			<jsp:include page="CommunityArtworkPage.jsp"/>
		</c:if>
		<c:if test="${param.sort eq 'artworkwrite'}">
			<jsp:include page="CommunityArtworkWritePage.jsp"/>
		</c:if>
		<c:if test="${param.sort eq 'discussion'}">
			<jsp:include page="CommunityDiscussionPage.jsp"/>
		</c:if>
		<c:if test="${param.sort eq 'discussionwrite'}">
			<jsp:include page="CommunityDiscussionWritePage.jsp"/>
		</c:if>
		<c:if test="${param.sort eq 'discussiondetail'}">
			<jsp:include page="CommunityDiscussionDetailPage.jsp"/>
		</c:if>
			<c:if test="${param.sort eq 'discussionupdate'}">
			<jsp:include page="CommunityDiscussionUpdatePage.jsp"/>
		</c:if>
		<c:if test="${param.sort eq 'review'}">
			<jsp:include page="CommunityReviewPage.jsp"/>
		</c:if>
		
	</div>
</body>
</html>