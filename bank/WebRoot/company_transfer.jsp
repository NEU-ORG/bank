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
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">
		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">行内转账</h2>
			</div>
			<div class="mdl-card__supporting-text">
				
				<form action="company_transfer.action?flag='notNull'"
					id＝"form" method="post">
					选择账号： 
					<select name="accountID">
						<c:forEach var="account" items="${companyAccounts}">
						<c:if test="${account.isSigned!='none'}">
							<option value="${account.id}">${account.accountNumber}(${account.name})</option>
							</c:if>
						</c:forEach>
					</select><br /> 
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="targetAccountNumber"> <label class="mdl-textfield__label"
							for="sample3">对方账号...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="amount"> <label class="mdl-textfield__label"
							for="sample3">转账金额...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="password"> <label class="mdl-textfield__label"
							for="sample3">交易密码...</label>
					</div><br/>

					<c:out value="${errorMessage }"></c:out>
					<div class="mdl-card__actions">
						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">转账</button>
					</div>

				</form>
			</div>
			<div class="mdl-card__menu">
				<button
					class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
					取消</button>
			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>