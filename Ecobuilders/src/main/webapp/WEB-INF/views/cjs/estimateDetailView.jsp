<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>그린리모델링 견적서 보기 페이지</title>
    <%@ include file= "/WEB-INF/inc/style.jsp" %>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #000;
            text-align: center;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .input-box {
            width: 100%;
            text-align: center;
            border: none;
        }
        .btn-submit {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .green-section {
            margin-top: 30px;
            background-color: #e0f7fa;
            padding: 15px;
            border: 1px solid #000;
        }
        .container {
            width: 1300px;
            align-content: center;
            margin: auto;
        }
    </style>
</head>
<body>
	<%@ include file= "/WEB-INF/inc/header.jsp" %>
    <div class="container">
        <h2 style="text-align: center;">견 적 서</h2>

        <table>
            <tr>
                <td>견적서 분류번호</td>
                <td>est_id</td>
            </tr>
            <tr>
                <td>상 호 일 자</td>
                <td colspan="3">est_date</td>
                <td>시 공 기 간</td>
                <td>est_period</td>
            </tr>
            <tr>
                <td style="height: 50px;">고객 정보</td>
                <td colspan="3">
                    <p>이름: mem_name</p>
                    <p>연락처: mem_phone</p>
                    <p>주소: est_address</p>
                </td>
                <td>시 공 사 명</td>
                <td><input class="input-box" type="text"></td>
            </tr>
            <tr>
                <td>수기사항</td>
				<td colspan="5">형태:<input type="text" name="a" placeholder="예시) 주택" class="input-box" /></td>
            </tr>
        </table>

        <h3>공종별 항목</h3>
        <table>
            <thead>
                <tr>
                    <th>품목</th>
                    <th>구분</th>
                    <th>단위</th>
                    <th>수량</th>
                    <th>단가</th>
                    <th>금액</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>전구</td>
                    <td>자재종류들어오면 될거같음</td>
                    <td>1</td>
                    <td>12</td>
                    <td>10,000</td>
                    <td><input type="number" placeholder="0" class="input-box"></td>
                    <td></td>
                </tr>
            </tbody>
            <tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
						<td class="inputbox"></td>
					</tr>
			</tbody>
			<tbody>
					<tr>
						<td colspan="2">합 계</td>
						<td colspan="5"><p><input type="text" name="quoPrice" placeholder="0" readonly /> (원)</p></td>
					</tr>
				</tbody>
        </table>

        <button class="btn-submit" onclick="submitForm()">제안서 수락</button>
        <a href="${pageContext.request.contextPath }/estimateMod">
            <button class="btn-submit">견적 수정 및 제안하기</button>
        </a>
    </div>
    
    <%@ include file= "/WEB-INF/inc/footer.jsp" %>

    <script>
        function submitForm() {
            alert("임시로 대충 만들어둔거니 제대로된 기능은 아직 생각 ㄴㄴ");
            // 여기에 제출 로직을 추가할 수 있습니다 (예: 서버로 데이터 전송)
        }
    </script>
</body>
</html>
