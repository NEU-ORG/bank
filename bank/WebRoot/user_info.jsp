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
<style>
.mdl-card {
        margin-top: 100px;
        margin-right: auto;
        margin-left: auto;

    }
    </style>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
			<div class="demo-card-wide mdl-card mdl-shadow--8dp">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">你的信息</h2>
                </div>
                <div class="mdl-card__supporting-text">
             		<c:out value="真实姓名：${user.realName}"></c:out><br/>
             		<c:out value="身份证号：${user.idNumber}"></c:out><br/>
             		<c:out value="手机号：${user.phoneNumber}"></c:out><br/>
             		<c:out value="所属分行：${user.bank.name}"></c:out><br/>
             		<c:out value="创建时间：${user.createDate}"></c:out><br/>
             		<c:out value="邮箱：${user.email}"></c:out><br/>
             		<c:out value="地址：${user.address.codeName}"></c:out><br/>
             		<c:out value="邮编：${user.postCode}"></c:out><br/>
                </div>
                <div class="mdl-card__menu">
                    <button class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                    确定
                    </button>
                </div>
            </div>
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
			<%@include file="/footer.jsp"%>
		</main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>