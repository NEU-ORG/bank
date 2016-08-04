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
$(document).ready(function() {
	var val = "1234";
	$("#test-button").click(function() {
	//	$.post("testAction",{val:val},function(a,b) {
	//			alert("a:"+a.jsonResult);
	//			alert("b:"+b);
	//		}
	//	);
	//});
	
	$.post("changepwdAction",
				{	accountId:"1",
					oldpwd:"1",
					pwd:"1"
				},function(v) {
					alert(v);
					//alert(b);
					//$("#msg-label").html(data.jsonResult);
				});
	});
});
</script>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div>
			<h1>测试界面</h1>
			<button id="test-button">test</button>
			</div>
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>