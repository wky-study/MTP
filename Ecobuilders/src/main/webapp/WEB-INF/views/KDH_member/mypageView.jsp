<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<!-- jQuery 추가 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<!--Style-->
<%@ include file="/WEB-INF/inc/style.jsp"%>

<style>
		.div {
			border: 0px solid black;

		}

        .actions-m {
            list-style: none;
            padding: 2%;
            display: flex;
            justify-content: center;
        }

        .actions-m li {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .my {
            text-align: center;
            margin-top: 60px;
            font-weight: bold;
            color: #333;
            font-size: 36px;
        }
        
         .button-m {
         	width: 300px;
            padding: 30px;
            text-align: center;
            border-radius: 40px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            transition: background-color 0.3s ease, transform 0.2s;
        }
        
         .button-m:hover {
            background-color: #0faf24c9;
            transform: scale(1.05);
        }
        
</style>

</head>

<body>

	<!-- Header -->
	<%@ include file="/WEB-INF/inc/header.jsp"%>

	<!-- 마이페이지 -->
	<section>
		<h2 class="my">마이페이지</h2>
		<ul class="actions-m">
			<li>
				<a href="${pageContext.request.contextPath }/memEditView" class="button-m" style="background-color: #0faf24c9;">회원정보 및 수정</a>
				<a href="${pageContext.request.contextPath }/mp_estimateList" class="button-m" style="background-color: #0faf24c9;">나의견적서</a>
			</li>
		</ul>
	</section>


        
</body>

<!-- Footer -->
<%@ include file="/WEB-INF/inc/footer.jsp"%>

</html>