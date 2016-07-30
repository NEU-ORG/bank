<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" charset="utf8" src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">

var userlist;

$(document).ready(function(){
	getUserList();
	$("#search").click(function() {
		alert("len:"+userlist.length);
		//table.fnDraw();
		addTable(userlist[$("#user-name").val()]);
	});
	
	$("#user-name").change(function() {
		alert("accounts:"+"|"+userlist[$(this).val()].accounts.length+"|");
		addTable(userlist[$(this).val()]);
	});
	
});

function addTable(user) {
	var a = user.accounts;
	alert("0:"+a.length);
	var newRow;
	for(var i=0;i<a.length;i++) {
		newRow = "<tr><td>"+a[i].accountNumber+
				"</td><td>"+user.realName+
				"</td><td>"+a[i].createBank+
				"</td><td>"+a[i].currency+
				"</td><td>"+a[i].balance+
				"</td><td>"+a[i].availableBalance+
				"</td></tr>";
		$("#alist_show").append(newRow);
	}
}

function getUserList() {
	var selObj = $("#user-name");
	$.ajax({
		type:"GET",
		url:"getUserList",
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				//alert("datalength:"+data.data.length);
				for(var i=0;i<data.data.length;i++)
					selObj.append("<option value='"+i+"'>"+data.data[i].realName+"</option>");
				userlist = data.data;
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}
</script>

<title>Insert title here</title>
</head>
<body >
	<h1>我的账户 0.0</h1>
	<br />

	<div id="controller">
		<a id="alist_action" href="account_list.action">account_list</a> <br />
		<a id="alistjson" href="AccountJsonAction">accountjson</a> <br /> <a
			id="alist_create_win" href="account_create_win.action">account_create</a>
	</div>
	<div>
		<select id="user-name"></select>
  		<button id="search">查找</button>
	</div>
	<table id="alist_show"></table>
	<table id="alist_show2">
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