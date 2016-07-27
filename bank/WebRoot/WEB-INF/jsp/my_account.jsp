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

	<div id="controler">
		<a id="alist_action" href="account_list.action">account_list</a> <br />
		<a id="alist_create_win" href="account_create_win.action">account_create</a>
	</div>
		<table id="alist_show">
			<s:iterator value="#request.accountList">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="user.getId()" /></td>
					<td><s:property value="accountNumber" /></td>
					<%-- <td><s:property value="withdrawalPassword" /></td>
					<td><s:property value="transactionPassword" /></td> --%>
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

</body>
</html>