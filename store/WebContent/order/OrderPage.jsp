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
	padding: 0;
	margin: 0;
}

.indexcenterdiv {
	width: 80%;
	height: 100%;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}

.orderinfodiv {
	border-radius: 6px;
	background: #474747;
	overflow: hidden;
}
.ordergamininfotable{
	text-align: center;
	color: lightgray;
	border-collapse:collapse;
}
.ordergamininfotable td{
	background:#383838;
}
.ordergamininfotable th{
	background:#626262;
	padding:10px 0;
}
.ordergamininfotable button{
	 float:left;
	 padding:5px 10px;
	 background:#808080;
	 border:1px solid darkgray;
	 border-radius:6px;
	 cursor:pointer;
	 outline:none;
}
.creditinfodiv{
	margin:20px 0;
	float:right;
	background:#626262;
	width:50%;
	padding:30px;
	border-radius:6px;
	box-sizing:border-box;
}
.creditinfotable{
	margin-top:20px;
	width:100%;
}
.creditinfotable th{
	color: lightgray;
	text-align:left;
	width:20%;
}
.creditinfotable tr td{
	padding:10px 0;
}
.creditinfotable input{
	border-radius:6px;
	border: 1px solid black;
	outline:none;
	height:3em; 
	margin-left:20px;
	float:left;
}
.ordersubmitbtn{
	margin-top:20px;
	border-radius:6px;
	border:1px solid black;
	cursor:pointer;
}
.ordersubmitbtn:hover{
	background:#ffdd00;
}

</style>
<script type="text/javascript">
function loginNeed(){
	alert("상품이 없네요. 둘러보고 오세요~!");
}
function uncheckAll(){
	var chkbox = document.getElementsByName('oseq');
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked) {
			chkbox[i].checked=false;
		}else{
		}
	}
}
function checkAll(){
	var chkbox = document.getElementsByName('oseq');
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked) {
		}else{
			chkbox[i].checked=true;
		}
	}
}
function checkDel() {
	var formorder = document.getElementById("orderform");
	var chkbox = document.getElementsByName('oseq');
	var oseq = ""
	var result = null;
	for (var i = 0; i < chkbox.length; i++) {
		if (chkbox[i].checked) {
			oseq = oseq + chkbox[i].value+",";
			result = true;
		}
	}
	//하나도 체크가 안되어있을 시
	if (result == null) {
		alert("상품을 먼저 선택해 주세요!");
	} else {
		formorder.action = "deleteOrders.go";
		formorder.submit();
	}
}
</script>
</head>
<body style="background-color: #1f1f1f;">
<form id="orderform" action="updateOrders.go" method="post">
	<div class="indexcenterdiv">
		<div class="orderinfodiv">
			<div style="padding:20px">
				<h2 style="color:#f2f2f2;">결제 정보</h2>
			</div>
			<table class="ordergamininfotable" style="width:100%">
				<tr>
					<th>선택</th>
					<th colspan="2">게임 정보</th>
					<th>운영 체제</th>
					<th>게임 가격</th>
				</tr>
				<c:choose>
					<c:when test="${orderInfo!=null}">
						<c:forEach var="gameInfo" items="${orderInfo}">
							<tr>
								<td style="width:5%; padding:10px; padding-top:12px;">
									<input type="checkbox" name="oseq" value="${gameInfo.oseq}"/>
									<input type="hidden" name="gseq" value="${gameInfo.gseq}"/>
								</td>
								<td style="width:10%; padding:10px; padding-top:12px;">
									<img src="/store/image/keyart/${gameInfo.keyart}" style="width: 100%;cursor:pointer" onclick="location.href='gameDetail.go?gseq=${gameInfo.gseq}'"/>
								</td>
								<td>
									<b  style="cursor:pointer;" onclick="location.href='gameDetail.go?gseq=${gameInfo.gseq}'">${gameInfo.name}</b>
								</td>
								<td>
									<c:choose>
										<c:when test="${gameInfo.platform eq '1'}">
											<b>윈도우</b>
										</c:when>
										<c:when test="${gameInfo.platform eq '1,2'}">
											<b>윈도우, 맥</b>
										</c:when>
										<c:when test="${gameInfo.platform eq '2'}">
											<b>맥</b>
										</c:when>
										<c:otherwise>
											<b>기타 플랫폼</b>
										</c:otherwise>
									 </c:choose>
								</td>
								<td>
									<b><f:formatNumber value="${gameInfo.price}" type="currency"/></b>
								</td>
							</tr>
							<tr>
								<td colspan="100%">
									<hr style="border:1px solid #626262">
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="100%" style="padding:30px">
								<b>결제 대기중인 게임이 없습니다.</b>
							</td>
						</tr>
					
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="100%" style="padding:10px 20px; background:#626262;">
						<button type="button" onclick="checkAll()">전체 선택</button>
						<button type="button" style="margin-left:20px;" onclick="uncheckAll()">전체 해제</button>
						<button type="button" style="margin-left:20px;" onclick="checkDel()">제거 하기</button>
						<b style="float:right; font-size:1.2em;margin-top:4px;">총 결제 금액 : <f:formatNumber value="${totalPrice}" type="currency"/></b>
					</td>
				</tr>
			</table>
			<div class="creditinfodiv">
				<h2 style="color:lightgray">구매 정보를 입력해 주세요.</h2>
				<table class="creditinfotable">
					<tr>
						<th>카드 번호</th>
						<td>
							<input type="text" pattern="\d{16}" title="16자리 숫자" maxlength="16" placeholder=" Credit Number" style="width:70%;" required/>
						</td>
					</tr>
					<tr>
						<th>유효 기간</th>
						<td>
							<input type="text" pattern="\d{2}" title="MM" maxlength="2" placeholder=" MM" style="width:20%" required/>
							<input type="text" pattern="\d{2}" title="YY" maxlength="2" placeholder=" YY" style="width:20%;" required/>
						</td>
					</tr>
					<tr>
						<th>생년 월일</th>
						<td>
							<input type="text" pattern="\d{6}" title="YYMMDD" maxlength="6" placeholder=" YYMMDD" style="width:43.5%;" required/>
						</td>
					</tr>
					<tr>
						<th>비밀 번호<br>앞 2자리</th>
						<td>
							<input type="text" pattern="\d{2}" title="Two Digit" maxlength="2" placeholder=" Two Digit" style="width:20%;" required/>
						</td>
					</tr>
					<tr>
						<td colspan="100%">
							<c:choose>
								<c:when test="${orderInfo!=null}">
									<input class="ordersubmitbtn" type="submit" style="width:100%; height:4em;" value="결제 하기">
								</c:when>
								<c:otherwise>
									<input class="ordersubmitbtn" type="button" style="width:100%; height:4em;" value="결제 하기" onclick="loginNeed()">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</form>
</body>
</html>