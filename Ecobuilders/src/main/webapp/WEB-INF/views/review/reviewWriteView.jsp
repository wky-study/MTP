<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>

<!-- 밑에 두줄 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<!-- 네이버 스마트 에디터 js파일 불러오기 -->
<script src="${pageContext.request.contextPath }/nse/js/HuskyEZCreator.js"></script>

<!-- jquery (AJAX 통신) -->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	
	
	<style type="text/css">
	
		div{
			border: 0px solid black;
		}
		
		.top-box{
			height: 350px;
			display: flex;
			justify-content: center;
			align-items:center;
			
			background-color: #F5F5F5;
		}
		
		.top-box > span{
			font-size: 100px;
			font-weight: bold;
			
			color: #ccc;
		}


	</style>
	
	
</head>
<body>

	<div class="top-box">
		<span>리뷰 작성</span>		
	</div>
			
	<section class="page-section" id="contact">
		<div class="container pt-5">
		
		
			<input type="file" id="inputImg" accept="image/*" hidden="true" onchange="f_sandImg()">
			
			<form id="reviewWriteForm" action="${pageContext.request.contextPath }/reviewWriteDo" method="POST" enctype="multipart/form-data">
				<div class="mb-3">
					<input class="form-control" id="inputId" type="text" name="reviewTitle" placeholder="제목을 입력해주세요."/>
				</div>

				<div class="mb-3">
					<textarea id="smartEditor" class="form-control"  rows="10" name="reviewContent"></textarea>
				</div>					
				
				<div class="d-flex justify-content-end">
					<a class="btn btn-secondary me-2" href="${pageContext.request.contextPath }/reviewView">취소</a>
					
					<!-- form 태그의 submit 역할을 함 -> type=submit 넣어주기 -->
					<button id="writeBtn" class="btn btn-primary" type="button">등록</button>
				</div>
			</form>
			
		</div>
	</section>
	
	<!-- 네이버 스마트 에디터 -->
	<script type="text/javascript">
		var oEditors = [];
		
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "smartEditor",  // textarea의 id
			sSkinURI : "${pageContext.request.contextPath }/nse/SmartEditor2Skin.html"
			
		});
		
		document.getElementById("writeBtn").addEventListener('click', ()=>{
			
			// 에디터에 작성된 내용(html태그 형태)을 숨겨진 textarea에 반영
			oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);
			
			document.getElementById("reviewWriteForm").submit();
		})
		
		// 이미지 첨부 받을 input 태그 객체 불러오기
		const v_inputImg = document.getElementById("inputImg");
		
		// 스마트에디터가 로드된 후 이미지 첨부 버튼에 클릭 이벤트 추가
		window.onload = function(){
			// 스마트 에디터가 그려진 iframe 가져오기
			const v_iframe = document.querySelector('#reviewWriteForm > div:nth-child(2) > iframe');
			console.log(v_iframe);
			// iframe 내 document 에 접근
			const v_iframeDocument = v_iframe.contentWindow.document;
			console.log(v_iframeDocument);
			// iframe의 document 안에 있는 이미지 첨부 버튼(id가 photoUploadBtn)에
			// 클릭 이벤트 부여
			v_iframeDocument.querySelector('#photoUploadBtn').addEventListener("click", ()=>{
				// 에디터 내 이미지 첨부 버튼 클릭 시 inputImg 태그 클릭
				v_inputImg.click();
			});
			
		}
		
		// 파일 첨부시 실행
		function f_sandImg(){
			let v_formData = new FormData();
			v_formData.append('file',event.target.files[0]);
			
			// 요청보낼 주소
			let v_url = '${pageContext.request.contextPath}/uploadImg';
			
			// AJAX 통신 요청
			$.ajax({
				type: 'POST',
				url: v_url,
				contentType: false,
				processData: false,
				enctype: 'multipart/form-data',
				data: v_formData,
				success: function(resp){
					// 이미지 태그 생성
					let imgTag = '<img style="width: 400px" src="';
						imgTag += '${pageContext.request.contextPath}/displayImage?fileName=' + resp;
						imgTag += '">'; 
						
					// 에디터 내부에 이미지 태그 넣기
					oEditors.getById['smartEditor'].exec("PASTE_HTML", [imgTag]);
				}
			});
		}
		
	</script>
	
	
</body>
</html>