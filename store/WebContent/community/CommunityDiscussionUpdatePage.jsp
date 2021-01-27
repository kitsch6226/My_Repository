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
	function fileCheck(file1, file2) { // 사이즈체크
		var pathpoint1 = file1.value.lastIndexOf('.');
		var filepoint1 = file1.value.substring(pathpoint1 + 1, file1.length);
		var filetype1 = filepoint1.toLowerCase();

		var pathpoint2 = file2.value.lastIndexOf('.');
		var filepoint2 = file2.value.substring(pathpoint1 + 1, file2.length);
		var filetype2 = filepoint2.toLowerCase();

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
			} else if (file2 != null) {
				fileSize2 = oas.getFile(file2.value).size;
			}
		}

		// 익스플로러가 아닐경우
		else {
			//파일이 널이 아닐때만 검사
			if (file1.value != '') {

				fileSize1 = file1.files[0].size;
				if (filetype1 == 'jpg' || filetype1 == 'gif'
						|| filetype1 == 'png' || filetype1 == 'jpeg'
						|| filetype1 == 'bmp') {
				} else {
					alert("이미지 파일만 첨부 가능합니다.");
					return;
				}
			//파일이 널이 아닐때만 검사
			} else if (file2.value != '') {

				fileSize2 = file2.files[0].size;
				if (filetype2 == 'jpg' || filetype2 == 'gif'
						|| filetype2 == 'png' || filetype2 != 'jpeg'
						|| filetype2 != 'bmp') {
				} else {
					alert("이미지 파일만 첨부 가능합니다.");
					return;
				}
			}
		}
		if (fileSize1 > maxSize && fileSize2 > maxSize) {
			alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
			return;
		}
		document.fileForm.submit();
	}
</script>
</head>
<body>
	<form name="fileForm" action="updateDiscussion.go" method="post"
		enctype="multipart/form-data">
		<div class="center" style="min-height: 600px">
			<div class="centermiddle"
				style="padding: 20px; width: 80%; height: 100%; margin: 0 auto;">
				<h1>의견 수정</h1>
				<hr style="margin: 10px auto;">
				<p>타인을 향한 비방과 욕설등은 제제를 받을 수 있습니다.</p>
				<input type="hidden" name="dseq" value="${discussion.dseq}"/>

				<table
					style="padding: 10px; margin: 0 auto; margin-top: 20px; width: 100%; height: 100%; background-color: #474747; border-radius: 6px;">
					<tr>
						<td style="width: 2%;">게임 종류</td>
						<td>${discussion.kind}</td>
					</tr>
					<tr>
						<td style="width: 10%; padding-top: 10px;">제목</td>
						<td><input type="text" style="width: 100%; padding: 2px 0;"
							name="subject" placeholder="제목을 작성해주세요"
							value="${discussion.subject}" required /></td>
					</tr>
					<tr>
						<td style="width: 10%; padding-top: 10px;">이미지</td>
						<td><c:forEach var="image" items="${discussion.image}">
								<input type="hidden" name="originalimage" value="${image}" />
							</c:forEach> <input type="file" name="discussionImage1" maxlength="2000"
							accept=".gif, .jpg, .png" /></td>
						<td><input type="file" name="discussionImage2"
							maxlength="2000" accept=".gif, .jpg, .png" /></td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">내용</td>
					</tr>
					<tr>
						<td colspan="100%" style="padding-top: 10px;"><textarea
								rows="30" style="width: 100%; resize: none;" name="content"
								placeholder="이곳에 내용을 적어주세요!" required>${discussion.content}</textarea>
						</td>
					</tr>
				</table>
				<input type="button"
					style="float: right; margin-top: 20px; padding: 5px 20px;"
					value="제 출"
					onclick="fileCheck( this.form.discussionImage1,this.form.discussionImage2 )" />
				<input type="button"
					style="float: left; margin-top: 20px; padding: 5px 20px;"
					value="목 록" onclick="location.href='javascript: history.back()'" />
			</div>
		</div>
	</form>
</body>
</html>