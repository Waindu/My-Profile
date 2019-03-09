<%--
  Created by IntelliJ IDEA.
  User: EducaciónIT
  Date: 09/03/2019
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.educacionit.profile.beans.User" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
    <h1>HOME</h1>
    <br>
    <%
        User u = (User) session.getAttribute("user");
    %>
    <H2>Welcome <%=u.getName() + " " + u.getLastName()%></H2>
</body>
</html>
