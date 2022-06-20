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
			String query = "INSERT INTO reservas_dos(fecha_entrada, fecha_salida, valor, forma_pago)"+"VALUES(?,?,?,?)";
			PreparedStatement statement;
				statement = con.prepareStatement("INSERT INTO reservas_dos "
                        + "(fecha_entrada, fecha_salida, valor, forma_pago)"
                        + " VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
    
				try(statement) {
					statement.setString(1, reserva.getCheckin());
					statement.setString(2, reserva.getCheckout());
					statement.setLong(3, reserva.getValor());
					statement.setInt(4, reserva.getFormaPago());
					final ResultSet resultSet = statement.executeQuery();
					try(resultSet){
						while(resultSet.next()) {
							reserva.setCheckin(resultSet.getString(1));
							reserva.setCheckout(resultSet.getString(2));
							reserva.setValor(resultSet.getLong(3));
							reserva.setFormaPago(resultSet.getInt(4));
							System.out.println("INSERT Correcto");
						}
					}
				}
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	

}
