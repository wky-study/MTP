<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>일반회원수정</title>

<!-- header 부분 -->

<style type="text/css">
.profile-box {
	width: 300px;
	height: 300px;
	border-radius: 150px;
	overflow: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: auto;
}

.profile-img {
	width: 110%;
	cursor: pointer;
}
</style>
<!-- Style -->
		<%@ include file= "/WEB-INF/inc/style.jsp" %>
</head>
<body id="page-top">
<!-- Header -->
		<%@ include file= "/WEB-INF/inc/header.jsp" %>

	<!-- Contact Section-->
	<section id="contact">
		<header class="major">
			<h2 style="padding-top: 100px;">회원수정</h2>

		</header>
		<div class="login-section">
			<form class="login-section-form" id="memEditForm" action="${pageContext.request.contextPath }/memEditDo"
				method="POST">
				<!-- 아이디 input-->
				<!-- inputId의 값이 id=value 형태로 전송되어야 함 -->
				<!-- 키값으로 사용될 id를 name 속성에 넣어주어야 함 -->
				<label for="inputId">아이디</label>
				<input class="input-form" id="inputId" type="text" name="memId" value="${sessionScope.login.memId }"readonly />

				<!-- 비밀번호 input-->
				<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
				<label for="inputPw">비밀번호</label>
				<input class="input-form" id="inputPw" type="password" name="memPassword" /> 

				<!-- 이름 input-->
				<label for="inputName">이름</label>
				<input class="input-form" id="inputName" type="text" name="memName"	value="${sessionScope.login.memName }" />

				<!-- 전화번호 input -->
				<label for="inputPhone">전화번호</label>
				<input class="input-form" id="inputPhone" type="text" name="memPhone" value="${sessionScope.login.memPhone }" /> 

				<!-- 주소 input -->

				<label for="inputAddress">주소</label>
				<input class="input-form" id="inputAddress" type="text" name="memAddress" value="${sessionScope.login.memAddress }" />

				<!-- 이메일 input -->
				<label for="inputEmail">이메일</label>
				<input class="input-form" id="inputEmail" type="email" name="memEmail" value="${sessionScope.login.memEmail }" />
					<div class="login-section-button">
						<button class="button special" id="memEditBtn" type="button">수정</button>
						<button class="button special" id="memDelBtn" type="button">회원탈퇴</button>
					</div>
				</form>
			</div>
		</section>
		<form id="memDelForm" action="${pageContext.request.contextPath }/memDelDo" method="POST"></form>
		
	<!-- 모달창 메세지 -->
	<script type="text/javascript">
		// input 태그 내 value값에 대한 validation 체크하는 경우
		
		let v_memId = '${sessionScope.login.memId}';
		
		document.getElementById("memDelBtn").addEventListener("click", ()=>{
			
			let v_input = prompt('정말로 삭제하시겠습니까? 삭제를 원하시면 아이디를 입력해주세요.');
			
			console.log(v_input);
			
			// 입력받은 아이디가 로그인 중인 아이디와 일치하는지 확인
			if(v_input == v_memId){
				// action=/memDelDo 인 form 태그의 submit 실행 
				document.getElementById('memDelForm').submit();
			}
			
		});
		
		document.getElementById("memEditBtn").addEventListener("click", ()=>{
			
			// action=/memEditDo 인 form 태그의 submit 실행 
			document.getElementById('memEditForm').submit();
			
		});
	</script>
		<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>
</body>

</html>