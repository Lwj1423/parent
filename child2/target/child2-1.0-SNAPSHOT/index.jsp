<%@ page import="org.sang.SayHello" %>
<%@ page import="org.child3.SayChild3" %><%--
  Created by IntelliJ IDEA.
  User: m1762
  Date: 2021/5/17 0017
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
<%SayHello sayHello = new SayHello();%>
<%=sayHello.sayHello("张三")%>

<%SayChild3 sayChild3 = new SayChild3();%>
<%=sayChild3.sayChild("李四")%>
</body>
</html>
