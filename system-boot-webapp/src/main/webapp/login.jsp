<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="jsp/public/head.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="jsp/public/nifty.jsp" %>
    <title>微立方智慧农业管理平台</title>
</head>

<!--TIPS-->
<!--You may remove all ID or Class names which contain "demo-", they are only used for demonstration. -->

<body>
<div id="container" class="cls-container">

    <!-- BACKGROUND IMAGE -->
    <!--===================================================-->
    <div id="bg-overlay" class="bg-img" style="background-image: url(static/img/bg-img-3.jpg)"></div>


    <!-- LOGIN FORM -->
    <!--===================================================-->
    <div class="cls-content">
        <div class="cls-content-sm panel">
            <div class="panel-body">
                <div class="mar-ver pad-btm">
                    <h1 class="h3">微立方智慧农业管理平台</h1>
                    <%--<p>账号登录</p>--%>
                </div>
                <form method="post" action="/login">
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="用户名" autofocus value="admin">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码" value="admin">
                    </div>
                    <div class="checkbox pad-btm text-left">
                        <input id="demo-form-checkbox" class="magic-checkbox" type="checkbox">
                        <label for="demo-form-checkbox">记住</label>
                    </div>
                    <button class="btn btn-primary btn-lg btn-block" type="submit">登录</button>
                </form>
            </div>

            <div class="pad-all">
                <a href="#" class="btn-link mar-rgt">忘记密码 ?</a>
                <a href="#" class="btn-link mar-lft">创建账号</a>

                <div class="media pad-top bord-top">

                </div>
            </div>
        </div>
    </div>
    <!--===================================================-->

</div>
<!--===================================================-->
<!-- END OF CONTAINER -->


</body>
</html>

