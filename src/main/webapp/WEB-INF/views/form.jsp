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
    <link rel="stylesheet" href="<c:url value="../../../resources/css/style.css"/>"/>
    <%--   <link rel="stylesheet" href="css/style.css" />--%>
</head>
<body>

<%@include file="fragments/header.jspf" %>


<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="/form/confirm" method="post" modelAttribute="donations" name="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>
                <c:forEach items="${cat}" var="c">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" value="${c.id}" class="categ"
                                   data-name="${c.name}">
                            <span class="checkbox"></span>
                            <span class="description">${c.name}</span>
                        </label>
                    </div>
                </c:forEach>
                    <%--<div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" value="clothes-useless"/>
                            <span class="checkbox"></span>
                            <span class="description">ubrania, do wyrzucenia</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" value="toys"/>
                            <span class="checkbox"></span>
                            <span class="description">zabawki</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" value="books"/>
                            <span class="checkbox"></span>
                            <span class="description">książki</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="categories" value="other"/>
                            <span class="checkbox"></span>
                            <span class="description">inne</span>
                        </label>
                    </div>--%>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input type="number" path="quantity" name="quantity" id="quantity" step="1" min="1"
                                    value="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach items="${institutions}" var="ins">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="institution" value="${ins.id}" class="institut"
                                   data-nam='${ins.name}'/>

                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">${ins.name}</div>
                  <div class="subtitle">
                    Cel i misja: ${ins.description}
                  </div>
                </span>
                        </label>
                    </div>
                </c:forEach>
                <form:errors path="institution" cssClass="ui-state-error"/>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input path="street" type="text" name="street" id="street"/>
                                <form:errors path="street" cssClass="ui-state-error"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input path="city" type="text" name="city" id="city"/>
                                <form:errors path="city" cssClass="ui-state-error"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input path="zipCode" type="text" name="postcode" id="postc"/>
                                <form:errors path="zipCode" cssClass="ui-state-error"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input path="phone" type="phone" name="phone" id="phone"/>
                                <form:errors path="phone" cssClass="ui-state-error"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input type="date" path="pickUpDate" name="pickUpDate" value="2019-10-30"
                                                     id="date"/>
                                <form:errors path="pickUpDate" cssClass="ui-state-error"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input type="time" path="pickUpTime" value="15:00" id="time"/>
                                <form:errors path="pickUpTime" cssClass="ui-state-error"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="pickUpComment" name="pickUpComment" rows="5"
                                               id="pick"/>
                                <form:errors path="pickUpComment" cssClass="ui-state-error"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="q"> </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text" id="fund"></span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="st">Prosta 51</li>
                                <li id="ci">Warszawa</li>
                                <li id="post">99-098</li>
                                <li id="number">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="dat">13/12/2018</li>
                                <li id="tim">15:40</li>
                                <li id="pic">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>


<%@include file="fragments/footer.jspf" %>



<script src="/../../resources/js/app.js"></script>
</body>
</html>
