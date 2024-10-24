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
	<section class="page-section" id="contact">

		<div class="container pt-5">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">기업회원수정</h2>
			<!-- Icon Divider-->
			<div class="row justify-content-center">
				<div class="col-lg-8 col-xl-7">
					<!-- type=submit인 버튼 클릭시 form 태그의 action 링크가 실행됨 -->
					<!-- 회원가입 요청시 서버에서 이를 받아줘야 함 -->
					<!-- /registDo 주소로 요청시 서버에서 회원가입 진행 -->
					<!-- 회원가입은 GET 방식으로 하면 문제가 있을 수 있으니 POST 방식 사용 -->
					<form id="ENT_memEditForm"
						action="${pageContext.request.contextPath }/ENT_memEditDo"
						method="POST">

						<!-- 사업자번호 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputBr" type="text" name="entBr"
								value="${sessionScope.login.entBr }" readonly /> <label
								for="inputBr">사업자번호</label>
						</div>

						<!-- 비밀번호 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPw" type="password"
								name="entPassword" /> <label for="inputPw">비밀번호</label>
						</div>

						<!-- 기업명 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputName" type="text"
								name="entName" value="${sessionScope.login.entName }" /> <label
								for="inputName">기업명</label>
						</div>

						<!-- 대표자명 input-->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputCeo" type="text"
								name="entCeo" value="${sessionScope.login.entCeo }" /> <label
								for="inputCeo">대표자명</label>
						</div>

						<!-- 주소 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputAddress" type="text"
								name="entAddress" value="${sessionScope.login.entAddress }" />
							<label for="inputAddress">주소</label>
						</div>

						<!-- 전화번호 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputPhone" type="tel"
								name="entPhone" value="${sessionScope.login.entPhone }" /> <label
								for="inputPhone">전화번호</label>
						</div>

						<!-- 이메일 input -->
						<div class="form-floating mb-3">
							<input class="form-control" id="inputEmail" type="email"
								name="entEmail" value="${sessionScope.login.entEmail }" /> <label
								for="inputEmail">이메일</label>
						</div>

					</form>

				<!--
					<form id="ent_memDelForm"
						action="${pageContext.request.contextPath }/ENT_memDelDo"
						method="POST"></form>
				-->
				
					<div class="d-flex justify-content-center">
						<button class="btn btn-primary me-2" id="ent_memEditBtn"
							type="button">기업회원수정</button>
							
					<!--	  
						<button class="btn btn-danger" id="ent_memDelBtn" type="button">기업회원탈퇴</button>
					-->
					
					</div>

				</div>
			</div>
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