<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>我的信用卡</h1>
	<div>
	<div style="width:200px;float:left">
		<a href="creditCard_info.action">信用卡信息查询<br/></a>
		<a href="creditCard_apply.action">申请信用卡<br/></a>
		<a href="creditCard_application_progress.action">申请进度查询<br/></a>
		<a href="creditCard_report_loss.action">卡片挂失<br/></a>
		<a href="creditCard_active.action">卡片激活<br/></a>
		<a href="creditCard_changeTPassword.action">交易密码修改<br/></a>
		<a href="creditCard_changeSPassword.action">查询密码修改<br/></a>
		<a >可用额度设置？？？<br/></a><br/>
	</div>
	<div style="float:left">
		<h1>未出账单查询</h1>
		<c:forEach var="detail" items="${uncheckedBill}">
			<c:out value="${detail.recordDate}"></c:out>
			<c:out value="${detail.transactionTime}"></c:out>
			<c:out value="${detail.amountPaid}"></c:out>
			<c:out value="${detail.amountReceived}"></c:out>
			<c:out value="${detail.currency}"></c:out>
			<c:out value="${detail.type}"></c:out>
			<c:out value="${detail.location}"></c:out>
			<c:out value="${detail.summary}"></c:out><br/>
		</c:forEach>	
	</div>
	</div>
</body>
</html>