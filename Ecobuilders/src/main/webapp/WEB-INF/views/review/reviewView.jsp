<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 게시판 목록</title>

	<style type="text/css">
		div{
			border: 1px solid black;
		}
		
		.content-box{
			display: flex;
			justify-content: center;
			width: 1200px;
			
			flex-wrap: wrap;
			
			margin: auto;
		}
		
		.card-box{
			width: calc(100% / 4 + 1px);
			height: 250px;
			margin: 10px;
			box-shadow: 0px 0px 5px 2px gray;
			border-radius: 2px;
			
			cursor: pointer;
		}
		
		.card-box > img {
			width: 100%;
		}
		
		.card-box > span{
			display: block;
		}
		
		.card-name {
			border-top: 0.5px solid #dddddd;
		
		}
		
		
	
	</style>
</head>
<body>

	<div class="container">
		<div class="content-box">
		
			<!-- 게시글 그리기 -->
			<c:forEach items="${keyReview}" var="ReviewDTO">
				<div class="card-box" id="cardBox" onclick='window.location.href = "${pageContext.request.contextPath }/reviewDetailView?no=${ReviewDTO.reviewNo}/"'>
					<img src="${pageContext.request.contextPath }/resources/assets/img/test1.jpg">
					<span class="card-title">${ReviewDTO.reviewTitle}</span>
					<span class="card-name">${ReviewDTO.memId}</span>
				</div>
			</c:forEach>

		</div>
	</div>
	
	
</body>
</html>