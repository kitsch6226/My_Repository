<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
	margin:0;
	padding:0;
}
.indexcenterdiv {
	width: 80%;
	height: 100%;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
}
.sortbtndiv{
	margin-left:20px;
	float:left;
}
.sortlist{
	float:left;
	padding:10px;
	width:6%;
	border-radius:6px;
	background:#474747;
	display:none;
	position:absolute;
	box-shadow: 0px 3px 6px 3px rgba(0, 0, 0, 0.7);
}
.sortlist li{
	color:gray;
	padding:10px 0px;
	text-align:center;
	list-style:none;
}
.sortbtn{
	width:100%;
	height:3.2em;
	color:lightgray;
	padding:10px 20px;
	border:1px solid #ffea00;
	border-radius:6px;
	background:transparent;
	outline:none;
}
.sortbtndiv:hover .sortlist{
	display:block;
}
.sortbtn:hover{
	background:#ffea00;
	color:black;
}
.indexcenterdiv a{
	color: #c2c2c2;
	text-decoration:none;
}
.indexcenterdiv li:hover a{
	color:white;
}
.newsdiv,.newsdivOgu,.newsdivLaunching,.newsdivUpdate{
	background:#474747;
	margin-top:20px;
	padding:20px;
	border-radius:6px;
	overflow:hidden;
}
.newsdiv p,.newsdivOgu p,.newsdivLaunching p,.newsdivUpdate p{
	 color:lightgray;
}
.newsdiv1{
	width:100%;
	box-sizing:border-box;
	display:table;
}

</style>
<script type="text/javascript">
function newsView(numb){
	var cr1 = document.getElementsByClassName("newsdivUpdate"); 
	var cr2 = document.getElementsByClassName("newsdivLaunching");
	var cr3 = document.getElementsByClassName("newsdivOgu"); 	
	if(numb==1){
		for(var i=0; i<cr1.length;i++){
		cr1[i].style.display="block";				
		}
		for(var i=0; i<cr2.length;i++){
		cr2[i].style.display="none";				
		}
		for(var i=0; i<cr3.length;i++){
			cr3[i].style.display="none";				
		}
	}else if(numb==2){
		for(var i=0; i<cr1.length;i++){
			cr1[i].style.display="none";				
		}
		for(var i=0; i<cr2.length;i++){
			cr2[i].style.display="block";				
		}
		for(var i=0; i<cr3.length;i++){
			cr3[i].style.display="none";				
		}
	}else if(numb==3){
		for(var i=0; i<cr1.length;i++){
			cr1[i].style.display="none";				
		}
		for(var i=0; i<cr2.length;i++){
			cr2[i].style.display="none";				
		}
		for(var i=0; i<cr3.length;i++){
			cr3[i].style.display="block";				
		}
	}else{
		for(var i=0; i<cr1.length;i++){
			cr1[i].style.display="block";				
			}
		for(var i=0; i<cr2.length;i++){
			cr2[i].style.display="block";				
		}
		for(var i=0; i<cr3.length;i++){
			cr3[i].style.display="block";				
		}
	}
}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<div class="indexcenterdiv">
		<div style="display:table; width:100%; padding-bottom:20px">
			<h1 style="float:left; color:lightgray">뉴스</h1>
			<div class="sortbtndiv">
				<input class="sortbtn" type="button" value="정렬 기준 : 최근"/>
				<div class="sortlist">
					<ul>
						<li><a href="javascript:void(0)" onclick="newsView(0)">최근</a></li>
						<li><a href="javascript:void(0)" onclick="newsView(1)">게임 업데이트</a></li>
						<li><a href="javascript:void(0)" onclick="newsView(2)">게임 런칭</a></li>
						<li><a href="javascript:void(0)" onclick="newsView(3)">오구 소식</a></li>
					</ul>
				</div>
			</div>
		</div>
		<c:choose>
			<c:when test="${newss!=null}">
			
				<c:forEach var="news" items="${newss}">
					<c:choose>
						<c:when test="${news.kind eq 'launching'}">
							<div class="newsdivLaunching">
								<div class="newsdiv1">
									<div style="width:10%; float:left;">
										<img src="/store/image/keyart/${news.keyart}" style="width:100%"/>
									</div>
									<h2 style="width:80%;float:left; color:lightgray; margin-left:20px;">${news.subject}</h2>
									<p style="width:8%; float:right;"><b style="float:right">${news.indate}</b></p>
									<p style="float:left; padding-top:30px; padding-left:20px;">${news.name}</p>
								</div>
								<hr style="margin:20px auto;">
								<div>
									<p>
										${news.content}
									</p>
								</div>
							</div>
						</c:when>
						<c:when test="${news.kind eq 'update'}">
							<div class="newsdivUpdate">
								<div class="newsdiv1">
									<div style="width:10%; float:left;">
										<img src="/store/image/keyart/${news.keyart}" style="width:100%"/>
									</div>
									<h2 style="width:80%;float:left; color:lightgray; margin-left:20px;">${news.subject}</h2>
									<p style="width:8%; float:right;"><b style="float:right">${news.indate}</b></p>
									<p style="float:left; width:140px;padding-top:30px; padding-left:20px;">${news.name}</p>
								</div>
								<hr style="margin:20px auto;">
								<div>
									<p>
										${news.content}
									</p>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="newsdivOgu">
								<div class="newsdiv1">
									<div style="width:10%; float:left;">
										<img src="/store/image/keyart/${news.keyart}" style="width:100%"/>
									</div>
									<h2 style="width:80%;float:left; color:lightgray; margin-left:20px;">${news.subject}</h2>
									<p style="width:8%; float:right;"><b style="float:right">${news.indate}</b></p>
									<p style="float:left;width:140px; padding-top:30px; padding-left:20px;">${news.name}</p>
								</div>
								<hr style="margin:20px auto;">
								<div>
									<p>
										${news.content}
									</p>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
			</c:when>
			<c:otherwise>
				<div class="newsdiv">
				<p align="center" style="padding:15%;">아직 새로운 소식이 없네요...뉴스를 기다려주세요!</p>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>