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
.mdl-card {
	margin-top: 100px;
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">修改查询密码</h2>
			</div>
			<div class="mdl-card__supporting-text">
			<c:out value="${passwordError}"/>
                	<c:set var="passwordError" value=""/>
				<form action="creditCard_changeSPassword.action?flag='notNull'"
					id＝"form" method="post">
					账号： <select name="creditCardID">
						<c:forEach var="card" items="${cards}">
							<option value="${card.id}">${card.cardNumber}</option>
						</c:forEach>
					</select>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="password"> <label class="mdl-textfield__label"
							for="sample3">旧密码...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="sample3"
							name="newPassword"> <label class="mdl-textfield__label"
							for="sample3">新密码...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="sample3"
							name="rPassword"> <label class="mdl-textfield__label"
							for="sample3">确认密码...</label>

					</div>
					<div class="mdl-card__actions">
						<a href="#"
							class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">取消</a>

						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">修改</button>
					</div>

				</form>
			</div>
		</div>

		<br />
		<br />
		<br />
		<br />
		<%@include file="/footer.jsp"%> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>
</form>
</div>
</div>
</body>
</html>