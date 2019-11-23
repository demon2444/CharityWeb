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
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body ng-app="myapp">
<%@include file="fragments/header.jspf" %>


<section class="login-page" id="reg">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post">

        <div class="form-group">
            <form:input path="firstname" type="text" name="firstname" placeholder="Imię"/>
            <form:errors path="firstname" cssClass="ui-state-error"/>
        </div>
        <div class="form-group">
            <form:input path="secondname" type="text" name="secondname" placeholder="Nazwisko"/>
            <form:errors path="secondname" cssClass="ui-state-error"/>
        </div>

        <div class="form-group">
            <form:input path="username" type="email" name="email" placeholder="Email"/>
            <form:errors path="username" cssClass="ui-state-error"/>
        </div>

        <div class="form-group" ng-controller="PasswordController">
            <form:input path="password" type="password" name="password" placeholder="Hasło" id="passwd" />
            <form:errors path="password" cssClass="ui-state-error"/>
            <div ng-style="passwordStrength"></div>
            <p id="counter"></p>
        </div>
        <div class="form-group" id="pass2">
            <form:input path="password2" type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/user/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<%@include file="fragments/footer.jspf" %>
<script src="<c:url value="../../../resources/js/reg.js"/>"></script>


</body>
</html>
