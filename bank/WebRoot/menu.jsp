<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="my-account">
    <li class="mdl-menu__item" onclick="location='account_info.action'">帐户查询</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">账户挂失</li>
    <li class="mdl-menu__item">添加新账户</li>
    <li class="mdl-menu__item">删除帐户</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li class="mdl-menu__item">Some Action</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
    <li disabled class="mdl-menu__item">Disabled Action</li>
    <li class="mdl-menu__item">Yet Another Action</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="credit-card">
    <li onclick="location='creditCard_info.action'" class="mdl-menu__item">信用卡查询</li>
    <li onclick="location='creditCard_changeSPassword.action'" class="mdl-menu__item">查询密码设置</li>
    <li onclick="location='creditCard_changeTPassword.action'" class="mdl-menu__item mdl-menu__item--full-bleed-divider">交易密码设置</li>

    <li onclick="location='creditCard_apply.action'" class="mdl-menu__item">申请信用卡</li>
    <li onclick="location='creditCard_application_progress.action'" class="mdl-menu__item">申请进度查询</li>
    <li onclick="location='creditCard_active.action'" class="mdl-menu__item">信用卡激活</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li class="mdl-menu__item">Some Action</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
    <li disabled class="mdl-menu__item">Disabled Action</li>
    <li class="mdl-menu__item">Yet Another Action</li>
</ul>