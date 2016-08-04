<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="company_account">
    <li class="mdl-menu__item" onclick="location='company_account_info.action'">帐户查询</li>
    <li class="mdl-menu__item" onclick="location='company_transactionDetail.action'">账户明细查询</li>
    <li class="mdl-menu__item">网银交易查询</li>
    <li class="mdl-menu__item">对账单查询</li>
    <li class="mdl-menu__item" onclick="location='company_changeTPassword.action'">修改查询密码</li>
    <li class="mdl-menu__item">增加删除上挂帐户</li>
    <li class="mdl-menu__item" onclick="location='company_reportLoss.action'">账户挂失</li>
    <li class="mdl-menu__item">票据挂失</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="operator">
    <li class="mdl-menu__item" onclick="location='account_info.action'">操作员管理</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider" onclick="location='account_lockwin.action'">账户权限管理</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li class="mdl-menu__item" onclick="location='company_internalTransfer.action'">企业内部转账</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider" onclick="location='company_transfer.action'">行内转账</li>
    <li class="mdl-menu__item">跨行转账</li>
    <li class="mdl-menu__item">收款人名册</li>
    <li class="mdl-menu__item" onclick="location='company_transferDetail'">转账查询</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li class="mdl-menu__item" >代发工资</li>
    <li class="mdl-menu__item" >代发工资查询</li>
    <li class="mdl-menu__item">费用报销和预借</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="jituan">
    <li class="mdl-menu__item" >集团账户管理</li>
    <li class="mdl-menu__item" onclick="location='company_internalTransfer.action'">账户查询</li>
    <li class="mdl-menu__item">资金归集</li>
    <li class="mdl-menu__item">结算中心支付</li>
    <li class="mdl-menu__item">账户利息计算</li>
    <li class="mdl-menu__item">资金调拨</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="huipiao">
    <li class="mdl-menu__item"">出票</li>
    <li class="mdl-menu__item ">保证</li>
    <li class="mdl-menu__item">背书转让</li>
    <li class="mdl-menu__item">贴现/赎回</li>
     <li class="mdl-menu__item">质押解质押</li>
      <li class="mdl-menu__item">提示付款</li>
       <li class="mdl-menu__item">追索/清偿</li>
        <li class="mdl-menu__item">企业账号验证</li>
         <li class="mdl-menu__item">商票扣款通知</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="互联">
    <li class="mdl-menu__item" >他行网银账户查询</li>
    <li class="mdl-menu__item">他行网银资金操作</li>
</ul>
