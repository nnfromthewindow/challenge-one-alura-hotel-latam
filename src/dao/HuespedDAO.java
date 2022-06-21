package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Huesped;
import model.Reserva;

public class HuespedDAO {

private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void agregarHuesped(Huesped huesped) {
		try {
			
		
			
			PreparedStatement statement;
				statement = con.prepareStatement("INSERT INTO huespedes(nombre,apellido,fecha_de_nacimiento,nacionalidad,telefono,id_reserva)"+"VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			System.out.println(huesped.getNombre());
			System.out.println(huesped.getApellido());
			System.out.println(huesped.getFechaNacimiento());
			System.out.println(huesped.getNacionalidad());
			System.out.println(huesped.getTelefono());
			System.out.println(huesped.getIdReserva());
				try(statement) {
					statement.setString(1, huesped.getNombre());
					statement.setString(2, huesped.getApellido());
					statement.setString(3, huesped.getFechaNacimiento());
					statement.setString(4, huesped.getNacionalidad());
					statement.setString(5, huesped.getTelefono());
					statement.setInt(6, huesped.getIdReserva());
					
					int affectedRows = statement.executeUpdate();
					 if (affectedRows == 0) {
				            throw new SQLException("Fallo el registro, intente de nuevo");
				        }
					 System.out.println("insertado con exito!!!");

//				        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//				            if (generatedKeys.next()) {
//				                reserva.setIdReserva(generatedKeys.getInt(1));
//				            }
//				            else {
//				                throw new SQLException("Fallo el registro, intente de nuevo");
//				            }
//					System.out.println("insertado con exito!!!");
//				        }
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
