<%@page contentType="text/html;utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--防止乱码--%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h1>系统主页V1.0</h1>

<shiro:guest>
    游客访问 <a href="login.jsp"></a>
</shiro:guest>

<%--user 标签：用户已经通过认证\记住我 登录后显示响应的内容--%>
<shiro:user>
    <%--主身份信息--%>
    欢迎[<shiro:principal/>]登录 <a href="${pageContext.request.contextPath}/user/logout">退出登陆</a>
</shiro:user>

<%--页面方式授权--%>
<ul>
    <shiro:hasAnyRoles name="user_manager,admin">
        <li><a href="">用户管理</a>
            <ul>
                <shiro:hasPermission name="user:add:*">
                    <li><a href="">添加</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:delete:*">
                    <li><a href="">删除</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:update:*">
                    <li><a href="">修改</a></li>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:find:*">
                    <li><a href="">查询</a></li>
                </shiro:hasPermission>
            </ul>
        </li>
    </shiro:hasAnyRoles>

    <shiro:hasAnyRoles name="order_manager,admin">
        <li><a href="">订单管理</a></li>
        <ul>
            <shiro:hasPermission name="order:add:*">
                <li><a href="">添加</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="order:delete:*">
                <li><a href="">删除</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="order:update:*">
                <li><a href="">修改</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="order:find:*">
                <li><a href="">查询</a></li>
            </shiro:hasPermission>
        </ul>
    </shiro:hasAnyRoles>
</ul>

</body>
</html>