<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>시공사 측 견적서 수정</title>
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
            width: 1000px;
            align-content: center;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/insertQuo" method="post">
    <div class="container">
        <h2 style="text-align: center;">견 적 서</h2>

        <table>
            <tr>
                <td>견적서 분류번호</td>
                <td><input type="text" name="quoId" class="input-box" /></td>
            </tr>
            <tr>
                <td>작성된 날짜</td>
                <td><input type="date" name="quoDate" class="input-box" /></td>
                <td>시공 시작 날짜</td>
                <td><input type="date" name="quoStart" class="input-box" /></td>
                <td>시공 종료 날짜</td>
                <td><input type="date" name="quoEnd" class="input-box" /></td>
            </tr>
            <tr>
                <td style="height: 50px;">고객 정보</td>
                <td colspan="3">
                    <p>이름: <input type="text" name="memName" /></p>
                    <p>연락처: <input type="text" name="memPhone" /></p>
                    <p>주소: <input type="text" name="estAddress" /></p>
                </td>
                <td>시공사 명</td>
                <td colspan="2"><input type="text" name="entName" /></td>
            </tr>
            <tr>
                <td>수기사항</td>
                <td colspan="6">
                    형태:
                    <label><input type="radio" name="type" value="단독"> 단독</label>
                    <label><input type="radio" name="type" value="주택"> 주택</label>
                    <label><input type="radio" name="type" value="아파트"> 아파트</label>
                    <label><input type="radio" name="type" value="단지"> 단지</label>
                    <label><input type="radio" name="type" value="기타"> 기타</label>
                    <br>
                    <input type="text" name="quoBlueprint" placeholder="도면(BLOB)" />
                </td>
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
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td><input type="text" name="itemName" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="itemType" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" /></td>
                    <td><input type="number" name="totalPrice" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
                <!-- 추가 품목 입력 필드 -->
            </tbody>
            <tbody>
                <tr>
                    <td colspan="2">합 계</td>
                    <td colspan="5"><input type="text" name="totalSum" id="total_sum" placeholder="0" readonly /> (원)</td>
                </tr>
            </tbody>
        </table>

        <button class="btn-submit" type="button" onclick="submitForm()">제안서 임시저장</button>
        <button class="btn-submit" type="submit">제안서 보내기</button>
    </div>
</form>
<button class="btn-submit" onclick="${pageContext.request.contextPath}/estimateDetailView">취 소</button>
        
<script>
    function calculateTotal() {
        let quantities = document.getElementsByName('quantity');
        let itemPrices = document.getElementsByName('itemPrice');
        let totalPrices = document.getElementsByName('totalPrice');

        for (let i = 0; i < quantities.length; i++) {
            let quantity = quantities[i].value || 0;
            let itemPrice = itemPrices[i].value || 0;
            const totalPrice = itemPrice * quantity;
            totalPrices[i].value = totalPrice;
        }
        calculateTotalSum();
    }

    function calculateTotalSum() {
        let totalPrices = document.getElementsByName('totalPrice');
        let totalSum = 0;

        for (let i = 0; i < totalPrices.length; i++) {
            totalSum += parseFloat(totalPrices[i].value) || 0;
        }

        document.getElementsByName('totalSum')[0].value = totalSum;
    }
</script>
</body>
</html>
