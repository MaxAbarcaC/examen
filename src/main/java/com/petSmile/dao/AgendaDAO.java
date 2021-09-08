package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.petSmile.conexion.Conexion;
import com.petSmile.model.Agenda;

public class AgendaDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	public List<Agenda> obtenerRegistros() throws SQLException {
		ResultSet resultSet = null;
		List<Agenda> listaRegistros = new ArrayList<Agenda>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM agenda";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Agenda a = new Agenda();
				a.setId(resultSet.getInt(1));
				a.setIdMascota(resultSet.getInt(2));
				a.setRutDueno(resultSet.getString(3));
				a.setNombreMascota(resultSet.getString(4));
				a.setHora(resultSet.getTime(5).toLocalTime());
				a.setFecha(resultSet.getDate(6).toLocalDate());
				listaRegistros.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaRegistros;
	}

	public boolean eliminar(int id) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "DELETE FROM agenda WHERE id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}

		return estadoOperacion;
	}

	@SuppressWarnings("null")
	public boolean crear(Agenda agenda) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			connection.setAutoCommit(false);
			sql = "INSERT INTO agenda (id, idMascota, rutDueno, nombreMascota, hora, fecha) VALUES(?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			
			

			statement.setInt(1, (Integer) 0);
			statement.setInt(2, agenda.getIdMascota());
			statement.setString(3, agenda.getRutDueno());
			statement.setString(4, agenda.getNombreMascota());
			statement.setTime(5, Time.valueOf(agenda.getHora()));
			statement.setDate(6, Date.valueOf(agenda.getFecha()));

			estadoOperacion = statement.executeUpdate() > 0;

			connection.commit();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}
