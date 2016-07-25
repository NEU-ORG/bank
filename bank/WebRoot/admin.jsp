<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<% request.setCharacterEncoding("utf-8"); %>
<title>Insert title here</title>
</head>
<body>
	<h1>控制台</h1>
	<h2>开户</h2>
	<form action="createAccountAction.action" method="post">
		真实姓名：<input type="text" name="realName"><br/>
		身份证号：<input type="text" name="idNumber"><br/>
		账户类型：<input type="radio" name="accountType" value="saving account">储蓄卡
		<input type="radio" name="accountType" value="credit card">信用卡<br/>
		卡号：<input type="text" name="accountNumber"><br/>
		取款密码：<input type="password" name="withdrawalPassword"><br/>
		币种：<input type="text" name="currency"><br/>
		开户行：<input type="text" name="bankName"><br/>
		手机号：<input type="text" name="phoneNumber"><br/>
		<input type="submit">
	</form>
</body>
</html>