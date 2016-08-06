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
</style>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
		<div class="mdl-grid portfolio-max-width">
			<c:forEach var="card" items="${creditCards}">
				<div
					class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact"
					style="margin-top: 30px">
					<div class="mdl-card__media">
						<img class="article-image" src=" images/example-blog07.jpg"
							border="0" alt="">
					</div>
					<div class="mdl-card__title ">
						<h2 class="mdl-card__title-text">${card.name}</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<table>
							<tr>
								<td>卡号：</td>
								<td>${card.cardNumber}</td>
							</tr>
							<tr>
								<td>类型：</td>
								<td>${card.type}</td>
							</tr>
							<tr>
								<td>额度：</td>
								<td>${card.creditLimit}</td>
							</tr>
							<tr>
								<td>已用额度：</td>
								<td>${card.balance}</td>
							</tr>
							<tr>
								<td>币种：</td>
								<td>${card.currency}</td>
							</tr>
							<tr>
								<td>状态：</td>
								<td>${card.status}</td>
							</tr>
							<tr>
								<td>积分：</td>
								<td>${card.score}</td>
							</tr>
							<tr>
								<td>账单日：</td>
								<td>每月${card.statementDate}号</td>
							</tr>
						</table>
					</div>
					<div class="mdl-card__actions mdl-card--border">
						<a
						href="creditCard_uncheckedBill.action?flag='notNull'&creditCardID=${card.id}">未出账单查询</a>
					
					<a
						href="creditCard_checkedBill.action" style="float:right">已出账单查询</a>
					</div>
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

		<%@include file="/footer.jsp"%> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>