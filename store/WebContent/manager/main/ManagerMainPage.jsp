<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지금 여기 오구! 매니저 페이지</title>
<link rel="shortcut icon" type="image/x-icon" href="/store/image/icon/favicon_inversion.ico" />
<style type="text/css">
*{
	padding:0;
	margin:0;
}
</style>
<script type="text/javascript">
</script>
</head>
<body>
 	<jsp:include page="../master/ManagerHeaderPage.jsp"/> 
	<c:if test="${param.kind eq 'game' or param.kind==null}">
		<jsp:include page="../game/ManagerGamePage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'editGame'}">
		<jsp:include page="../game/ManagerGameUpdatePage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'addGame'}">
		<jsp:include page="../game/ManagerGameAddPage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'qna'}">
		<jsp:include page="../qna/QnaPage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'qnaDetail'}">
		<jsp:include page="../qna/QnaDetailPage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'user'}">
		<jsp:include page="../user/ManagerUserPage.jsp"/>
	</c:if>
	<c:if test="${param.kind eq 'editUser'}">
		<jsp:include page="../user/ManagerUserUpdatePage.jsp"/>
	</c:if>
</body>
</html>