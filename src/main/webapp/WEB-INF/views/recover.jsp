<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
  <%@include file="fragments/header.jspf" %>



    <section class="login-page" id="res">
      <h2>Podaj maila użytkownika aby zresetować hasło</h2>
      <form:form method="post" modelAttribute="user" action="/user/recover">
        <div class="error">
           <span >${error}</span>
        </div>
        <div class="form-group">
          <form:input path="username" type="email" placeholder="Email" />
          <form:errors path="username" cssClass="ui-state-error"/>
        </div>


        <div class="form-group form-group--buttons">
          <button class="btn" type="submit">Zresetuj</button>
        </div>
      </form:form>
    </section>

  <%@include file="fragments/footer.jspf"%>

    <%--<footer>
        <div class="contact">
          <h2>Skontaktuj się z nami</h2>
          <h3>Formularz kontaktowy</h3>
          <form>
            <div class="form-group form-group--50">
              <input type="text" name="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
              <input type="text" name="surname" placeholder="Nazwisko" />
            </div>
  
            <div class="form-group">
              <textarea name="message" placeholder="Wiadomość" rows="1"></textarea>
            </div>
  
            <button class="btn" type="submit">Wyślij</button> 
          </form>
        </div>
        <div class="bottom-line">
          <span class="bottom-line--copy">Copyright &copy; 2018</span>
          <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="images/icon-facebook.svg"/></a>
            <a href="#" class="btn btn--small"><img src="images/icon-instagram.svg"/></a>
          </div>
        </div>
      </footer>--%>
  </body>
</html>
