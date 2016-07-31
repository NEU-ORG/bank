<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="material.min.css">
<script src="material.min.js"></script>
<style>
.mdl-card {
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header portfolio-header">
		<div class="mdl-layout__header-row "></div>

		</header>

		<main class="mdl-layout__content">

		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">注册</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<c:if test="${!empty ErrorMessage}">
					<c:out value="${ErrorMessage}" />
				</c:if>
				<form action="signUp.action"id＝"form">
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text"
							name="realName"> <label
							class="mdl-textfield__label" for="sample3">姓名...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="idNumber"
							> <label class="mdl-textfield__label"
							for="sample3">身份证号...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="cardNumber"
							> <label class="mdl-textfield__label"
							for="sample3">帐号...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="userName"
							id="sample3"> <label class="mdl-textfield__label"
							for="sample3">用户名...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" name="password"
							id="sample3"> <label class="mdl-textfield__label"
							for="sample3">密码...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3">
						<label class="mdl-textfield__label" for="sample3">确认密码...</label>

					</div>
					<div class="mdl-card__actions">
						<button onclick="location='sign_up.jsp'"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">注册</button>
					</div>

				</form>
			</div>
		</div>
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
</body>
</html>