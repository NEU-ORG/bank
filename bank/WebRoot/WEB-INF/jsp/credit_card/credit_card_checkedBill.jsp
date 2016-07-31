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
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<h1>已出账单查询</h1>
			<c:out value="${checkedBill.statementDate}"></c:out>
			<c:out value="${checkedBill.dueDate}"></c:out>
			<c:out value="${checkedBill.statementBalance}"></c:out>
			<c:out value="${checkedBill.minPayment}"></c:out><br/>
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>