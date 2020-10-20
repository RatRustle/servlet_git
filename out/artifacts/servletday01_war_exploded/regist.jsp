<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020-10-13
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
        <h1>用户注册</h1>
        <form action="/reg" method="post">
          用户名：<input type="text" name="username" placeholder="请输入账号"><br>
          密码：<input type="password" name="password" placeholder="请输入密码"><br>
          电话：<input type="tel" name="phone" placeholder="请输入电话"><br>
          <input type="submit" value="提交">
        </form>
  </body>
</html>
