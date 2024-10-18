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
		
		<!-- 글쓰기 버튼 임시 -->
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
	
	<!-- 화면 그리기 script -->
	<script type="text/javascript">
	    const v_contentBox = document.querySelector('.content-box');
	    
	    let v_pageNo = '${keySearch.pageNo}';
	    
	    // 페이지 벗어나기 직전에 스크롤을 최상단에 올리는 코드 넣기
		window.onload = function(){
	    	setTimeout (function (){
	    		scrollTo(0,0);
	    	}, 100);
	    };
	    
	    
	    window.addEventListener('scroll', () => {
	        // 현재 스크롤 위치
	        const scrollY = window.scrollY;
	        
	        // 현재 창의 높이
	        const windowHeight = window.innerHeight;
	        
	        // 전체 문서의 높이
	        const documentHeight = document.documentElement.scrollHeight;
	        
	        // 맨 아래에 도달했는지 확인
	        if (scrollY + windowHeight >= documentHeight) {
	        	
	            console.log('맨 아래에 도달했습니다!');
	            
	            v_pageNo++;
	            
		        // .card-box 요소의 개수
	            const reviewCount = document.querySelectorAll('.card-box').length; 
		        console.log(reviewCount);
		        
		        let v_data = 'reviewCount=' + '${keySearch.reviewCount}';
		        	v_data += '&pageNo=' + v_pageNo; 

	            // AJAX 요청으로 서버에 데이터 요청
	            $.ajax({
	                type: "POST",
	                url: "${pageContext.request.contextPath}/loadMoreDO", // 서버 URL
	                data: v_data, // 현재 로드된 게시글 수 전달
	                success: function(resp) {
	                    console.log(resp); 
						let v_json = resp
						console.log(v_json);
						
						// 넘어온 데이터가 없을 시 이벤트 제거
	                    if (v_json.length < 1) {
	                        console.log('더 이상 데이터가 없습니다.');
	                        window.removeEventListener('scroll', arguments.callee);
	                        return; // 더 이상 실행하지 않음
	                    }
	                    
	                    let newCardsHtml = '';
	                    // for문으로 v_json의 길이만큼 반복
	                    for (let i = 0; i < v_json.length; i++) {
	                        const ReviewDTO = v_json[i]; // 각 ReviewDTO를 가져옴
	                        
	                        newCardsHtml += '';
	                        newCardsHtml += '<div class="card-box" id="cardBox" ';
	                        newCardsHtml += 'onclick=\'window.location.href="' + '${pageContext.request.contextPath}' + '/reviewDetailView?no=' + ReviewDTO['reviewNo'] + '"\'>';
	                        newCardsHtml += '<img src="' + '${pageContext.request.contextPath}' + '/resources/assets/img/test1.jpg">';
	                        newCardsHtml += '<span class="card-title">' + ReviewDTO['reviewTitle'] + '</span>';
	                        newCardsHtml += '<span class="card-name">' + ReviewDTO['memId'] + '</span>';
	                        newCardsHtml += '</div>';
	                    }

	                    v_contentBox.insertAdjacentHTML('beforeend', newCardsHtml);
	                    
	                    
	                }
	            }); 
	            
	        }
	    });
	</script>
	
</body>
</html>