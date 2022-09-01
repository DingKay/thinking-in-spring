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
\${requestUser.name} : ${requestUser.name}
\${requestUser.age} : ${requestUser.age}
\${requestUser.timestamp} : ${requestUser.timestamp}

 \${sessionUser.name} : ${sessionUser.name}
 \${sessionUser.age} : ${sessionUser.age}
 \${sessionUser.timestamp} : ${sessionUser.timestamp}

\${servletContextUser.name} : ${applicationScope['scopedTarget.servletContextUser'].name}
\${servletContextUser.age} : ${applicationScope['scopedTarget.servletContextUser'].age}
\${servletContextUser.timestamp} : ${applicationScope['scopedTarget.servletContextUser'].timestamp}
</body>
</html>
