<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收款人列表</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />

<style type="text/css">
.mdl-card {
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
	width: 400px;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

function init() {
	var loginInfo = "userName="+"<c:out value="${loginInfo}" />";
	//alert(loginInfo);
	$.ajax({
		type:"GET",
		url:"QueryPayeeList",
		data:loginInfo,
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				pl = data.result;
				AddTable(pl)
			} else
				alert("缺少数据");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddTable(data) {
	//alert("a:"+data.length);
	var newRow;
	for(var i=0;i<data.length;i++) {
		newRow = "<tr><td>"+data[i].account.accountNumber+
				 "</td><td>"+data[i].payeeName+
				 "</td><td>"+data[i].account.bank.type+
				 /* "</td><td>"+""+ */
				 "</td></tr>";
		$("#plist").append(newRow);
	}
}

</script>

</head>
<body onload="init();")>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<!-- <h1>收款人列表</h1> -->
				<div class="mdl-grid portfolio-max-width" id="a-card">
        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
                    <div class="mdl-card__title ">
                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">收款人列表</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
						<label> 用户：<c:out value="${loginInfo}" /> </label>
                    	<br /><br />
						<table id="plist" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
							<thead>
							    <tr>
							      <th class="mdl-data-table__cell--non-numeric">收款人账号</th>
							      <th>收款人名</th>
							      <th>收款人银行</th>
							      <!-- <th>转账</th> -->
							    </tr>
							</thead>
							<tbody>
							</tbody>
						</table>
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