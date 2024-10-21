<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 게시판 목록</title>

<!--Style-->
<%@ include file= "/WEB-INF/inc/style.jsp" %>
	
 <!-- jQuery 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- 밑에 두줄 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>


	<style type="text/css">
		div{
			border: 0px solid black;
		}
		
		.content-box{
			display: flex;
			justify-content: center	; 
			width: 1200px;
			flex-wrap: wrap;
			height: auto; 
			
			overflow-y: auto;
			
			transition: height 0.5s ease; /* 높이 변화에 애니메이션 추가 */
			gap: 20px;
			margin: auto;
		}
		
		.card-box{
			width: calc(100% / 4 + 1px);
			height: auto;
			margin: 10px;
			box-shadow: 0px 0px 5px 2px gray;
			border-radius: 2px;
			
			cursor: pointer;
		}
		
		.card-box > img {
			width: 100%;
			height: 240px;
			object-fit: cover;
		}
		
		.card-box > span{
			display: block;
		}
		
		.card-name {
			border-top: 0.5px solid #dddddd;
		}
		
		.my-write-btn{
			position: fixed;
			right: 200px;
			bottom: 50px;
		}
		
		.my-page-up{
			position: fixed;
			right: 120px;
			bottom: 50px;
			
			width: 38px;
			
			border-radius: 19px;
			
			
			box-shadow : 0 0 0 1px #6c757d;
		}
		
		.my-page-up:hover{
			background-color: #6c757d;
		}
		
		.my-page-up > img{
			width: 100%;
			cursor:pointer;
		}
		
	
	</style>
</head>
<body>

<!-- Header -->
<%@ include file= "/WEB-INF/inc/header.jsp" %>




	<div class="container">
		
		<!-- 글쓰기 버튼 -->
		<div class="d-flex justify-content-end my-write-btn" >
			<button id="writeBtn" class="btn btn-outline-secondary" >글쓰기</button>
		</div>
		
		<div class="d-flex justify-content-end my-page-up " >
			<img onclick="window.scrollTo(0,0)" src="${pageContext.request.contextPath }/resources/images/upBtn.png">
		</div>		

		<div class="content-box mt-3 mb-3">
			<!-- 게시글 그리기 -->
			<c:forEach items="${keyReview}" var="ReviewDTO">
				<div class="card-box" id="cardBox" onclick='window.location.href = "${pageContext.request.contextPath }/reviewDetailView?no=${ReviewDTO.reviewNo}"'>
					<img src="${pageContext.request.contextPath }/displayImage?fileName=${ReviewDTO.reviewPath}">
					<span class="card-title">${ReviewDTO.reviewTitle}</span>
					<span class="card-name">${ReviewDTO.memName}</span>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<!-- 페이징 -->
	<div class="d-flex justify-content-center">
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		  	<!-- 검색중이면 검색옵션과 검색어를 유지하면서 페이징 처리 -->
			<!-- 검색중이지 않으면 검색 옵션과 검색어가 주소창에 나타나지 않게 하기 -->
			<!-- searchWord가 null이면 a태그의 href에서 searchOption 과 searchWord 떼어내기 -->

	    	<!-- 이전 페이지 -->
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
		    <!-- 중간 페이지 번호 부분 -->
		    <!-- model에 keySearch 이름으로 searchVO를 담음 -->
		    <!-- searchVO 내 pageNo, firstPage, lastPage 채워져있음 -->
			    <c:forEach begin="${keySearch.firstPage }" end="${keySearch.lastPage }" var="num">
					    <li class="page-item ${keySearch.pageNo == num ? 'active' : '' } ">
					    	<c:if test="${keySearch.searchWord != null}">
							    <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}">${num }</a>
					    	</c:if>						    
					    	<c:if test="${keySearch.searchWord == null}">
							    <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${num }&rowSizePerPage=${keySearch.rowSizePerPage}">${num }</a>
					    	</c:if>						    
					    </li>
			    </c:forEach>
		   
		    <!-- 다음 페이지 -->
		    <!-- 마지막 페이지 도달 시 disabled 추가 -->
			    <li class="page-item ${keySearch.pageNo == keySearch.finalPage ? 'disabled' : ''  }">
				    <c:if test="${keySearch.searchWord == null && keySearch.lastPage >= 10}">
				     <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}" aria-label="Next">
				    	 <span aria-hidden="true">&raquo;</span>
				     </a>
				    </c:if>
				    <c:if test="${keySearch.searchWord != null && keySearch.lastPage >= 10}">
				     <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.lastPage + 1 }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}" aria-label="Next">
				    	 <span aria-hidden="true">&raquo;</span>
				     </a>
				    </c:if>
				    <c:if test="${keySearch.searchWord != null && keySearch.lastPage <= 10}">
				     <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.lastPage }&rowSizePerPage=${keySearch.rowSizePerPage}&searchOption=${keySearch.searchOption}&searchWord=${keySearch.searchWord}" aria-label="Next">
				    	 <span aria-hidden="true">&raquo;</span>
				     </a>
				    </c:if>
				    <c:if test="${keySearch.searchWord != null && keySearch.lastPage <= 10}">
				     <a class="page-link" href="${pageContext.request.contextPath }/reviewView?pageNo=${keySearch.lastPage }&rowSizePerPage=${keySearch.rowSizePerPage}" aria-label="Next">
				    	 <span aria-hidden="true">&raquo;</span>
				     </a>
				    </c:if>
			    </li>

		    
		  </ul>
		</nav>
	</div>					
	<!-- 검색기능 -->
	<div class="d-flex justify-content-center">
		<form class="d-flex" action="${pageContext.request.contextPath }/reviewView" method="GET" >
			<select class="form-select me-1" name="searchOption">
				<option value="title" selected>제목</option>
				<option value="content">내용</option>
				<option value="name">작성자</option>
			</select>

			<input class="form-control me-1" type="text" name="searchWord">
			<button class="btn btn-primary" type="submit">
				<svg xmlns="http:www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12">
				</svg>
			</button>
		</form>
	</div>
	
	
	
<!-- Footer -->
<%@ include file= "/WEB-INF/inc/footer.jsp" %>
	
	
	<!-- 글 작성 script -->
	<script type="text/javascript">
	
		let v_id = '${sessionScope.login.memId}';
		
		document.getElementById("writeBtn").addEventListener("click", ()=>{
			
			location.href = '${pageContext.request.contextPath }/reviewWriteView';
			
			if(v_id){
				location.href = '${pageContext.request.contextPath }/reviewWriteView';
			}
			else{
				alert("로그인 후 글쓰기가 가능합니다.");
				location.href = '${pageContext.request.contextPath}/loginView';
			} 
			
		})
	</script>
	
	<!-- 페이징 script -->
	<script type="text/javascript">
		let v_search = '${keySearch.searchWord}';
		
		function f_change() {
			console.log(event.target);
			console.log(event.target.value);
			
			let v_url = "${pageContext.request.contextPath}/reviewView";
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