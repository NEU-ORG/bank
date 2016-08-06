<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加银行卡</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />
<style>
.mdl-card {
	margin-top: 50px;
	margin-right: auto;
	margin-left: auto;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
var alist;

$(document).ready(function() {
	$("#create-button").click(function() {
		var accountnum = $("#account").val();
		var pwd = $("#pwd").val();
		//alert("1:"+accountnum+"|2:"+pwd);
		$.post("addaccountAction",
				{	accountNumber:accountnum,
					pwd:pwd
				},function(a,b) {
					$("#msg-label").html(a.jsonResult);
				});
	});
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
				alist = data.result;
			} else
				alert("无数据");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

</script>

</head>
<body onload="init();">
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<%-- <h1>添加银行卡 :<c:out value="${loginInfo}" /></h1>
			<br /> --%>
			
			<div class="demo-card-wide mdl-card mdl-shadow--8dp">
					<div class="mdl-card__media">
                        <img class="article-image" src=" images/example-blog02.jpg" border="0" alt="">
                    </div>
					<div class="mdl-card__title">
						<h2 class="mdl-card__title-text">添加银行卡</h2>
					</div>
					<div class="mdl-card__supporting-text">
						<label id="msg-label"></label>
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="account"
									name="account"> <label class="mdl-textfield__label"
									for="account">银行卡号...</label>
							</div>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="pwd"
									name="Password"> <label class="mdl-textfield__label"
									for="pwd">请设置交易密码...</label>
		
							</div>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="repwd"
									name="rePassword"> <label class="mdl-textfield__label"
									for="repwd">确认交易密码...</label>
		
							</div>
							<div class="mdl-card__actions">
								<a href="#" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">取消</a>
		
								<button id="create-button"
									class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
									style="float: right;">修改</button>
							</div>
					</div>
				</div>

<%-- 	<form action="account_create.action" method="post">
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
	</form> --%>

			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>