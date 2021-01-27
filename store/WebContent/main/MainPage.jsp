<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지금 여기 오구! 게임 플랫폼</title>
<link rel="shortcut icon" type="image/x-icon" href="/store/image/icon/favicon.ico" />
<style type="text/css">
*{
margin:0;
padding:0;
}
</style>
</head>
<body style="background-color: #1f1f1f;">


	<jsp:include page="../master/HeaderPage.jsp"/>
	<!-- 메인 인덱스 페이지 -->
	<c:if test="${param.kind eq '' or param.kind == null}">
		<jsp:include page="../main/IndexPage.jsp"/>
	</c:if>
	<!-- 게임 상세 페이지 -->
	<c:if test="${param.kind eq 'gamedetail'}">
		<jsp:include page="../game/GameDetailPage.jsp"/>
	</c:if>
	<!-- 오더 페이지 -->
	<c:if test="${param.kind eq 'order'}">
		<jsp:include page="../order/OrderPage.jsp"/>
	</c:if>
	<!-- 라이브러리 페이지 -->
	<c:if test="${param.kind eq 'library'}">
		<jsp:include page="../library/LibraryPage.jsp"/>
	</c:if>
	<!-- 찜 목록 -->
	<c:if test="${param.kind eq 'wishlist'}">
		<jsp:include page="../order/WishListPage.jsp"/>
	</c:if>
	<!-- 뉴스 페이지 -->
	<c:if test="${param.kind eq 'news'}">
		<jsp:include page="../news/NewsPage.jsp"/>
	</c:if>
	<!-- 서포트 페이지 -->
	<c:if test="${param.kind eq 'support'}">
		<jsp:include page="../support/SupportPage.jsp"/>
	</c:if>
	<!-- 서포트1:1문의 페이지 -->
	<c:if test="${param.kind eq 'supportone'}">
		<jsp:include page="../support/SupportWritePage.jsp"/>
	</c:if>
	<!-- 서포트 답변 상세 페이지 -->
	<c:if test="${param.kind eq 'supportqnadetail'}">
		<jsp:include page="../support/SupportQnaDetailPage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'accountsetting'}">
		<jsp:include page="../member/AccountSettingPage.jsp"/>
	</c:if>
	<!-- 검색 결과 페이지 -->
	<c:if test="${param.kind eq 'search'}">
		<jsp:include page="../game/SearchPage.jsp"/>
	</c:if>
	<!-- 커뮤니티 페이지 -->
	<c:if test="${param.kind eq 'community'}">
		<jsp:include page="../community/CommunityPage.jsp"/>
	</c:if>
	
	<jsp:include page="../master/FooterPage.jsp"/>
</body>
</html>