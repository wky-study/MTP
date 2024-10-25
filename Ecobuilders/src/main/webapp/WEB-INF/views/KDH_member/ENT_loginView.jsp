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
<title>기업회원 로그인</title>

<style type="text/css">
.error-msg {
	color: red;
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
			<h2 style="padding-top: 100px;">기업회원 로그인</h2>
		</header>
		<!-- Contact Section Form-->
		<div class="login-section">
			<!-- type=submit인 버튼 클릭시 form 태그의 action 링크가 실행됨 -->
			<!-- 회원가입 요청시 서버에서 이를 받아줘야 함 -->
			<!-- /ENT_registDo 주소로 요청시 서버에서 회원가입 진행 -->
			<!-- 회원가입은 GET 방식으로 하면 문제가 있을 수 있으니 POST 방식 사용 -->
			<form id="contactForm" class="login-section-form" action="${pageContext.request.contextPath }/ENT_loginDo"
				method="POST">
				<input type="hidden" name="from" value="${keyFrom }">

				<!-- 사업자번호 input-->
				<label for="inputBr">사업자번호(-없이작성)</label>
				<input class="input-form" id="inputBr" type="text" name="entBr" value="${cookie.rememberBr.value }"
					${cookie.rememberBr.value==null ? "autofocus" : "" } />


				<!-- 비밀번호 input-->
				<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
				<label for="inputPw">비밀번호</label>
				<input class="input-form" id="inputPw" type="password" name="entPassword" ${cookie.rememberBr.value
					!=null ? "autofocus" : "" } />

				<!-- 사업자번호 기억하기 체크박스 -->

				<!-- 쿠키에 rememberBr가 있으면 태그 내에 checked 문구 넣기 -->
				<!-- ${cookie.rememberBr.value != null ? "checked" : "" } -->
				<input class="form-check-input" type="checkbox" name="rememberBr" id="flexCheckDefault"
					${cookie.rememberId.value !=null ? "checked" : "" }> <label style="font-size: 14px;" for="flexCheckDefault"> 사업자번호 기억하기 </label>


				<!-- model에 담긴 키값 failMsg의 값이 꺼내짐 -->
				<span class="error-msg">${failMsg }</span>


				<!-- Submit Button-->
				<div class="login-section-button">
					<button class="button special" id="submitButton" type="submit">기업회원 로그인</button>
					<button class="button special" id="submitButton" type="button"
						onclick= "window.location.href= '${pageContext.request.contextPath}/ENT_registView'">기업회원가입</button>
				</div>
			</form>
		</div>
	</section>

	<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>

</body>
</html>