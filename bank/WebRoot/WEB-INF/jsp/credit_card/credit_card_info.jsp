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
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
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
	
		<%@include file="/footer.jsp"%>
		</main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>