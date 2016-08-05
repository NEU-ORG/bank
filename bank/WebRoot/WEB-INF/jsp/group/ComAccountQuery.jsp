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
	min-width: 300px;
	width: 300px;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#a-button").click(function() {
		var val = $(this).val();
		alert("click"+val);
		
	});
	//alert("loginInfo:"+loginInfo);
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
				//alert("success1");
				//var tabObj = $("#alist-show");
				//AddAccountsTable(tabObj, data.result);
				AddAccountCard(data.result);
				
			} else
				alert("status=false");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddAccountCard(d) {
		var data = d.companyAccounts;
    	for(var i=0;i<data.length;i++) {
		if(data[i].isSigned == "none")
			continue;
		var str = "<div class=\"mdl-card mdl-grid portfolio-max-width\" id=\"a-card\">"+
        		"<div class=\"mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact\">"+
                    "<div class=\"mdl-card__media\">"+
                        "<img class=\"article-image\" src=\" images/example-blog02.jpg\" border=\"0\" alt=\"\">"+
                    "</div><div class=\"mdl-card__title \">"+
                        "<h2 class=\"mdl-card__title-text\" id=\"a-num\">";
        if(data[i].name == null || data[i].name == "")
        	str = str + data[i].accountNumber;
        else 
        	str = str + data[i].name;
        str = str + "</h2></div><div class=\"mdl-card__supporting-text\"><table id=\"a-tab\">";
        str = str + "<tr><td>Account Number:</td><td>"+data[i].accountNumber+"</td></tr>"+
        			"<tr><td>Company Name:</td><td>"+d.companyName+"</td></tr>"+
        			"<tr><td>Currency:</td><td>"+data[i].currency+"</td></tr>"+
        			"<tr><td>Balance:</td><td>"+data[i].balance+"</td></tr>"+
        			"<tr><td>Available Balance:</td><td>"+data[i].availableBalance+"</td></tr>"+
        			"<tr><td>Bank:</td><td>"+data[i].bank.name+"</td></tr>";
        			//"<tr><td>Create Date:</td><td>"+new Date(data[i].createDate.time).toISOString()+"</td></tr>";
        str = str + "</table></div><div class=\"mdl-card__actions mdl-card--border\">"+
                        "<button id=\"a-button\" class=\" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent\" "+
						"\" onclick=\"location='account_transdetail_win.action?accountId="+data[i].id+"&display=1'\""+
						"style=\"float: right;\">交易明细查询</button></div></div>"
		$("#ca-card").append(str); 
	}
}

</script>

</head>
<body>
	<%@include file="/company_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/company_header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<h1>集团账户查询</h1>
			
			<div class="mdl-grid portfolio-max-width" id="ca-card"></div> 
			
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>