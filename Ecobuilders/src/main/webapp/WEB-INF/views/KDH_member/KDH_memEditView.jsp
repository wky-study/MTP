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
</head>
<body id="page-top">

	<!-- Contact Section-->
	<section class="page-section" id="contact">
		<!-- 부트스트랩으로 padding-top 을 좀 주고자 한다. -->
		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">회원수정</h2>
			<!-- Icon Divider-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<!-- type=submit인 버튼 클릭시 form 태그의 action 링크가 실행됨 -->
					<!-- 회원가입 요청시 서버에서 이를 받아줘야 함 -->
					<!-- /registDo 주소로 요청시 서버에서 회원가입 진행 -->
					<!-- 회원가입은 GET 방식으로 하면 문제가 있을 수 있으니 POST 방식 사용 -->
					<form id="memEditForm"
						action="${pageContext.request.contextPath }/memEditDo"
						method="POST">

						<!-- 아이디 input-->
						<div class="form-floating mb-3">
							<!-- inputId의 값이 id=value 형태로 전송되어야 함 -->
							<!-- 키값으로 사용될 id를 name 속성에 넣어주어야 함 -->
							<input class="form-control" id="inputId" type="text" name="memId"
								value="${sessionScope.login.memId }" readonly /> <label
								for="inputId">아이디</label>
						</div>

						<!-- 비밀번호 input-->
						<div class="form-floating mb-3">
							<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
							<input class="form-control" id="inputPw" type="password"
								name="memPassword" /> <label for="inputPw">비밀번호</label>
						</div>

						<!-- 이름 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text"
								name="memName" value="${sessionScope.login.memName }" /> <label
								for="inputName">이름</label>
						</div>

						<!-- 전화번호 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPhone" type="tel"
								name="memPhone" value="${sessionScope.login.memPhone }" /> <label
								for="inputPhone">전화번호</label>
						</div>

						<!-- 주소 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputAddress" type="text"
								name="memAddress" value="${sessionScope.login.memAddress }" />
							<label for="inputAddress">주소</label>
						</div>

						<!-- 이메일 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputEmail" type="email"
								name="memEmail" value="${sessionScope.login.memEmail }" /> <label
								for="inputEmail">이메일</label>
						</div>

					</form>

					<form id="memDelForm"
						action="${pageContext.request.contextPath }/memDelDo"
						method="POST"></form>

					<div class="d-flex justify-content-center">
						<button class="btn btn-primary me-2" id="memEditBtn" type="button">수정</button>
						<button class="btn btn-danger" id="memDelBtn" type="button">회원탈퇴</button>
					</div>

				</div>
			</div>
		</div>
	</section>

	<!-- footer 부분 -->

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
</body>

</html>