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
		<a href="creditCard_info.action">信用卡信息查询</a><br/>
		<a href="creditCard_apply.action">申请信用卡</a><br/>
		<a href="creditCard_application_progress.action">申请进度查询</a><br/>
		<a href="creditCard_report_loss.action">卡片挂失</a><br/>
		<a href="creditCard_active.action">卡片激活</a><br/>
		<a href="creditCard_changeTPassword.action">交易密码修改<br/></a>
		<a href="creditCard_changeSPassword.action">查询密码修改<br/></a>
		<a >可用额度设置？？？</a><br/>
	</div>
	<div style="float:left">
		<a href="creditCard_creditLimit.action">可用额度查询</a><br/>
		<a href="creditCard_checedBill.action">已出账单查询</a><br/>
		<a href="creditCard_unchecedBill.action">未出账单查询</a><br/>
		<a href="creditCard_score.action">积分查询</a>
	</div>
	<div style="float:left">
		<h1>积分查询</h1>
		<c:if test="${empty user.creditCards}">
			<a>您还未拥有信用卡！！</a><br />
			<a href="creditCard_apply.action">申请信用卡</a><br/>
		</c:if>
		<c:forEach var="card" items="${user.creditCards}">
			<c:out value="卡号：${card.cardNumber} 积分：${card.score}"></c:out><br />
		</c:forEach>
	</div>
	</div>
</body>
</html>