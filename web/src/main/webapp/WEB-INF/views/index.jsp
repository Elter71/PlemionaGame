<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Start</title>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
        }

    </style>
</head>
<body>
<a href="<c:url value="/game/"/>"><h1>Gra</h1></a>
<a href="<c:url value="/register"/>"><h1>Rejestracja</h1></a>


</body>
</html>
