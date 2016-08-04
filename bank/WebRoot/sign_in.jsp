<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
	 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'sign_in.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <link rel="stylesheet" href="material.min.css">
    <script src="material.min.js"></script>
    <style>
    .mdl-card {
        margin-top: 80px;
        margin-right: auto;
        margin-left: auto;

    }
    
</style>

</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header portfolio-header">
            <div class="mdl-layout__header-row "></div>

        </header>

        <main class="mdl-layout__content">

            
            
  <div class="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
  <div class="mdl-tabs__tab-bar">
      <a href="#starks-panel" class="mdl-tabs__tab is-active">个人银行</a>
      <a href="#lannisters-panel" class="mdl-tabs__tab">企业银行</a>
  </div>

  <div class="mdl-tabs__panel is-active" id="starks-panel">
  		<div class="demo-card-wide mdl-card mdl-shadow--8dp">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">登录</h2>
                </div>
                <div class="mdl-card__supporting-text">
                	<c:out value="${loginError}"/>
                	<c:set var="loginError" value=""/>
             
                    <form action="userSignIn.action" id＝"form" method="post">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" id="sample3" name="userName">
                            <label class="mdl-textfield__label" for="sample3">用户名...</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="password" id="sample3" name="password">
                            <label class="mdl-textfield__label" for="sample3">密码...</label>

                        </div>
                        <div class="mdl-card__actions">
                            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记用户名</a>
                            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记密码</a>
                            <button onclick="document.getElementById('form').submit()" class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="float: right;">登录</button>
                        </div>

                    </form>
                </div>
                <div class="mdl-card__menu">
                    <button onclick="location='sign_up.jsp'" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                    注册
                    </button>
                </div>
            </div>
  </div>
  <div class="mdl-tabs__panel" id="lannisters-panel">
    	<div class="demo-card-wide mdl-card mdl-shadow--8dp">
                <div class="mdl-card__title">
                    <h2 class="mdl-card__title-text">登录</h2>
                </div>
                <div class="mdl-card__supporting-text">
                	<c:out value="${loginError}"/>
                	<c:set var="loginError" value=""/>
             
                    <form action="companySignIn.action" id＝"form" method="post">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" id="sample3" name="operatorName">
                            <label class="mdl-textfield__label" for="sample3">用户名...</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="password" id="sample3" name="password">
                            <label class="mdl-textfield__label" for="sample3">密码...</label>

                        </div>
                        <div class="mdl-card__actions">
                            <a  class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记用户名</a>
                            <a  class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">忘记密码</a>
                            <button onclick="document.getElementById('form').submit()" class=" mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" style="float: right;">登录</button>
                        </div>

                    </form>
                </div>
            </div>
  </div>
        </main>
        <footer class="mdl-mini-footer">
            <div class="mdl-mini-footer__left-section">
                <div class="mdl-logo">Simple portfolio website</div>
            </div>
            <div class="mdl-mini-footer__right-section">
                <ul class="mdl-mini-footer__link-list">
                    <li>
                        <a href="#">Help</a>
                    </li>
                    <li>
                        <a href="#">Privacy & Terms</a>
                    </li>
                </ul>
            </div>
        </footer>
    </main>
</div>
</body>
</html>
