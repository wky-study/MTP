<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<title>Eco Builders</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/skel-layers.min.js"></script>
<script src="${pageContext.request.contextPath}/js/init.js"></script>
<noscript>
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/skel.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/css/style-xlarge.css" />

</noscript>

<style>
.product {
	width: 150px;
	height: 150px;
	background-color: #3cadd4;
	text-align: center;
	color: white;
	margin: 5px;
	border-radius: 10px;
	cursor: pointer;
}

.product:hover {
	background-color: #0faf24c9;
	transform: scale(1.05);
	transition: transform 0.2s;
}

.reviews-container {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 20px;
	padding-left: 30px;
	padding-right: 30px;
	margin-bottom: 50px;
}

.reviews-in {
	position: relative;
	display: flex;
	width: 100%;
	min-width: 0px;
	flex-flow: column;
	border-radius: 10px;
	border: solid 2px rgba(144, 144, 144, 0.25);
}

.reviews-img {
	height: 280px;
	overflow: hidden;
	position: relative;
	border-radius: 10px;
}

.img-in {
	width: 100%;
	height: 100%;
	object-fit: cover;
	position: absolute;
	top: 0px;
	left: 0px;
	transition: transform 0.2s;
	cursor: pointer;
}

.img-in:hover {
	transform: scale(1.05);
	transition: transform 0.2s;
}

.reviews-contents {
	margin-top: 10px;
}
</style>
</head>

<body class="landing">

	<!-- Header -->
	<header id="header">
		<h1>
			<a href="index.html">Eco Builders</a>
		</h1>
		<nav id="nav">
			<ul>

				<li><a href="${pageContext.request.contextPath}/">Main</a></li>
				<li><a href="${pageContext.request.contextPath}/prodView">Products</a></li>
				<li><a href="${pageContext.request.contextPath}/reviewView">Reviews</a></li>

				<c:if test="${sessionScope.login == null }">
					<li><a href="${pageContext.request.contextPath}/log/loginView"
						, class="button special">로그인</a></li>
				</c:if>
				
				<c:if test="${sessionScope.login != null }">
					<li><a href="${pageContext.request.contextPath }/log/loginView"
						, class="button special">${sessionScope.login.memName}님</a></li>
					<li><a href="<c:url value="/logoutDo"/>"
						, class="button special">로그아웃</a></li>
				</c:if>

			</ul>

		</nav>
	</header>

	<!-- Banner -->
	<section id="banner">
		<h2>!!!!!!!!!!복사해서 로그인 작업중!!!!!!!!!!</h2>
		<p>지속가능한 리모델링으로 지구를 지키세요.</p>
		<ul class="actions">
			<li><a href="${pageContext.request.contextPath}/estStep1"
				class="button big">리모델링 견적확인</a></li>
			<li><a href="${pageContext.request.contextPath}/#" class="button big"
				style="background-color: #0faf24c9;">기업회원 바로가기</a></li>
		</ul>


	</section>



</body>

</html>