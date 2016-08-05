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
var alist;

$(document).ready(function() {
	//alert("loginInfo:"+loginInfo);
	
	$("#lock-button").click(function() {
		var aid = $("#user-account option:selected").val();
		var pwd = $("#pwd").val();
		$.post("lockAction",{accountId:aid,pwd:pwd},function(a,b) {
			$("#msg-label").html(a.jsonResult);
		});
		/* $.ajax({
		  type: 'POST',
		  url: "account_lock.action",
		  data: {accountId:aid,pwd:pwd},
		  success: function(msgResult){
		  	alert("c")
		  },
		  dataType: "JSON",
		  error:function(msgResult,b){
		  	alert(JSON.stringify(msgResult));
		  	alert(b);
		  }
		}); */
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
		if(data[i].isSigned == "none")
			continue;
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
				<h1>账户挂失</h1>
				                    
				<div class="mdl-grid portfolio-max-width" id="a-card">
	        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
	                    <div class="mdl-card__media">
	                        <img class="article-image" src=" images/example-blog02.jpg" border="0" alt="">
	                    </div>
	                    <div class="mdl-card__title ">
	                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">账户挂失</h2>
	                    </div>
	                    <div class="mdl-card__supporting-text">
							 账号：<select id="user-account" name="accountId"></select>
	                    	<br /><br />
	        				<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<input class="mdl-textfield__input" type="password" id="pwd"
								name="password"> <label class="mdl-textfield__label"
								for="pwd">密码...</label>
							</div>
							<br />
							<label id="msg-label"></label>
	                    </div>
	                    <div class="mdl-card__actions mdl-card--border">
	                        <button id="lock-button" 
	                        	class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
	                        	style="float:right;">挂失</button>
	                    </div>
	                </div>
	               
	            </div>	
				
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>