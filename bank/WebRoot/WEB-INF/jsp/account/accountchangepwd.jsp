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
	$("#changepwd-button").click(function() {
		var accountId = $("#user-account option:selected").val();
		var oldpwd = $("#oldpwd").val();
		var pwd = $("#newpwd").val();
		//alert("1:"+accountId+"|2:"+oldpwd+"|3:"+pwd);
		$.post("changepwdAction",
				{	accountId:accountId,
					oldpwd:oldpwd,
					pwd:pwd
				},function(a,b) {
					//alert(a.jsonResult);
					//alert(b);
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
				//alert("success1");
				alist = data.result;
				//alert("alist"+alist.length);
				var selObj = document.getElementById("user-account");
				AddAccountSelect(selObj, alist);
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddAccountSelect(selObj, data) {
	for(var i=0;i<data.length;i++) {
		selObj.options.add(new Option(data[i].accountNumber,data[i].id))
	}
}
</script>

</head>
<body onload="init();">
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<h1>交易密码修改:<c:out value="${loginInfo}" /></h1>
			
			<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">交易密码修改</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<%-- <c:out value="${passwordError}"/>
                <c:set var="passwordError" value=""/> --%>
                <label id="msg-label"></label>
                <br /><br />

					账号：<select id="user-account" name="accountId"></select>
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="oldpwd"
							name="password"> <label class="mdl-textfield__label"
							for="oldpwd">旧密码...</label>
					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="newpwd"
							name="newPassword"> <label class="mdl-textfield__label"
							for="newpwd">新密码...</label>

					</div>
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="password" id="repwd"
							name="rPassword"> <label class="mdl-textfield__label"
							for="repwd">确认密码...</label>

					</div>
					<div class="mdl-card__actions">
						<a href="#" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">取消</a>

						<button id="changepwd-button"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">修改</button>
					</div>


			</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
			
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>