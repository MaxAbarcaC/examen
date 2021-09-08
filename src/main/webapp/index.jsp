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
	<form method="get"
		action="<c:url value='/usuarios'/>">
		<div class="form_description">
			<h2>Inicio de Sesion</h2>
			<p></p>
		</div>
		<ul>

			<li id="li_1"><input type="hidden" name="opcion" value="listar">
			<label class="description" for="element_1">Usuario
			</label>
				<div>
					<input id="username" name="username" type="text" />
				</div></li>
			<li id="li_2"><label class="description" for="element_2">Contraseña
			</label>
				<div>
					<input id="password" name="password" type="password" />
				</div></li>

			<li><input id="loginbtn" class="button_text" type="submit"
				name="submit" value="Ingresar" />
				</li>				
		</ul>
	</form>
	<br/>
	<% out.print(request.getAttribute("mensaje")); %>
</body>
</html>