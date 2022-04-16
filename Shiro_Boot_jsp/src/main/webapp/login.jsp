<%@page contentType="text/html;utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Login</title>

    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            // 点击图片切换验证码
            $("#vcodeImg").click(function () {
                $(this).prop("src", ${pageContext.request.contextPath}"/user/getImage?t=" + new Date().getTime());    //为了避免浏览器的缓存机制，改变参数
            });
        });
    </script>

</head>
<body>
<h1>登录界面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username" required> <br/>
    密码 : <input type="password" name="password" required> <br>
    请输入验证码: <input type="text" name="vcode" required>
    <img id="vcodeImg" src="${pageContext.request.contextPath}/user/getImage" alt="" title="看不清？换一张"><br>
    <input type="checkbox" name="rememberMe"/>记住我
    <input type="submit" value="登录">
</form>
</body>
</html>
