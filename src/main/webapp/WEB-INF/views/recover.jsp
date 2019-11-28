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


  </body>
</html>
