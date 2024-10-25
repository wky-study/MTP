<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
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
		<form id="searchForm" class="d-flex"
			action="${pageContext.request.contextPath }/prodView" method="GET">
			<div class="pd-banner" data-category="">전체</div>
			<div class="pd-banner" data-category="창호">고효율 창호</div>
			<div class="pd-banner" data-category="환기">환기 장치</div>
			<div class="pd-banner" data-category="보일러,난방">냉난방 장치</div>
			<div class="pd-banner" data-category="단열,마감">단열 보강재</div>
			<div class="pd-banner" data-category="조명">조명</div>
			<div class="pd-banner" data-category="도료">차열도료</div>
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
			<h4><fmt:formatNumber value="${prodList.itemPrice}" type="number" pattern="#,###"/>원</h4>
		</div>
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