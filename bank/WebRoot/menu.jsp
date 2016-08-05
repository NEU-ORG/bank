<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="my-account">
    <li class="mdl-menu__item" onclick="location='account_info.action'">帐户查询</li>
    <li class="mdl-menu__item" onclick="location='account_changepwd_win.action'">交易密码修改</li>
    <li class="mdl-menu__item" onclick="location='account_transdetail_win.action'">交易明细查询</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider" onclick="location='account_lockwin.action'">账户挂失</li>
    <li class="mdl-menu__item" onclick="location='account_create_win.action'">添加银行卡</li>
    <li class="mdl-menu__item" onclick="location='account_delete_win.action'">删除银行卡</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li class="mdl-menu__item" onclick="location='account_transfer_win.action'">转账业务</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider" onclick="location='account_db_transfer_win.action'">跨行汇款</li>
    <li class="mdl-menu__item " onclick="location='account_transferdetail_win.action'">转账查询</li>
    <li class="mdl-menu__item" onclick="location='account_paylist_win.action'">收款人名册</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="credit-card">
    <li onclick="location='creditCard_info.action'" class="mdl-menu__item">信用卡查询</li>
    <li onclick="location='creditCard_checkedBill.action'" class="mdl-menu__item">已出账单查询</li>
    <li onclick="location='creditCard_uncheckedBill.action'" class="mdl-menu__item">未出账单查询</li>
    <li onclick="location='creditCard_changeSPassword.action'" class="mdl-menu__item">查询密码设置</li>   
    <li onclick="location='creditCard_changeTPassword.action'" class="mdl-menu__item mdl-menu__item--full-bleed-divider">交易密码设置</li>

    <li onclick="location='creditCard_apply.action'" class="mdl-menu__item">申请信用卡</li>
    <li onclick="location='creditCard_application_progress.action'" class="mdl-menu__item">申请进度查询</li>
    <li onclick="location='creditCard_active.action'" class="mdl-menu__item">信用卡激活</li>
    <li onclick="location='creditCard_report_loss.action'" class="mdl-menu__item">信用卡挂失</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li class="mdl-menu__item">Some Action</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
    <li disabled class="mdl-menu__item">Disabled Action</li>
    <li class="mdl-menu__item">Yet Another Action</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="setting">
    <li onclick="location='user_info.action'" class="mdl-menu__item">个人资料查询</li>
    <li onclick="location='user_changeUserInfo.action'" class="mdl-menu__item">个人资料修改</li>
    <li onclick="location='user_changeUserName.jsp'" class="mdl-menu__item">修改登录名</li>
    <li onclick="location='user_changePassword.jsp'" class="mdl-menu__item">修改登录密码</li>
</ul>
