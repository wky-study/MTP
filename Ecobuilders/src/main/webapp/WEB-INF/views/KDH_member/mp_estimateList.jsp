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
								<th class="d-flex justify-content-center scope="col">견적서분류번호</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${keyEstList}" var="myestList"
								varStatus="status">
									<tr>
										<td scope="row">${status.index + 1}</td>
										<td>${myestList.estId }</td>
									</tr>
							</c:forEach>
							
						</tbody>
						
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>

</body>
</html>