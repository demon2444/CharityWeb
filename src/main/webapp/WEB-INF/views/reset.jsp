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
      <h2>Zresetuj hasło</h2>
      <form:form method="post" action="/user/reset" modelAttribute="user">
        <div class="error">
           <span >${message}</span>
        </div>
        <div class="form-group">
          <form:input path="username" type="email" disabled="true" />
        </div>
        <div class="form-group">
          <form:input path="password" type="password" placeholder="Hasło" />
          <form:errors path="password" cssClass="ui-state-error"/>
        </div>
        <div class="form-group">
          <form:input path="password2" type="password" placeholder="Powtórz hasło" />
          <form:errors path="password2" cssClass="ui-state-error"/>

          <form:hidden path="id"/>
          <form:hidden path="username"/>
          <form:hidden path="enabled"/>
          <form:hidden path="donation"/>
          <form:hidden path="roles"/>
          <form:hidden path="firstname"/>
          <form:hidden path="secondname"/>
          <form:hidden path="token"/>
          <form:hidden path="enabled"/>

        </div>


        <div class="form-group form-group--buttons">
          <button class="btn" type="submit">Zresetuj hasło</button>
        </div>
      </form:form>
    </section>

  <%@include file="fragments/footer.jspf"%>


  </body>
</html>
