<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>



<!-- jQuery 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<!--Style-->
<%@ include file="/WEB-INF/inc/style.jsp"%>

<style type="text/css">
	div {
		border: 0px solid black;
	}
	
	.content-box {
		height: 400px;
	}
	
	.my-content {
		width: 49%;
		overflow-y: auto;
	}
</style>
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>


	<div class="container mt-5 mb-5">

		<div class="content-box d-flex justify-content-between mb-3">

			<!-- 회원 관리 기능 -->
			<div class="my-content">
				<div class="d-flex justify-content-center border-bottom">
					<h4>회원관리</h4>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">아이디</th>
							<th scope="col">이름</th>
							<th scope="col">핸드폰</th>
							<th scope="col">이메일</th>
							<th scope="col">등급</th>
							<th scope="col">권한변경</th>
							<th scope="col">계정삭제</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${keyMemList}" var="memberDTO" varStatus="status">
							<tr>
								<td scope="row">${status.index + 1}</td>
								<td>${memberDTO.memId }</td>
								<td>${memberDTO.memName }</td>
								<td>${memberDTO.memPhone }</td>
								<td>${memberDTO.memEmail }</td>

								<c:if test="${memberDTO.memLv == '1' }">
									<td>일반</td>
								</c:if>
								<c:if test="${memberDTO.memLv == '0' }">
									<td>관리자</td>
								</c:if>

								<c:if test="${memberDTO.memLv == '1'}">
									<td><button class="btn btn-primary"
											onclick="f_edit('${memberDTO.memId }')" type="button">추가</button></td>
								</c:if>
								<c:if
									test="${memberDTO.memLv == '0' && memberDTO.memId != 'admin'}">
									<td><button class="btn btn-warning"
											onclick="f_out('${memberDTO.memId }')" type="button">제거</button></td>
								</c:if>

								<c:if test="${memberDTO.memId == 'admin' }">
									<td></td>
								</c:if>

								<c:if test="${memberDTO.memId != 'admin' }">
									<td><button class="btn btn-danger"
											onclick="f_delete('${memberDTO.memId }')" type="button">삭제</button></td>
								</c:if>
								<c:if test="${memberDTO.memId == 'admin' }">
									<td>관리자</td>
								</c:if>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<!--  -->
			<div class="my-content">
				<div class="d-flex justify-content-center border-bottom">
					<h4>무언가</h4>
				</div>		
						
			</div>
		</div>


		<div class="content-box d-flex justify-content-between">

			<!-- 오늘 올라온 게시글 -->
			<div class="my-content">
				<div class="d-flex justify-content-center border-bottom">
					<h4>ToDay Review</h4>
				</div>				
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">No</th>
							<th scope="col">title</th>
							<th scope="col">neme</th>
							<th scope="col">date</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${keyReviewList}" var="reviewDTO" varStatus="status">
							<c:if test="${fn:substring(reviewDTO.reviewDate, 0, 10) == keyToDay}">
								<tr onclick="f_click('${reviewDTO.reviewNo }')" class="reviewRow" id="reviewLink">
									<td scope="row">${status.index + 1}</td>
									<td>${reviewDTO.reviewNo }</td>
									<td>${reviewDTO.reviewTitle }</td>
									<td>${reviewDTO.memName }</td>
									<td>${reviewDTO.reviewDate }</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>				
				
				
					
			</div>

			<!-- 견적서 검색 기능? -->
			<div class="my-content">
				<div class="d-flex justify-content-center border-bottom">
					<h4>견적서</h4>
				</div>				
				
			</div>
		</div>




	</div>


	<!-- Footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<!-- 리뷰게시글 이동 -->
	<script type="text/javascript">
		
		function f_click(reviewNo){
			console.log(reviewNo);
			// 새 탭 열기
	        window.open("${pageContext.request.contextPath}/reviewDetailView?no=" + reviewNo, '_blank'); // '_blank'는 새 탭에서 열도록 지정					
		}
	
	
	</script>

	<!-- 회원 관리 -->
	<script type="text/javascript">
		function f_delete(memId){
			console.log(memId);
			if(confirm("정말 삭제하시겠습니까?")){
				
				const v_url = "${pageContext.request.contextPath}/delAdminDo";
				
				$.ajax({
					type: 'POST',
					url: v_url,
					contentType : "application/json; charset:UTF-8",
					data: memId,
					success: function(resp){
						alert("삭제 완료");
						location.reload();
					}
				});
			};
		}
	
	 	
		function f_edit(memId){
			if(confirm("관리자로 추가하시겠습니까?")){
				
				const v_url = "${pageContext.request.contextPath}/updateAdminDo";
				
				$.ajax({
					type: 'POST',
					url: v_url,
					contentType : "application/json; charset:UTF-8",
					data: memId,
					success: function(resp){
						alert("추가 완료");
						location.reload();
					}
				})
			}
		};

		
		function f_out(memId){
			if(confirm("관리자에서 제외시키겠습니까?")){
				
				const v_url = "${pageContext.request.contextPath}/outAdminDo";
				
				$.ajax({
					type: 'POST',
					url: v_url,
					contentType : "application/json; charset:UTF-8",
					data: memId,
					success: function(resp){
						alert("제외 완료");
						location.reload();
					}
				})				
				
			}
			
		}
		
	</script>



</body>
</html>