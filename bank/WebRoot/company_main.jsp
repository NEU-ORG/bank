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
	margin-top: 80px;
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
				$("#alable").html("公司："+data.result.companyName);
				AddTable(clist);
			} else
				alert("缺少数据");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddTable(data) {
	$("#a-list tbody").empty();
	var newRow;
		for(var i=0;i<data.length;i++) {
				newRow = "<tr><td>"+data[i].accountNumber+
						 "</td><td>"+data[i].name+
						 "</td><td>"+data[i].status+
						 "</td><td>"+data[i].type+
						 "</td><td>"+data[i].currency+
						 "</td><td>"+data[i].balance+
						 "</td><td>"+data[i].availableBalance+
						 "</td></tr>";
				$("#a-list").append(newRow);
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
			<!-- <h1>公司主界面</h1> -->
			<div class="mdl-grid portfolio-max-width">
				<div class="mdl-grid mdl-cell mdl-cell--12-col mdl-cell--4-col-tablet mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__media mdl-cell mdl-cell--12-col-tablet">
                        <img class="article-image" src=" images/example-blog01.jpg" border="0" alt="">
                    </div>
                    <div class="mdl-cell mdl-cell--8-col">
                    	<br />
                        <h2 class="mdl-card__title-text">欢迎使用网上银行系统公司业务，<c:out value="${loginInfo}" /></h2>
                        <br />
                        <div class="mdl-card__supporting-text no-left-padding">
         					<label id="alabel"></label>
                           	<table id="a-list" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
								<thead>
								    <tr>
								      <th class="mdl-data-table__cell--non-numeric">账号</th>
								      <th>账户名</th>
								      <th>状态</th>
								      <th>类型</th>
								      <th>币种</th>
								      <th>余额</th>
								      <th>可用余额</th>
								    </tr>
								</thead>
								<tbody>
								</tbody>
							</table>
                        </div>
                    </div>
                </div>
			</div>
			</div>
			<br /><br /><br />
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>