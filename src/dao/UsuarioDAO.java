package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	private Connection con;
	
	public  UsuarioDAO(Connection con) {
		this.con = con;
	}

	public boolean login(Usuario usuario) {
		
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"SELECT username, pass FROM users WHERE username=? AND pass=?"
					);
			try(statement) {
				statement.setString(1, usuario.getUserName());
				statement.setString(2, usuario.getUserPass());
				ResultSet result = statement.executeQuery();
				if(result.next()) {
					return true;
				}
				return false;
			}			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}



}
