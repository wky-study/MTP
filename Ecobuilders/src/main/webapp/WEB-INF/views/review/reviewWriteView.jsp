<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>리뷰 작성</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
	<style type="text/css">
	
		div{
			border: 1px solid black;
		}
		
		.top-box{
			height: 400px;
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
			
			<div class="mb-3">
			  <label for="exampleFormControlInput1" class="form-label">Email address</label>
			  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
			</div>
			<div class="mb-3">
			  <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
			  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>			
			
		</div>
	</section>
	
	
</body>
</html>