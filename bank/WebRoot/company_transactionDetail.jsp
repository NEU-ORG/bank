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
<style type="text/css">
.mdl-card {
	margin-top: 80px;
	margin-right: auto;
	margin-left: auto;
	min-width: 800px;
	width: 1600px;
}
</style>
</head>
<body>
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">



		<div>
			<div class="mdl-grid portfolio-max-width" id="a-card">
				<div
					class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
					<div class="mdl-card__title ">
						<br />
						<br />
						<h2 class="mdl-card__title-text" id="a-num">部分日志查询</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<c:out value="${errorMessage}"></c:out>
						<form action="company_transactionDetail?flag='notNull'"
							id＝"form" method="post">
							选择账户： <select name="accountID">
								<c:forEach var="account" items="${companyAccounts}">
									<c:if test="${account.isSigned!='none'}">
										<option value="${account.id}">${account.accountNumber}(${account.name})</option>
									</c:if>
								</c:forEach>
							</select><br />
							<br /> 开始日期：<input type="date" name="beginTime" /><br />
							<br /> 结束日期：<input type="date" name="endTime" /><br />
							<button onclick="document.getElementById('form').submit()"
								class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="float: right;">查询</button>
						</form>
						<br />
						<br /> <br />
						<br />
						<br />
						<table id="t-detail"
							class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
							<thead>
								<tr>
									<th class="mdl-data-table__cell--non-numeric">交易时间</th>
									<th>操作人</th>
									<th>支出</th>
									<th>收入</th>
									<th>币种</th>
									<th>交易类型</th>
									<th class="mdl-data-table__cell--non-numeric">备注</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="detail" items="${transactionDetails}">
									<tr>
										<td>${detail.transactionTime}</td>
										<td>${detail.companyOperator.managerName}</td>
										<td>${detail.amountPaid}</td>
										<td>${detail.amountReceived}</td>
										<td>${detail.currency}</td>
										<td>${detail.type}</td>
										<td>${detail.message}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="mdl-card__actions mdl-card--border"></div>
				</div>

			</div>
		</div>

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
