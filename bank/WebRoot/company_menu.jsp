<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="company_account">
    <li class="mdl-menu__item" onclick="location='company_account_info.action'">帐户查询</li>
    <li class="mdl-menu__item" onclick="location='company_transactionDetail.action'">账户明细查询</li>
    <li class="mdl-menu__item" onclick="location='company_changeTPassword.action'">修改查询密码</li>
    <li class="mdl-menu__item" onclick="location='company_addAccount.action'">增加帐户</li>
    <li class="mdl-menu__item" onclick="location='company_deleteAccount.action'">删除帐户</li>
    <li class="mdl-menu__item" onclick="location='company_reportLoss.action'">账户挂失</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li class="mdl-menu__item" onclick="location='company_internalTransfer.action'">企业内部转账</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider" onclick="location='company_transfer.action'">行内转账</li>
    <li class="mdl-menu__item" onclick="location='company_transferDetail'">转账查询</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li class="mdl-menu__item" onclick="location='group_payroll_win.action'">代发工资</li>
    <li class="mdl-menu__item" onclick="location='group_wagedetail_win.action'">代发工资查询</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="jituan">
    <li class="mdl-menu__item" onclick="location='group_query_win.action'">集团账户管理</li>
    <li class="mdl-menu__item" onclick="location='group_transdetail_win.action'">账户查询</li>
    <li class="mdl-menu__item" onclick="location='group_transfer_win.action'">资金调拨</li>
    <li class="mdl-menu__item" onclick="location='group_cashsweep_win.action'">资金归集</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="huipiao">
    <li class="mdl-menu__item" onclick="location='company_draftChupiao.action'">出票</li>
    <li class="mdl-menu__item" onclick="location='company_draftZhuanrang.action'">背书转让</li>
    <li class="mdl-menu__item" onclick="location='company_draftTiexian.action'">贴现</li>
      <li class="mdl-menu__item" onclick="location='company_draftFukuan.action'">提示付款</li>
       <li class="mdl-menu__item" onclick="location='company_draftZhuisuo.action'">追索/清偿</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="setting">
    <li class="mdl-menu__item" onclick="location='company_logout.action'">退出系统</li>
</ul>
