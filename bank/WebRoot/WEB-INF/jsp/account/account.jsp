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
td {
      text-align:center; /*设置水平居中*/
      vertical-align:middle;/*设置垂直居中*/
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
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
				"</td><td>"+data[i].bank.name+
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
			
			<div class="mdl-grid portfolio-max-width">
        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
                    <div class="mdl-card__media">
                        <img class="article-image" src=" images/example-blog02.jpg" border="0" alt="">
                    </div>
                    <div class="mdl-card__title ">
                        <h2 class="mdl-card__title-text">Loren</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenan convallis.
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent">
                          View Updates
                        </a>
                    </div>
                </div>
                
                <div>
				<table id="alist-show" 	class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
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
                
            </div>
		
			
			
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>