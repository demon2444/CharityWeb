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

    <script src="<c:url value="/webjars/jquery/3.0.0/jquery.min.js"/>"></script>
    <script src="<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"/>"></script>
    <link href="<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<%@include file="fragments/header.jspf" %>




<section class="stats">
    <div class="container container--85">


<div class="stats--item">
        <table class="table table-hover" id="tab">
            <thead class="thead-dark">
            <tr>

                <th scope="col">Imie</th>
                <th scope="col">Nazwisko</th>
                <th scope="col">E-mail</th>
                <th scope="col">Konto aktywne</th>
                <th scope="col">Uprawnienia</th>
                <th scope="col"><a href="/form/time" class="tablink">Zarządzań uprawnieniami</a></th>
                <th scope="col"><a href="/form/time" class="tablink">Zabokuj konto</a></th>
                <th scope="col"><a href="/form/time" class="tablink">Usuń konto</a></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="u">



                <tr class="table-info">

                    <td>${u.firstname}</td>
                    <td>${u.secondname}</td>
                    <td>${u.username}</td>
                    <td><c:if test="${u.enabled == true}">Tak</c:if>
                        <c:if test="${u.enabled == false}">Nie</c:if>
                    </td>
                    <td><c:forEach items="${u.roles}" var="nam">
                        <c:if test="${nam.name == 'ROLE_ADMIN'}">Administrator <br></c:if>
                        <c:if test="${nam.name == 'ROLE_USER'}">User</c:if>

                    </c:forEach>
                    </td>
                    <td>
                        <a href="/admin/change/${u.id}" class="btn btn--small">Zmień</a>
                    </td>

                    <td>
                        <a href="/admin/block/${u.id}" class="btn btn--small"><c:if test="${u.enabled == true}">Zablokuj</c:if>
                            <c:if test="${u.enabled == false}">Odblokuj</c:if></a>
                    </td>
                    <td>
                        <a href="/admin/delete/${u.id}" class="btn btn--small">Usuń</a>
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>


     </div>
    </div>


</section>


<%@include file="fragments/footer.jspf" %>


</body>
</html>
