<%--
  Created by IntelliJ IDEA.
  User: EducaciónIT
  Date: 09/03/2019
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
    <h1>Welcome</h1>
    <hr>
    <form method="post" action="login">
        <input type="text" name="txtEmail">
        <input type="text" name="txtPassword">
        <input type="submit" value="login">
    </form>
    <br>
    <%
        if(request.getParameter("err") != null && request.getParameter("err").equals("1") ) {


    %>
    <h2>Usuario no existe!!</h2>
    <%
        }
    %>
</body>
</html>
