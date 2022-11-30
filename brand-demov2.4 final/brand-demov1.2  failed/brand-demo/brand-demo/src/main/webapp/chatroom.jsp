<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/11/19
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
    <link href="css/chatroom.css" rel="stylesheet">
</head>


<style>
    * {
        box-sizing: border-box;
        color: white;
        font-family: 新宋体;

    }

    html {
        height: 100%;
        width: 100%;
        overflow: hidden;
        margin: 0;
        padding: 0;
        background-repeat: no-repeat;
        background-size: 100% 100%;
        -moz-background-size: 100% 100%;
    }

    body {
      margin: 0;
    }

    .header {

        padding: 20px;
        text-align: left;

    }

    /* 导航条 */
    .topnav {
        overflow: hidden;

    }

    /* 导航链接 */
    .topnav a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    /* 链接 - 修改颜色 */
    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    /* 创建三个不相等的列 */
    .column {
        float: left;
        padding: 10px;
    }

    /* 左右两侧宽度 */
    .column.side {
        width: 40%;
    }

    /* 中间区域宽度 */
    .column.middle {
        width: 60%;
    }

    /* 列后面清除浮动 */
    .row:after {
        content: "";
        display: table;
        clear: both;
    }
    #cart{
        width: 100px;
        margin-left: 15px;
        border-radius: 5px;
        border-style: hidden;
        height: 30px;
        background-color: rgba(216, 191, 216, 0.5);
        outline: none;
        color: #f0edf3;
        padding-left: 10px;}
    #send{
        width: 100px;
        margin-left: 15px;
        border-radius: 5px;
        border-style: hidden;
        height: 30px;
        background-color: rgba(216, 191, 216, 0.5);
        outline: none;
        color: #f0edf3;
        padding-left: 10px;
    }
    #logout{
        width: 100px;
        margin-left: 15px;
        border-radius: 5px;
        border-style: hidden;
        height: 30px;
        background-color: rgba(216, 191, 216, 0.5);
        outline: none;
        color: #f0edf3;
        padding-left: 10px;}
    input[type="text"]{

background-color: black;


     padding-bottom: 20px;
    }  /* 响应式布局 - 宽度小于600px时设置上下布局 */
    @media screen and (max-width: 600px) {
        .column.side, .column.middle {
            width: 100%;
        }
    }
</style>


<body>

<div class ="header">
    <h1>${user.username},欢迎您</h1>
</div>


    <div class="row">
        <div class="column middle">

    <h3>当前在线</h3>
    <table >
<c:forEach items="${userlist}" var="username" varStatus="status">

    <tr>

    </tr>  <td>${username}</td>
    <tr>

    </tr>

</c:forEach>
    </table>
          </div>
     <div class ="column side">
<form action="/brand-demo/selectAllServlet" method="post">
    <input type="submit" value="商城" id="cart" />
</form>
         <form action="/brand-demo/logoutServlet" method="post">
             <input type="submit"  id="logout" value="退出登录" />
         </form>

<table>

    <c:forEach items="${msgList}" var="msg" varStatus="status">
           <tr>

    </tr>  <td>${msg.time}</td>
        <tr>

        </tr>
        <td><% for(int i=0;i<6;i++){ %>
            &nbsp
            <% }%>${msg.userName}:</td>

            <td>${msg.content} </td>
    </c:forEach>

</table>
     </div>
        <div class="column side">
<form action="/brand-demo/SendServlet" method="post" id="content">
    <input type="hidden" name="username" value="${user.username}">

    <label >
<input type="text"  name="content"  id="text">
    </label>


    <input type="submit" value="发送" id="send">
</form>

      </div>
<%
    // 设置每隔5秒刷新一次
 //   response.setIntHeader("Refresh", 5);
    // 获取当前时间
    Calendar calendar = new GregorianCalendar();
    String am_pm;
    int hour = calendar.get(Calendar.HOUR);
    int minute = calendar.get(Calendar.MINUTE);
    int second = calendar.get(Calendar.SECOND);
    if(calendar.get(Calendar.AM_PM) == 0)
        am_pm = "AM";
    else
        am_pm = "PM";
    String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
    out.println("当前时间为: " + CT + "\n");
%>
</body>
<script language="JavaScript">

    document.getElementById("msg").onclick = function (){
        location.href = "/brand-demo/brand.jsp";
    }



</script>
</html>
