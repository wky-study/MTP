<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>기업회원가입</title>
    
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
			<h2 style="padding-top: 100px;">기업회원가입</h2>
		</header>
		<!-- Contact Section Form-->
		<div class="login-section">
			<form class="login-section-form" id="contactForm" action="${pageContext.request.contextPath }/ENT_registDo"
				method="POST">
				<!-- 사업자번호 input-->
				<label for="inputBr">사업자번호(-없이입력)</label>
				<input class="input-form" id="inputBr" type="text" name="br" />

				<!-- 비밀번호 input-->
				<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
				<label for="inputPw">비밀번호</label>
				<input class="input-form" id="inputPw" type="password" name="pw" />

				<!-- 회사명 input-->
				<label for="inputName">회사명</label>
				<input class="input-form" id="inputName" type="text" name="name" />

				<!-- 대표자명 input -->
				<label for="inputCeo">대표자명</label>
				<input class="input-form" id="inputCeo" type="text" name="ceo" />

				<!-- 전화번호 input -->
				<label for="inputPhone">전화번호</label>
				<input class="input-form" id="inputPhone" type="text" name="phone" />

				<!-- 회사주소 input -->
				<label for="inputENT_Address">회사주소</label>
				<input class="input-form" id="inputAddress" type="text" name="address" />

				<!-- 이메일 input -->
				<label for="inputEmail">이메일</label>
				<input class="input-form" id="inputEmail" type="email" name="email" />

				<!-- Submit Button-->
				<div class="login-section-button">
					<button class="button special" id="submitButton" type="submit">기업회원가입</button>
				</div>
			</form>
		</div>
	</section>
    
	<script type="text/javascript">		
	
	</script>
	<!-- Footer -->
	<%@ include file= "/WEB-INF/inc/footer.jsp" %>
</body>

</html>