<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>


<html lang="ko">

<head>
<meta charset="UTF-8">
<title>Eco Builders</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- Style -->
<%@ include file="/WEB-INF/inc/style.jsp"%>
<style>
.bigg {
	width: 1500px;
	display: flex;
}

.left-bigg {
	width: 1300px;
}

.right-bigg {
	width: 200px;
}
</style>
</head>

<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>


	<!-- Products Banner -->
	<div class="bigg">
		<div class="left-bigg">
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

			<!-- Products List -->
			<div class="products-list" style="padding-top: 0px;">

				<c:forEach items="${prodList}" var="prod">
					<div class="pd-list">
						<div class="pd-list-bottom">
							<div class="labels">
								<span class="label-grd">${prod.itemLv}</span> <span
									class="label-sts">${prod.itemEfi}</span>
							</div>
							<div class="product-title">
								<a href="<c:url value="/prodDetails?itemId=${prod.itemId}"/>"
									style="font-size: 18px;">${prod.itemName}</a> <span>후기
									30건</span>
							</div>
							<div class="price-section">
								<span class="price"><fmt:formatNumber
										value="${prod.itemPrice}" type="number" pattern="#,###" />원</span>
								<button class="buy-btn" onclick=>추가하기</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<!-- Pagination -->
			<div class="d-flex justify-content-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<!-- 검색중이면 검색옵션과 검색어를 유지하면서 페이징 처리 -->
						<!-- 검색중이지 않으면 검색 옵션과 검색어가 주소창에 나타나지 않게 하기 -->
						<!-- searchWord가 null이면 a태그의 href에서 searchOption 과 searchWord 떼어내기 -->

						<!-- 이전 페이지 -->
						<li id="backBtn" class=""><c:if
								test="${keySearch.searchWord != null}">
								<a class=""
									href="${pageContext.request.contextPath }/prodView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}"
									aria-label="Previous"> <span aria-hidden="true">Previous</span>
								</a>
							</c:if> <c:if test="${keySearch.searchWord == null}">
								<a class=""
									href="${pageContext.request.contextPath }/prodView?pageNo=${keySearch.firstPage - 1 }&rowSizePerPage=${keySearch.rowSizePerPage}"
									aria-label="Previous"> <span aria-hidden="true">Previous</span>
								</a>
							</c:if></li>
						<!-- 중간 페이지 번호 부분 -->
						<!-- model에 keySearch 이름으로 searchVO를 담음 -->
						<!-- searchVO 내 pageNo, firstPage, lastPage 채워져있음 -->
						<c:forEach begin="${keySearch.firstPage }"
							end="${keySearch.lastPage }" var="num">
							<li class=" ${keySearch.pageNo == num ? 'active' : '' } "><c:if
									test="${keySearch.searchWord != null}">
									<a class=""
										href="${pageContext.request.contextPath }/prodView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
								</c:if> <c:if test="${keySearch.searchWord == null}">
									<a class=""
										href="${pageContext.request.contextPath }/prodView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
								</c:if></li>
						</c:forEach>

						<!-- 다음 페이지 -->
						<!-- 마지막 페이지 도달 시 disabled 추가 -->
						<li
							class=" ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
							<a id="aTagBtn" class="" style="cursor: pointer;"
							aria-label="Next"><span aria-hidden="true">Next</span></a>
						</li>


					</ul>
				</nav>
			</div>


			<!-- 검색기능 -->
			<form action="${pageContext.request.contextPath }/prodView"
				method="GET" id="searchForm" class="form-area"
				novalidate="novalidate" autocomplete="off">
				<div class="search-box">

					<div class="select-box">
						<select id="searchOption" name="searchOption">
							<option value="title" selected>자재명</option>
						</select>
					</div>
					<div class="search-bar">
						<input type="text" name="searchWord" id="searchWord"
							autocomplete="off" data-placeholder-focus="false" required />
					</div>


					<button type="submit" class="button special" id="searchButton"
						style="margin-top: 15px;">검색</button>
				</div>
			</form>
		</div>
		<div class="right-bigg" id="list"></div>
	</div>
	<input type="button" onclick="goFinal()" value="Next" />




	<!-- Footer -->
	<%@ include file="/WEB-INF/inc/footer.jsp"%>




	<!-- 이전 페이지로 이동 -->
	<script type="text/javascript">
		
		let v_firstPage = "${keySearch.firstPage}";
		
		console.log(v_firstPage);
		
		if(v_firstPage == 1){
			document.getElementById("backBtn").classList.add("disabled");
		}else{
			document.getElementById("backBtn").classList.remove("disabled");
		}
		
	</script>



	<!-- 페이징 script -->
	<script type="text/javascript">
	
	function goFinal() { location.href =
		"${pageContext.request.contextPath}/estFinal"; }
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
		
		/* 끝으로 이동 */
		let v_aTagBtn = document.getElementById("aTagBtn");
		v_aTagBtn.addEventListener("click", ()=>{
			
		     let v_searchWord = '${keySearch.searchWord}';
		     let v_lastPage = '${keySearch.lastPage}';
		     let v_rowSizePerPage = '${keySearch.rowSizePerPage}';
		     console.log(v_searchWord);
		     console.log(v_lastPage);
		     console.log(v_rowSizePerPage);
		     
		     if(v_searchWord == "" ){
		    	 if(v_lastPage % 10 != 0){
		    		 v_aTagBtn.href = "${pageContext.request.contextPath }/prodView?pageNo=${keySearch.lastPage}";
		    	 }else if(v_lastPage % 10 == 0){
		    		 v_aTagBtn.href = "${pageContext.request.contextPath }/prodView?pageNo=${keySearch.lastPage + 1}";
		    	 }
		     }else if(v_searchWord != ""){
		    	 if(v_lastPage % 10 != 0){
		    		 v_aTagBtn.href = "${pageContext.request.contextPath }/prodView?pageNo=${keySearch.lastPage}&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}";
		    	 }else if(v_lastPage % 10 == 0){
		    		 v_aTagBtn.href = "${pageContext.request.contextPath }/prodView?pageNo=${keySearch.lastPage + 1}&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}";
		    	 }
		     }
			
		})
		/* 인풋태그 엔터 입력시 반응 */
		let v_searchButton = document.getElementById("searchButton");
		
		document.addEventListener("keydown", ()=>{
			if (event.key === "Enter"){
				v_searchButton.click();
			}
			
		})
		
		let v_searchForm = document.getElementById("searchForm");
			
		/* 검색 버튼 클릭 */
		v_searchButton.addEventListener("click", ()=>{
			
			v_searchForm.submit();
			
		})
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