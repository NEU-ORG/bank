<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资金调拨</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />

<style type="text/css">
.mdl-card {
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://code.ciphertrick.com/demo/jquerysession/js/jquerysession.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	
	$("#transfer-button").click(function() {
		var aid = $("#account option:selected").val();
		var taid = $("#target-account option:selected").val();
		var paynum = $("#paynum").val();
		var pwd = $("#pwd").val();
		/* alert("1:"+aid);
		alert("\n2:"+taid);
		alert("\n3:"+paynum);
		alert("\n4:"+pwd); */ 
		$.post("GroupTransferAction",
			{accountId:aid,
			 targetAccountId:taid,
			 pay:paynum,
			 pwd:pwd},
			function(a,b) {
				$("#msg-label").html(a.jsonResult);
		});
	});
});


function init() {
	var loginInfo = "operatorName="+"<c:out value="${loginInfo}" />";
	//alert(loginInfo);
	$.ajax({
		type:"GET",
		url:"QueryCompanyMsg",
		data:loginInfo,
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				//alert("success");
				clist = data.result.companies;
				var selObj1 = document.getElementById("account");
				var selObj2 = document.getElementById("target-account");
				AddSelect(selObj1,clist);
				AddSelect(selObj2,clist);
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddSelect(selObj, data) {
	for(var i=0;i<data.length;i++) {
		for(var j=0;j<data[i].companyAccounts.length;j++) {
			selObj.options.add(new Option(data[i].companyAccounts[j].name,data[i].companyAccounts[j].id));
		}
	}
}
</script>

</head>
<body onload="init();">
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">
			<div>
				<h1>资金调拨</h1>
			
				<div class="mdl-grid portfolio-max-width" id="a-card">
	        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
	                    <div class="mdl-card__media">
	                        <img class="article-image" src=" images/example-blog02.jpg" border="0" alt="">
	                    </div>
	                    <div class="mdl-card__title ">
	                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">资金调拨</h2>
	                    </div>
	                    <div class="mdl-card__supporting-text">
							 个人账户：<select id="account"></select>
	                    	<br /><br />
							 目标账户：<select id="target-account"></select>
	                    	<br /><br />
							<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="text" id="paynum"
									name="paynum"> <label class="mdl-textfield__label"
									for="paynum">请输入转账金额...</label>
							</div>
	        				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="pwd"
									name="password"> <label class="mdl-textfield__label"
									for="pwd">请输入交易密码...</label>
							</div>
							<br />
							<label id="msg-label"></label>
	                    </div>
	                    <div class="mdl-card__actions mdl-card--border">
	                        <a href="#" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">取消</a>
							<button id="transfer-button"
								class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="float: right;">资金调拨</button>
	                    </div>
	                </div>
	               
	            </div>	
			
			</div>
			<br /><br /><br /><br /><br /><br /><br /><br /><br />
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>