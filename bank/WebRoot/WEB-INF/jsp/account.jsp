<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="my-account">
		<li class="mdl-menu__item" onclick="location='account_info.action'">帐户查询</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">账户挂失</li>
		<li class="mdl-menu__item">添加新账户</li>
		<li class="mdl-menu__item">删除帐户</li>
	</ul>
	<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="transfer">
		<li class="mdl-menu__item">Some Action</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another
			Action</li>
		<li disabled class="mdl-menu__item">Disabled Action</li>
		<li class="mdl-menu__item">Yet Another Action</li>
	</ul>
	<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="credit-card">
		<li class="mdl-menu__item">信用卡查询</li>
		<li class="mdl-menu__item">查询密码设置</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">交易密码设置</li>
		<li class="mdl-menu__item">申请信用卡</li>
		<li class="mdl-menu__item">申请进度查询</li>
		<li class="mdl-menu__item">信用卡激活</li>
	</ul>
	<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect" for="pay">
		<li class="mdl-menu__item">Some Action</li>
		<li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
		<li disabled class="mdl-menu__item">Disabled Action</li>
		<li class="mdl-menu__item">Yet Another Action</li>
	</ul>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header mdl-layout__header--waterfall portfolio-header">
			<div class="mdl-layout__header-row portfolio-logo-row">
				<span class="mdl-layout__title">
					<div class="portfolio-logo"></div> 
					<span class="mdl-layout__title">Simple portfolio website</span>
				</span>
			</div>
			<div class="mdl-layout__header-row portfolio-navigation-row">
				<button id="my-account" class="mdl-button mdl-js-button">我的账户</button>
				<button id="transfer" class="mdl-button mdl-js-button">转账汇款</button>
				<button id="credit-card" class="mdl-button mdl-js-button">信用卡</button>
				<button id="pay" class="mdl-button mdl-js-button">充值缴费</button>
				<button id="setting" class="mdl-button mdl-js-button">设置</button>
			</div>
		</header>
		
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
		
		<footer class="mdl-mini-footer">
		<div class="mdl-mini-footer__left-section">
			<div class="mdl-logo">Simple portfolio website</div>
		</div>
		<div class="mdl-mini-footer__right-section">
			<ul class="mdl-mini-footer__link-list">
				<li><a href="#">Help</a></li>
				<li><a href="#">Privacy & Terms</a></li>
			</ul>
		</div>
		</footer> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>