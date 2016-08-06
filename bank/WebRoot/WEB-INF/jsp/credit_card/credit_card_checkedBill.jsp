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
<style type="text/css">
.mdl-card {
	margin-top: 100px;
	margin-right: auto;
	margin-left: auto;
	min-width: 800px;
	width: 1600px;
}
</style>
</head>
<body>
	<%@include file="/menu.jsp"%>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="/header.jsp"%>
		<main class="mdl-layout__content">
		<div>
				<div class="mdl-grid portfolio-max-width" id="a-card">
        		<div class="mdl-cell mdl-cell--4-col mdl-cell--4-col-tablet mdl-card  mdl-card mdl-shadow--4dp portfolio-blog-card-compact">
                    <div class="mdl-card__title ">
                        <br /><br /><h2 class="mdl-card__title-text" id="a-num">未出出账单查询</h2>
                    </div>
                    <div class="mdl-card__supporting-text">
                    <c:out value="${errorMessage}"></c:out>
                    <form action="creditCard_checkedBill.action?flag='notNull'" id＝"form" method="post">
						选择账号： <select name="creditCardID">
						<c:forEach var="card" items="${creditCards}">
							<option value="${card.id}">${card.cardNumber}(${card.name})</option>
						</c:forEach>			
					</select>
					选择账单日：<input type="date" name="billDate">
					<button onclick="document.getElementById('form').submit()"
							class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
						>查询</button>
					</form>
                    	<br /><br />
						<table id="t-detail" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
							<thead>
							    <tr>
							      <th class="mdl-data-table__cell--non-numeric">账单日</th>
							      <th class="mdl-data-table__cell--non-numeric">还款日</th>
							      <th>币种</th>
							      <th>应还金额</th>
							      <th>最低还款额</th>
							      <th>总支出</th>
							      <th>总收入</th>
						
							    </tr>
							</thead>
							<tbody>						
							<tr>
							<td>${bill.statement_date}</td>
							<td>${bill.due_date}</td>
							<td>${bill.currency}</td>
							<td>${bill.statement_balance}</td>
							<td>${bill.min_payment}</td>
							<td>${bill.amount_paid}</td>
							<td>${bill.amount_received}</td>
							</tr>
							</tbody>
						</table>
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        
                    </div>
                </div>
               
            </div> 
			</div>
			<br /><br /><br /><br /><br /><br /><br /><br /><br />
			
			
		

		<%@include file="/footer.jsp"%> </main>

	</div>
	<script src="material.min.js"></script>
</body>
</html>