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
<body>
<%@include file="fragments/header.jspf" %>


<section class="login-page" id="reg">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post" action="/user/settings">


        <div class="form-group" id="update">
            <form:hidden path="id"/>
            <form:input path="firstname" type="text" name="firstname" id="firstname" placeholder="Imię"/>
            <p id="firstText"></p>
        </div>
        <div class="form-group">
            <form:input path="secondname" type="text" name="secondname" id="secondname" placeholder="Nazwisko"/>
            <p id="secondText"></p>
        </div>

        <div class="form-group">
            <form:input path="username" type="email" name="email" id="mail" placeholder="Email"/>
            <p id="username"></p>
        </div>

        <div class="form-group">
            <input type="password" name="passChange" placeholder="Hasło" id="passwd"/>
            <p id="pass"></p>
            <form:hidden path="password"/>
            <form:hidden path="enabled"/>
        </div>
        <div class="form-group">
            <form:input path="password2" type="password" name="password2" id="paswd2" placeholder="Powtórz hasło"/>
            <p id="pass2"></p>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zauktualizuj</button>
        </div>
    </form:form>
</section>
<%@include file="fragments/footer.jspf" %>
<script src="/../../resources/js/register.js"></script>


</body>
</html>
