<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<title>일반회원가입</title>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<!-- Style -->
		<%@ include file= "/WEB-INF/inc/style.jsp" %>
</head>

<body id="page-top">
<!-- Header -->
		<%@ include file= "/WEB-INF/inc/header.jsp" %>

    <!-- Contact Section-->
    <section class="page-section" id="contact">
    	<!-- 부트스트랩으로 padding-top 을 좀 주고자 한다. -->
        <div class="container pt-5">
            <!-- Contact Section Heading-->
            <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">일반회원가입</h2>
            <!-- Contact Section Form-->
            <div class="row justify-content-center">
                <div class="col-lg-8 col-xl-7">          	
                    <form id="contactForm" action="${pageContext.request.contextPath }/registDo" method="POST">
                        
        						<!-- 아이디 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputId" type="text" name="id" />
							<label for="inputId">아이디</label>
						</div>

						<!-- 비밀번호 input-->
						<div class="form-floating mb-3">
							<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
							<input class="form-control" id="inputPw" type="password"
								name="pw" /> <label for="inputPw">비밀번호</label>
						</div>

						<!-- 이름 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text"
								name="name" /> <label for="inputName">이름</label>
						</div>

						<!-- 전화번호 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPhone" type="tel"
								name="phone" /> <label for="inputPhone">전화번호</label>
						</div>

						<!-- 주소 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputAddress" type="address"
								name="address" /> <label for="inputAddress">주소</label>
						</div>

						<!-- 이메일 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputEmail" type="email"
								name="email" /> <label for="inputEmail">이메일</label>
						</div>


						<!-- Submit Button-->
						<button class="btn btn-primary btn-xl" id="submitButton"
							type="submit">일반회원가입</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		

	</script>
		<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>
</body>

</html>