<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>${keyReview.reviewTitle}</title>

<!-- 밑에 두줄 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

	<!-- jQuery 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 


	<style type="text/css">
		div{
			border: 0px solid black;
		}

		.top-box{
			height: 550px;
			display: flex;
			justify-content: center;
			align-items:center;
			
			overflow: hidden;
			
			background-color: #F5F5F5;
		}
		
		.top-box > img {
			width: 100%;
		}
		
		.content-box{
			width: 800px;	
			margin: auto;
		}
		
		.est-box {
			height: 280px;
			border: 1px solid black;
		}
		
		.my-hr {
		    margin: 0;
		    padding: 0;
		    height: 1px;
		    border: none;
		    background-color: #EAEDEF;
		    margin-top: 20px;
		}
		.my-span{
			font-weight: 500;
		    font-size: 13px;
		    line-height: 18px;
		    color: #828C94;
		}
		
		.my-info {
			border-top : 1px solid #ddd;
			border-bottom : 1px solid #ddd;
			
			height: 100px;
		
		}

	
	</style>
</head>
<body>

	<div class="top-box mb-5">
		<img src="${pageContext.request.contextPath }/displayImage?fileName=${keyReview.reviewPath}">
	</div>

	<div class="container">
		<div class="content-box">
			
			<!-- 바디 부분 -->
			<div class="d-block">
				<h1>${keyReview.reviewTitle }</h1>
				<div class="d-flex justify-content-between mb-3 mt-3">
					<h4>${keyReview.memName}</h4>
					<button type="button" class="btn btn-info">팔로우</button>
				</div>
				
				<!-- 견적서에 따른 데이터 들어갈곳 추후 -->
				<div class="est-box">
					<span>견적서 내용 들어갈곳</span>
				</div>
				
				<!-- 내용 부분 -->
				<div class="mt-5 mb-5">${keyReview.reviewContent}</div>
				
				<!-- 내용 끝  -->
				<!-- 현재 하드코딩 -->
				<div >
					<div class="d-flex justify-content-between mt-3">
						<div>
							<span class="my-span">좋아요 : 0</span>
							<span class="my-span">조회수 : 0</span>
						</div>
						<div>
							<span class="my-span">신고하기</span>
						</div>
					</div>
					
					<div class="d-flex justify-content-between align-items-center mb-5 mt-3 my-info">
						<h4>${keyReview.memName}</h4>
						<button type="button" class="btn btn-info">팔로우</button>
					</div>
				</div>
				
				<!-- 댓글 창 -->
				<div>
					
					<!-- 하드코딩상태 -->
					<div>
						<h2>댓글 : 0</h2>
					</div>
				
					<!-- 댓글 리스트 -->
					<div id="replyBox" class="reply-box">
						<!-- 밑에 참고 -->
						<c:forEach items="${keyReplyList }" var="replyDTO">
							<div class="row pt-2 pb-2">
								<input type="hidden" value="${replyDTO.replyNo }">
								<div class="col-2">${replyDTO.memName }</div>
								<div class="col-7">${replyDTO.replyContent }</div>
								<div class="col-2">${replyDTO.replyDate }</div>
								<div class="col-1">
								
									<!-- 로그인 기능 나오면 변경 -->
									<c:if test="${sessionScope.login.memId == replyDTO.memId && sessionScope.login.memId != null}">
										<span class="my-span" onclick="f_delete()">삭제</span>
									</c:if>
									
								</div>
							</div>
						</c:forEach>
					</div>
					
					<!-- 댓글 작성하는곳 -->
					<div class="mt-5 mb-5">
						<form id="replyForm" class="row" action="${pageContext.request.contextPath }/replyWriteDo" method="POST">
							<input type="hidden" name="memId" value="${sessionScope.login.memId }">
							<input type="hidden" name="reviewNo" value="${keyReview.reviewNo }">
							<div class="col-10">
								<input id="replyInput" class="form-control" type="text" name="replyContent">
							</div>
							<button id="replyBtn" class="btn btn-primary col-2" type="button">등록</button>
						</form>
					</div>
				</div>				
				
			</div>
			


		</div>
	</div>

	
	<script type="text/javascript">
	
	/* 댓글 입력 창 클릭 이벤트 */
	document.getElementById("replyInput").addEventListener("click", ()=>{
		
		
		if(!v_name){
			location.href = "${pageContext.request.contextPath}/loginView";
		} 
		
		
	})
	
	let v_replyBox = document.getElementById("replyBox");			

	/* 등록버튼 클릭 이벤트 */
	document.getElementById("replyBtn").addEventListener("click", ()=>{
	let v_replyInput =  document.getElementById("replyInput").value;

	/* form 태그 가져오기 */
	let v_formData = $('#replyForm').serialize(); // replyContent = asdsa
	let v_url = $('#replyForm').attr('action');
	
	// memId, boardNo, replyContent 데이터
	console.log(v_formData);
	
	
	$.ajax({
		type : "POST",
		url : v_url,
		data : v_formData,
		success : function(resp){
			console.log(resp);	  //JSON 객체 (jQuery에서 자동으로 parse 해줌)
			
			/* 댓글창 비워주기 */
			document.getElementById("replyInput").value = "";	
			
			// 댓글 한줄에 대한 html코드 생성
			let v_reply = '<div class="row pt-2 pb-2">';
			v_reply += '     <input type="hidden" value="' + resp['replyNo'] + '">';
			v_reply += '     <div class="col-2">' + resp['memName'] + '</div>';
			v_reply += '     <div class="col-7">' + resp['replyContent'] + '</div>';
			v_reply += '     <div class="col-2">' + resp['replyDate'] + '</div>' ;
			v_reply += '     <div class="col-1">';
			v_reply += '       <span class="my-span" onclick="f_delete()">삭제</span>';
			v_reply += '     </div>'; 
			v_reply += '   </div>'; 
			
			v_replyBox.innerHTML += v_reply; 
		}
	});
	
	
	if(!v_replyInput){
		return;
	}
	

		
		
	});

	function f_delete(){
		if(!confirm("정말로 삭제하시겠습니까?")){
			return;
		}
		
		console.log(event.target.parentElement);
		console.log(event.target.parentElement.parentElement.children[0].value);
		let v_parent = event.target.parentElement.parentElement;
		
		let v_replyNo = event.target.parentElement.parentElement.children[0].value;
		
		// AJAX 통신으로 해당 replyNo에 대한 UPDATE문 실행
		let v_ajax = new XMLHttpRequest();
		
		v_ajax.open('POST', '${pageContext.request.contextPath}/delReplyDo');
		
		// 데이터를 보내기 위해 데이터 형식을 만들어 주기 (form의 serialize 형태) 
		let v_data = "replyNo=" + v_replyNo;
		
		// form의 serialize 형태로 데이터를 보내기 위한 헤더 설정
		v_ajax.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		
		// AJAX 통신이 끝나고 나면 실행되는 함수 (콜백함수)
		v_ajax.onload = ()=>{
			// 응답은 success 아니면 fail 문자열이 옴
			console.log(v_ajax.response);
			
			if(v_ajax.response == 'success'){
				v_parent.remove();
			}
			
		}
		
		// send 시 데이터를 보낸다.
		v_ajax.send(v_data);
		//event.target.parentElement.parentElement.remove();
		
	}	
	
	</script>
	
	
</body>
</html>