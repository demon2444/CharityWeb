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
    <h2>Wyślij wiadomość</h2>
    <form:form modelAttribute="email" action="/mail/send"  method="post" >

        <div class="form-group">
            <form:input path="reply"  type="text" name="reply" placeholder="Twój email"/>
        </div>
        <div class="form-group">
            <form:input path="title"  type="text" name="title" placeholder="Tytuł   "/>
        </div>
        <div class="form-group">
            <form:textarea path="text" name="text" placeholder="Treść"/>

        </div>



        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Wyślij</button>
        </div>
    </form:form>
</section>
<%@include file="fragments/footer.jspf" %>


</body>
</html>
