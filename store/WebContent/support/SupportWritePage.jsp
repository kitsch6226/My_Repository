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
	min-height:780px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
	color:lightgray;
	box-sizing:border-box;
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
	padding-top:10px;
	width:70%;
	outline:none;
}
.settingp{
	margin-top:10px;
}
.supportwritetable tr td{

	padding-top:5px;
}
.supportwritetable tr td input,.supportwritetable tr td select{
	padding:3px;
}
</style>
<script type="text/javascript">
</script>
</head>
<body style="background-color: #1f1f1f;">
	<form action="addQna.go" method="post">
	<div class="indexcenterdiv">
		<div class="center" style="min-height:600px">
			<div class="centermiddle" style="padding:20px; width:80%; height:100%; margin:0 auto;">
				<h1>문의 등록</h1>
				<hr style="margin:10px auto;">
				<p>관리자가 직접 문의에 답을 드립니다.</p>
				<table class="supportwritetable" style="padding:10px; margin:0 auto; margin-top:20px; width:100%; height:100%;background-color: #474747; border-radius:6px;">
					<tr>
						<td style="width:10%">문의 종류</td>
						<td><select name="kind" required>
								<option value="">문의 내용을 선택해주세요</option>
								<option value="게임환불">게임 환불</option>
								<option value="계정관련">계정 관련</option>
								<option value="버그">버그</option>
							</select></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" style="width:100%;" name="subject" placeholder="제목을 작성해주세요" required/></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td colspan="100%">
							<textarea rows="30"style="width:100%; resize:none;" name="content" placeholder="이곳에 내용을 적어주세요!" required></textarea>
						</td>
					</tr>
				</table>
				<input type="submit" style="float:right; margin-top:20px; padding:5px 20px;" value="제 출"/>
				<input type="button" style="float:left; margin-top:20px; padding:5px 20px;" value="취 소" onclick="location.href='javascript: history.back()'"/>
			</div>
		</div>
		</div>
	</form>
</body>
</html>