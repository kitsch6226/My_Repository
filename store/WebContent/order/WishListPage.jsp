<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	min-height: 500px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}

.indexcenterdiv a {
	color: lightgray;
	text-decoration: none;
}

.indexcenterdiv li:hover a {
	color: white;
}

.sortbtndiv {
	margin-left: 20px;
	float: left;
}

.sortbtn {
	position: relative;
	width: 100%;
	height: 3.2em;
	color: lightgray;
	padding: 10px 20px;
	border: 1px solid #ffea00;
	border-radius: 6px;
	background: transparent;
	outline: none;
}

.sortlist {
	padding: 10px;
	width: 5%;
	border-radius: 6px;
	background: #474747;
	display: none;
	position: absolute;
	box-shadow: 0px 3px 6px 3px rgba(0, 0, 0, 0.7);
}

.sortlist li {
	color: gray;
	padding: 10px 0px;
	text-align: center;
	list-style: none;
}

.sortbtndiv:hover .sortlist {
	display: block;
}

.sortbtn:hover {
	background: #ffea00;
	color: black;
}

.orderbtn {
	color: lightgray;
	background: transparent;
	border-radius: 6px;
	border: 1px solid #ffea00;
	padding: 10px 20px;
	cursor: pointer;
}

.orderbtn:hover {
	background: #ffea00;
	color: black;
}

.wishlisttable {
	border: 0px solid black;
	border-spacing: 0px;
	text-align: center;
}
.wishlisttable td{
	color:#A9A9A9;
}
.wishlisttable b {
	color: darkgray;
}

.wishlisttable a:hover {
	color: white;
}
/*     분류 구분되는 디브            */
.SortIndate, .SortRate, .SortDiscount {
	
}

.SortRate, .SortDiscount {
	display: none;
}

.gametitlea {
	font-weight: bold;
	font-size: 1.5em;
}

.gametitlea:hover {
	color: white;
}
</style>
<script type="text/javascript">

	function checkDel() {
		var chkbox = document.getElementsByName('gseq');
		var gseq = ""
		var result = null;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				gseq = gseq + chkbox[i].value+",";
				result = true;
			}
		}
		//하나도 체크가 안되어있을 시
		if (result == null) {
			alert("상품을 먼저 선택해 주세요!");
		} else {
			document.frm.action = "deleteWishlist.go?gseq="+gseq;
			document.frm.submit();
		}
	}
	function checkOrder() {
		var chkbox = document.getElementsByName('gseq');
		var gseq = ""
		var result = null;
		for (var i = 0; i < chkbox.length; i++) {
			if (chkbox[i].checked) {
				gseq = gseq + chkbox[i].value+",";
				result = true;
			}
		}
		//하나도 체크가 안되어있을 시
		if (result == null) {
			alert("상품을 먼저 선택해 주세요!");
		} else {
			document.frm.action = "addOrders.go";
			document.frm.submit();
		}
	}
	function gameDetailGo(num){
		window.location.href="gameDetail.go?gseq="+num;
	}


</script>
</head>
<body style="background-color: #1f1f1f;">
	<form name="frm" method="post">
		<c:if test="${param.wish eq 'already'}">
			<script>
		if(confirm("이미 결제 창에 있는 게임이 있습니다.\n결제 창으로 이동하시겠어요?")){
			window.location.href="orders.go";
		}
			
		</script>
		</c:if>
		<div class="indexcenterdiv">
			<div style="width: 100%; display: table;">
				<p
					style="width: 120px; height: 120px; max-height: 120px; float: left; background: gray; border-radius: 6px; overflow: hidden;">
					<img src="/store/image/profile/${loginInfo.image}"
						style="width: 100%" ondragstart="return false;" />
				</p>
				<div
					style="margin-top: 78px; margin-left: 20px; display: table; float: left">
					<h2
						style="position: relative; padding-top: 12px; float: left; color: lightgray;">${loginInfo.name}
						님의 찜 목록</h2>
					<div class="sortbtndiv">
						<input class="sortbtn" id="sortbtn" type="button"
							value="정렬 기준 : ${wishlistSort}" />
						<div class="sortlist">
							<ul>
								<li><a href="wishlist.go?sort=indate">최근</a></li>
								<li><a href="wishlist.go?sort=rate">평가</a></li>
								<li><a href="wishlist.go?sort=discount">할인율</a></li>
							</ul>
						</div>
					</div>
				</div>
				<p style="float: right; margin-top: 80px; margin-left: 20px;">
					<button type="button" class="orderbtn" onclick="checkDel()">선택삭제</button>
					<button type="button" class="orderbtn" onclick="checkOrder()">선택주문</button>
				</p>
			</div>
			<c:choose>
				<c:when test="${wishlistGames!=null}">
					<c:forEach var="gameInfo" items="${wishlistGames}">
						<div class="SortIndate"
							style="background: #525252; border-radius: 6px; overflow: hidden; margin-top: 20px;">
							<table class="wishlisttable">
								<tr>
									<td rowspan="5"
										style="width: 5%; zoom: 1.5; border-right: 2px solid black;">
										<input name="gseq" type="checkbox" value="${gameInfo.gseq}"
										onclick="doOpenCheck(this)" />
									</td>
									<td rowspan="5"
										style="width: 25%; padding: 20px; border-right: 2px solid black;">
										<div
											style="margin: 0 auto; width: 380px; overflow: hidden;cursor:pointer; border: 1px solid black;">
											<img src="/store/image/keyart/${gameInfo.keyart}"
												style="width: 100%; display: block"
												onclick="gameDetailGo(${gameInfo.gseq})" />
										</div>
									</td>
								</tr>
								<tr style="">
									<td colspan="2"
										style="padding-left: 20px; text-align: left; width: 60%; border-bottom: 2px solid black;">
										<a class="gametitlea" href="javascript:void(0)" onclick="gameDetailGo(${gameInfo.gseq})">
											${gameInfo.name} </a>
									</td>
								</tr>
								<tr>
									<td
										style="padding-left: 20px; text-align: left; width: 30%; border-bottom: 2px solid black; border-right: 2px solid black;">
										<b>게임 평가 : </b> <c:choose>
											<c:when test="${gameInfo.userrate > '90'}">
												꼭 해봐야 함&nbsp;
											</c:when>
											<c:when
												test="${gameInfo.userrate <='90' and gameInfo.userrate > '70'}">
												완전 재밌는 게임&nbsp;
											</c:when>
											<c:when
												test="${gameInfo.userrate <= '70' and gameInfo.userrate > '50'}">
												꽤 괜찮은 편&nbsp;
											</c:when>
											<c:when test="${gameInfo.userrate == '0'}">
												평가가 존재하지 않음&nbsp;
											</c:when>
											<c:otherwise>
												문제가 있음&nbsp;
											</c:otherwise>
										</c:choose>
									</td>
									<td
										style="padding-left: 20px; text-align: left; width: 30%; border-bottom: 2px solid black;">
										<b
										style="color: #ffea00; font-size: 1em; padding: 10px; background: #1f1f1f; border-radius: 8px;"><f:formatNumber
												value="${gameInfo.price}" type="currency" /> 원</b>
									</td>
								</tr>
								<tr>
									<td
										style="padding-left: 20px; text-align: left; width: 30%; border-bottom: 2px solid black; border-right: 2px solid black;">
										<b>운영 체제 : </b> <c:choose>
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
									</td>
									<td
										style="padding-left: 20px; text-align: left; width: 30%; border-bottom: 2px solid black;">
										<b
										style="color: #ffea00; font-size: 1em; padding: 10px; background: #1f1f1f; border-radius: 8px;">
											<c:choose>
												<c:when test="${gameInfo.price eq 0}">
												무료 게임이에요.
											</c:when>
												<c:otherwise>
													<c:if test="${gameInfo.discountrate > '0'}">
													${gameInfo.discountrate}% 할인율
												</c:if>
													<c:if test="${gameInfo.discountrate eq ''}">
													할인중이 아닙니다.											
												</c:if>
												</c:otherwise>
											</c:choose>
									</b>
									</td>
								</tr>
								<tr>
									<td
										style="padding-left: 20px; text-align: left; width: 30%; border-right: 2px solid black;">
										<b>태그: </b> <c:if test="${gameInfo.tag[0] != null}">
											<a href="#">#${gameInfo.tag[0]}</a>
										</c:if> <c:if test="${gameInfo.tag[1] != null}">, <a href="#">#${gameInfo.tag[1]}</a>
										</c:if> <c:if test="${gameInfo.tag[2] != null}">, <a href="#">#${gameInfo.tag[2]}</a>
										</c:if> <c:if test="${gameInfo.tag[3] != null}">, <a href="#">#${gameInfo.tag[3]}</a>
										</c:if>
									</td>
									<td style="padding-left: 20px; text-align: left; width: 30%;">
										<b>찜 한 날짜 : ${gameInfo.indate}</b>
									</td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<p align="center" style="margin-top: 10%; color: #c2c2c2">
						<b>아직 찜한 게임이 없어요! 게임을 둘러보는건 어떨까요?</b>
					</p>
				</c:otherwise>
			</c:choose>			
		</div>
	</form>
</body>
</html>