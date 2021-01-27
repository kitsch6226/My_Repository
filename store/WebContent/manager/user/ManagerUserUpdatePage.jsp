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
	background:#c2c2c2;
	color:black;
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
#Useruseyn{
 	margin-top:20px;
 	padding:10px;
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
		}if(file1.value.length>50){
			alert("파일 이름이 너무 길어요...경로 포함 최대 50자");
			return;
		}
	}
	
	var accountInput = document.getElementById("accountName");
	if(accountInput.value==''||accountInput.value==null){
		alert("이름을 입력해 주세요!");
		return;
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
<body>
	<form name="accountSettingForm" action="updateUserManager.go" enctype="multipart/form-data" method="post">
		<c:if test="${param.check eq 'ok'}">
			<script>
				alert('정보 변경이 완료 되었습니다!')
			</script>
		</c:if>
		<div class="indexcenterdiv">
			<h1>유저 설정</h1>
			<div class="settingcenterdiv">
				<p>프로필 이미지</p>
				<div style="width:100%; display:table;">
					<div style="width:10%; float:left">
						<input type="hidden" name="num" value="${userInfo.num}"/>
						<input type="hidden" name="originalimage" value="${userInfo.image}"/>
						<div style="overflow:hidden; margin-top:20px; max-height:150px;border-radius:6px;">
							<img src="/store/image/profile/${userInfo.image}" style="width:100%;" ondragstart="return false;"/>
						</div>
					</div>
					<input type="file" name="image" accept=".jpg,.png" style="float:left; margin-left:40px; margin-top:145px;"/>
				</div>
				<div style="width:100%;">
					<p class="settingp">가입일</p><br>
					<b>${userInfo.indate}</b>
					<p class="settingp">프로필 수정일</p><br>
					<c:choose>
										<c:when test="${userInfo.modidate!=null}">
										<b>${userInfo.modidate}</b>
										</c:when>
										<c:otherwise>
										<b>수정 기록 없음</b>
										</c:otherwise>
					</c:choose>
					<p class="settingp">프로필 메일</p>
					<input class="settinginput" name="mail" type="text" pattern="[가-힣a-zA-Z]{2,10}"
					maxlength="10" title="수정 불가" value="${userInfo.mail}" placeholder="프로필 메일 수정 불가" readonly/>
					<p class="settingp">프로필 이름</p>
					<input class="settinginput" name="name" id="accountName"type="text" pattern="[가-힣a-zA-Z]{2,10}"
					maxlength="10" title="영문/한글 10자 이내" value="${userInfo.name}" placeholder="프로필 이름" required/>
					<p class="settingp">탈퇴처리</p>
					<select name="useyn" id="Useruseyn" required>
							<option value="y">선택</option>
							<option value="y">Y-가입</option>
							<option value="n">N-탈퇴</option>
					</select>
				</div>
				<button type="button" style="float:right; margin-top:30px; padding:10px 20px;" onclick="fileCheck(this.form.image)">수정하기</button>
				<button type="button" style="float:left; margin-top:30px; padding:10px 20px;" onclick="location.href='user.go'">취소</button>
			</div>
		</div>
	</form>
</body>
</html>