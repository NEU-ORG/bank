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
<script type="text/javascript" charset="utf8" src="js/jquery-1.10.2.min.js"></script>

<script type="text/javascript">

function init() {
	$.ajax({
		type:"GET",
		url:"QueryConstant",
		dataType:"json",
		success:function(data) {
			if(data.status==true) {
				/* alert("success"); */
				var tabObj = $("#benefit_show");
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
	if(data[i].type == "存款利率")
	{
			newRow = "<tr><td>"+data[i].text+
				"</td><td>"+data[i].value+
				"</td></tr>";
		tabObj.append(newRow);
	}
	}
}

</script>

</head>
<body onload="init();">
	<%@include file="/admin_menu.jsp"%>
	<%-- <%@include file="/menu.jsp"%> --%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<h1>利率浏览</h1>
			<div class="mdl-grid portfolio-max-width">
				<table id="benefit_show" 	class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
				    	<tr>
				      		<th>类型</th>
				      		<th>利率</th>
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