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


<%--<section class="login-page" id="reg">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="user" method="post" action="/user/profile">


        <div class="form-group" id="update">
            <form:hidden path="id"/>
            <form:input path="firstname" type="text" name="firstname" placeholder="Imię"/>
        </div>
        <div class="form-group">
            <form:input path="secondname" type="text" name="secondname" placeholder="Nazwisko"/>
        </div>

        <div class="form-group">
            <form:input path="username" type="email" name="email" placeholder="Email"/>
        </div>

        <div class="form-group">
            <input path="password" type="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="form-group">
            <input path="password2" type="password" name="password2" placeholder="Powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <button class="btn" type="submit">Zauktualizuj</button>
        </div>
    </form:form>
</section>--%>

<section class="stats">
    <div class="container container--85">
        <%--<div class="stats--item">
            <em>${bags}</em>

            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>


            <em>${donateInstitutions}</em>
            <h3>Wspartych organizacji</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>--%>

<div class="stats--item">
        <table class="table table-hover" id="tab">
            <thead class="thead-dark">
            <tr>

                <th scope="col"><a href="/form/my" class="table-warning">Id</a></th>
                <th scope="col">Ilość Worków</th>
                <th scope="col">Ulica</th>
                <th scope="col">Kod pocztowy</th>
                <th scope="col">Miasto</th>
                <th scope="col">Telefon</th>
                <th scope="col">Instytucja odbierająca</th>
                <th scope="col">Data odbioru</th>
                <th scope="col">Godzina odbioru</th>
                <th scope="col">Uwagi dla kuriera</th>
                <th scope="col"><a href="/form/picked" class="table-warning">Odebrane</a></th>
                <th scope="col"><a href="/form/time" class="table-warning"> Potwierdzony odbiór</a></th>
                <th scope="col">Potwierdź odbiór</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${donations}" var="d">



                <tr class="table-info">


                    <td>${d.id}</td>
                    <td>${d.quantity}</td>
                    <td>${d.street}</td>
                    <td>${d.zipCode}</td>
                    <td>${d.city}</td>
                    <td>${d.phone}</td>
                    <td>${d.institution.name}</td>

                    <td>${d.pickUpDate}</td>
                    <td>${d.pickUpTime}</td>
                    <td>${d.pickUpComment}</td>
                    <td><c:if test="${d.picked == true}">Tak</c:if>
                        <c:if test="${d.picked == false}">Nie</c:if>
                    </td>
                    <td>${d.pickedOn}


                    </td>
                    <td>
                        <a href="/form/done/${d.id}" class="btn btn-secondary btn-sm">Odebrane</a>
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
