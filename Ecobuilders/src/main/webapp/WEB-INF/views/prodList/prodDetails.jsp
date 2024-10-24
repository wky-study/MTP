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
		<form id="searchForm" class="d-flex" action="${pageContext.request.contextPath }/prodView" method="GET" >
			<div class="pd-banner" data-category="창호">고효율 창호</div>
			<div class="pd-banner" data-category="환기장치">환기 장치</div>
			<div class="pd-banner" data-category="냉난방장치">냉난방 장치</div>
			<div class="pd-banner" data-category="단열보강재">단열 보강재</div>
			<div class="pd-banner" data-category="조명">조명</div>
			<div class="pd-banner" data-category="태양광패널">태양광 패널</div>
			<div class="pd-banner" data-category="차열도료">차열도료</div>
			<div class="pd-banner" data-category="일사조절장치">일사조절장치</div>
			<div class="pd-banner" data-category="기타">기타</div>
		</form>
	</div>

	<!-- Product-->
	<div class="prod-dt-box">
		<div class="prod-dt-img">
			<img src="images/window_icon.jpg" alt="">
		</div>
		<div class="prod-dt-des">
			<h2>${prodList.itemName}</h2>
			<h3>${prodList.itemType}</h3>
			<h4>${prodList.entName}</h4>
			<h4>${prodList.itemPrice}원</h4>
		</div>
	</div>
	
	





	<!-- Pagination -->

	<div class="pagination-container">
		<ul class="pagination">
			<!-- Previous Page Link -->
			<li class="page-item ${keySearch.firstPage == 1 ? 'disabled' : '' }">
			    	<c:if test="${keySearch.searchWord != null}">
				      <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
			    	</c:if>
			    	<c:if test="${keySearch.searchWord == null}">
				      <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
			    	</c:if>
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
			    	<a id="aTagBtn" class="page-link"  style="cursor: pointer;" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
			    </li>
		</ul>
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
		<script type="text/javascript">
		 	document.querySelectorAll('.pd-banner').forEach(function(banner) {
		        banner.addEventListener('click', function() {
		            // 클릭된 배너의 data-category 속성 값 가져오기
		            var category = this.getAttribute('data-category');
		            
		            // 페이지 이동 (카테고리를 쿼리 파라미터로 넘김)
		            window.location.href = '${pageContext.request.contextPath}/prodView?searchOption=category&searchWord='+category;
		        });
		    });
		
		</script>
</body>

</html>