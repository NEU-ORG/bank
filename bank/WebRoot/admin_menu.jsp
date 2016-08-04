<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="my-account">
    <li class="mdl-menu__item" onclick="location='about.html'">修改账户名</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">修改密码</li>
    <li class="mdl-menu__item">行内机构维护</li>
    <li class="mdl-menu__item">删除帐户</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li onclick="location='admin_benefitShow'"class="mdl-menu__item">查询利率</li>
    <li onclick="location='admin_changeBenefit'"class="mdl-menu__item mdl-menu__item--full-bleed-divider">更改利率</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="credit-card">
    <li onclick="location='creditCard_info.action'" class="mdl-menu__item">修改账户名</li>
    <li onclick="location='creditCard_changeSPassword.action'" class="mdl-menu__item">修改密码</li>
    <li onclick="location='creditCard_changeTPassword.action'" class="mdl-menu__item mdl-menu__item--full-bleed-divider">行内机构维护</li>
    <li onclick="location='creditCard_apply.action'" class="mdl-menu__item">行内部门维护</li>
    <li onclick="location='creditCard_application_progress.action'" class="mdl-menu__item">费率设置</li>
    <li onclick="location='creditCard_active.action'" class="mdl-menu__item">大额转账时间设定</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li class="mdl-menu__item">查询利率</li>
    <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">更改利率</li>
</ul>