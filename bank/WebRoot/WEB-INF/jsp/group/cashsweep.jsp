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
	min-width: 700px;		
	width: 700px;
}
</style>

<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

var clist;

$(document).ready(function() {
	$("#company-list").change(function() {
		var index = $("#company-list option:selected").val();
		//alert("i:"+index);
		AddTable(clist,index);
	});
	$("#ca-list").change(function() {
		var index = $("#company-list option:selected").val();
		AddTable(clist,index);
	});
});

function cashsweep() {
	var checklist=[];
	var i=0;
	$(".mycheckbox").each(function() {
		if($(this).is(':checked')) {
			//alert("id:"+$(this).val());
			checklist[i]=$(this).val();
			i++;
		}
	});
	var cl = "{\"list\":[";
	for(var i=0;i<checklist.length;i++) {
		//alert(checklist[i]); 
		if(i == (checklist.length-1))
			cl = cl + checklist[i];
		else 
			cl = cl + checklist[i] + ',';
	}
	cl = cl + ']}';
	//alert(cl);
	var aid = $("#ca-list option:selected").val();
	var pwd = $("#pwd").val();
	$.post("cashsweepAction",
			{
				accountId:aid,
				checklist:cl,
				pwd:pwd,
			},function(a,b) {
				$("#msg-label").html(a.jsonResult);
			},dataType="json");
}

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
				AddTable(clist,-1);
			} else
				alert("status=false");
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

function AddTable(data, index) {
	var str1 = "<input type=\"checkbox\" class=\"mycheckbox\" class=\"mdl-switch__input\" value=\"";
	var str2 = "\" >"
	var noid = $("#ca-list option:selected").val();
	$("#a-list tbody").empty();
	var newRow;
	if(index == -1) {
		for(var i=0;i<data.length;i++) {
			for(var j=0;j<data[i].companyAccounts.length;j++) {
				if(data[i].companyAccounts[j].id == noid)
					continue;
				newRow = "<tr><td>"+str1+data[i].companyAccounts[j].id+str2+
						 "</td><td>"+data[i].companyAccounts[j].accountNumber+
						 "</td><td>"+data[i].companyAccounts[j].name+
						 "</td><td>"+data[i].companyAccounts[j].status+
						 "</td><td>"+data[i].companyAccounts[j].type+
						 "</td><td>"+data[i].companyAccounts[j].currency+
						 "</td><td>"+data[i].companyAccounts[j].balance+
						 "</td><td>"+data[i].companyAccounts[j].availableBalance+
						 "</td></tr>";
				$("#a-list").append(newRow);
			}
		}
	} else {
		for(var i=0;i<data.length;i++) {
			if(data[i].id != index)
				continue;
			for(var j=0;j<data[i].companyAccounts.length;j++) {
				if(data[i].companyAccounts[j].id == noid)
					continue;
				newRow = "<tr><td>"+str1+data[i].companyAccounts[j].id+str2+
						 "</td><td>"+data[i].companyAccounts[j].accountNumber+
						 "</td><td>"+data[i].companyAccounts[j].name+
						 "</td><td>"+data[i].companyAccounts[j].status+
						 "</td><td>"+data[i].companyAccounts[j].type+
						 "</td><td>"+data[i].companyAccounts[j].currency+
						 "</td><td>"+data[i].companyAccounts[j].balance+
						 "</td><td>"+data[i].companyAccounts[j].availableBalance+
						 "</td></tr>";
				$("#a-list").append(newRow);
			}
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
			<h1>资金归集:<c:out value="${loginInfo}" /></h1>

				<div class="mdl-grid portfolio-max-width" id="a-card">
	        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
	                    <div class="mdl-card__title ">
	                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">资金归集</h2>
	                    </div>
	                    <div class="mdl-card__supporting-text">
	                    	 归集账户：<select id="ca-list"></select>
	                    	<br /><br />
	                    	公司：<select id="company-list"></select>
	                    	<br />
	                    	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<input class="mdl-textfield__input" type="password" id="pwd"
									name="password"> <label class="mdl-textfield__label"
									for="pwd">请输入交易密码...</label>
							</div><br />
							<label id="msg-label"></label>
							<br />
	                    	<button id="trans-button"
								class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
								style="float:left;" onclick="cashsweep();">资金归集</button>
							<br /><br /><br />
							<label>集中账户：</label>
							<table id="a-list" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
								<thead>
								    <tr>
								      <th></th>
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