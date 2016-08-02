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
	<%@include file="/menu_admin.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header
			class="mdl-layout__header mdl-layout__header--waterfall portfolio-header">
		<div class="mdl-layout__header-row portfolio-logo-row">
			<span class="mdl-layout__title">
				<div class="portfolio-logo"></div> <span class="mdl-layout__title">Simple
					portfolio website</span>
			</span>
		</div>
		<div
			class="mdl-layout__header-row portfolio-navigation-row mdl-layout--large-screen-only">
			<button id="my-account" class="mdl-button mdl-js-button">银行操作员管理</button>
			<button id="transfer" class="mdl-button mdl-js-button">报表查询</button>
			<button id="credit-card" class="mdl-button mdl-js-button">系统参数管理</button>
			<button id="pay" class="mdl-button mdl-js-button">监控管理</button>
			<button id="setting" class="mdl-button mdl-js-button">设置</button>
		</div>
		</header>
		<div class="mdl-layout__drawer mdl-layout--small-screen-only">
			<button id="my-account" class="mdl-button mdl-js-button">银行操作员管理</button>
			<button id="transfer" class="mdl-button mdl-js-button">报表查询</button>
			<button id="credit-card" class="mdl-button mdl-js-button">系统参数管理</button>
			<button id="pay" class="mdl-button mdl-js-button">监控管理</button>
			<button id="setting" class="mdl-button mdl-js-button">设置</button>
		</div>
		<main class="mdl-layout__content">
		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">登录</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<c:if test="${!empty loginError}">
					<c:out value="${loginError}" />
				</c:if>
				<form action="loginAction.action" id＝"form" method="post">
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