<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>Eco Builders</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!--Style-->
		<%@ include file= "/WEB-INF/inc/style.jsp" %>
	
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

		.img-in:hover{
			transform: scale(1.05);
			transition: transform 0.2s;
		}
		.reviews-contents{
			margin-top: 10px;
		}
	</style>
</head>

<body class="landing">

	<!-- Header -->
	
	<%@ include file= "/WEB-INF/inc/header.jsp" %>
	


	<!-- Banner -->
	<section id="banner">
		<h2>탄소를 줄이고, 미래를 밝히다!</h2>
		<p>지속가능한 리모델링으로 지구를 지키세요.</p>
		<ul class="actions">
			<li>
				<a href="${pageContext.request.contextPath}/estStep1" class="button big">리모델링 견적확인</a>
			</li>
			<li>
				<a href="#" class="button big" style="background-color: #0faf24c9;">기업회원 바로가기</a>
			</li>
		</ul>
	</section>

	<!-- Products -->
	<section>
		<header class="major">
			<h2 style="padding-top: 100px;">Products</h2>
		</header>

		<div class="container">
			<div class="" style="justify-content: center; display: flex; text-align: center;">
				<div class=" ">
					<div class="product">
						<h3 style=" line-height: 150px; color: white;">창호 교체</h3>
					</div>
				</div>
				<div class=" ">
					<div class="product">
						<h3 style=" line-height: 150px; color: white;">환기 장치</h3>
					</div>
				</div>
				<div class=" ">
					<div class="product">
						<h3 style=" line-height: 150px; color: white;">냉난방 장치</h3>
					</div>
				</div>
				<div class=" ">
					<div class="product">
						<h3 style=" line-height: 150px; color: white;">단열 보강</h3>
					</div>
				</div>
			</div>
			<div class="container" style="padding-bottom: 100px;">
				<div class="" style="justify-content: center; display: flex; text-align: center;">
					<div class=" ">
						<div class="product">
							<h3 style=" line-height: 150px; color: white;">조명(LED)</h3>
						</div>
					</div>
					<div class=" ">
						<div class="product">
							<h3 style=" line-height: 150px; color: white;">태양광 패널</h3>
						</div>
					</div>
					<div class=" ">
						<div class="product">
							<h3 style=" line-height: 150px; color: white;">차열 도료</h3>
						</div>
					</div>
					<div class=" ">
						<div class="product">
							<h3 style=" line-height: 150px; color: white;">일사조절장치</h3>
						</div>
					</div>
				</div>
			</div>
	</section>

	<!-- Reviews -->

	<section>
		<header class="major" style="border: solid 1px rgba(144, 144, 144, 0.25)">
			<h2 style="padding-top: 100px;">Reviews</h2>
		</header>
		<div class="reviews-container">
			<div class="reviews-in">
				<div class="reviews-img" >
					<img src="./images/window_icon.jpg" class="img-in" alt="">
				</div>
				<div class="reviews-contents">
					<h3 style="margin: 0; padding-left: 10px;">시공사</h3>
					<h4 style="margin-top: 5px; padding-left: 10px">리뷰 내용 ...</h4>
				</div>
			</div>
			<div class="reviews-in">
				<div class="reviews-img" >
					<img src="./images/window_icon.jpg" class="img-in" alt="">
				</div>
				<div class="reviews-contents">
					<h3 style="margin: 0; padding-left: 10px;">시공사</h3>
					<h4 style="margin-top: 5px; padding-left: 10px">리뷰 내용 ...</h4>
				</div>
			</div>
			<div class="reviews-in">
				<div class="reviews-img" >
					<img src="./images/window_icon.jpg" class="img-in" alt="">
				</div>
				<div class="reviews-contents">
					<h3 style="margin: 0; padding-left: 10px;">시공사</h3>
					<h4 style="margin-top: 5px; padding-left: 10px">리뷰 내용 ...</h4>
				</div>
			</div>
		</div>
	</section>



	<!-- Footer -->
	
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>
	

</body>

</html>