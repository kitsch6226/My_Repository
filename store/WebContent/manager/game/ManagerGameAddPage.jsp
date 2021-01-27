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

.editTable tr td {
	padding: 4px 0;
}
</style>
<script type="text/javascript">
function fileCheck(file1,file2,file3,file4,file5,file6){  	  // 사이즈체크
	var pathpoint1 = file1.value.lastIndexOf('.');
	var filepoint1 = file1.value.substring(pathpoint1+1,file1.length);
	var filetype1=filepoint1.toLowerCase();
	
	var pathpoint2 = file2.value.lastIndexOf('.');
	var filepoint2 = file2.value.substring(pathpoint2+1,file2.length);
	var filetype2=filepoint2.toLowerCase();
	
	var pathpoint3 = file3.value.lastIndexOf('.');
	var filepoint3 = file3.value.substring(pathpoint3+1,file3.length);
	var filetype3=filepoint3.toLowerCase();
	
	var pathpoint4 = file4.value.lastIndexOf('.');
	var filepoint4 = file4.value.substring(pathpoint4+1,file4.length);
	var filetype4=filepoint4.toLowerCase();
	
	var pathpoint5 = file5.value.lastIndexOf('.');
	var filepoint5 = file5.value.substring(pathpoint5+1,file5.length);
	var filetype5=filepoint5.toLowerCase();
	
	var pathpoint6 = file6.value.lastIndexOf('.');
	var filepoint6 = file6.value.substring(pathpoint6+1,file6.length);
	var filetype6=filepoint6.toLowerCase();

	
    var maxSize  = 5 * 1024 * 1024    //5MB
    var fileSize1 = 0;
    var fileSize2 = 0;
    var fileSize3 = 0;
    var fileSize4 = 0;
    var fileSize5 = 0;
    var fileSize6 = 0;
    
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
	}else if(file2.value!=''){
		fileSize2 = file2.files[0].size;
		if(filetype2=='jpg'||filetype2=='gif'||filetype2=='png'||filetype2=='jpeg'||filetype2=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize2 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}else if(file3.value!=''){
		fileSize3 = file3.files[0].size;
		if(filetype3=='jpg'||filetype3=='gif'||filetype3=='png'||filetype3=='jpeg'||filetype3=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize3 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}else if(file4.value!=''){
		fileSize4 = file4.files[0].size;
		if(filetype4=='jpg'||filetype4=='gif'||filetype4=='png'||filetype4=='jpeg'||filetype4=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize4 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}else if(file5.value!=''){
		fileSize5 = file5.files[0].size;
		if(filetype5=='jpg'||filetype5=='gif'||filetype5=='png'||filetype5=='jpeg'||filetype5=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize5 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}else if(file6.value!=''){
		fileSize6 = file6.files[0].size;
		if(filetype6=='jpg'||filetype6=='gif'||filetype6=='png'||filetype6=='jpeg'||filetype6=='bmp')
		{
		}else{
			alert("이미지 파일만 첨부 가능합니다.");
	        return;
		}
	    if(fileSize6 > maxSize)
	    {
	        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
	        return;
	    }
	}
}
//값이 비어있는지 체크
var gameTitle  = document.getElementById("gameTitle");
var developer  = document.getElementById("developer");
var keyart = document.getElementById("keyart");
var portrait = document.getElementById("portrait");
var main1 = document.getElementById("main1"); 
var gameContent1 = document.getElementById("gameContent1");
var gameContent2 = document.getElementById("gameContent2");
var genre  = document.getElementById("genre");
var gameTag1 = document.getElementById("gameTag1");
var gameTag2 = document.getElementById("gameTag2");
var gameTag3 = document.getElementById("gameTag3");
var price1 = document.getElementById("price1");
var price2 = document.getElementById("price2");
var specialofferyn = document.getElementById("specialofferyn");
var freegameyn = document.getElementById("freegameyn");
var newgameyn = document.getElementById("newgameyn");
var violence = document.getElementById("violence");
var platform = document.getElementById("platform");

var minos = document.getElementById("min-os");
var minstorage = document.getElementById("min-storage");
var minmemory = document.getElementById("min-memory");
var minprocessor = document.getElementById("min-processor");
var minvga = document.getElementById("min-vga");

var maxos = document.getElementById("max-os");
var maxstorage = document.getElementById("max-storage");
var maxmemory = document.getElementById("max-memory");
var maxprocessor = document.getElementById("max-processor");
var maxvga = document.getElementById("max-vga");


if(gameTitle.value==''||gameTitle.value==null){
	alert("게임 제목을 입력해 주세요!");
	return;
}else if(developer.value==""||developer.value==null){
	alert("개발사를 넣어 주세요!");
	return
}else if(keyart.value==""||keyart.value==null){
	alert("키아트 파일을 넣어 주세요!");
	return
}else if(portrait.value==""||portrait.value==null){
	alert("포트레이트 파일을 넣어 주세요!");
	return
}else if(main1.value==""||main1.value==null){
	alert("메인 파일을 넣어 주세요!");
	return
}else if(gameContent1.value==""||gameContent1.value==null){
	alert("게임 내용1를 입력해 주세요!");
	return
}else if(gameContent2.value==""||gameContent2.value==null){
	alert("게임 내용2를 입력해 주세요!");
	return
}else if(genre.value==""||genre.value==null){
	alert("게임 장르를 입력해 주세요!");
	return
}else if(gameTag1.value==""||gameTag1.value==null){
	alert("게임 태그1를 입력해 주세요!");
	return
}else if(gameTag2.value==""||gameTag2.value==null){
	alert("게임 태그2를 입력해 주세요!");
	return
}else if(gameTag3.value==""||gameTag3.value==null){
	alert("게임 태그3를 입력해 주세요!");
	return
}else if(specialofferyn.value==""||specialofferyn.value==null){
	alert("특별할인 여부를 입력해 주세요!");
	return
}else if(freegameyn.value==""||freegameyn.value==null){
	alert("무료게임 여부를 입력해 주세요!");
	return
}else if(newgameyn.value==""||newgameyn.value==null){
	alert("신작 게임 여부를 입력해 주세요!");
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
}else if(platform.value==""||platform.value==null){
	alert("연령 제한을 입력해 주세요!");
	return
}else if(violence.value==""||violence.value==null){
	alert("연령 제한을 입력해 주세요!");
	return
}else if(minprocessor.value==""||minprocessor.value==null){
	alert("최소 cpu를 입력해 주세요!");
	return
}
else if(minos.value==""||minos.value==null){
	alert("최소 os를 입력해 주세요!");
	return
}else if(minstorage.value==""||minstorage.value==null){
	alert("최소 용량을 입력해 주세요!");
	return
}else if(minmemory.value==""||minmemory.value==null){
	alert("최소 메모리를 입력해 주세요!");
	return
}else if(minvga.value==""||minvga.value==null){
	alert("최소 그래픽 사양을 입력해 주세요!");
	return
}else if(maxprocessor.value==""||maxprocessor.value==null){
	alert("최대 cpu를 입력해 주세요!");
	return
}else if(maxos.value==""||maxos.value==null){
	alert("최대 os를 입력해 주세요!");
	return
}else if(maxstorage.value==""||maxstorage.value==null){
	alert("최대 용량을 입력해 주세요!");
	return
}else if(maxmemory.value==""||maxmemory.value==null){
	alert("최대 메모리를 입력해 주세요!");
	return
}else if(maxvga.value==""||maxvga.value==null){
	alert("최대 그래픽 사양을 입력해 주세요!");
	return
}
document.updatefileForm.submit();
}
</script>
</head>
<body>
	<form name="updatefileForm" action="addGame.go" method="post"
		enctype="multipart/form-data">
		<div class="center" style="min-height: 600px">
			<div class="centermiddle"
				style="padding: 80px; width: 80%; height: 100%; margin: 0 auto;">
				<h1>게임 등록</h1>
				<hr style="margin: 10px auto;">
				<p>신중하게 등록 부탁 드립니다.</p>
				<!-- hidden -->
				<input type="hidden" name="gseq" value="${gameInfo.gseq}" />
				<%-- 				<c:choose>
					<c:when test="${gameInfo!=null}"> --%>
				<table class="editTable"
					style="padding: 10px; margin: 0 auto; margin-top: 20px; width: 100%; height: 100%; background-color: #c2c2c2; border-radius: 6px;">
					<tr>
						<td style="width: 10%;">제목</td>
						<td><input type="text" id="gameTitle"
							style="width: 100%; padding: 2px 0;" name="subject"
							placeholder="제목을 작성해주세요" value="${gameInfo.name}" required /></td>
					</tr>
					<tr>
						<td style="width: 10%;">개발사</td>
						<td>
							<input type="text" maxlength="50" name="developer" id="developer"/>
						</td>
					</tr>
					<tr>
						<td style="width: 10%;">키아트 이미지</td>
						<td><input type="hidden" name="Uri" value="keyart" /> <input
							type="file" id="keyart" name="keyart" maxlength="2000"
							accept=".gif, .jpg, .png" /></td>
					</tr>
					<tr>
						<td style="width: 10%;">포트레이트 이미지</td>
						<td><input type="hidden" name="Uri" value="portrait" /> <input
							type="file" id="portrait" name="portrait" maxlength="2000"
							accept=".gif, .jpg, .png" /></td>
					</tr>
					<tr>
						<td style="width: 10%;">메인 이미지<br>(최소 1개)
						</td>
						<td><input type="hidden" name="Uri" value="main" /> <input
							type="file" id="main1" name="main1" maxlength="2000"
							accept=".gif, .jpg, .png" /> <input type="file" id="main2"
							name="main2" maxlength="2000" accept=".gif, .jpg, .png" /> <input
							type="file" id="main3" name="main3" maxlength="2000"
							accept=".gif, .jpg, .png" /> <input type="file" id="main4"
							name="main4" maxlength="2000" accept=".gif, .jpg, .png" /></td>
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
						<td style="padding-top: 10px;">게임 장르</td>
						<td colspan="100%" style="">
						<select name="genre" id="genre" required>
								<option value="">장르</option>
								<option value="FPS">FPS</option>
								<option value="액션">액션</option>
								<option value="스포츠">스포츠</option>
								<option value="RPG">RPG</option>
								<option value="캐쥬얼">캐쥬얼</option>
								<option value="슈팅">슈팅</option>
								<option value="인디">인디</option>
								<option value="샌드박스">샌드박스</option>
							</select>
						</td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">게임 태그</td>
						<td colspan="100%" style=""><select name="tag1" id="gameTag1"
							required>
								<option value="">태그1</option>
								<option value="CO-OP">CO-OP</option>
								<option value="싱글플레이">싱글 플레이</option>
								<option value="멀티플레이">멀티</option>
								<option value="싱글과 멀티플레이">싱글과 멀티</option>
						</select> <select name="tag2" id="gameTag2" required>		
								<option value="">태그2</option>
								<option value="인디">인디</option>
								<option value="오픈월드">오픈월드</option>
								<option value="VR">VR</option>
								<option value="레이싱">레이싱</option>
								<option value="스포츠">스포츠</option>
								<option value="턴제">턴제</option>
						</select> <select name="tag3" id="gameTag3" required>
								<option value="">태그3</option>
								<option value="캐주얼">캐주얼</option>
								<option value="아케이드">아케이드</option>
								<option value="어드벤쳐">어드벤쳐</option>
								<option value="액션">액션</option>
								<option value="전략">전략</option>
						</select> <select name="tag4" id="gameTag4" required>
								<option value="">태그4</option>
								<option value="일인칭">일인칭 시점</option>
								<option value="삼인칭">삼인칭 시점</option>
						</select></td>
					</tr>
					<tr>
					<tr>
						<td style="padding-top: 10px;">게임 상태</td>
						<td colspan="100%" style=""><select name="specialofferyn"
							id="specialofferyn" required>
								<option value="">특별할인 여부</option>
								<option value="y">Y</option>
								<option value="n">N</option>
						</select> <select name="freegameyn" id="freegameyn" required>
								<option value="">무료게임 여부</option>
								<option value="y">Y</option>
								<option value="n">N</option>
						</select> <select name="newgameyn" id="newgameyn" required>
								<option value="">신작게임 여부</option>
								<option value="y">Y</option>
								<option value="n">N</option>
						</select> <select name="adgameyn" id="adgameyn" required>
								<option value="n">광고게임 여부</option>
								<option value="y">Y</option>
								<option value="n">N</option>
						</select>
					</tr>
					<tr>
						<td style="padding-top: 10px;">가격1</td>
						<td colspan="3"><input type="number" id="price1"
							name="price1" min="10000" max="90000" /> 가격2(할인) <input
							type="number" id="price2" name="price2" min="10000" max="80000" />
						</td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">플랫폼</td>
						<td colspan="3"><select name="platform" id="platform"
							required>
								<option value="">플랫폼 선택</option>
								<option value="1,2">윈도우,맥</option>
								<option value="1">윈도우</option>
								<option value="2">맥</option>
						</select></td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">연령제한</td>
						<td colspan="3"><select name="violence" id="violence"
							required>
								<option value="">연령 선택</option>
								<option value="15">15</option>
								<option value="18">18</option>
								<option value="0">전체연령가</option>
						</select></td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">최소사양</td>
						<td colspan="3"><input type="text" maxlength="50"
							id="min-processor" name="min-processor"placeholder=" cpu" /> 
							<input type="text"
							maxlength="50" id="min-os" name="min-os"placeholder=" os" />
							 <input
							type="text" maxlength="50" id="min-storage" name="min-storage"
							placeholder=" storage" /> 
							<input type="text" maxlength="50"
							id="min-memory" name="min-memory"placeholder=" memory" /> 
							<input type="text"
							maxlength="50" id="min-vga" name="min-vga"placeholder=" vga" /></td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">최대사양</td>
						<td><input type="text" maxlength="50"
							id="max-processor" name="max-processor"placeholder=" cpu" /> 
							<input type="text"
							maxlength="50" id="max-os" name="max-os" placeholder=" os" />
							 <input
							type="text" maxlength="50" id="max-storage" name="max-storage"
							placeholder=" storage" /> 
							<input type="text" maxlength="50"
							id="max-memory" name="max-memory"placeholder=" memory" /> 
							<input type="text"
							maxlength="50" id="max-vga" name="max-vga"placeholder=" vga" />
						</td>
						<td colspan="3"></td>
					</tr>
				</table>
				<%-- 				</c:when>
				</c:choose> --%>
				<input type="button"
					style="float: right; margin-top: 20px; padding: 5px 20px;"
					value="제 출"
					onclick="fileCheck( this.form.keyart,this.form.portrait,this.form.main1,this.form.main2,this.form.main3,this.form.main4 )" />
				<input type="button"
					style="float: left; margin-top: 20px; padding: 5px 20px;"
					value="목 록" onclick="location.href='javascript: history.back()'" />
			</div>
		</div>
	</form>
</body>
</html>