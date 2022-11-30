<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<%   Cookie[] cookies = request.getCookies();
String value="";
    for (Cookie cookie : cookies) {
        //3. 获取数据
        String name = cookie.getName();
        if("username".equals(name)){
             value = cookie.getValue();//获取的是URL编码后的值 %E5%BC%A0%E4%B8%89
            //URL解码
            value = URLDecoder.decode(value, StandardCharsets.UTF_8);
            break;
        }
    }
   %>
<div id="loginDiv" style="height: 350px">
    <form action="/brand-demo/loginServlet" method="post" id="form">
        <h1 id="loginMsg">LOGIN</h1>
        <div id="errorMsg">${login_msg} ${register_msg}</div>
        <p>Username:<input id="username"  type="text" name="username" value=<%=value%>></p>

        <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
        <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>



</body>
</html>