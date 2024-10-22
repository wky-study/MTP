<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>거래소 게시판</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/style.css" />
    <style>
        /* 전체 페이지 스타일 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 20px;
        }

        /* 카드 스타일 */
        .card {
            width: 230px;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 10px;
            text-align: center;
            margin: 10px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s;
        }

        /* 카드 hover 효과 */
        .card:hover {
            transform: scale(1.05);
        }

        /* 썸네일 스타일 */
        .thumbnail {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            overflow: hidden;
            margin: 0 auto 10px auto;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f0f0;
        }

        .thumbnail img {
            max-width: 100%;
            max-height: 100%;
        }

        /* 글 제목 스타일 */
        .title {
            font-size: 18px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }

        /* 작성자 이름 스타일 */
        .author {
            font-size: 14px;
            color: #777;
        }

        /* 헤더 스타일 */
        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        /* 카드 컨테이너 스타일 */
        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
    </style>
</head>
<body>
    <header class="header">
        <h2>거래소 게시판</h2>
        <p>일반 고객이 올린 견적서를 보고 시공사에서 볼 수 있는 게시판</p>
    </header>
    
    <div class="card-container">
        <!-- 첫 번째 카드 -->
        <section class="card">
            <a href="${pageContext.request.contextPath}/estimateDetailView" style="text-decoration: none; color: inherit;">
                <div class="thumbnail">
                    <!-- 견적서가 썸네일로 나타나게 하기까지 해보기(안되면 아쉽고) -->
                    <!-- 글제목이랑 글번호쪽 수정해야함 -->
                </div>
                <div class="title">${cjs.post_no }</div>
                <div class="title">${cjs.post_title }</div>
                <div class="author">${cjs.post_author }</div>
            </a>
        </section>

        <!-- 두 번째 카드 -->
        <section class="card">
            <a href="${pageContext.request.contextPath}/estimateDetailView" style="text-decoration: none; color: inherit;">
                <div class="thumbnail">
                    <!-- 견적서가 썸네일로 나타나게 하기까지 해보기(안되면 아쉽고) -->
                </div>
                <div class="title">${cjs.post_no }</div>
                <div class="title">${cjs.post_title }</div>
                <div class="author">${cjs.post_author }</div>
            </a>
        </section>

        <!-- 세 번째 카드 -->
        <section class="card">
            <a href="${pageContext.request.contextPath}/estimateDetailView" style="text-decoration: none; color: inherit;">
                <div class="thumbnail">
                    <!-- 견적서가 썸네일로 나타나게 하기까지 해보기(안되면 아쉽고) -->
                </div>
                <div class="title">글 제목 3</div>
                <div class="author">작성자: 닉네임</div>
            </a>
        </section>
        
        <!-- 추가 카드 예시 -->
        <section class="card">
            <a href="${pageContext.request.contextPath}/estimateDetailView" style="text-decoration: none; color: inherit;">
            
                <div class="thumbnail">
                	<!-- 견적서가 썸네일로 나타나게 하기까지 해보기(안되면 아쉽고) -->
                </div>
                <div class="title">${cjs.post_no }</div>
                <div class="title">${cjs.post_title }</div>
                <div class="author">${cjs.post_author }</div>
            </a>
        </section>
        
    </div>
</body>
</html>
