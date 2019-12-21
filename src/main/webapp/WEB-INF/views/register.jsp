<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body ng-app="myapp">
<%@include file="fragments/header.jspf" %>


<section class="login-page" id="reg">
    <h2><sec:authorize access="isAnonymous()">Załóż konto</sec:authorize>
        <sec:authorize access="isAuthenticated()"> Zmień dane</sec:authorize> </h2>
    <form:form modelAttribute="user" method="post">

        <div class="form-group">
            <form:input path="firstname" type="text" placeholder="Imię" id="firstname"/>
            <form:errors path="firstname" cssClass="ui-state-error"/>
            <p id="firstText"></p>
        </div>
        <div class="form-group">
            <form:input path="secondname" type="text" placeholder="Nazwisko" id="secondname"/>
            <form:errors path="secondname" cssClass="ui-state-error"/>
            <p id="secondText"></p>
        </div>

        <div class="form-group">
            <form:input path="username" id="mail" type="email" placeholder="Email"/>
            <form:errors path="username" cssClass="ui-state-error"/>
            <p id="username"></p>
        </div>

        <div class="form-group" >
            <form:input path="password" type="password" id="passwd" placeholder="Hasło"  />
            <form:errors path="password" cssClass="ui-state-error"/>
            <p id="pass"></p>
        </div>
        <div class="form-group">
            <form:input path="password2" type="password" id="passwd2" placeholder="Powtórz hasło"/>
            <form:errors path="password2" cssClass="ui-state-error"/>
            <p id="pass2"></p>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<%@include file="fragments/footer.jspf" %>
<script src="/../../resources/js/register.js"></script>

</body>
</html>
