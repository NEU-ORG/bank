<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
	<%@include file="/admin_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/admin_header.jsp"%>
		<main class="mdl-layout__content">
		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
			<div class="mdl-card__title">
				<h2 class="mdl-card__title-text">修改费率</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<%-- 	<c:out value="真实姓名：${user.realName}"></c:out>
				<br />
				<c:out value="身份证号：${user.idNumber}"></c:out>
				<br />
				<c:out value="手机号：${user.phoneNumber}"></c:out>
				<br />
				<c:out value="所属分行：${user.bank.name}"></c:out>
				<br />
				<c:out value="创建时间：${user.createDate}"></c:out>
				<br /> --%>
				<form action="admin_benefitSet" id＝"form" method="post">
				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					费率： <select name="benefitID">
						<c:forEach var="benefit" items="${benefits}">
							<option value="${benefit.id}">${benefit.type}${benefit.text}(${benefit.value})</option>
						</c:forEach>
					</select>

				</div>
<%-- 				<c:out value="更改前的费率：${constant.type}"></c:out>
				<br /> --%>
				
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<input class="mdl-textfield__input" type="text" id="sample3"
							name="value"> <label class="mdl-textfield__label"
							for="sample3">费率...</label>
					</div>
					<div class="mdl-card__actions">
						<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							style="float: right;">修改</button>
					</div>

				</form>
			</div>
			<div class="mdl-card__menu">
				<button
					class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
					取消</button>
			</div>
		</div>
		<br />
		<br />

		<%@include file="/footer.jsp"%> </main>
	</div>
	<script src="material.min.js"></script>
</body>
</html>