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

<script type="text/javascript" charset="utf8" src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	//alert("loginInfo:"+loginInfo);
});
function init() {
	var loginInfo = "userName="+"<c:out value="${loginInfo}" />";
	//alert(loginInfo);
	$.ajax({
		type:"GET",
		url:"getUserAccounts",
		data:loginInfo,
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				//alert("success1");
				var tabObj = $("#alist-show");
				AddAccountsTable(tabObj, data.result);
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddAccountsTable(tabObj, data) {
	var newRow;
	for(var i=0;i<data.length;i++) {
		newRow = "<tr><td>"+data[i].accountNumber+
				"</td><td>"+"<c:out value="${loginInfo}" />"+
				"</td><td>"+data[i].currency+
				"</td><td>"+data[i].balance+
				"</td><td>"+data[i].availableBalance+
				"</td><td>"+data[i].createBank+
				"</td><td>"+new Date(data[i].createDate.time).toISOString()+
				"</td></tr>";
		tabObj.append(newRow);
	}
}
</script>

</head>
<body onload="init();">
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			
			<h1>我的账户:<c:out value="${loginInfo}" /></h1><br />
		
			<div>
				<table id="alist-show" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
				    	<tr>
				      		<th>账号</th>
				      		<th>用户名</th>
				      		<th>币种</th>
				      		<th>余额</th>
				      		<th>可用余额</th>
				      		<th>申请银行</th>
				      		<th>申请时间</th>
				    	</tr>
				  	</thead>
				  	<tbody></tbody>
				</table>
			</div>
			
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>