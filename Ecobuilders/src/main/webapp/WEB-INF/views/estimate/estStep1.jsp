<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/inc/style.jsp"%>

</head>
<body>
	<%@ include file="/WEB-INF/inc/header.jsp"%>
	<!-- 건물 및 집 정보를 받는 페이지 -->
	<h2>기본정보입력</h2>
	<hr>
	<input type="button" onclick="inputAdress()" value="주소 찾기" />
	<br />
	<input type="text" id="sample4_roadAddress" placeholder="도로명주소" />
	<input type="text" id="sample4_jibunAddress" placeholder="지번주소" />
	<span id="guide" style="color: #999; display: none"></span>
	<input type="text" id="sample4_detailAddress" placeholder="상세주소" />
	<input type="text" id="sample4_extraAddress" placeholder="참고항목" />




	<hr>
	<input type="button" onclick="goStep2()" value="Next" />


	<%@ include file="/WEB-INF/inc/footer.jsp"%>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		let roadAddr = ""; // 도로명 주소 변수
		let extraRoadAddr = ""; // 참고 항목 변수

		function inputAdress() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							roadAddr = data.roadAddress; // 도로명 주소 변수
							extraRoadAddr = ""; // 참고 항목 변수

							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ""
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ""
									&& data.apartment === "Y") {
								extraRoadAddr += extraRoadAddr !== "" ? ", "
										+ data.buildingName : data.buildingName;
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraRoadAddr !== "") {
								extraRoadAddr = " (" + extraRoadAddr + ")";
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById("sample4_roadAddress").value = roadAddr;
							document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

							// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
							if (roadAddr !== "") {
								document.getElementById("sample4_extraAddress").value = extraRoadAddr;
							} else {
								document.getElementById("sample4_extraAddress").value = "";
							}

							var guideTextBox = document.getElementById("guide");
							// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
							if (data.autoRoadAddress) {
								var expRoadAddr = data.autoRoadAddress
										+ extraRoadAddr;
								guideTextBox.innerHTML = "(예상 도로명 주소 : "
										+ expRoadAddr + ")";
								guideTextBox.style.display = "block";
							} else if (data.autoJibunAddress) {
								var expJibunAddr = data.autoJibunAddress;
								guideTextBox.innerHTML = "(예상 지번 주소 : "
										+ expJibunAddr + ")";
								guideTextBox.style.display = "block";
							} else {
								guideTextBox.innerHTML = "";
								guideTextBox.style.display = "none";
							}
						},
					}).open();
		}
		function goStep2() {
			let flag = true;
			if (roadAddr == "") {
				alert("주소를 입력해 주세요");
				flag = false;
			}
			if (flag) {
				location.href = "${pageContext.request.contextPath}/estStep2";
			}
		}
	</script>

</body>

</html>