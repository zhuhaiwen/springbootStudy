<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录界面</title>
</head>
<body>
    <form method="get" action="/user/login">
        用户名：<input type="text" name="name"/><br/>
        密码：<input type="password" name="pwd"/><br/>
        <input type="submit" value="登陆"/>
    </form>
</body>