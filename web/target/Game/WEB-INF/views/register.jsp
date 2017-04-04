<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error {
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 450px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<div id="login-box">

    <h2>Zarejestruj się do gry!</h2>

    <%-- <c:if test="${not empty error}">
         <div class="error">${error}</div>
     </c:if>
     <c:if test="${not empty msg}">
         <div class="msg">${msg}</div>
     </c:if>--%>
    <%--<form:form method="post" modelAttribute="registerForm" action="/register">--%>
    <%--Login:--%>
    <%--<form:input path="login" id="login"/>--%>
    <%--<form:errors path="login" id="error"/>--%>
    <%--<br/>--%>
    <%--Hasło:--%>
    <%--<form:input path="password" id="passowrd"/>--%>
    <%--<form:errors path="password" id="error"/>--%>
    <%--<br/>--%>

    <%--</form:form>--%>


    <form:form modelAttribute="registerForm"
               action="" method='POST'>

        <table>
            <tr>
                <td>Login:</td>
                <td><form:input path="login" id="login"/>
                    <br/>
                    <form:errors path="login" class="error"/>
                </td>
            </tr>
            <tr>
                <td>Hasło:</td>
                <td><form:input path="password" id="password" type="password"/>
                    <br/>
                    <form:errors path="password" class="error"/>
                </td>
            </tr>
            <tr>

                <td>Powtórz hasło:</td>
                <td>
                    <form:input path="samePassword" id="password" type="password"/>
                    <br/>
                    <form:errors path="password" class="error"/>
                </td>


            </tr>
            <tr>
                <td>Akcektuje regulamin</td>
                <td>
                    <from:checkbox path="accept" id="checkbox"/>
                    <br/>
                    <form:errors path="accept" class="error"/>
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit"
                           value="Wyślij"/>
                </td>
            </tr>
        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>

    </form:form>
</div>

</body>
</html>
