<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
        <%@include file="BarNavigation.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page accueil</title>
<script type="text/javascript" src="testfile.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<h2>Toutes les Annonces</h2>
<c:if test="${enregistre==true}">
  Vous n'êtes pas enregistré, vous ne pouvez pas ajouter de commentaire.
  <a href="afficherPageIdentification">S'enregistrer</a>
</c:if>
<table>
  <tr>
  <td>Titre</td>
  <td>Description</td>
  <td>Image</td>
  <td>Date de publication</td>
  <td>Date d'expiration</td>
  <td>Id Utilisateur</td>
  <td>Commentaires</td>
  <td>Categorie</td>
  
  </tr>
  <c:forEach items="${annonces}" var="a">
  <tr>
  <td>${a.titre }</td>
  <td>${a.description }</td>
  <td><img alt="image non disponible" width="100px" height="100px" src="${a.image}"/></td>
  <td>${a.datePublication }</td>
  <td>${a.dateExpiration }</td>
  <td>${a.utilisateur }</td>
  <td>${a.listeCommentaire }</td>
  <td>${a.categorie }</td>
  <td><a href="ajoutterUnCommentaireToutesLesAnnonces?id=${a.id }">Ajouter un commentaire à cette annonce</a></td>
  </tr>
  </c:forEach>
  </table>


  <c:if test="${bol==true}">

		Veuillez rentrer le commentaire:
    <f:form method="POST" action="enregistrerCommentaireToutesLesAnnonces"  modelAttribute="c">
      <input type="hidden" value="${idAnnonce}" name="idAnnonce">
    Commentaire:<f:input path="leCommentaire" />
    <br>
    <input type="submit" value="Envoyer le commentaire">
    </f:form>
	</c:if>

</body>
</html>