<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <title>마이페이지</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .profile-box {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px auto;
        }

        .profile-img {
            width: 100%;
            cursor: pointer;
        }

        .form-container {
            max-width: 600px;
            margin: auto;
        }
    </style>
</head>

<body>
    <div class="container pt-5">
        <h2 class="text-center text-uppercase text-secondary mb-4">일반회원 My Page</h2>

        <!-- 정보 수정 Form -->
        <form id="memEditForm" action="${pageContext.request.contextPath}/memEditDo" method="POST" class="form-container">

            <!-- 아이디 (읽기 전용) -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputId" type="text" name="memId" 
                    value="${sessionScope.login.memId}" readonly />
                <label for="inputId">아이디</label>
            </div>

            <!-- 비밀번호 -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputPw" type="password" name="memPassword" 
                    placeholder="비밀번호 입력" />
                <label for="inputPw">비밀번호</label>
            </div>

            <!-- 이름 -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputName" type="text" name="memName" 
                    value="${sessionScope.login.memName}" />
                <label for="inputName">이름</label>
            </div>

            <!-- 전화번호 -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputPhone" type="tel" name="memPhone" 
                    pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}" value="${sessionScope.login.memPhone}" 
                    placeholder="010-1234-5678" />
                <label for="inputPhone">전화번호</label>
            </div>

            <!-- 이메일 -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputEmail" type="email" name="memEmail" 
                    value="${sessionScope.login.memEmail}" />
                <label for="inputEmail">이메일</label>
            </div>

            <!-- 주소 -->
            <div class="form-floating mb-3">
                <input class="form-control" id="inputAddress" type="text" name="memAddress" 
                    value="${sessionScope.login.memAddress}" />
                <label for="inputAddress">주소</label>
            </div>

            <div class="d-flex justify-content-center mt-4">
                <button class="btn btn-primary me-2" id="memEditBtn" type="button">수정</button>
                <button class="btn btn-danger" id="memDelBtn" type="button" data-bs-toggle="modal" data-bs-target="#confirmModal">회원탈퇴</button>
            </div>
        </form>
    </div>

    <!-- 회원탈퇴 확인 모달 -->
    <div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="confirmLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmLabel">회원탈퇴 확인</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    정말로 탈퇴하시겠습니까? 아이디를 입력해주세요.
                    <input type="text" id="confirmInput" class="form-control mt-2" placeholder="아이디 입력">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                    <button type="button" id="confirmDelete" class="btn btn-danger">탈퇴</button>
                </div>
            </div>
        </div>
    </div>

    <!-- JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript">
        let v_memId = '${sessionScope.login.memId}';

        // 수정 버튼 클릭 시 form 제출
        document.getElementById("memEditBtn").addEventListener("click", () => {
            document.getElementById("memEditForm").submit();
        });

        // 회원탈퇴 모달의 삭제 버튼 클릭 시 처리
        document.getElementById("confirmDelete").addEventListener("click", () => {
            const inputId = document.getElementById("confirmInput").value;
            if (inputId === v_memId) {
                document.getElementById("memDelForm").submit();
            } else {
                alert("아이디가 일치하지 않습니다.");
            }
        });
    </script>
</body>

</html>
