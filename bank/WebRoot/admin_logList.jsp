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
<style type="text/css">
.mdl-card {
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
	min-width: 800px;
	width: 400px;
}
</style>
</head>
<body>
	<%@include file="/admin_menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/admin_header.jsp"%>
		<main class="mdl-layout__content">
		<div class="mdl-grid portfolio-max-width" id="a-card">
			<div
				class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
				<div class="mdl-card__title ">
					<br />
					<br />
					<h2 class="mdl-card__title-text" id="a-num">未出出账单查询</h2>
				</div>
				<div class="mdl-card__supporting-text">
					<table id="logList"
						class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
						<thead>
							<tr>
								<th class="mdl-data-table__cell--non-numeric">交易者</th>
								<th>交易类型</th>
								<th>交易时间</th>
								<th class="mdl-data-table__cell--non-numeric">交易信息</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="detail" items="${logList}">
								<tr>
									<td>${detail.operator}</td>
									<td>${detail.type}</td>
									<td>${detail.time}</td>
									<td>${detail.message}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="mdl-card__actions mdl-card--border"></div>
				</div>

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
		<%@include file="/footer.jsp"%> </main>


	</div>
	<script src="material.min.js"></script>
</body>
</html>