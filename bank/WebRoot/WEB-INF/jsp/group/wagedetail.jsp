<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>代发工资查询</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />

<style type="text/css">
.mdl-card {
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
	min-width: 800px;
	width: 2000px;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

var clist;

$(document).ready(function() {
	$("#company-list").change(function() {
		var index = $("#company-list option:selected").val();
		//alert("i:"+index);
		AddSelect2(clist,index);
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
				AddSelect(clist);
				AddSelect2(clist,-1);
			} else
				alert("缺少数据");
		},
		error:function() {
			alert("ajax error");
		}
	});
}

function AddSelect(data) {
	var selObj = document.getElementById("company-list");
	for(var i=0;i<data.length;i++) {
		selObj.options.add(new Option(data[i].companyName,data[i].id));
	}
	selObj.options.add(new Option("全部",-1));
	selObj.text = "全部";
	selObj.value = -1;
}

function AddSelect2(data, index) {
	$("#ca-list").html("");
	var selObj = document.getElementById("ca-list");
	if(index == -1) {
		for(var i=0;i<data.length;i++) {
			for(var j=0;j<data[i].companyAccounts.length;j++) {
				selObj.options.add(new Option(data[i].companyAccounts[j].name,data[i].companyAccounts[j].id));
			}
		}
	} else {
		for(var i=0;i<data.length;i++) {
			if(data[i].id != index)
				continue;
			for(var j=0;j<data[i].companyAccounts.length;j++) {
				selObj.options.add(new Option(data[i].companyAccounts[j].name,data[i].companyAccounts[j].id));
			}
		}
	}
}

function getTransDetail() {
	$("#t-detail tbody").empty();
	var aid = document.getElementById("ca-list").value;
	var bti = new Date(document.getElementById("btime").value).getTime();
	var eti = new Date(document.getElementById("etime").value).getTime();
	
	//alert("bt:"+bti);
	//alert("et:"+eti); 
	info="companyAccountId="+aid+"&btime="+bti+"&etime="+eti;
	$.ajax({
		type:"GET",
		url:"QueryComTransDetails",
		data:info,
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				atlist = data.result;
				//alert("atlist:"+atlist.length);
				AddTable(atlist);
			} else
				alert("没有交易记录");
		},
		error:function() {
			alert("ajax error td");
		}
	});
}

function AddTable(data) {
	var newRow;
	for(var i=0;i<data.length;i++) {
		if(data[i].type != "代发工资" && data[i].type != "工资")
			continue;
		var ta = "";
		if("accountNumber" in data[i].companyAccountByTargetAccount)
			ta = data[i].companyAccountByTargetAccount.accountNumber;
		newRow = "<tr><td>"+data[i].companyAccountByAccountId.accountNumber+
				 "</td><td>"+data[i].companyOperator.managerName+
				 "</td><td>"+new Date(data[i].transactionTime.time).toISOString()+
				 "</td><td>"+data[i].amountPaid+
				 "</td><td>"+data[i].amountReceived+
				 "</td><td>"+data[i].balance+
				 "</td><td>"+ta+
				 "</td><td>"+data[i].currency+
				 "</td><td>"+data[i].type+
				 "</td><td>"+data[i].message+
				 "</td></tr>";
		$("#t-detail").append(newRow);
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
			<%-- <h1>代发工资查询:<c:out value="${loginInfo}" /></h1> --%>

				<div class="mdl-grid portfolio-max-width" id="a-card">
	        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
	                    <div class="mdl-card__title ">
	                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">代发工资查询</h2>
	                    </div>
	                    <div class="mdl-card__supporting-text">
							公司：<select id="company-list"></select>
	                    	<br /><br />
	                    	账户：<select id="ca-list"></select>
	                    	<br /><br />
							查询开始时间：<input type="datetime-local" id="btime" />
	                    	<br /><br />
	                    	查询结束时间：<input type="datetime-local" id="etime" />
	                    	<br /><br />
	                    	<button id="trans-button"
								class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="float:left;" onclick="getTransDetail();">交易明细查询</button>
							<br /><br /><br />
							<table id="t-detail" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
								<thead>
								    <tr>
								      <th class="mdl-data-table__cell--non-numeric">卡号</th>
								      <th class="mdl-data-table__cell--non-numeric">操作人</th>
								      <th class="mdl-data-table__cell--non-numeric">交易时间</th>
								      <th>支出</th>
								      <th>收入</th>
								      <th>余额</th>
								      <th>对方账户</th>
								      <th>币种</th>
								      <th>交易类型</th>
								      <th class="mdl-data-table__cell--non-numeric">注解</th>
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