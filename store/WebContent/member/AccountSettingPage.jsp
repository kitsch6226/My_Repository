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
.settingcenterdiv{
	padding:0;
	overflow:hidden;
	padding:20px;
	margin-top:20px;
	border-radius:6px;
	overflow:hidden;
	border:none;
	background:#474747;
	color:lightgray;
	display:block;
}
.settinginput{
	margin-top:10px;
	padding:10px;
	width:70%;
	outline:none;
}
.settingp{
	margin-top:20px;
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
		    if(file1.value.length>50){
		    	alert("파일 이름이 너무 길어요... 경로 포함 최대 50자!");
		    	return;
		    }
		}
	}
	var accountInput1 = document.getElementById("accountName");
	var accountInput2 = document.getElementById("accountpw");
	if(accountInput1.value==''||accountInput1.value==null){
		alert("이름을 입력해 주세요!");
		return;
	}
	if(accountInput2.value==''||accountInput2.value==null){
		alert("비밀번호를 입력해 주세요!");
		return;
	}else{
		if(chk(/(?=^\S{8,30}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/,accountInput2)){
			
		}else{
			alert("비밀번호 양식을 지켜주세요!\n영문 대소,특수문자 포함 최소 8자 최대 30자 공백없음");
			return;
		}
	}
	function chk(re, e){
		if(re.test(e.value)){
			return true;
		}
		return false;
	}

    document.accountSettingForm.submit();
}
	
	function deleteAccount(){
		if(confirm("탈퇴하면 현재 라이브러리에 있는 게임이 사라지고\n다시 이용할 수 없게 됩니다.\n그래도 탈퇴 하시겠어요?")){
			 document.accountSettingForm.encoding="application/x-www-form-urlencoded";
			 document.accountSettingForm.action="accountDelete.go";
			 document.accountSettingForm.submit();
		}
	}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<form name="accountSettingForm" action="accountSetting.go" enctype="multipart/form-data" method="post">
		<c:if test="${param.check eq 'ok'}">
			<script>
				alert('정보 변경이 완료 되었습니다!')
			</script>
		</c:if>
		<div class="indexcenterdiv">
			<h1 style="color:lightgray;">계정 설정</h1>
			<div class="settingcenterdiv">
				<p>프로필 이미지</p>
				<div style="width:100%; display:table;">
					<div style="width:10%; float:left">
						<input type="hidden" name="num" value="${loginInfo.num}"/>
						<input type="hidden" name="originalimage" value="${loginInfo.image}"/>
						<div style="overflow:hidden; margin-top:20px; max-height:150px;border-radius:6px;">
							<img src="/store/image/profile/${loginInfo.image}" style="width:100%;" ondragstart="return false;"/>
						</div>
					</div>
					<input type="file" name="image" accept=".jpg,.png" style="float:left; margin-left:40px; margin-top:145px;"/>
				</div>
				<div style="width:100%;">
					<p class="settingp">프로필 이름</p>
					<input class="settinginput" name="name" id="accountName"type="text" pattern="[가-힣a-zA-Z]{2,10}"
					maxlength="10" title="영문/한글 10자 이내" value="${loginInfo.name}" placeholder="프로필 이름" required/>
					<p class="settingp">비밀번호</p>
					<input class="settinginput" name="pw" id="accountpw" type="password" placeholder="변경할 비밀번호 혹은 현재 비밀번호"
					pattern="(?=^\S{8,30}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$"
					title="영문 대소,특수문자 포함 최소 8자 최대 30자 공백없음" maxlength="30" required/>
				</div>
				<button type="button" style="margin-top:30px; padding:10px 20px;" onclick="fileCheck(this.form.image)">수정하기</button>
				<c:if test="${loginInfo!=null}">
					<button type="button" style="margin-top:30px;float:right; padding:10px 20px;background:transparent;border:1px solid #1c1c1c; outline:none; color:#7c7c7c" onclick="deleteAccount()">탈퇴하기</button>
				</c:if>
			</div>
		</div>
	</form>
</body>
</html>