<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Catégories</title>
<script type="text/javascript" src="testfile.js"></script>
</head>
<body>


<f:form action="saveCategorie" modelAttribute="c">

<f:hidden path="id"/>

Nom Categories: <f:input path="nomCategorie" />
<br>


<input type="submit" value="Envoyer">
</f:form>


<table>
<tr>
<td>NomCategorie</td>
<td>Supprimer</td>
<td>Modifier</td>

</tr>
<c:forEach items="${categories}" var="c">
<tr>
<td>${c.nomCategorie }</td>
<td><a href="SupprimerCategorie?id=${c.id }">Supprimer</a></td>
<td><a href="modifierCategorie?id=${c.id }">Modifier</a></td>
</tr>
</c:forEach>



</table>

</body>
</html>