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

                    <th scope="col">Ilość Worków</th>
                    <th scope="col">Ulica</th>
                    <th scope="col">Kod pocztowy</th>
                    <th scope="col">Miasto</th>
                    <th scope="col">Telefon</th>
                    <th scope="col">Instytucja odbierająca</th>
                    <th scope="col">Data odbioru</th>
                    <th scope="col">Godzina odbioru</th>
                    <th scope="col">Uwagi dla kuriera</th>
                    <th scope="col">Oderane</th>
                    <c:if test="${donation.picked == false}">
                        <th scope="col">Potwierdź odbiór</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>


                <tr class="table-info">


                    <td>${donation.quantity}</td>
                    <td>${donation.street}</td>
                    <td>${donation.zipCode}</td>
                    <td>${donation.city}</td>
                    <td>${donation.phone}</td>
                    <td>${donation.institution.name}</td>
                    <td>${donation.pickUpDate}</td>
                    <td>${donation.pickUpTime}</td>
                    <td>${donation.pickUpComment}</td>
                    <td><c:if test="${donation.picked == true}">Tak</c:if>
                        <c:if test="${donation.picked == false}">Nie</c:if>
                    </td>
                    <c:if test="${donation.picked == false}">
                        <td><a href="/form/done/${donation.id}" class="btn btn--small">Potwierdź odbiór</a></td>
                    </c:if>
                </tr>
                </tbody>

            </table>
            <a href="/form/my" class="btn btn--small">Powrót</a>

        </div>
    </div>


</section>


<%@include file="fragments/footer.jspf" %>


</body>
</html>
