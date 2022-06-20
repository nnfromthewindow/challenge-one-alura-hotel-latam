package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sqlString = "INSERT INTO RESERVAS(id, fecha_entrada, fecha_salida, valor, forma_pago)VALUES(?,?,?,?,?)";
			PreparedStatement statement;
				statement = con.prepareStatement(sqlString,Statement.RETURN_GENERATED_KEYS);
				try(statement) {
					statement.setInt(1, reserva.getIdReserva());
					statement.setString(2, reserva.getCheckin());
					statement.setString(3, reserva.getCheckout());
					statement.setInt(4, reserva.getValor());
					statement.setInt(5, reserva.getFormaPago());
				}
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	

}
