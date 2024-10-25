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
<title>기업회원수정</title>

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

	<!-- Contact Section Heading-->
	<header class="major">
		<h2 style="padding-top: 100px;">기업회원수정</h2>
	</header>
	<!-- Icon Divider-->
	<div class="login-section">
		<form class="login-section-form" id="ENT_memEditForm"
			action="${pageContext.request.contextPath }/ENT_memEditDo" method="POST">
			<!-- 사업자번호 input-->
			<label for="inputBr">사업자번호</label>
			<input class="input-form" id="inputBr" type="text" name="entBr" value="${sessionScope.login.entBr }" readonly />

			<!-- 비밀번호 input-->
			<label for="inputPw">비밀번호</label>
			<input class="input-form" id="inputPw" type="password" name="entPassword" />

			<!-- 기업명 input-->
			<label for="inputName">기업명</label>
			<input class="input-form" id="inputName" type="text" name="entName" value="${sessionScope.login.entName }" /> 

			<!-- 대표자명 input-->
			<label for="inputCeo">대표자명</label>
			<input class="input-form" id="inputCeo" type="text" name="entCeo" value="${sessionScope.login.entCeo }" />

			<!-- 주소 input -->
			<label for="inputAddress">주소</label>
			<input class="input-form" id="inputAddress" type="text" name="entAddress" value="${sessionScope.login.entAddress }" />
			<!-- 전화번호 input -->
			<label for="inputPhone">전화번호</label>
			<input class="input-form" id="inputPhone" type="text" name="entPhone" value="${sessionScope.login.entPhone }" /> 

			<!-- 이메일 input -->
			<label for="inputEmail">이메일</label>
			<input class="input-form" id="inputEmail" type="email" name="entEmail"	value="${sessionScope.login.entEmail }" /> 
			<div class="login-section-button">
				<button  class="button special" id="ent_memEditBtn" type="button">기업회원수정</button>
			</div>
		</form>
	</div>
</section>
	
<!-- Footer -->
<%@ include file= "/WEB-INF/inc/footer.jsp" %>

	
	<!-- 모달창 메세지 -->
	<script type="text/javascript">
		// input 태그 내 value값에 대한 validation 체크하는 경우
/*
		let v_entBr = '${sessionScope.login.entBr}';

		document.getElementById("ent_memDelBtn").addEventListener("click", ()=>{
			
			let v_input = prompt('정말로 삭제하시겠습니까? 삭제를 원하시면 사업자번호를 입력해주세요.');
			
			console.log(v_input);
			

			if(v_input == v_entBr){

				document.getElementById('ent_memDelForm').submit();
			}
			
		});
*/
		document.getElementById("ent_memEditBtn").addEventListener("click", ()=>{
			
			// action=/ENT_memEditDo 인 form 태그의 submit 실행 
			document.getElementById('ENT_memEditForm').submit();
			
		});

	</script>
</body>
</html>