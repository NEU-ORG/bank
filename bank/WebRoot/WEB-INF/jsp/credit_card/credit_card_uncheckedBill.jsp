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
				<h2 class="mdl-card__title-text">未出账单</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<form action="creditCard_uncheckedBill.action?flag='notNull'" id＝"form" method="post">
					选择账号： <select name="creditCardID">
						<c:forEach var="card" items="${creditCards}">
							<option value="${card.id}">${card.cardNumber}(${card.name})</option>
						</c:forEach>
					</select>
					<div class="mdl-card__actions">
						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">查询</button>
					</div>

				</form>
				<c:forEach var="detail" items="${uncheckedBill}">
					<c:out value="${detail.transactionTime}"></c:out>
					<c:out value="${detail.amountPaid}"></c:out>
					<c:out value="${detail.amountReceived}"></c:out>
					<c:out value="${detail.currency}"></c:out>
					<c:out value="${detail.type}"></c:out>
					<c:out value="${detail.message}"></c:out>
					<br />
				</c:forEach>
			</div>
			<div class="mdl-card__menu">
				<button
					class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
					取消</button>
			</div>
		</div>

		<%@include file="/footer.jsp"%> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>