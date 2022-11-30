<%@ page import="com.lzk.pojo.User" %>
<%@ page import="static com.lzk.pojo.User.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/brand.css" rel="stylesheet">

</head>


<style>
    * {
        box-sizing: border-box;
        color: white;
        font-family: '楷体';
    }


    body {
        margin: 0;
        height: 100%;
    }

    /* 头部样式 */
    .header {

        padding: 30px;
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

    /* 响应式布局 - 宽度小于600px时设置上下布局 */
    @media screen and (max-width: 600px) {
        .column.side, .column.middle {
            width: 100%;
        }
    }
</style>









<body>






    <div class="header">
<h1>${user.username},欢迎您</h1>

    </div>


    <div class="topnav">

<form action="/brand-demo/MsgServlet" method="get">
    <input type="submit" value="进入聊天室" id="msg"  />
</form>
        <input type="button" value="新增" id="add" ><br>


    </div>

<hr>
    <div class="row">
    <div class="column middle">
        <h2>商品列表</h2>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌</th>
        <th>商品</th>
        <th>价格</th>
        <th>广告语</th>
        <th></th>
        <th></th>

    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.goodsName}</td>
            <td>${brand.price}￥</td>
            <td>${brand.adv}</td>
               <td>

                   <form action="/brand-demo/CartServlet" method="post">
                      <input type="hidden" name="id" value="${brand.id}">
                      <input type="hidden" name="brandName" value="${brand.brandName}">
                      <input type="hidden" name="goodsName" value="${brand.goodsName}">
                      <input type="hidden" name="price" value="${brand.price}">
                      <input type="hidden" name="adv" value="${brand.adv}">
                      <input type="hidden" name="userid" value="${user.id}">
                      <input type="hidden" name="status" value="${brand.status+1}">
                      <input type="submit" name="sign" value="+" id="ad" />
                   </form></td>
                <td>
                   <form action="/brand-demo/CartServlet" method="post">
                       <input type="hidden" name="id" value="${brand.id}">
                       <input type="hidden" name="brandName" value="${brand.brandName}">
                       <input type="hidden" name="goodsName" value="${brand.goodsName}">
                       <input type="hidden" name="price" value="${brand.price}">
                       <input type="hidden" name="adv" value="${brand.adv}">
                       <input type="hidden" name="userid" value="${user.id}">
                       <input type="hidden" name="status" value="${brand.status-1}">
                       <input type="submit"   name= "sign" value="--" id="--" />


                </form>

                   </td>

        </tr>

    </c:forEach>
</table>
</div>

    <div class="column side">
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌</th>
        <th>商品</th>
        <th>价格</th>
        <th>数量</th>
        <th>总计</th>



    </tr>

    <h2>购物车</h2>

    <%! int i = 0; %>
    <c:forEach items="${cart}" var="brand" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>

            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.goodsName}</td>
            <td>${brand.price}￥</td>
            <td>${brand.status}</td>
            <td>${brand.total}￥</td>



        </tr>

    </c:forEach>


</table>
    </div>



<h2>总金额
<%
out.println(request.getAttribute("sum"));

%>
    <br>

    <form action="/brand-demo/deleteServlet" method="post">
        <input type="submit"  id="delete" value="清空购物车"/>
    </form>
    <h3>在线人数
        <%
            out.println(usernumber);

        %>
</h3>   <form action="/brand-demo/logoutServlet" method="post">
        <input type="submit"  id="logout" value="退出登录" />
    </form>
    </div>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/brand-demo/addBrand.jsp";
    }
    document.getElementById("delete").onclick = function (){
        alert("清空购物车成功！")

    }
    document.getElementById("msg").onclick = function (){
        location.href = "/brand-demo/chatroom.jsp";
    }


</script>

</body>
</html>