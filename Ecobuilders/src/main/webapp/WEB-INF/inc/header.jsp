<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!-- Header -->
	<header id="header">
		<h1><a href="${pageContext.request.contextPath}/">Eco Builders</a></h1>
		<nav id="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Main</a></li>
				<li><a href="${pageContext.request.contextPath}/prodView">Products</a></li>
				<li><a href="${pageContext.request.contextPath}/reviewView">Reviews</a></li>
				<c:if test="${sessionScope.login == null}">
				<li><a href="${pageContext.request.contextPath}/loginView" class="button special">Login</a></li>
				</c:if>
				<c:if test="${sessionScope.login != null}">
				<li><a href="${pageContext.request.contextPath}/mypageView">${sessionScope.login.memName} 님</a></li>
				<li><a href="<c:url value="/logoutDo" />" class="button special">Logout</a></li>
				</c:if>
				
			</ul>
		</nav>
	</header>