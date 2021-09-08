package com.petSmile.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petSmile.dao.UsuarioDAO;

@WebServlet(description = "controla el inicio de sesión de usuario", urlPatterns = {"/usuarios"})
public class UsuarioController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Map<String, String> mapMensajes = new HashMap<>();
        String mensaje;
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {			
			if(usuarioDAO.validar(user, pass)) {
				request.getRequestDispatcher("reservas").forward(request, response);
			}else {
				 mensaje = "Credenciales Inválidas";
				 request.setAttribute("mensaje", mensaje);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}	
}
