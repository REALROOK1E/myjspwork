<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加商品</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand-demo/addServlet" method="post">
    品牌名称：<input name="brandName" ><br>
    商品名称：<input name="goodsName"><br>
    价格：<input name="price"><br>
    广告语：<textarea rows="5" cols="20" name="adv"></textarea><br>
    <input type="submit" value="提交">
</form>
</body>
</html>