<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 21/11/2021
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<p>Votre message a bien été envoyé</p>
<c:forEach items="${demandeDePrix}" var="demande">
    ${demande.email}
</c:forEach>

</body>
</html>
