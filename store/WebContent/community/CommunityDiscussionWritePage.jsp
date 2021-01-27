<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		var filepoint2 = file2.value.substring(pathpoint2 + 1, file2.length);
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
			}
		}
		// 익스플로러가 아닐경우
		else {
			var kind = document.getElementById("discussionwritekind");
			var subject = document.getElementById("discussionwritesubject");
			var content = document.getElementById("discussionwritecontent");
			if (kind.value == null || kind.value == '') {
				alert("게임 종류를 선택해 주세요!");
				return;
			} else if (subject.value == null || subject.value == ''
					|| content.value == null || content.value == '') {
				alert("제목, 내용을 모두 채워주세요!");
				return;
			} else if (subject.value.length > 50 || content.value.length > 900) {
				alert("제목은 50자 내용은 900자 까지입니다!");
				return;
			}

			if (file1.value != '') {
					fileSize1 = file1.files[0].size;
					if (filetype1 == 'jpg' || filetype1 == 'gif' || filetype1 == 'png'
						|| filetype1 == 'jpeg' || filetype1 == 'bmp') {
					} else {
						alert("이미지 파일만 첨부 가능합니다.");
						return;
					}
					if (fileSize1 > maxSize) {
						alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
						return;
					}
					if (file1.value.length > 150) {
						alert("파일 이름이 너무 길어요... 각각 최대 150자!");
						return;
					}
			}
			if (file2.value != '') {
				fileSize2 = file2.files[0].size;
				if (filetype1 == 'jpg' || filetype2 == 'gif' || filetype2 == 'png'
					|| filetype2 == 'jpeg' || filetype2 == 'bmp') {
				} else {
					alert("이미지 파일만 첨부 가능합니다.");
					return;
				}
				if (fileSize2 > maxSize) {
					alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.");
					return;
				}
				if (file2.value.length > 150) {
					alert("파일 이름이 너무 길어요... 각각 최대 150자!");
					return;
				}
			}

		}

		document.discussionWriteForm.submit();
	}
</script>
</head>
<body>
	<form action="addDiscussion.go" method="post" name="discussionWriteForm"
		enctype="multipart/form-data">
		<div class="center" style="min-height: 600px">
			<div class="centermiddle"
				style="padding: 20px; width: 80%; height: 100%; margin: 0 auto;">
				<h1>의견 등록</h1>
				<hr style="margin: 10px auto;">
				<p>타인을 향한 비방과 욕설등은 제제를 받을 수 있습니다.</p>
				<table
					style="padding: 10px; margin: 0 auto; margin-top: 20px; width: 100%; height: 100%; background-color: #474747; border-radius: 6px;">
					<tr>
						<td style="width: 2%;">게임 종류</td>
						<td><select id="discussionwritekind" name="kind" required>
								<option value="">게임을 선택해 주세요.</option>
								<option value="사이버펑크 2077">사이버펑크 2077</option>
								<option value="카르토">카르토</option>
								<option value="풋볼매니저 2021">풋볼매니저 2021</option>
								<option value="히트맨">히트맨3</option>
								<option value="할로우나이트">할로우나이트</option>
								<option value="기타">기타</option>
						</select></td>
					</tr>
					<tr>
						<td style="width: 10%; padding-top: 10px;">제목</td>
						<td><input type="text" style="width: 100%;" name="subject"
							id="discussionwritesubject" placeholder="제목을 작성해주세요" required /></td>
					</tr>
					<tr>
						<td style="width: 10%; padding-top: 10px;">이미지</td>
						<td><input type="file" name="discussionImage1" maxlength="30"
							accept=".gif, .jpg, .png" /></td>
						<td><input type="file" name="discussionImage2" maxlength="30"
							accept=".gif, .jpg, .png" /></td>
					</tr>
					<tr>
						<td style="padding-top: 10px;">내용</td>
					</tr>
					<tr>
						<td colspan="100%" style="padding-top: 10px;"><textarea
								rows="30" style="width: 100%; resize: none;"
								id="discussionwritecontent" name="content"
								placeholder="이곳에 내용을 적어주세요!" required></textarea></td>
					</tr>
				</table>
				<input type="button"
					style="float: right; margin-top: 20px; padding: 5px 20px;"
					value="제 출"
					onclick="fileCheck(this.form.discussionImage1,this.form.discussionImage2)" />
				<input type="button"
					style="float: left; margin-top: 20px; padding: 5px 20px;"
					value="목 록" onclick="location.href='javascript: history.back()'" />
			</div>
		</div>
	</form>
</body>
</html>