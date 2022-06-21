package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	
	public void agregarReserva(Reserva reserva) {
		try {
			//String query = "INSERT INTO reservas_dos(fecha_entrada, fecha_salida, valor, forma_pago)"+"VALUES(?,?,?,?)";
			PreparedStatement statement;
				statement = con.prepareStatement("INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_pago)"+"VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
				try(statement) {
					statement.setString(1, reserva.getCheckin());
					statement.setString(2, reserva.getCheckout());
					statement.setLong(3, reserva.getValor());
					statement.setInt(4, reserva.getFormaPago());
					int affectedRows = statement.executeUpdate();
					 if (affectedRows == 0) {
				            throw new SQLException("Creating user failed, no rows affected.");
				        }

				        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				            if (generatedKeys.next()) {
				                reserva.setIdReserva(generatedKeys.getInt(1));
				            }
				            else {
				                throw new SQLException("Creating user failed, no ID obtained.");
				            }
					System.out.println("insertado con exito!!!");
				        }
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
//	public void getIdReserva(Reserva reserva) {
//		PreparedStatement statement;
//		statement = con.prepareStatement("INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_pago)"+"VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//	
//		
//	}

}
