<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <h3>Listado de Agendados</h3>
    <div class="row">
        <br>
        <a href="reservas?opcion=crear" class="btn btn-primary" id="agendar">Nuevo Agendamiento</a>
        <a href="/users/chat" class="btn btn-warning">Ir al Chat</a>
        <a href="/" class="btn btn-danger">Cerrar Sesion</a>
        <table class="table table-stripped">
            <thead>
                <tr>
                	<th scope="col">ID Registro</th>
                    <th scope="col">ID Mascota</th>
                    <th scope="col">RUT Dueño</th>
                    <th scope="col">Nombre Mascota</th>
                    <th scope="col">Hora</th>
                    <th scope="col">Fecha</th>
                    <th scope="col" colspan="2">Operacion</th>
                </tr>
            </thead>
            <c:forEach var="agenda" items = "${lista}">
            <tr>
                <td><c:out value="${agenda.id}"/></td>
                <td><c:out value="${agenda.idMascota}"/></td>
                <td><c:out value="${agenda.rutDueno}"/></td>
                <td><c:out value="${agenda.nombreMascota}"/></td>
                <td><c:out value="${agenda.hora}"/></td>
                <td><c:out value="${agenda.fecha}"/></td>
                <td>
                    <a href="reservas?opcion=modificar&id=<c:out value='${agenda.id}'></c:out>">Modificar</a>
                </td>
                <td>
                    <a href="reservas?opcion=eliminar&id=<c:out value='${agenda.id}'></c:out>">Eliminar</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>