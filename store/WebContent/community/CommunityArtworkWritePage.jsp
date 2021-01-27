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

.settingcenterdiv {
	padding: 0;
	overflow: hidden;
	padding: 20px;
	margin-top: 20px;
	border-radius: 6px;
	overflow: hidden;
	border: none;
	background: #474747;
	color: lightgray;
	display: block;
}

.settinginput {
	margin-top: 10px;
	padding: 10px;
	width: 70%;
	outline: none;
}

.settingp {
	margin-top: 20px;
}
</style>
<script type="text/javascript">
	function fileCheck(file1) { // 사이즈체크
		var pathpoint1 = file1.value.lastIndexOf('.');
		var filepoint1 = file1.value.substring(pathpoint1 + 1, file1.length);
		var filetype1 = filepoint1.toLowerCase();

		var maxSize = 5 * 1024 * 1024 //5MB
		var fileSize1 = 0;
		var fileSize2 = 0;
		// 브라우저 확인
		var browser = navigator.appName;
		// 익스플로러일 경우
		if (browser == "Microsoft Internet Explorer") {
			var oas = new ActiveXObject("Scripting.FileSystemObject");
			if (file1 != null) {
				fileSize1 = oas.getFile(file1.value).size;
			}
		}
		// 익스플로러가 아닐경우
		else {
			if (file1.value != '') {
				fileSize1 = file1.files[0].size;
				if (filetype1 == 'jpg' || filetype1 == 'gif'
						|| filetype1 == 'png' || filetype1 == 'jpeg'
						|| filetype1 == 'bmp') {
				} else {
					alert("이미지 파일만 첨부 가능합니다.");
					return;
				}
				if (fileSize1 > maxSize) {
					alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
					return;
				}
			}if(file1.value.length>200){
				alert("파일 이름이 너무 길어요... 최대 200자!");
				return;
			}
		}
		document.communityArtworkAddForm.submit();
	}
</script>
</head>
<body style="background-color: #1f1f1f;">
	<form name="communityArtworkAddForm" action="addArtwork.go"
		enctype="multipart/form-data" method="post">
		<div class="indexcenterdiv">
			<h1 style="color: lightgray;">작품 등록</h1>
			<div class="settingcenterdiv">
				<h3>작품 이미지</h3>
				<div style="width: 100%; display: table;">
					<input type="file" name="image" accept=".jpg,.png"
						style="float: left; margin-top: 20px;" />
				</div>
				<div style="width: 100%; margin-top: 40px;">
					<h3>주의 사항</h3>
					<p class="settingp">
						1. 개인 또는 단체의 이익을 목적으로 부정한 활동 금지<br>
						<br> (1) 일반적인 회원으로 가장하여 홍보성 게시물을 작성하여서는 안됩니다.<br>
						<br> (2) 이미지 링크용도, 추천인코드, 권한획득 목적의 게시물 반복 작성 등<br> 개인적
						이득을 위한 활동을 하실 수 없습니다.<br>
						<br> (3) 개인, 특정 단체에 대한 긍정적 또는 부정적 여론조성을 위해<br>
						<br> 부당하게 활동할 수 없습니다. <br>
					</p>
				</div>
				<button type="button" style="margin-top: 30px; padding: 10px 20px;"
					onclick="fileCheck(this.form.image)">등록하기</button>
			</div>
		</div>
	</form>
</body>
</html>