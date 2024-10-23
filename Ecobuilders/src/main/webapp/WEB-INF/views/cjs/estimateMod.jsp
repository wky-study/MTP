<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>시공사 측 견적서 수정</title>
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
    width: 90%; /* 가로 넓이를 90%로 변경 */
    text-align: center;
    border: none;
    background-color: white;
    transition: background-color 0.3s;
}

.input-box.filled {
    background-color: #dff0d8; /* 입력 완료 색상 */
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
}
</style>
</head>
<body>
	<%@ include file= "/WEB-INF/inc/header.jsp" %>
	
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
					<td><input type="date" name="quoStartdate" class="input-box" /></td>
					<td>시공 종료 날짜</td>
					<td><input type="date" name="quoEnddate" class="input-box" /></td>
				</tr>
				<tr>
					<td style="height: 50px;">고객 정보</td>
					<td colspan="3">
						<p>
							이름: <input type="text" name="memName" class="input-box" />
						</p>
						<p>
							연락처: <input type="text" name="memPhone" class="input-box" />
						</p>
						<p>
							주소: <input type="text" name="estAddress" class="input-box" />
						</p>
					</td>
					<td>시공사 명</td>
					<td colspan="2" class="input-box" >${sessionScope.login.entName}</td>
				</tr>
				<tr>
					<td>수기사항</td>
					<td colspan="5">형태:<input type="text" name="a" placeholder="예시) 주택" class="input-box" />

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
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td><input type="text" name="itemName" placeholder="제품명)" class="input-box" /></td>
						<td><input type="text" name="itemType" class="input-box" /></td>
						<td><input type="text" name="unit" class="input-box" /></td>
						<td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="itemPrice" placeholder="0" oninput="calculateTotal()" class="input-box" /></td>
						<td><input type="number" name="totalPrice" placeholder="0" readonly class="input-box" /></td>
						<td><input type="text" name="remarks" class="input-box" /></td>
					</tr>
				</tbody>
				
				<tbody>
					<tr>
						<td colspan="2">합 계</td>
						<td colspan="5"><p><input type="text" name="quoPrice" placeholder="0" readonly /> (원)</p></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="quoOpen" id="quoOpen" />

			<button class="btn-submit" type="button" onclick="submitForm('Y')">제안서 임시저장</button>
			<button class="btn-submit" type="button" onclick="submitForm('N')">제안서 보내기</button>
	</form>
		<button class="btn-submit" onclick="location.href='${pageContext.request.contextPath}/estimateDetailView'">취 소</button>
		</div>
	
	<%@ include file= "/WEB-INF/inc/footer.jsp" %>
	<script>
	function submitForm(quoOpenValue) {
	    document.getElementById("quoOpen").value = quoOpenValue; 
	    document.forms[0].submit();
	}

    function calculateTotal() {
        let quantities = document.getElementsByName('quantity');
        let itemPrices = document.getElementsByName('itemPrice');
        let totalPrices = document.getElementsByName('totalPrice');

        for (let i = 0; i < quantities.length; i++) {
            let quantity = quantities[i].value || 0;
            let itemPrice = itemPrices[i].value || 0;
            const totalPrice = itemPrice * quantity;
            totalPrices[i].value = totalPrice;

            // 배경색 변경
            if (quantity > 0 || itemPrice > 0) {
                quantities[i].classList.add('filled');
                itemPrices[i].classList.add('filled');
            } else {
                quantities[i].classList.remove('filled');
                itemPrices[i].classList.remove('filled');
            }
        }
        calculateTotalSum();
    }

    function calculateTotalSum() {
        let totalPrices = document.getElementsByName('totalPrice');
        let quoPrice = 0;

        for (let i = 0; i < totalPrices.length; i++) {
        	quoPrice += parseFloat(totalPrices[i].value) || 0;
        }

        document.getElementsByName('quoPrice')[0].value = quoPrice; // 총 합계 값을 입력
    }
</script>
</body>
</html>
