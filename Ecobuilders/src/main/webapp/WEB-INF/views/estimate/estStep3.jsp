<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/inc/style.jsp"%>
<style>
.inputInfo {
	width: 1600px;
	margin-left: 20px;
	display: flex;
	justify-content: space-evenly;
	border: 1px solid red;
}

.inputItem {
	width: 1300px;
}

.itemList {
	width: 300px;
	border: 1px solid black;
}
</style>

</head>
<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!-- 건물 및 집 정보를 받는 페이지 -->
	<div style="height: 20px"></div>
	<div class="inputInfo">
		<div class="inputItem">
			<h2>자재 및 기기 선택</h2>
			<hr>
			<div class="d-flex justify-content-center">
				<form id="searchForm" class="d-flex"
					action="${pageContext.request.contextPath }/reviewView"
					method="GET">
					<select id="searchOption" class="form-select me-1"
						name="searchOption">
						<option value="title" selected>제목</option>
						<option value="content">내용</option>
						<option value="name">작성자</option>
					</select> <input id="searchWord" class="form-control me-1" type="text"
						name="searchWord">
					<button id="searchButton" class="btn btn-primary" type="button">검색
					</button>
				</form>
			</div>

			<hr>
		</div>
		<div class="itemList" id = "itemBox"></div>
		<hr>
	</div>


	<input type="button" onclick="goFinal()" value="Next" />


	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	var v_itemBox = document.getElementById("itemBox");
	var v_itemList = [];
	function addItem(item){
		v_itemList.add(item);
		
	}

		function goFinal() {
			location.href = "${pageContext.request.contextPath}/estStepFinal";
		}
	</script>

</body>

</html>