package com.petSmile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petSmile.conexion.Conexion;

public class UsuarioDAO {

	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	//buscar usuario
	public boolean validar(String user, String pass) throws SQLException {
		ResultSet resultSet = null;
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql = "SELECT nombreUsuario, password FROM usuario WHERE nombreUsuario = ? AND password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				if(resultSet.getString(1).equals(user) && resultSet.getString(2).equals(pass)) {
					estadoOperacion = true;
				}else {
					estadoOperacion = false;
				}
			}			
			connection.commit();
			statement.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	private Connection obtenerConexion() throws SQLException {
		  return Conexion.getConnection();
		 }
}
