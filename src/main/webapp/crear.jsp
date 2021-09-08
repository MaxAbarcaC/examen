<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Participante</title>
        <link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css">
    </head>
    <body>
        <h2>Agregar Participante</h2>
        <form action="<c:url value="/reservas" />" method="post">
        <input type="hidden" name="opcion" value="guardar">
            IDMascota:
            <input type="text"
                   name="idMascota"
                   id="idMascota"
                   />
            <br />

            Rut Dueño:
            <input type="text"
                   name="rutDueno" 
                   id="rutDueno"
                   />
            <br />

            Nombre mascota
            <input type="text"
                   name="nombreMascota"
                   id="nombreMascota" 
                   />
            <br />

            Fecha y hora:
            <input type="text"
           		   id="datetimepicker"
                   name="pickedDate"
                   />
            <br />

            <input type="submit" id="guardar" value="Guardar" />
            <br />

        </form>
        <br/>

        <c:out value="${mensaje}" />
    </body>    
	<script src="js/jquery.js"></script>
	<script src="js/build/jquery.datetimepicker.full.min.js"></script>
	<script>
	jQuery('#datetimepicker').datetimepicker();
</script>
</html>