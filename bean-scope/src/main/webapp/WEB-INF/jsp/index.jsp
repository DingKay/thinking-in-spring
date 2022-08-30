<jsp:useBean id="user" scope="request" type="com.dk.geek.bean.domain.User"/>
<%--
  Created by IntelliJ IDEA.
  User: dkay
  Date: 2022/8/31
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
 \${user.name} : ${user.name}
 \${user.age} : ${user.age}
 \${user.timestamp} : ${user.timestamp}
</body>
</html>
