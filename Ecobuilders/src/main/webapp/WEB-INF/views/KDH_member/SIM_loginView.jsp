<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<!--Style-->
<%@ include file="/WEB-INF/inc/style.jsp"%>

<style>
.div {
	border: 0px solid black;
}

.actions-b {
	list-style: none;
	padding: 2%;
	display: flex;
	justify-content: center;
}

.actions-b li {
	display: flex;
	flex-direction: column;
	gap: 20px;
}

.b {
	text-align: center;
	margin-top: 60px;
	font-weight: bold;
	color: #333;
	font-size: 36px;
}

.button-b {
	width: 300px;
	padding: 30px;
	text-align: center;
	border-radius: 40px;
	font-size: 18px;
	font-weight: bold;
	color: white;
	transition: background-color 0.3s ease, transform 0.2s;
}

.button-b:hover {
	background-color: #0faf24c9;
	transform: scale(1.05);
}
</style>



</head>
<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- 일반+기업 로그인 -->
	<section>
		<h2 class="b">로그인</h2>
		<ul class="actions-b">
			<li><a href="${pageContext.request.contextPath }/loginView"
				class="button-b" style="background-color: #0faf24c9;">일반회원</a> <a
				href="${pageContext.request.contextPath }/ENT_loginView"
				class="button-b" style="background-color: #0faf24c9;">기업회원</a></li>
		</ul>
	</section>

</body>

<!-- Footer -->
<%@ include file="/WEB-INF/inc/footer.jsp"%>
</html>