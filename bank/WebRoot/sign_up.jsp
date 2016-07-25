<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	<form action="signUp.action">
	真实姓名：<input type="text" name="realName"/><br />
	身份证号：<input type="text" name="idNumber"/><br />
	卡号：<input type="text" name="cardNumber"/><br />
	登录名：<input type="text" name="userName"/><br />
	登陆密码：<input type="text" name="password"/><br />
	<input type="submit" value="注册"/>
	</form>
</body>
</html>