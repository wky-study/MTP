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



	</div>

	<!-- Pagination -->

	<div class="pagination-container">
		<ul class="pagination">
			<!-- Previous Page Link -->
			<li class="page-item ${keySearch.firstPage == 1 ? 'disabled' : '' }">
				<a href="${pageContext.request.contextPath }/prodView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}">&laquo; Previous</a>
			</li>
			<!-- Page Number Links -->
			<c:forEach begin="${keySearch.firstPage }" end="${keySearch.lastPage }" var="num">
		    	<li class="page-item ${keySearch.pageNo == num ? 'active' : ''}">
		    		<c:if test="${keySearch.searchWord == null }">
			    		<a class="page-link" href="${pageContext.request.contextPath }/prodView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
		    		</c:if>
		    		<c:if test="${keySearch.searchWord != null }">
			    		<a class="page-link" href="${pageContext.request.contextPath }/prodView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
		    		</c:if>
		    	</li>
		    </c:forEach>
			<!-- Next Page Link -->
				<li class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
					<c:if test="${keySearch.searchWord == null }">
					    <a class="page-link" href="${pageContext.request.contextPath }/prodView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}" >
					      <span aria-hidden="true">&raquo;</span>
					    Next</a>
				    </c:if>
   			    </li>
		</ul>
	</div>
	
	<!-- 검색기능 -->
	<div class="d-flex justify-content-center">
		<form id="searchForm" class="d-flex" action="${pageContext.request.contextPath }/prodView" method="GET" >
			<select id="searchOption" class="form-select me-1" name="searchOption">
				<option value="title" selected>제품명</option>
				<option value="name">시공사명</option>
			</select>

			<input id="searchWord" class="form-control me-1" type="text" name="searchWord">
			<button id="searchButton" class="btn btn-primary" type="submit">
				<svg xmlns="http:www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12">
				</svg>
			</button>
		</form>
	</div>




	<!-- Footer -->
		<%@ include file= "/WEB-INF/inc/footer.jsp" %>
		
		
		
		
		<script type="text/javascript">
		let v_search = '${keySearch.searchWord}';
		
		function f_change() {
			console.log(event.target);
			console.log(event.target.value);
			
			let v_url = "${pageContext.request.contextPath}/prodView";
			let v_query = "?rowSizePerPage=" + event.target.value;
				v_query += "&pageNo=${keySearch.pageNo}";
			
			if(v_search){
				v_query += "&searchOption=${keySearch.searchOption}";
				v_query += "&searchWord=${keySearch.searchWord}";
			}
				
			
			location.href = v_url + v_query;
		}	
		


		
	</script>
</body>

</html>