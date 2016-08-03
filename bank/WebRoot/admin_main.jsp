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
	<%@include file="/admin_menu.jsp"%>
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
			<button id="transfer" class="mdl-button mdl-js-button">利率设置</button>
			<button id="credit-card" class="mdl-button mdl-js-button">系统参数管理</button>
			<button id="pay" class="mdl-button mdl-js-button">利率设置</button>
			<button id="setting" class="mdl-button mdl-js-button">设置</button>
		</div>
		</header>
		<div class="mdl-layout__drawer mdl-layout--small-screen-only">
			<button id="my-account" class="mdl-button mdl-js-button">银行操作员管理</button>
			<button id="transfer" class="mdl-button mdl-js-button">利率设置</button>
			<button id="credit-card" class="mdl-button mdl-js-button">系统参数管理</button>
			<button id="pay" class="mdl-button mdl-js-button">利率设置</button>
			<button id="setting" class="mdl-button mdl-js-button">设置</button>
		</div>
		<main class="mdl-layout__content">

		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>