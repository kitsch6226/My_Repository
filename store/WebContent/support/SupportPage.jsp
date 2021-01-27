<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
.indexcenterdiv {
	width: 80%;
	height: 100%;
	min-height:600px;
	margin: 0 auto;
	padding: 128px 0px;
	display: table;
	color:lightgray;
	box-sizing:border-box;
}
.supportheader{
	width:100%;
	display:table;
}
.supportheader button{
	float:right;
	border:1px solid #ffea00;
	padding: 10px 20px;
	background: transparent;
	outline: none;
	cursor:pointer;
	border-radius:6px;
	color:lightgray;
}

.supportcontent{
	 margin-top:20px;
	 width:98%;
	 background:#3f3f3f;
	 padding:20px;
	 display:table;
	 border-radius:6px;
	 overflow:hidden;
}
.supportcontent button{
	float:left;
	width:80px;
	padding:2px 10px;
	border:1px solid lightgray;
	border-radius: 6px;
	color: lightgray;
	background:transparent;
}
.supportcontent a:link{
	color: lightgray;
	text-decoration:none;
}
.supportcontent a:visited{
	color: lightgray;
}
.supportcontent a:hover{
	color: white;
}

</style>
<script type="text/javascript">

	function ffd(idvalue){
		var folderble = document.getElementById(idvalue);
		if(folderble.style.display=='none'){
			folderble.style.display="block";
		}else{
			folderble.style.display="none";
		}
		
	}
	function loginAlert(){
		var frmsupport = document.getElementById("supportForm");
		alert("로그인이 필요합니다!");
		frmsupport.action="login.go";
		frmsupport.submit();
	}
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
	
	var chk = getParameterByName("check");
	if(getParameterByName("check")=='added'){
		alert("문의가 등록 되었습니다!");
	};
	if(getParameterByName("check")=='false'){
		alert("해당하는 문의를 찾을 수 없습니다.");
	};
</script>
</head>
<body style="background-color: #1f1f1f;">
<form action="addQna.go" method="post" id="supportForm">
	<div class="indexcenterdiv">
		<h1 style="float:left">고객 지원</h1>
		<div class="supportheader">
			<h3 style="float:left; margin-top:10px;">무엇을 도와드릴까요?</h3>
			<c:if test="${loginInfo!=null}">
				<button onclick="location.href='addQna.go'">1:1 문의하기</button>
			</c:if>
			<c:if test="${loginInfo==null}">
				<button onclick="loginAlert()">1:1 문의하기</button>
			</c:if>
		</div>
		
		<div class="supportcontent">
			<button disabled>구매 관련</button>
			<h3 style="width:80%; float:left; margin-left:20px;"><a href="javascript:void(0)" onclick="ffd('folddiv')">환불 하려면 어떻게 해야하나요?</a></h3>
			<p style="float:right;"><b style="float:right">2020-11-08</b></p>
		</div>
		<div id="folddiv" style="padding:20px;display:none">
			<p >
				환불/취소 요청은 아래와 같은 방법으로 접수하실 수 있습니다.<br>
				 고객센터 직접 문의 (1:1상담, 게시판, 이메일, 전화: 1588-6226)<br>
				* 결제 취소 및 환불은 환불 신청 접수 후 7일 이내에 처리해 드립니다.<br>
				* 단, 환불 금액이 1,000원 미만인 경우 OGU머니 로 환불됩니다.<br>
				* 환불 시 구매자와 환불자가 다를 경우 19세 미만의 고객은 보호자의 동의가 필요합니다.
			</p>
		</div>
		
		<div class="supportcontent">
			<button disabled>정보 보안</button>
			<h3 style="width:80%; float:left; margin-left:20px;"><a href="javascript:void(0)" onclick="ffd('folddiv2')">개인정보 처리방침</a></h3>
			<p style="float:right;"><b style="float:right">2020-11-08</b></p>
		</div>
		<div id="folddiv2" style="padding:20px;display:none">
				<h3>1. 개인정보 처리방침이란?</h3><br>
				주식회사 Ogu()이하"회사")는 이용자의 ‘동의를 기반으로 개인정보를 수집·이용 및 제공’하고 있으며, ‘이용자의 권리 (개인정보 자기결정권)를 적극적으로 보장’합니다.<br>
				회사는 정보통신서비스제공자가 준수하여야 하는 대한민국의 관계 법령 및 개인정보보호 규정, 가이드라인을 준수하고 있습니다.<br>
				“개인정보처리방침”이란 이용자의 소중한 개인정보를 보호함으로써 이용자가 안심하고 서비스를 이용할 수 있도록 회사가 준수해야 할 지침을 의미합니다.<br>
				본 개인정보처리방침은 회사가 제공하는 Ogu계정 기반의 서비스(이하 ‘서비스'라 함)에 적용됩니다.<br><br>
				
				<h3>2. 개인정보 수집</h3><br>
				
				서비스 제공을 위한 필요 최소한의 개인정보를 수집하고 있습니다.<br>
				회원 가입 시 또는 서비스 이용 과정에서 홈페이지 또는 개별 어플리케이션이나 프로그램 등을 통해 아래와 같은 서비스 제공을 위해 필요한 최소한의 개인정보를 수집하고 있습니다.<br><br>
				
				[오구계정]<br><br>
				<b>필수</b><br>
				이메일, 비밀번호, 이름(닉네임), 프로필사진, 서비스 이용내역, 서비스 내 구매 및 결제 내역<br><br>
				
				[유료서비스 이용 시]<br><br>
				신용카드 : 카드번호(일부), 카드사명 등<br><br>
				
				[환불처리 시]<br><br>
				계좌은행, 계좌번호, 예금주명, 이메일<br><br>
				
				<h3>3. 개인정보 이용</h3><br>
				회원관리, 서비스 제공·개선, 신규 서비스 개발 등을 위해 이용합니다.<br>
				회원 가입 시 또는 서비스 이용 과정에서 홈페이지 또는 개별 어플리케이션이나 프로그램 등을 통해 아래와 같이 서비스 제공을 위해 필요한 최소한의 개인정보를 수집하고 있습니다.<br>
				회원 식별/가입의사 확인, 본인/연령 확인, 부정이용 방지<br>
				만 14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부 확인, 법정 대리인 권리행사 시 본인 확인<br>
				이용자간 메시지 전송, 친구등록 및 친구추천 기능의 제공<br>
				친구에게 활동내역을 알리거나 이용자 검색, 등록 등의 기능 제공<br>
				신규 서비스 개발, 다양한 서비스 제공, 문의사항 또는 불만처리, 공지사항 전달<br>
				유료서비스 이용 시 컨텐츠 등의 전송이나 배송·요금 정산<br>
				서비스의 원활한 운영에 지장을 주는 행위(계정 도용 및 부정 이용 행위 등 포함)에 대한 방지 및 제재<br>
				인구통계학적 특성과 이용자의 관심, 기호, 성향의 추정을 통한 맞춤형 컨텐츠 추천 및 마케팅에 활용<br>
				음성명령 처리 및 음성인식 향상, 개인화 서비스 제공<br>
				서비스 이용 기록, 접속 빈도 및 서비스 이용에 대한 통계, 프라이버시 보호 측면의 서비스 환경 구축, 서비스 개선에 활용<br>
		</div>
		
		<div class="supportcontent">
			<button disabled>주의사항</button>
			<h3 style="width:80%; float:left; margin-left:20px;"><a href="javascript:void(0)" onclick="ffd('folddiv3')">법적 고지및 주의 사항</a></h3>
			<p style="float:right;"><b style="float:right">2020-11-08</b></p>
		</div>
		<div id="folddiv3" style="padding:20px;display:none">
				<h3>라이선스 및 사이트 및 서비스 액세스</h3>
				사이트 및 서비스 내용은 사용자의 개인 사용을 위해 제공되며 상업적으로 이용할 수 없습니다.<br>
				모든 뉴스 기사, 설명서, 오디오 클립 및 비디오 클립, 그래픽, 로고, 아이콘, 이미지 또는<br>
				여기에 포함된 다운로드(또는 "콘텐츠")를 포함하며 이에 제한되지 않는 사이트에 게시된 모든 자료 또는<br>
				정보는 저작권에 의해 보호되며 콘텐츠 제공자로 표시된 제삼자 또는 Ogu에 의해 소유 또는 제어됩니다.<br>
				 사용자는 모든 콘텐츠에 포함된 모든 추가 저작권 공지, 정보 또는 제한 사항을 준수해야 합니다.<br>
				 본 사이트 및 콘텐츠는 프랑스 및 국제 저작권법에 의해 보호됩니다.<br>
				 사용자는 Ogu의 사전 서면 동의 없이는 본 콘텐츠 또는 사이트의 전체 또는 일부라도<br>
				 수정, 게시, 전송, 전송 또는 판매 과정에 참여, 재생산(아래 단락에 제공된 경우는 예외), 파생 작업물 생성, 배포, 수행, 표시할 수 없습니다.<br><br>
				
				사용자는 여기에 포함된 모든 저작권 및 기타 공지를 준수하는 한 개인 또는 비상업적 용도로만 본 사이트에 표시된 콘텐츠 및 기타 다운로드 항목을 다운로드하거나 복사할 수 있습니다.<br><br>
				
				<h3>저작권, 상표권 및 지적 자산 권한</h3>
				본 사이트 및/또는 서비스에 포함되었거나 본 사이트를 통해 제공되는 모든 콘텐츠는 Ogu 또는 해당 공급자의 자산이며,<br>
				프랑스 및 국제 저작권법, 저작자 권한 및 데이터베이스 권한 법률에 의해 보호됩니다. 본 사이트에 포함되었거나 본 사이트를 통해 제공되는 그래픽,<br>
				로고, 페이지 헤더, 단추 아이콘 및 제품 이름은 Ogu의 상표 또는 등록 상표입니다.<br>
				본 사이트 및/또는 서비스에 표시되는 Ogu 소유 이외의 다른 모든 상표는 해당 소유자의 자산입니다.<br><br>
				
				귀하가 본 서비스를 통해 저장하거나 공유하는 귀하의 사용자 콘텐츠에 대한 모든 권한,<br>
				소유권 및 이해 관계는 귀하에게 귀속됩니다.<br>
				귀하가 개인정보 보호 설정에서 이 콘텐츠를 공유하도록 선택하는 경우에는,<br>
				귀하가 본 서비스 제공과 관련하여 서비스 알고리즘 향상 및 학습을 위해 귀하의 사용자 콘텐츠를 복사,<br>
				저장, 수정 및 사용할 수 있는 비배타적이고, 전 세계적이고, 로열티가 없고, 비용이 완전히 지급되었고,<br>
				양도 가능하고, 서브라이센스가 가능하며, 영구적이고 취소할 수 없는 라이센스 권한을 Ogu에 부여하는 것으로 간주됩니다.<br>
				동시에 사용자 콘텐츠와 관련된 분석 데이터를 제공하기 위해(예: 저장된 페이지 수)<br>
				본사의 자동화된 시스템을 사용해서 귀하의 콘텐츠를 분석할 수 있는 권한을 Ogu에 부여하는 것으로 간주됩니다.<br><br>
				
				본사는 모든 사용자들이 다른 사람의 저작권 및 기타 지적 자산 권한을 준수한다고 가정합니다.<br>
				사용자가 그러한 권한을 위반할 경우, Ogu는 고지 없이 위반 콘텐츠를 제거하거나 사용자 계정을 삭제할 수 있는 권한을 보유합니다.<br>
				본사 서비스를 통해 사용자의 저작권 위반을 고지할 경우, ogu@ogu.com(으)로 연락하고 해당 위반 사례의 증거 및 설명을 제공하십시오.<br><br>
				
				귀하가 고유 재량에 따라 본 사이트 및/또는 본 서비스의 기능 및 성능과 관련하여 Ogu에 피드백을 제공하는 경우(예: 잠재적인 오류 식별, 기능 개선 또는 향상 내용)("피드백"),<br>
				귀하에 대한 제한 또는 보상 없이 어떤 목적으로든 귀하의 피드백을 사용할 수 있는 권한이 Ogu에 부여됩니다.<br>
				Ogu에 피드백을 제공하고 싶은 경우, 이 피드백을 기밀로 유지해야 하며 제3자에게 알려주지 않아야 합니다.
		</div>
	
		<div class="supportcontent">
			<button disabled>입점안내</button>
			<h3 style="width:80%; float:left; margin-left:20px;"><a href="javascript:void(0)" onclick="ffd('folddiv4')">상품 입점 안내</a></h3>
			<p style="float:right;"><b style="float:right">2020-11-08</b></p>
		</div>
		<div id="folddiv4" style="padding:20px;display:none">
			<h3>상담 신청 및 입점 과정은 아래와 같이 진행됩니다.</h3><br><br>
			<div style="padding:20px; width:50%; border-radius:6px; background: white">
				<img src="/store/image/icon/img_infodesk_inputgoods01.gif" style="width:100%"/>
			</div>
		</div>
	</div>
</form>
</body>
</html>