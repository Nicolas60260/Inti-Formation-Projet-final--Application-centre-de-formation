<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Annonces</title>

</head>
<body>


<f:form method="POST" action="saveAnnonce" enctype="multipart/form-data" modelAttribute="a">

<f:hidden path="id"/>

Titre: <f:input path="titre" />
<br>
Description: <f:input path="description" />
<br>
Date de publication: <f:input path="datePublication" />
<br>
Date d'expiration: <f:input path="dateExpiration" />
<br>
Categorie: 
<f:select path="categorie.id">
  <f:options items="${categories}" itemValue="id" itemLabel="nomCategorie"/>
</f:select>
<br>

choisir une image: <input type="file" name="file"/>
<br>
<input type="submit" value="Envoyer">
</f:form>


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
<td><a href="SupprimerAnnonce?id=${a.id }">Supprimer</a></td>
<td><a href="modifierAnnonce?id=${a.id }">Modifier</a></td>

</tr>
</c:forEach>
</table>

<f:form action="afficherAnnonceParCat" modelAttribute="categorie" enctype="multipart/form-data">

Afficher Annonces par Categorie: 

<f:select path="id">

  <f:options items="${categories}" itemValue="id" itemLabel="nomCategorie"/>

</f:select>
<input type="submit" value="Envoyer">
</f:form>

<c:if test = "${listeAnnonce != null}">
  <c:forEach items="${listeAnnonce}" var="l">
  <table>
    <tr>
      <td>${l.titre }</td>
      <td>${l.description }</td>
      <td>${l.image }</td>
      <td>${l.datePublication }</td>
      <td>${l.dateExpiration }</td>
      <td>${l.utilisateur }</td>
      <td>${l.listeCommentaire }</td>
      <td>${l.categorie.nomCategorie}</td>
    </tr>
  </table>
  </c:forEach>
</c:if>

Afficher Annonces par Utilisateur: 


<f:form action="afficherAnnonceParUtilisateur" modelAttribute="utilisateur">

<f:select path="id">

  <f:options items="${utilisateurs}" itemValue="id" itemLabel="nomUtilisateur"/>

</f:select>
<input type="submit" value="Envoyer">

</f:form>

<c:if test = "${listeAnnonceParUtilisateur != null}">
  <c:forEach items="${listeAnnonceParUtilisateur}" var="l">
  <table>
    <tr>
      <td>${l.titre }</td>
      <td>${l.description }</td>
      <td>${l.image }</td>
      <td>${l.datePublication }</td>
      <td>${l.dateExpiration }</td>
      <td>${l.utilisateur }</td>
      <td>${l.listeCommentaire }</td>
      <td>${l.categorie.nomCategorie}</td>
    </tr>
  </table>
  </c:forEach>
</c:if>


</body>
</html>