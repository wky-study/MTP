<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>나의견적서페이지</title>


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

<style>
div {
	border: 0px solid black;
}

.content-box {
	height: 400px;
}

.my-table {
	height: 85%;
	overflow-y: auto;
}
</style>
</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>


	<div class="container mt-5 mb-5">

		<div class="content-box">

			<!-- 견적서 확인 -->
			<div class="my-content">
				<div class="d-flex justify-content-center border-bottom">
					<h4>견적서</h4>
				</div>
				<div class="my-table">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">아이디</th>
								<th scope="col">이름</th>
								<th scope="col">날짜</th>
								<th scope="col">공사기간</th>
								<th scope="col">자재</th>
								<th scope="col">가격</th>
								<th scope="col">주소</th>
								<th scope="col">자세히보기</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${keyEstList}" var="estimateList"
								varStatus="status">
								<c:if test="${memberDTO.memAdmin != '0' }">
									<tr>
										<td scope="row">${status.index + 1}</td>
										<td>${estimateList.memId }</td>
										<td>${estimateList.memName }</td>
										<td>${estimateList.memDate }</td>
										<td>${estimateList.memPeriod }</td>
										<td>${estimateList.memItems }</td>
										<td>${estimateList.memPrice }</td>
										<td>${estimateList.memAddress }</td>


									</tr>
								</c:if>
							</c:forEach>
							
						</tbody>
						
					</table>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<!-- 리뷰게시글 이동 -->
	<script type="text/javascript">
		function f_click(reviewNo) {
			console.log(reviewNo);
			// 새 탭 열기
			window.open(
					"${pageContext.request.contextPath}/reviewDetailView?no="
							+ reviewNo, '_blank'); // '_blank'는 새 탭에서 열도록 지정					
		}
		// 추가 할거 생각
		function f_click(itemId) {
			console.log(itemId);
		}
	</script>

</body>
</html>
