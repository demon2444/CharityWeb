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
    <h2>Dodaj Instytucję</h2>
    <form:form modelAttribute="institution" action="/admin/institutions/edit" method="post" >

        <div class="form-group">
            <form:input path="name" type="text" placeholder="Nazwa"/>
            <form:errors path="name" cssClass="ui-state-error" />
        </div>
        <div class="form-group">
            <form:textarea path="description" placeholder="Opis instytucji"/>
            <form:errors path="description" cssClass="ui-state-error" />

            <form:hidden path="id"/>
        </div>



        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zapisz</button>
        </div>
    </form:form>
</section>
<%@include file="fragments/footer.jspf" %>


</body>
</html>
