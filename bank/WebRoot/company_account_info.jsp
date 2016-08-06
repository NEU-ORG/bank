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
</head>
<body>
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">
		<div class="mdl-grid portfolio-max-width">
			<c:forEach var="account" items="${companyAccounts}">
				<div
					class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact"
					style="margin-top: 30px">
					<div class="mdl-card__media">
						<img class="article-image" src=" images/example-blog07.jpg"
							border="0" alt="">
					</div>
					<div class="mdl-card__title ">
						<h2 class="mdl-card__title-text">${account.name}</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<table>
							<tr>
								<td>账号：</td>
								<td>${account.accountNumber}</td>
							</tr>
							<tr>
								<td>余额：</td>
								<td>${account.balance}</td>
							</tr>
							<tr>
								<td>可用额度：</td>
								<td>${account.availableBalance}</td>
							</tr>
							<tr>
								<td>币种：</td>
								<td>${account.currency}</td>
							</tr>
							<tr>
								<td>状态：</td>
								<td>${account.status}</td>
							</tr>
							<tr>
								<td>签约状态：</td>
								<td>${account.isSigned}</td>
							</tr>
							<tr>
								<td>所属分行：</td>
								<td>${account.bank.name}</td>
							</tr>
						</table>
					</div>
					<div class="mdl-card__actions mdl-card--border">

						<a href="company_transactionDetail" style="float:right">交易详情查询</a>
					</div>
				</div>
			</c:forEach>
		</div>

		<br/><br/>
		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>