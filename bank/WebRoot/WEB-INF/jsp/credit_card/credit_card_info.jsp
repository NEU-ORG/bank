<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />
<style>
.demo-card-event.mdl-card {
	width: 256px;
	height: 256px;
	margin-top: 30px;
	padding: 10px;
	padding-top:40px;
}
</style>
</head>
<body>
	<ul
		class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
		for="my-account">
		<li class="mdl-menu__item" onclick="location='about.html'">帐户查询</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">账户挂失</li>
		<li class="mdl-menu__item">添加新账户</li>
		<li class="mdl-menu__item">删除帐户</li>
	</ul>
	<ul
		class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
		for="transfer">
		<li class="mdl-menu__item">Some Action</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another
			Action</li>
		<li disabled class="mdl-menu__item">Disabled Action</li>
		<li class="mdl-menu__item">Yet Another Action</li>
	</ul>
	<ul
		class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
		for="credit-card">
		<li onclick="location='creditCard_info.action'" class="mdl-menu__item">信用卡查询</li>
		<li onclick="location='creditCard_changeSPassword.action'"
			class="mdl-menu__item">查询密码设置</li>
		<li onclick="location='creditCard_changeTPassword.action'"
			class="mdl-menu__item mdl-menu__item--full-bleed-divider">交易密码设置</li>

		<li onclick="location='creditCard_apply.action'"
			class="mdl-menu__item">申请信用卡</li>
		<li onclick="location='creditCard_application_progress.action'"
			class="mdl-menu__item">申请进度查询</li>
		<li onclick="location='creditCard_active.action'"
			class="mdl-menu__item">信用卡激活</li>
	</ul>
	<ul
		class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
		for="pay">
		<li class="mdl-menu__item">Some Action</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another
			Action</li>
		<li disabled class="mdl-menu__item">Disabled Action</li>
		<li class="mdl-menu__item">Yet Another Action</li>
	</ul>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header
			class="mdl-layout__header mdl-layout__header--waterfall portfolio-header">
		<div class="mdl-layout__header-row portfolio-logo-row">
			<span class="mdl-layout__title">
				<div class="portfolio-logo"></div> <span class="mdl-layout__title">Simple
					portfolio website</span>
			</span>
		</div>
		<div class="mdl-layout__header-row portfolio-navigation-row">

			<button id="my-account" class="mdl-button mdl-js-button">我的账户</button>
			<button id="transfer" class="mdl-button mdl-js-button">转账汇款</button>
			<button id="credit-card" class="mdl-button mdl-js-button">信用卡</button>
			<button id="pay" class="mdl-button mdl-js-button">充值缴费</button>
			<button id="setting" class="mdl-button mdl-js-button">设置</button>
		</div>
		</header>
		<main class="mdl-layout__content">



		
			<c:if test="${empty creditCards}">
				<a>您还未拥有信用卡！！</a>
				<br />
				<a href="creditCard_apply.action">申请信用卡</a>
				<br />
			</c:if>
			<div class="mdl-grid" style="max-width:800px; text-align: center">
				<c:forEach var="card" items="${creditCards}">
					<div
						class="mdl-cell mdl-cell--3-col demo-card-event mdl-card mdl-shadow--4dp">
						<c:out value="卡号：${card.cardNumber}"></c:out>
						<br />
						<c:out value="类型：${card.type}"></c:out>
						<br />
						<c:out value="额度：${card.creditLimit}"></c:out>
						<br />
						<c:out value="已用额度：${card.balance}"></c:out>
						<br />
						<c:out value="币种：${card.currency}"></c:out>
						<br />
						<c:out value="状态：${card.status}"></c:out>
						<br />
						<c:out value="积分：${card.score}"></c:out>
						<br />
						<c:out value="账单日：每月${card.statementDate}号"></c:out>
						<br />
						<a href="creditCard_uncheckedBill.action?creditCardID=${card.id}">未出账单查询</a>
						<a href="creditCard_checkedBill.action?creditCardID=${card.id}">已出账单查询</a>
	
					</div>
				</c:forEach>
			</div>

		

		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<footer class="mdl-mini-footer">
		<div class="mdl-mini-footer__left-section">
			<div class="mdl-logo">Simple portfolio website</div>
		</div>
		<div class="mdl-mini-footer__right-section">
			<ul class="mdl-mini-footer__link-list">
				<li><a href="#">Help</a></li>
				<li><a href="#">Privacy & Terms</a></li>
			</ul>
		</div>
		</footer> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>