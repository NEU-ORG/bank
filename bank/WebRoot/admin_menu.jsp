<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="my-account">
    <li onclick="location='admin_changeTPassword.action'"class="mdl-menu__item mdl-menu__item--full-bleed-divider">修改操作员密码</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="transfer">
    <li onclick="location='admin_benefitShow'"class="mdl-menu__item">查询利率</li>
    <li onclick="location='admin_changeBenefit'"class="mdl-menu__item mdl-menu__item--full-bleed-divider">查询用户信息</li>

</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="credit-card">
    <li onclick="location='admin_changeBenefit'"class="mdl-menu__item mdl-menu__item--full-bleed-divider">更改利率</li>
    <li onclick="location='admin_transferTimeSet'" class="mdl-menu__item">大额转账时间设定</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="pay">
    <li onclick="location='admin_logShow'"class="mdl-menu__item">查询全部日志</li>
    <li onclick="location='admin_logPartlyShow'"class="mdl-menu__item mdl-menu__item--full-bleed-divider">查询部分日志</li>
</ul>
<ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
    for="setting">
    <li onclick="location='admin_loginOut.action'"class="mdl-menu__item">退出系统</li>
</ul>