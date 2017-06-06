<%--
  Created by IntelliJ IDEA.
  User: Ionas
  Date: 21.05.2017
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title run run</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    if (name == null || name.length() == 0) {
%>
Hello, world !
<% } else {
%>
Hello, world ! I'm <%= name%>
<%
    }
%>
</body>
</html>
