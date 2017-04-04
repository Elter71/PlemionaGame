<%--
  Created by IntelliJ IDEA.
  User: Rodzice
  Date: 09.03.2017
  Time: 09:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>


<html>
<head>
    <style>
        input[type=submit] {
            padding: 5px 15px;
            background: #ccc;
            border: 0 none;
            cursor: pointer;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }
    </style>
    <%--<link href="../resources/style/style.css" rel="stylesheet">--%>
    <title>Game</title>
</head>
<body>
<c:url var="a" value="/game/"/>
<form:form action="${a}" methodParam="POST">
    Dostepne wioski:
    <c:forEach items="${GameProgressList}"varStatus="status">
        <input type="submit" name="action" value="${(status.index)+1}"/>
    </c:forEach>
    <%--TODO dodaj sprawdzanie długosci listy wiosek i na tej podstawie dodaj przysikji(petla forech)--%>
</form:form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        <a href="<c:url value="/logout" />">Wyloguj</a>
    </h2>
</c:if>

</body>
</html>
