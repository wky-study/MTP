
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

<title>로그인</title>

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
	<section class="page-section" id="contact">
		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2class ="page-section-heading text-center text-uppercasetext-secondarymb-0">로그인
			</h2>
			<div class="divider-custom-line"></div>
		</div>
		<!-- Contact Section Form-->
		<div class="row justify-content-center">
			<div class="col-lg-8 col-xl-7">
				<!-- type=submit인 버튼 클릭시 form 태그의 action 링크가 실행됨 -->
				<!-- 회원가입 요청시 서버에서 이를 받아줘야 함 -->
				<!-- /registDo 주소로 요청시 서버에서 회원가입 진행 -->
				<!-- 회원가입은 GET 방식으로 하면 문제가 있을 수 있으니 POST 방식 사용 -->
				<form id="contactForm"
					action="${pageContext.request.contextPath }/loginDo" method="POST">
					<!-- /loginDo 로 쏠때, /loginView 를 요청했었던 URL 주소를 같이 보냄 -->
					<input type="hidden" name="from" value="${keyFrom }">

					<!-- 아이디 input-->
					<div class="form-floating mb-3">
						<!-- inputId의 값이 id=value 형태로 전송되어야 함 -->
						<!-- 키값으로 사용될 id를 name 속성에 넣어주어야 함 -->
						<!-- 쿠키에 rememberId가 있으면 값 넣음 -->
						<input class="form-control" id="inputId" type="text" name="memId"
							value="${cookie.rememberId.value }"
							${cookie.rememberId.value == null ? "autofocus" : "" } /> <label
							for="inputId">아이디</label>
					</div>

					<!-- 비밀번호 input-->
					<div class="form-floating mb-3">
						<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
						<input class="form-control" id="inputPw" type="password"
							name="memPassword"
							${cookie.rememberId.value != null ? "autofocus" : "" } /> <label
							for="inputPw">비밀번호</label>
					</div>

					<!-- 아이디 기억하기 체크박스 -->
					<div class="form-check mb-3">
						<!-- 쿠키에 rememberId가 있으면 태그 내에 checked 문구 넣기 -->
						<!-- ${cookie.rememberId.value != null ? "checked" : "" } -->
						<input class="form-check-input" type="checkbox" name="rememberId"
							id="flexCheckDefault"
							${cookie.rememberId.value != null ? "checked" : "" }> <label
							class="form-check-label" for="flexCheckDefault"> 아이디 기억하기
						</label>
					</div>

					<!-- 서버로부터 failMsg가 전달되어 오면 화면에 출력 -->
					<div class="mb-3">
						<!-- model에 담긴 키값 failMsg의 값이 꺼내짐 -->
						<span class="error-msg">${failMsg }</span>
					</div>

					<!--Button-->
					<button class="btn btn-primary btn-xl" id="submitButton"
						type="submit">로그인</button>
					<button id="registBtn" type="button">회원가입</button>
				</form>

			</div>
		</div>



	</section>

	<script type="text/javascript">
		document.getElementById("registBtn").addEventListener("click", ()=>{
			
			window.location.href = "${pageContext.request.contextPath }/registView";
		})
	
	</script>


		<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>

</body>

</html>