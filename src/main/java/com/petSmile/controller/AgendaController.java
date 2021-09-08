package com.petSmile.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petSmile.dao.AgendaDAO;
import com.petSmile.model.Agenda;

@WebServlet(description = "controla las solicitudes para el manejo de reservas", urlPatterns = {"/reservas"})
public class AgendaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public AgendaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String opcion = request.getParameter("opcion");
		
		if(opcion.equals("crear")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("crear.jsp");
			requestDispatcher.forward(request, response);
		}else if (opcion.equals("listar")) {
			
			AgendaDAO agendaDAO = new AgendaDAO();
			List<Agenda> lista = new ArrayList<>();
			try {
				lista = agendaDAO.obtenerRegistros();
				ServletContext context=getServletContext();
				context.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listadoReservas.jsp");
				requestDispatcher.forward(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}else if (opcion.equals("eliminar")) {
			AgendaDAO agendaDAO = new AgendaDAO();
			int id = Integer.parseInt(request.getParameter("iD"));
			try {
				agendaDAO.eliminar(id);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listadoReservas.jsp");
				requestDispatcher.forward(request, response);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		AgendaDAO agendaDAO = new AgendaDAO();
		Agenda agenda = new Agenda();
		
		//Formateando fecha y hora desde el datepicker
		String fecha = request.getParameter("pickedDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(fecha, formatter);
		LocalDate localDate = localDateTime.toLocalDate();
		LocalTime localTime = localDateTime.toLocalTime();
		
		
		if(opcion.equals("guardar")) {
			
			agenda.setIdMascota(Integer.parseInt(request.getParameter("idMascota")));
			agenda.setRutDueno(request.getParameter("rutDueno"));
			agenda.setNombreMascota(request.getParameter("nombreMascota"));				
			agenda.setFecha(localDate);
			agenda.setHora(localTime);
			
		}try {
			List<Agenda> lista = new ArrayList<>();
			agendaDAO.crear(agenda);
			lista = agendaDAO.obtenerRegistros();
			ServletContext context=getServletContext();
			context.setAttribute("lista", lista);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listadoReservas.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
