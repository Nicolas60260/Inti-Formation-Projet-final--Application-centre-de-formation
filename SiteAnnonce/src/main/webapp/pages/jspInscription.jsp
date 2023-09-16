<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page d'inscription</title>
<script type="text/javascript" src="testfile.js"></script>
</head>
<body>
<h2>Inscrivez-vous</h2>

  <f:form action="enregistrerUtilisateur" modelAttribute="utilisateur">

  Nom Utilisateur: <f:input path="nomUtilisateur" />
  <br>
  eMail: <f:input path="mail" />
  <br>
  Mot de passe: <f:input path="mdp" />
  <br>
  <input type="submit" value="S'enregistrer'">

  </f:form>

</body>
</html>