<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Espace Personnel gestion de mes annonces</title>
<script type="text/javascript" src="testfile.js"></script>
</head>
<body>
<h2>Mes Annonces</h2>
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
<c:forEach items="${annonces}" var="annonce">
<tr>
<td>${annonce.titre }</td>
<td>${annonce.description }</td>
<td><img alt="image non disponible" width="100px" height="100px" src="${annonce.image}"/></td>
<td>${annonce.datePublication }</td>
<td>${annonce.dateExpiration }</td>
<td>${annonce.utilisateur }</td>
<td>${annonce.listeCommentaire }</td>
<td>${annonce.categorie }</td>
<td><a href="SupprimerAnnonce?id=${a.id }">Supprimer</a></td>
<td><a href="modifierAnnonce?id=${a.id }">Modifier</a></td>
</tr>

</c:forEach>
</table>

<h2>Poster une nouvelle annonce</h2>

<f:form method="POST" action="enregistrerAnnonceEspacePersonnel" enctype="multipart/form-data" modelAttribute="a">

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




</body>
</html>