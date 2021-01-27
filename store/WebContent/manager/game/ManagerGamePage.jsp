<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon"
	href="/webapp/market/img/favicon.ico" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.searchdiv {
	width: 20%;
	height: 48px;
	float: right;
	background-color: #474747;
	border-radius: 6px;
}

#searchContent {
	float: right;
	width: 86%;
	height: 100%;
	border: none;
	background-color: transparent;
	outline: none;
	color: #f2f2f2;
}

#searchContent::placeholder {
	color: #919191;
}

#searchbtn {
	border-radius: 6px;
	border: 1px solid gray;
	width: 48px;
	height: 48px;
	position: absolute;
	background-color: transparent;
	outline: none;
	border: none;
	cursor: pointer;
}

#searchbtn img {
	height: 50%;
}

.carttable th {
	border-top: 1px solid darkgray;
	border-bottom: 1px solid darkgray;
}

.carttable a:link, .carttable a:visited {
	color: black;
	text-decoration: none;
}

.carttable a:hover, .carttable a:hover {
	text-decoration: underline;
}

.tdd {
	border-left: 1px solid lightgray;
	border-bottom: 1px solid darkgray;
}

.priceinput1, .priceinput2 {
	border: none;
	font-size: 16px;
	text-align: center;
	outline: none;
	background-color: none;
}

.priceinput1 {
	display: none;
}

#staticMenu {
	margin: 0;
	padding: 20px;
	position: absolute;
	right: 0px;
	top: 0px;
	background-color: #dadada;
	border-radius: 6px;
}
</style>
<script type="text/javascript">
	var stmnSide = 40;//스테틱 메뉴 좌 혹은 우 여백
	var stmnGap = 0;
	var stmnTop = 300;
	var stmnActivSpd = 10; //스크롤 인식하는 딜레이 크면 느림
	var stmnScrollSpd = 2; //스크롤의 속도 크면 느림

	function InitStaticMenu() {
		//리프레쉬를 대비 새롭게 값을 구해와야하기 때문에 변수로 쓰지 않는다.
		document.getElementById('staticMenu').style.right = stmnSide + 'px'
		document.getElementById('staticMenu').style.top = document.body.scrollTop
				+ stmnTop + 'px';
		RefreshStaticMenu();

	}

	function RefreshStaticMenu() {
		//시작 포인트와 엔드 포인트 설정
		var startPoint, endPoint
		startPoint = parseInt(document.getElementById('staticMenu').style.top,
				10);
		endPoint = Math.max(document.documentElement.scrollTop,
				document.body.scrollTop)
				+ stmnTop;
		if (endPoint < stmnGap)
			endPoint = stmnGap;
		if (startPoint != endPoint) {
			var stmnScrollAmt = Math.ceil(Math.abs(startPoint - endPoint) / 15);
			document.getElementById('staticMenu').style.top = parseInt(document
					.getElementById('staticMenu').style.top, 10)
					+ ((endPoint < startPoint) ? -stmnScrollAmt : stmnScrollAmt)
					+ 'px';
		}
		//refresh 펑션을 작동하게 하는 타이머
		var stmnTimer = setTimeout("RefreshStaticMenu();", stmnActivSpd);
	}
	function toTop() {
		window.scrollTo({
			top : 0,
			left : 0,
			behavior : 'smooth'
		});
	}
	function toBottom() {
		var limit = document.querySelector("#mainbody").offsetHeight;
		window.scrollTo({
			top : limit,
			left : 0,
			behavior : 'smooth'
		});
	}

	//선택상자 선택여부 확인
	function checkDel() {
		if (confirm("정말 숨김처리 하시겠어요?")) {
			var chkbox = document.getElementsByName('gseq');
			var gseq = ""
			var result = null;
			for (var i = 0; i < chkbox.length; i++) {
				if (chkbox[i].checked) {
					result = true;
				}
			}
			//하나도 체크가 안되어있을 시
			if (result == null) {
				alert("상품을 먼저 선택해 주세요!");
			} else {
				document.frm2.enctype = "application/x-www-form-urlencoded";
				document.frm2.action = "deleteGame.go";
				document.frm2.submit();
			}
		}
	}

	function doOpenCheck(chk) {
		var obj = document.getElementsByName("gseq");
		for (var i = 0; i < obj.length; i++) {
			if (obj[i] != chk) {
				obj[i].checked = false;
			}
		}
	}
	function searching() {
		var searchbar = document.getElementById("searchContent");
		if (searchbar.value == "" || searchbar.value == null) {
			alert("검색어를 입력해주세요!");
			return;
		} else {
			searchbar.value = "Game:" + searchbar.value;
		}

		var frmheader = document.getElementById("Gamefrm");
		frmheader.action = "searchManager.go";
		frmheader.submit();
	}

	function searchingGo(value) {
		var frmheader = document.getElementById("Gamefrm");
		frmheader.action = "searchManager.go?searchContent=Game:" + value;
		frmheader.submit();
	}
</script>
</head>
<body id="mainbody" onload="InitStaticMenu()">
	<form action="addGamePage.go" name="frm" id="frm" method="post"
		enctype="multipart/form-data">
		<div id="staticMenu">
			<table>
				<tr>
					<td colspan="100%" style="padding: 10px 0px;"><input
						type="submit" value="게임 등록" style="padding: 10px;'" /></td>
				</tr>
				<tr>
					<td colspan="100%" style="padding: 10px 0px;"><input
						type="button" value="게임 숨김" style="padding: 10px;'"
						onclick="checkDel();" /></td>
				</tr>
				<tr style="width: 90%; margin: 0 auto;">
					<td align="center"><input name="gototop" type="button"
						value="▲" onclick="toTop();" style="padding: 11px;'" /></td>
					<td align="center"><input name="gotobottom" type="button"
						value="▼" onclick="toBottom();" style="padding: 11px;'" /></td>
				</tr>
			</table>
		</div>
	</form>
	<div class="center" style="min-height: 600px; padding-top: 90px;">
		<div class="wrapper"
			style="margin: 0 auto; border-radius: 6px; width: 80%;">
			<h1 style="float: left;">
				<img src="/webapp/market/img/product.png" style="width: 1.5em" />
			</h1>
			<p
				style="font-size: 2em; font-weight: bold; padding-top: 6px; float: left">&nbsp;게임
				현황</p>
			<form method="post" id="Gamefrm" onsubmit="searching()">
				<div class="searchdiv">
					<button id="searchbtn" type="button" onclick="searching()">
						<img src="/store/image/icon/search.png"
							ondragstart="return false;" />
					</button>
					<input type="text" id="searchContent" name="searchContent"
						maxlength="30" onsubmit="searching()" title="최소 1글자를 입력해 주세요"
						placeholder="이름,번호,무료,특가" required />
				</div>
			</form>
			<c:if test="${searchTitle!=null}">
				<br>
				<p style="float: left">&nbsp;검색어 : ${searchTitle}</p>
			</c:if>
			<form action="addGamePage.go" name="frm2" id="frm2" method="post"
				enctype="multipart/form-data">
				<div class="centermiddle">
					<table class="carttable"
						style="background-color: white; border-spacing: 0px; width: 100%; margin-top: 20px;">
						<tr style="background-color: #e3e3e3; width: 100%;">
							<th align="center" style="width: 4%; padding: 4px;">
								&nbsp;선택</th>
							<th style="width: 2%;">번호</th>
							<th style="width: 1%">장르</th>
							<th style="width: 7%;">keyart</th>
							<th style="width: 20%;">이름</th>
							<th style="width: 15%;">태그</th>
							<th style="width: 10%;">가격1</th>
							<th style="width: 10%;">가격2</th>
							<th style="width: 5%">추천1</th>
							<th style="width: 5%">추천2</th>
							<th style="width: 2%">광고</th>
							<th style="width: 2%">특가</th>
							<th style="width: 2%">무료</th>
							<th style="width: 5%">플랫폼</th>
							<th style="width: 2%">존재</th>
							<th style="width: 15%;">출시 일자</th>
						</tr>
						<c:choose>
							<c:when test="${allgames!=null}">
								<c:forEach var="gameInfo" items="${allgames}">
									<tr style="height: 3em;">
										<td class="tdd" align="center"><input type="checkbox"
											name="gseq" value="${gameInfo.gseq}"
											onclick="doOpenCheck(this)" /></td>
										<td class="tdd" align="center">${gameInfo.gseq}</td>
										<td class="tdd" align="center">${gameInfo.genre}</td>
										<td class="tdd" align="center"><img
											src="/store/image/keyart/${gameInfo.keyart}"
											style="width: 5em;" /></td>
										<td class="tdd" align="center"><a
											href="updateGame.go?gseq=${gameInfo.gseq}"> <b>${gameInfo.name}</b>
										</a></td>
										<td class="tdd" align="center"><c:forEach var="gameTag"
												items="${gameInfo.tag}">
												<c:if test="${gameTag != null}">
													<a href="javascript:void(0)"
														onclick="searchingGo('${gameTag}')"> #${gameTag} </a>
													<br>
												</c:if>
											</c:forEach></td>
										<td class="tdd" align="center"><fmt:formatNumber
												value="${gameInfo.price1}" type="currency" />원</td>
										<td class="tdd" align="center"><fmt:formatNumber
												value="${gameInfo.price2}" type="currency" />원</td>
										<td class="tdd" align="center">${gameInfo.rate1}</td>
										<td class="tdd" align="center">${gameInfo.rate2}</td>
										<td class="tdd" align="center">${gameInfo.adgameyn}</td>
										<td class="tdd" align="center">${gameInfo.specialofferyn}</td>
										<td class="tdd" align="center">${gameInfo.freegameyn}</td>
										<td class="tdd" align="center">${gameInfo.platform}</td>
										<td class="tdd" align="center">${gameInfo.useyn}</td>
										<td class="tdd" align="center">${gameInfo.releasedate}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="100%" style="text-align: center; padding: 10px;"><b>등록된
											게임이 없어요!</b></td>
								</tr>
							</c:otherwise>
						</c:choose>
						<tr></tr>
						<tr style="width: 100%; background-color: #e3e3e3;">
							<td colspan="100%" align="right"
								style="padding: 14px; border-top: 1px solid darkgray; border-bottom: 1px solid darkgray;">
							</td>
						</tr>

					</table>
					<p>
						<button type="button" style="margin: 20px 0px; padding: 10px;"
							onclick="checkDel();">선택 게임 숨김</button>
						<button type="submit"
							style="margin: 20px 0px; padding: 10px; float: right;">게임
							등록</button>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>