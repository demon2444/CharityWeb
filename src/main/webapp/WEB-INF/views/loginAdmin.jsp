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



    <section class="login-page" id="log">
      <h2>Zaloguj się</h2>
      <form:form method="post" modelAttribute="user">
        <div class="form-group">
          <form:input path="username" type="email" name="username" placeholder="Email" />
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="form-group">
          <form:input path="password" type="password" name="password" placeholder="Hasło" />
            <form:errors path="password" cssClass="error"/>
          <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
          <a href="/user/register#reg" class="btn btn--without-border">Załóż konto</a>
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form:form>
    </section>

  <%@include file="fragments/footer.jspf"%>


  </body>
</html>
