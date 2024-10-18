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
    <div class="container">
        <h2 style="text-align: center;">견 적 서</h2>

        <table>
            <tr>
                <td>견적서 분류번호</td>
                <td><input type="text" name="quo_id" class="input-box" /></td>
            </tr>
            <tr>
                <td>상 호 일 자</td>
                <td colspan="3"><input type="date" name="quo_date" class="input-box" /></td>
                <td>시 공 기 간</td>
                <td><input type="text" name="est_period" class="input-box" /></td>
            </tr>
            <tr>
                <td style="height: 50px;">고객 정보</td>
                <td colspan="3">
                    <p>이름: <input type="text" name="mem_name" /></p>
                    <p>연락처: <input type="text" name="mem_phone" /></p>
                    <p>주소: <input type="text" name="est_address" /></p>
                </td>
                <td>시공사 명</td>
                <td><input type="text" name="ent_name" /></td>
            </tr>
            <tr>
                <td>수기사항</td>
                <td colspan="5">
                    형태:
                    <label><input type="radio" name="type" value="단독"> 단독</label>
                    <label><input type="radio" name="type" value="주택"> 주택</label>
                    <label><input type="radio" name="type" value="아파트"> 아파트</label>
                    <label><input type="radio" name="type" value="단지"> 단지</label>
                    <label><input type="radio" name="type" value="기타"> 기타</label>
                    <br>
                    <input type="text" name="est_blueprint" placeholder="est_blueprint" />
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
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
                        <tbody>
                <tr>
                    <td><input type="text" name="item_name" placeholder="예시) 전구" /></td>
                    <td><input type="text" name="item_type" /></td>
                    <td><input type="text" name="unit" /></td>
                    <td><input type="number" name="quantity" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="item_price" placeholder="0" oninput="calculateTotal()" /></td>
					<td><input type="number" name="total_price" placeholder="0" readonly /></td>
                    <td><input type="text" name="remarks" /></td>
                </tr>
            </tbody>
            

            
            <tbody>
                <tr>
                    <td colspan="2">합 계</td>
                    <!-- <td colspan="5"><input type="text" name="total_sum" placeholder="0" readonly /> (원)</td> -->
                    <td colspan="5"><input type="text" name="total_sum" id="total_sum" placeholder="0" readonly /> (원)</td>
                    
                </tr>
            </tbody>
        </table>

        <button class="btn-submit" onclick="submitForm()">제안서 임시저장</button>
        <button class="btn-submit" onclick="submitForm()">견적서 보내기</button>
        <button class="btn-submit" onclick="submitForm()">취 소</button>
    </div>

    <script>
        function submitForm() {
            // 입력된 값들을 수집
            // 추가로 수정 필요함
            const formData = {
                quo_id: document.getElementsByName('quo_id')[0].value,
                quo_date: document.getElementsByName('quo_date')[0].value,
                est_period: document.getElementsByName('est_period')[0].value,
                mem_name: document.getElementsByName('mem_name')[0].value,
                mem_phone: document.getElementsByName('mem_phone')[0].value,
                est_address: document.getElementsByName('est_address')[0].value,
                ent_name: document.getElementsByName('ent_name')[0].value,
                type: document.querySelector('input[name="type"]:checked') ? document.querySelector('input[name="type"]:checked').value : null,
                est_blueprint: document.getElementsByName('est_blueprint')[0].value,
                item_name_1: document.getElementsByName('item_name_1')[0].value,
                item_type_1: document.getElementsByName('item_type_1')[0].value,
                unit_1: document.getElementsByName('unit_1')[0].value,
                quantity_1: document.getElementsByName('quantity_1')[0].value,
                item_price_1: document.getElementsByName('item_price_1')[0].value,
                total_price_1: document.getElementsByName('total_price_1')[0].value,
                remarks_1: document.getElementsByName('remarks_1')[0].value,
                total_sum: document.getElementsByName('total_sum')[0].value
            };

            // 확인을 위한 로그 출력
            console.log(formData);

            // 여기에 서버로 데이터를 전송하는 로직을 추가할 수 있습니다.
            alert("입력된 데이터가 콘솔에 출력되었습니다.");
        }
        
        function calculateTotal() {
            // 'quantity'와 'item_price' 이름을 가진 모든 입력 필드를 가져옴
            let quantities = document.getElementsByName('quantity');
            let itemPrices = document.getElementsByName('item_price');
            let totalPrices = document.getElementsByName('total_price');

            // 각 항목에 대해 반복 처리
            for (let i = 0; i < quantities.length; i++) {
                // 각 필드의 값을 가져옴 (빈 값일 경우 0으로 설정)
                let quantity = quantities[i].value || 0;
                let itemPrice = itemPrices[i].value || 0;

                // 총 가격 계산
                const totalPrice = itemPrice * quantity;

                // 결과를 해당 항목의 'total_price' 필드에 표시
                totalPrices[i].value = totalPrice;
            }

            // 총합 계산 및 표시해주는 함수 실행
            calculateTotalSum();
            
            
        }
        
        function calculateTotalSum() {
            let totalPrices = document.getElementsByName('total_price');
            let totalSum = 0;

            // 총 가격 필드들을 순회하며 총합 계산
            for (let i = 0; i < totalPrices.length; i++) {
                totalSum += parseFloat(totalPrices[i].value) || 0;
            }

            // 총합을 'total_sum' 필드에 표시
            document.getElementsByName('total_sum')[0].value = totalSum;
        }
        
        
    </script>
</body>
</html>
