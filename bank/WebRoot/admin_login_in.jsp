<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />
<script src="material.min.js"></script>
<style>
.mdl-card {
	margin-top: 100px;
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
	<%-- <%@include file="/admin_menu.jsp"%> --%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%-- <%@include file="/admin_header.jsp"%> --%>
		<header class="mdl-layout__header portfolio-header">
            <div class="mdl-layout__header-row "></div>
        </header>
		<main class="mdl-layout__content">
		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">登录</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<c:if test="${!empty loginError}">
					<c:out value="${loginError}" />
				</c:if>
				<form action="admin_signUp" id＝"form" method="post">
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="userName"> <label class="mdl-textfield__label"
							for="sample3">用户名...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="sample3"
							name="password"> <label class="mdl-textfield__label"
							for="sample3">密码...</label>

					</div>
					<div class="mdl-card__actions">
						<a href="forget_username.jsp"
							class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记用户名</a>
						<a href="forget_password.jsp"
							class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记密码</a>
						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">登录</button>
					</div>

				</form>
			</div>
		</div>
		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>