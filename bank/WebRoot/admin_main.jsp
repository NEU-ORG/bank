<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="material.min.css" />
<link rel="stylesheet" href="styles.css" />
<script src="material.min.js"></script>
<style>
.mdl-card {
	margin-top: 100px;
	margin-right: auto;
	margin-left: auto;
}
</style>
</head>
<body>
	<%@include file="/admin_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/admin_header.jsp"%>
		<main class="mdl-layout__content">
			<div class="mdl-grid portfolio-max-width">
				<div class="mdl-grid mdl-cell mdl-cell--12-col mdl-cell--4-col-tablet mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__media mdl-cell mdl-cell--12-col-tablet">
                        <img class="article-image" src=" images/example-blog01.jpg" border="0" alt="">
                    </div>
                    <div class="mdl-cell mdl-cell--8-col">
                    	<br />
                        <h2 class="mdl-card__title-text">欢迎使用网上银行系统管理功能，<c:out value="${loginInfo}" /></h2>
                        <br />
                        <div class="mdl-card__supporting-text no-left-padding">
                           	<c:out value="真实姓名：liuhe"></c:out><br/>
		             		<c:out value="身份证号：123456789123456789"></c:out><br/>
		             		<c:out value="手机号：12345678901"></c:out><br/>
		             		<c:out value="所属分行：东北大学建行分行"></c:out><br/>
		             		<c:out value="创建时间：2016-07-31 15:11:00.0"></c:out><br/>
		             		<c:out value="邮箱：123@126.com"></c:out><br/>
		             		<c:out value="地址：沈阳"></c:out><br/>
		             		<c:out value="邮编：123456789"></c:out><br/>
                        </div>
                    </div>
                </div>
			</div><br /><br /><br /><br />
		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>