package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	
	public void agregarReserva(Reserva reserva) {
		try {
			
			PreparedStatement statement;
				statement = con.prepareStatement("INSERT INTO reservas(fecha_entrada, fecha_salida, valor, forma_pago)"+"VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
				try(statement) {
					statement.setString(1, reserva.getCheckin());
					statement.setString(2, reserva.getCheckout());
					statement.setLong(3, reserva.getValor());
					statement.setInt(4, reserva.getFormaPago());
					int affectedRows = statement.executeUpdate();
					 if (affectedRows == 0) {
				            throw new SQLException("Fallo el registro, intente de nuevo");
				        }

				        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				            if (generatedKeys.next()) {
				                reserva.setIdReserva(generatedKeys.getInt(1));
				            }
				            else {
				                throw new SQLException("Fallo el registro, intente de nuevo");
				            }
					System.out.println("insertado con exito!!!");
				        }
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	 public List<Reserva> listar() {
	        List<Reserva> resultado = new ArrayList<>();

	        try {
	            final PreparedStatement statement = con
	                    .prepareStatement("SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas");
	    
	            try (statement) {
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new Reserva(
	                                resultSet.getInt("id"),
	                                resultSet.getString("fecha_entrada"),
	                                resultSet.getString("fecha_salida"),
	                                resultSet.getString("valorToString"),
	                                resultSet.getInt("forma_pago")));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }

}
