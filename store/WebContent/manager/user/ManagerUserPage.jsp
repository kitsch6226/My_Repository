<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		if(confirm("정말 탈퇴처리 하시겠어요?")){
			var chkbox = document.getElementsByName('num');
			var gseq = ""
			var result = null;
			for (var i = 0; i < chkbox.length; i++) {
				if (chkbox[i].checked) {
					result = true;
				}
			}
			//하나도 체크가 안되어있을 시
			if (result == null) {
				alert("유저를 먼저 선택해 주세요!");
			} else {
				document.frm2.enctype = "application/x-www-form-urlencoded";
				document.frm2.action = "userDeleteManager.go";
				document.frm2.submit();
			}
		}
	}
	function modiUser(num){
		document.frm2.action = "updateUserManager.go?num="+num;
		document.frm2.submit();
	}
	
	function doOpenCheck(chk){
	    var obj = document.getElementsByName("num");
	    for(var i=0; i<obj.length; i++){
	        if(obj[i] != chk){
	            obj[i].checked = false;
	        }
	    }
	}
	function searching() {
		var searchbar = document.getElementById("searchContent");
		if (searchbar.value == "" || searchbar.value == null) {
			alert("검색어를 입력해주세요!");
			return;
		}else{
			searchbar.value = "User:"+searchbar.value;
		}

		var frmheader = document.getElementById("Userfrm");
		frmheader.action = "searchManager.go";
		frmheader.submit();
	}
	
</script>
</head>
<body onload="InitStaticMenu()">
	<form name="frm" id="frm" method="post" enctype="multipart/form-data">
		<div id="staticMenu">
			<table>
				<tr>
					<td colspan="100%" style="padding: 10px 0px;"><input
						type="button" value="탈퇴처리" style="padding: 10px;'"
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
				style="font-size: 2em; font-weight: bold; padding-top: 6px; float: left">&nbsp;유저
				현황</p>

			<form method="post" id="Userfrm" onsubmit="searching()">
				<!--검색창-->
				<div class="searchdiv">
					<button id="searchbtn" type="button" onclick="searching()">
						<img src="/store/image/icon/search.png"
							ondragstart="return false;" />
					</button>
					<input type="text" id="searchContent" name="searchContent"
						maxlength="30" onsubmit="searching()" title="최소 1글자를 입력해 주세요"
						placeholder="번호/이름/메일" required />
				</div>
			</form>

			<c:if test="${searchTitle!=null}">
				<br>
				<p style="float: left">&nbsp;검색어 : ${searchTitle}</p>
			</c:if>
			<form name="frm2" id="frm2" method="post"
				enctype="multipart/form-data">
				<div class="centermiddle">
					<table class="carttable"
						style="background-color: white; border-spacing: 0px; width: 100%; margin-top: 20px;">
						<tr style="background-color: #e3e3e3; width: 100%;">
							<th align="center" style="width: 4%; padding: 4px;">
								&nbsp;선택</th>
							<th style="width: 3%;">유저번호</th>
							<th style="width: 14%;">이미지</th>
							<th style="width: 14%;">메일</th>
							<th style="width: 14%;">이름</th>
							<th style="width: 16%;">보유게임수</th>
							<th style="width: 14%;">존재</th>
							<th style="width: 14%;">가입일</th>
							<th style="width: 14%;">수정일</th>
						</tr>
						<c:choose>
							<c:when test="${users!=null}">
								<c:forEach var="userInfo" items="${users}">
									<tr style="height: 3em;">
										<td class="tdd" align="center"><input type="checkbox"
											name="num" value="${userInfo.num}"
											onclick="doOpenCheck(this)" /></td>
										<td class="tdd" align="center">${userInfo.num}</td>
										<td class="tdd" align="center">
											<div
												style="width: 50px; height: 50px; border: 1px solid black; background: #474747; overflow: hidden;">
												<img src="/store/image/profile/${userInfo.image}"
													style="width: 100%; display: block"
													ondragstart="return false" />
											</div>
										</td>
										<td class="tdd" align="center">${userInfo.mail}</td>
										<td class="tdd" align="center">
											<div style="width: 400px;">
												<a href="javascript:void(0)"
													onclick="modiUser(${userInfo.num})"> <b>${userInfo.name}</b>
												</a>
											</div>
										</td>
										<td class="tdd" align="center">${userInfo.gamenumb}</td>
										<td class="tdd" align="center">${userInfo.useyn}</td>
										<td class="tdd" align="center">${userInfo.indate}</td>
										<td class="tdd" align="center"><c:choose>
												<c:when test="${userInfo.modidate!=null}">
											${userInfo.modidate}
											</c:when>
												<c:otherwise>
											수정 안함
											</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="100%" style="text-align: center; padding: 10px;"><b>등록된
											유저가 없어요!</b></td>
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
							onclick="checkDel();">선택 유저 탈퇴처리</button>
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>