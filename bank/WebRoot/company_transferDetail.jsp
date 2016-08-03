<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<h2 class="mdl-card__title-text">交易详情</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<form action="company_transferDetail?flag='notNull'" id＝"form" method="post">
					选择账号： <select name="accountID">
						<c:forEach var="account" items="${companyAccounts}">
							<option value="${account.id}">${account.accountNumber}(${account.name})</option>
						</c:forEach>
					</select><br/>
					开始日期：<input type="date" name="beginTime"/><br />
					结束日期：<input type="date" name="endTime"/>
					<div class="mdl-card__actions">
						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">查询</button>
					</div>

				</form>
				<c:forEach var="detail" items="${transactionDetails}">
					<c:out value="操作人：${detail.companyOperator.managerName}"></c:out>
					<c:out value="交易时间：${detail.transactionTime}"></c:out>
					<c:out value="支出：${detail.amountPaid}"></c:out>
					<c:out value="收入：${detail.amountReceived}"></c:out>
					<c:out value="币种：${detail.currency}"></c:out>
					<c:out value="交易类型：${detail.type}"></c:out>
					<c:out value="附言：${detail.message}"></c:out>
					<br />
				</c:forEach>
			</div>
			<div class="mdl-card__menu">
				<button
					class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
					取消</button>
			</div>
		</div>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>