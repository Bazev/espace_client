<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Demande de prix</title>
</head>
<body>
<form action="priceRequest" method="post">
    <label>Votre adresse email</label>
    <input type="email" name="email">
    <br>
    <label>Poussette</label>
    <select name="ID">
        <c:forEach items="${poussettes}" var="poussette">
            <option value="${poussette}">${poussette.nom}</option>
        </c:forEach>
    </select>
    <br>
    <label>Date de Début</label>
    <input type="date" name="dateBegin">
    <br>
    <label>Date de Fin</label>
    <input type="date" name="dateEnd">
    <br>

    <label>Options Choisies</label>
    <br>
    <c:forEach items="${options}" var="option">
        <input type="radio" value="${option}" id="option">
        <label for="option">${option.nom}</label>
    </c:forEach>
    <br>

    <label>Informations complémentaires</label>
    <br>
    <textarea>

    </textarea>
    <br>
    <input type="submit" value="Envoyer">



</form>

</body>
</html>
