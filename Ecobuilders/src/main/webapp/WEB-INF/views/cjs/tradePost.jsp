<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>견적서 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="/WEB-INF/inc/style.jsp" %>
    <style>
        /* 전체 페이지 스타일 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
        }

        /* 카드 스타일 */
        .card {
            width: calc(25% - 20px);
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
    <%@ include file="/WEB-INF/inc/header.jsp" %>
    <header class="header">
        <h2>견적서 목록</h2>
        <p>고객이 올린 견적서를 확인할 수 있는 페이지입니다.</p>
    </header>
    
    <div class="card-container">
        <!-- 견적서 카드 -->
        <c:if test="${empty estimateList}">
            <p>견적서 목록이 없습니다.</p>
        </c:if>
        
        <c:forEach items="${estimateList}" var="estimateDTO">
            <section class="card">
                <a href="${pageContext.request.contextPath}/estimateDetailView/${estimateDTO.estId}" style="text-decoration: none; color: inherit;">
                    <div class="title">${estimateDTO.memName}의 견적서</div>
                    <div class="author">작성자: ${estimateDTO.memName}</div>
                </a>
            </section>
        </c:forEach>
    </div>
    <%@ include file="/WEB-INF/inc/footer.jsp" %>
</body>
</html>
