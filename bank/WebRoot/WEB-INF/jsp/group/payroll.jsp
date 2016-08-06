<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资金归集</title>
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
<script type="text/javascript">

function init() {
	var loginInfo = "operatorName="+"<c:out value="${loginInfo}" />";
	//alert(loginInfo);
	$.ajax({
		type:"GET",
		url:"QueryComAccounts",
		data:loginInfo,
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				//alert("success");
				clist = data.result.companyAccounts;
				AddSelect(clist);
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddSelect(data) {
	var selObj = document.getElementById("ca-list");
	for(var i=0;i<data.length;i++) {
		selObj.options.add(new Option(data[i].accountNumber,data[i].id));
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
			<h1>代发工资:<c:out value="${loginInfo}" /></h1>

				<div class="mdl-grid portfolio-max-width" id="a-card">
	        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
	                    <div class="mdl-card__title ">
	                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">代发工资</h2>
	                    </div>
	                    <div class="mdl-card__supporting-text">
	                    	<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload" method="post">
	                    		 账户：<select id="ca-list" name="aselect"></select>
		                    	<br /><br />
		                    	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
									<input class="mdl-textfield__input" type="password" id="pwd"
										name="pwd"> <label class="mdl-textfield__label"
										for="pwd">请输入交易密码...</label>
								</div><br />
								<c:out value="${errormsg}" />
								<br /><br />
								<input type="file" name="uploadImages" accept="application/vnd.ms-excel" /><br />
								<br /><br />
								<button id="transfer-button"
								class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="float: left;">代发工资</button>
							</form>
	                    </div>
	                    <div class="mdl-card__actions mdl-card--border">
	                        
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