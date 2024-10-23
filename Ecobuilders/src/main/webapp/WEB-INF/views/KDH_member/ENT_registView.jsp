<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>기업회원가입</title>

</head>
<body id="page-top">

    <!-- Contact Section-->
    <section class="page-section" id="contact">

        <div class="container pt-5">
            <!-- Contact Section Heading-->
            <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">기업회원가입</h2>
            <!-- Contact Section Form-->
            <div class="row justify-content-center">
                <div class="col-lg-8 col-xl-7">          	
                    <form id="contactForm" action="${pageContext.request.contextPath }/ENT_registDo" method="POST">
                        
                        <!-- 사업자번호 input-->
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputBr" type="text" name="br" />	
                            <label for="inputBr">사업자번호(-없이입력)</label>
                        </div>

                        <!-- 비밀번호 input-->
                        <div class="form-floating mb-3">
                        	<!-- inputPw의 값이 pw=value 형태로 전송되어야 함. pw를 name속성에 넣어주기 -->
                            <input class="form-control" id="inputPw" type="password" name="pw" />
                            <label for="inputPw">비밀번호</label>
                        </div>
                        
                        <!-- 회사명 input-->
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputName" type="text" name="name" />	
                            <label for="inputName">회사명</label>
                        </div>     
                        
                        <!-- 대표자명 input -->                                                   
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputCeo" type="text" name="ceo" />	
                            <label for="inputCeo">대표자명</label>
                        </div> 
                        
                        <!-- 전화번호 input -->                                                   
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputPhone" type="tel" name="phone" />	
                            <label for="inputPhone">전화번호</label>
                        </div> 
                        
                        <!-- 회사주소 input -->
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputAddress" type="address" name="address" />	
                            <label for="inputENT_Address">회사주소</label>
                        </div> 
                            
                        <!-- 이메일 input -->
                        <div class="form-floating mb-3">
                            <input class="form-control" id="inputEmail" type="email" name="email" />	
                            <label for="inputEmail">이메일</label>
                        </div>     
                        
                        <!-- Submit Button-->
                        <button class="btn btn-primary btn-xl" id="submitButton" type="submit">기업회원가입</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
	<script type="text/javascript">		
	
	</script>
</body>

</html>