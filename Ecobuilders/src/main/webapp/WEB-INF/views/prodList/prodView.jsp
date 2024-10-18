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
	<!-- Style -->
		<%@ include file= "/WEB-INF/inc/style.jsp" %>

</head>

<body>

	<!-- Header -->
		<%@ include file= "/WEB-INF/inc/header.jsp" %>
	

	<!-- Products Banner -->
	<div class="products">
		<div class="pd-banner">고효율 창호</div>
		<div class="pd-banner">냉난방 장치</div>
		<div class="pd-banner">단열 보강재</div>
		<div class="pd-banner">조명</div>
		<div class="pd-banner">태양광 패널</div>
		<div class="pd-banner">차열도료</div>
		<div class="pd-banner">일사조절장치</div>
	</div>

	<!-- Products List -->
	<div class="products-list" style="padding-top: 0px;">
		<div class="pd-list">
			<div class="pd-list-top">
				<img class="pd-img" src="images/window_icon.jpg" alt="">
			</div>
			<div class="pd-list-bottom">
				<div class="labels">
					<span class="label-grd">효율 등급</span>
					<span class="label-sts">효율 수치</span>
				</div>
				<div class="product-title">
					<a href="" style="font-size: 23px;">제품 이름</a>
					<span>후기 30건</span>
				</div>
				<div class="price-section">
					<span class="price">830,000원</span>
					<button class="buy-btn">구매하기</button>
				</div>
			</div>
		</div>
		<c:forEach items= "${prodList}" var="prod">
			<div class="pd-list">
				<div class="pd-list-top">
					<img class="pd-img" src="images/window_icon.jpg" alt="">
				</div>
				<div class="pd-list-bottom">
					<div class="labels">
						<span class="label-grd">${prod.itemLv}</span>
						<span class="label-sts">${prod.itemEfi}</span>
					</div>
					<div class="product-title">
						<a href="" style="font-size: 23px;">${prod.itemName}</a>
						<span>후기 30건</span>
					</div>
					<div class="price-section">
						<span class="price">${prod.itemPrice}원</span>
						<button class="buy-btn">구매하기</button>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>
		<div class="pd-list">
			<div class="pd-list-top"></div>
			<div class="pd-list-bottom"></div>
		</div>


	</div>

	<!-- Pagination -->

	<div class="pagination-container">
		<ul class="pagination">
			<!-- Previous Page Link -->
			<li class="disabled">
				<a href="#">&laquo; Previous</a>
			</li>
			<!-- Page Number Links -->
			<li class="active"><a href="#">1</a>
			</li>
			<li>
				<a href="#">2</a>
			</li>
			<li>
				<a href="#">3</a>
			</li>
			<li>
				<a href="#">4</a>
			</li>
			<li>
				<a href="#">5</a>
			</li>
			<!-- Next Page Link -->
			<li>
				<a href="#">Next &raquo;</a>
			</li>
		</ul>
	</div>




	<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>
</body>

</html>