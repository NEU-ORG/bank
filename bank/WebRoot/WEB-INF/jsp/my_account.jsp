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
	<h1>我的账户 0.0</h1>
	<br />

	<a href="account_list.action">account_list</a>
	<br />

	<form name="alist">
		<table>
			<tr>
				<td>id</td>
				<td>name</td>
				<td>user.getId()</td>
				<td>account_number</td>
				<td>withdrawal_password</td>
				<td>transaction_password</td>
				<td>currency</td>
				<td>create_bank</td>
				<td>create_date</td>
				<td>is_signed</td>
				<td>status</td>
				<td>type</td>
				<td>balance</td>
				<td>available_balance</td>
			</tr>
			<s:iterator value="#request.accountList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="user.getId()" /></td>
					<td><s:property value="accountNumber" /></td>
					<td><s:property value="withdrawalPassword" /></td>
					<td><s:property value="transactionPassword" /></td>
					<td><s:property value="currency" /></td>
					<td><s:property value="createBank" /></td>
					<td><s:property value="createDate" /></td>
					<td><s:property value="isSigned" /></td>
					<td><s:property value="status" /></td>
					<td><s:property value="type" /></td>
					<td><s:property value="balance" /></td>
					<td><s:property value="availableBalance" /></td>
				</tr>
			</s:iterator>
		</table>
	</form>

</body>
</html>