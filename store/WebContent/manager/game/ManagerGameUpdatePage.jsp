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

.settingp {
	margin-top: 20px;
}
.editTable tr td{
	padding:4px 0;
}
</style>
<script type="text/javascript">
function fileCheck(file1){  	  // 사이즈체크
	var pathpoint1 = file1.value.lastIndexOf('.');
	var filepoint1 = file1.value.substring(pathpoint1+1,file1.length);
	var filetype1=filepoint1.toLowerCase();

    var maxSize  = 5 * 1024 * 1024    //5MB
    var fileSize1 = 0;
    var fileSize2 = 0;
// 브라우저 확인
var browser=navigator.appName;
// 익스플로러일 경우
if (browser=="Microsoft Internet Explorer")
{	
	var oas = new ActiveXObject("Scripting.FileSystemObject");
	if(file1!=null){
	fileSize1 = oas.getFile( file1.value ).size;
	}
}
// 익스플로러가 아닐경우
else
{	
	if(file1.value!=''){
		fileSize1 = file1.files[0].size;
		if(filetype1=='jpg'||filetype1=='gif'||filetype1=='png'||filetype1=='jpeg'||filetype1=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize1 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}
}
//값이 비어있는지 체크
var gameTitle  = document.getElementById("gameTitle");
var gameContent1 = document.getElementById("gameContent1");
var gameContent2 = document.getElementById("gameContent2");
var keyart = document.getElementById("keyart");
var price1 = document.getElementById("price1");
var price2 = document.getElementById("price2");
var gameTag1 = document.getElementById("gameTag1");
var gameTag2 = document.getElementById("gameTag2");
var gameTag3 = document.getElementById("gameTag3");
var gameTag4 = document.getElementById("gameTag4");
var specialofferyn = document.getElementById("specialofferyn");
var freegameyn = document.getElementById("freegameyn");
var newgameyn = document.getElementById("newgameyn");
var useyn = document.getElementById("useyn");

if(keyart.value.length>100){
	alert("파일 이름이 너무 길어요.. 최대 100자");
	return;
}
if(gameTitle.value==''||gameTitle.value==null){
	alert("게임 제목을 입력해 주세요!");
	return;
}else if(gameContent1.value==""||gameContent1.value==null){
	alert("게임 내용1를 입력해 주세요!");
	return
}else if(gameContent2.value==""||gameContent2.value==null){
	alert("게임 내용2를 입력해 주세요!");
	return
}else if(price1.value==""||price1.value==null){
	alert("가격1를 입력해 주세요!");
	return
}else if(price1.value<0||price1.value>90000){
	alert("가격1: 0원이상 9만원 이하");
	return
}else if(price2.value<0||price2.value==null){
	alert("가격2를 입력해 주세요!");
	return
}else if(price2.value<0||price2.value>80000){
	alert("가격2: 0원이상 8만원 이하");
	return
}else if(parseInt(price1.value,10)<parseInt(price2.value,10)){
	alert("가격1이 더 높게 설정해주세요...");
	return
}else if(gameTag1.value==""||gameTag1.value==null){
	alert("게임 태그1를 입력해 주세요!");
	return
}else if(gameTag2.value==""||gameTag2.value==null){
	alert("게임 태그2를 입력해 주세요!");
	return
}else if(specialofferyn.value==""||specialofferyn.value==null){
	alert("특별할인 여부를 입력해 주세요!");
	return
}else if(freegameyn.value==""||freegameyn.value==null){
	alert("무료게임 여부를 입력해 주세요!");
	return
}else if(newgameyn.value==""|newgameyn.value==null){
	alert("신작 게임 여부를 입력해 주세요!");
	return
}else if(useyn.value==""|useyn.value==null){
	alert("게임 숨김 여부를 입력해 주세요!");
	return
}


document.updatefileForm.submit();
}
function select(){
	document.getElementById("useyn").value=""
}
</script>
</head>
<body>
	<form name="updatefileForm" action="updateGame.go" method="post" enctype="multipart/form-data">
		<div class="center" style="min-height: 600px">
			<div class="centermiddle"
				style="padding: 80px; width: 80%; height: 100%; margin: 0 auto;">
				<h1>게임 수정</h1>
				<hr style="margin: 10px auto;">
				<p>신중하게 수정 부탁 드립니다.</p>
				<!-- hidden -->
				<input type="hidden" name="gseq" value="${gameInfo.gseq}"/>
<%-- 				<c:choose>
					<c:when test="${gameInfo!=null}"> --%>
						<table class="editTable" style="padding: 10px; margin: 0 auto; margin-top: 20px; width: 100%; height: 100%; background-color: #c2c2c2; border-radius: 6px;">
							<tr>
								<td style="width:10%;">제목</td>
								<td>
								<input type="text" id="gameTitle" style="width: 100%; padding: 2px 0;" name="subject" placeholder="제목을 작성해주세요"
									value="${gameInfo.name}" required />
								</td>
							</tr>
							<tr>
								<td style="width:10%;">키아트 이미지</td>
								<td>
									<input type="hidden" name="originalimage" value="${gameInfo.keyart}" />
									<input type="file" name="keyart" id="keyart"maxlength="150" accept=".gif, .jpg, .png"/>
								</td>
							</tr>
							<tr>
								<td style="padding-top: 10px;">내용1</td>
							</tr>
							<tr>
								<td colspan="100%" style=""><textarea id="gameContent1"
										rows="6" style="width: 100%; resize: none;" name="content1"
										placeholder="이곳에 내용을 적어주세요!" maxlength="330" required>${gameInfo.content1}</textarea>
								</td>
							</tr>
							<tr>
								<td style="padding-top: 10px;">내용2</td>
							</tr>
							<tr>
								<td colspan="100%" style=""><textarea id="gameContent2"
										rows="15" style="width: 100%; resize: none;" name="content2"
										placeholder="이곳에 내용을 적어주세요!" maxlength="2500" required>${gameInfo.content2}</textarea>
								</td>
							</tr>
							<tr>
								<td style="padding-top: 10px;">가격1</td>
								<td colspan="3">
									<input type="number" id="price1"
									name="price1" min="10000" max="90000" value="${gameInfo.price1}"/> 가격2(할인) <input
									type="number" id="price2" name="price2" min="10000" max="80000" value="${gameInfo.price2}"/>
								</td>
							</tr>
							<tr>
								<td style="padding-top: 10px;">게임 태그</td>
								<td colspan="100%">
									<select name="tag1" id="gameTag1"
										required>
											<option value="">태그1</option>
											<option value="CO-OP">CO-OP</option>
											<option value="싱글플레이">싱글 플레이</option>
											<option value="멀티플레이">멀티</option>
											<option value="싱글과 멀티플레이">싱글과 멀티</option>
									</select> <select name="tag2" id="gameTag2" required>		
											<option value="">태그3</option>
											<option value="캐주얼">캐주얼</option>
											<option value="아케이드">아케이드</option>
											<option value="어드벤쳐">어드벤쳐</option>
											<option value="액션">액션</option>
									</select> <select name="tag3" id="gameTag3" required>
											<option value="">태그2</option>
											<option value="인디">인디</option>
											<option value="오픈월드">오픈월드</option>
											<option value="VR">VR</option>
											<option value="전략">전략</option>
											<option value="시뮬레이션 ">시뮬레이션</option>
											<option value="레이싱">레이싱</option>
											<option value="스포츠">스포츠</option>
											<option value="턴제">턴제</option>
									</select> <select name="tag4" id="gameTag4" required>
											<option value="">태그4</option>
											<option value="일인칭">일인칭 시점</option>
											<option value="삼인칭">삼인칭 시점</option>
									</select>
								</td>
							</tr>
							<tr>
							<td style="padding-top: 10px;">게임 상태</td>
							<td colspan="100%">
								<select name="adgameyn" id="adgameyn"required>
									<option value="n">광고게임 여부</option>
									<option value="y">Y</option>
									<option value="n">N</option>
								</select>
								<select name="specialofferyn" id="specialofferyn" required>
									<option value="">특별할인 여부</option>
									<option value="y">Y</option>
									<option value="n">N</option>
								</select>
								<select name="newgameyn" id="newgameyn"required>
									<option value="">신작게임 여부</option>
									<option value="y">Y</option>
									<option value="n">N</option>
								</select>
								<select name="freegameyn" id="freegameyn"required>
									<option value="">무료게임 여부</option>
									<option value="y">Y</option>
									<option value="n">N</option>
								</select>
							</tr>
							<tr>
								<td style="padding-top: 10px;">숨김 처리</td>
								<td colspan="100%">
									<select name="useyn" id="useyn"required>
										<option value="">숨김 여부</option>
										<option value="y">Y-노출</option>
										<option value="n">N-숨김</option>
									</select>
								</td>
								<td>
								<input type="button" onclick="select()"/>
								</td>
							</tr>
						</table>
				<input type="button"
					style="float: right; margin-top: 20px; padding: 5px 20px;"
					value="제 출"
					onclick="fileCheck( this.form.keyart )" />
				<input type="button"
					style="float: left; margin-top: 20px; padding: 5px 20px;"
					value="목 록" onclick="location.href='javascript: history.back()'" />
			</div>
		</div>
	</form>
</body>
</html>