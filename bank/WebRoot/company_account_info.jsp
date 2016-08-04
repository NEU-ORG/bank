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
</head>
<body>
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">
			
			<div class="mdl-grid" style="max-width:800px; text-align: center">
				<c:if test="${empty companyAccounts}">
				<a>公司还没有账户！！</a>
				<br />
				</c:if>
				<c:forEach var="account" items="${companyAccounts}">
					<c:if test="${account.isSigned!='none'}">
					<div
						class="mdl-cell mdl-cell--3-col demo-card-event mdl-card mdl-shadow--4dp">
						<c:out value="账号：${account.accountNumber}"></c:out>
						<br />
						<c:out value="余额：${account.balance}"></c:out>
						<br />
						<c:out value="可用余额：${account.availableBalance}"></c:out>
						<br />
						<c:out value="币种：${account.currency}"></c:out>
						<br />
						<c:out value="状态：${account.status}"></c:out>
						<br />
						<c:out value="签约状态：${account.isSigned}"></c:out>
						<br />
						<c:out value="所属分行：${account.bank.name}"></c:out>
						<br />
						<c:out value="ID：${account.id}"></c:out>
						<br />
						<a>交易明细查询</a>
				
	
					</div>
					</c:if>
				</c:forEach>
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>