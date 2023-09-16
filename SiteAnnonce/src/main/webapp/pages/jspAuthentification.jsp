<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page D'authentification</title>
<script type="text/javascript" src="testfile.js"></script>
</head>


<body>
<!-- ////////// Affichage des erreurs de connexion /////// -->
<c:if test="${not empty param.error}">
  <font color="red"> Login error. <br /> Reason :
    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
  </font>
</c:if>

<!-- //////// Affichage du message de déconnexion //////// -->
<c:if test="${not empty param.logout_message }">
  <font color="red"> You have been logged out successfully </font>
</c:if>



<!-- ///////////////////// Formulaire //////////////////// -->
<div align="center">

  <!-- Construction de l'url effectuant l'autentification -->
  <c:url value="login" var="loginUrl" />

  <!-- Formulaire -->
  <f:form action="${loginUrl}" method="POST">
    <table>
      <tr>
        <td>Adresse Mail :</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>Mot de passe :</td>
        <td><input type="text" name="password" /></td>
      </tr>
      <tr>
        <td colspan="2" align="right"><input type="submit"
          value="Se Connecter" /> <input type="reset" value="Reset" /></td>
      </tr>
    </table>
  </f:form>
</div>

<br />
<br />
<!--  Affichage d'un lien vers la page d'accueil  -->
<c:if test="${not empty param.logout_message}">
  <font color="red"> 
    <a href="${pageContext.request.contextPath}/messageList">Page d'accueil</a>
  </font>
</c:if>

</body>
</html>