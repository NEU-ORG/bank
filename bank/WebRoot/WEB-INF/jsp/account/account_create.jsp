<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>创建账户 0.0</h1>
	<br />

	<form action="account_create.action" method="post">
		<table>
			<tr>
				<td>Account Number:</td>
				<td><input type="text" name="accountNumber" /></td>
				<td><s:fielderror fieldName="accountNumber" /></td>
			</tr>
			<tr>
				<td>Transaction Password:</td>
				<td><input type="password" name="transactionPassword" /></td>
				<td><s:fielderror fieldName="transactionPassword" /></td>
			</tr>
			<tr>
				<td>Retransaction Password:</td>
				<td><input type="password" name="retransactionPassword" /></td>
				<td><s:fielderror fieldName="retransactionPassword" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>

	

</body>
</html>