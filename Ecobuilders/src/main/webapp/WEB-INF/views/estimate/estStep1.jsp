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
.address {
	width: 500px;
	height: 500px;
}

.big-con {
	height: 500px;
	display: flex;
	justify-content: space-evenly;
	align-items: center;
}

.right-con {
	width: 300px;
	height: 300px;
	border: 1px solid black;
	display: flex;
	justify-content: center;
	align-items: center;
}

.right-con.img {
	width: 100%;
	height: 100%;
}

.left-con {
	width: 300px;
	height: 300px;
	border: 1px solid black;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: x-large;
	font-weight: bolder;
}
</style>
</head>

<body class>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!-- 건물 및 집 정보를 받는 페이지 -->
<body>
	<div class="big-con">
		<a href = "${pageContext.request.contextPath}/estStep2" class="right-con">
			<img
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTcNmoe2cqqLm-PjJoE98HrNhg43-9LFuVtAohp6I8YY_ujZYeahpHcII&s"
				onclick="">
		</a>
		<a href="${pageContext.request.contextPath }/mp_estimateList"
			class="left-con">견적서 불러오기</a>


	</div>



	<%@ include file="/WEB-INF/inc/footer.jsp"%>



</body>



</html>