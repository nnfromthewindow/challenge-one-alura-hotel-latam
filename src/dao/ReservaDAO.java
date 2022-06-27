package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Huesped;
import model.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	
	public void agregarReserva(Reserva reserva) {
		try {
			con.setAutoCommit(false);
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
				        con.commit();
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	 public int borrarReserva(Integer id) {
	        try {
	        	con.setAutoCommit(false);
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM reservas WHERE ID = ?");

	            try (statement) {
	                statement.setInt(1, id);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();

	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public int editar(Integer idReserva, String fechaEntrada, String FechaSalida,String valor, Integer formaPago) {
	        try {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE reservas SET "
	                    + " fecha_entrada = ?, "
	                    + " fecha_salida = ?,"
	                    + " valor = ?,"
	                    + " forma_pago = ?"
	             	                 
	                    + " WHERE id = ?");

	            try (statement) {
	            	statement.setString(1, fechaEntrada);
	                statement.setString(2, FechaSalida);
	                statement.setFloat(3, Float.parseFloat(valor.substring(2, valor.length()).replace(".", "")));
	                statement.setInt(4, formaPago);
	                statement.setInt(5, idReserva);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();

	                return updateCount;
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
	                                resultSet.getString("valor"),
	                                resultSet.getInt("forma_pago")));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }
	 
	 public List<Reserva> listar(String textoABuscar) {
	        List<Reserva> resultado = new ArrayList<>();

	        try {
	            String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago"
	            + " FROM reservas WHERE id = ? OR ? >= fecha_entrada AND ? <= fecha_salida";
	           
	            
	            final PreparedStatement statement = con.prepareStatement(
	                    sql);
	    
	            try (statement) {
	                statement.setString(1, textoABuscar);
	                statement.setString(2, textoABuscar);
	                statement.setString(3, textoABuscar);
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        
							resultado.add(new Reserva(
	                                resultSet.getInt("id"),
	                                resultSet.getString("fecha_entrada"),
	                                resultSet.getString("fecha_salida"),
	                                resultSet.getString("valor"),
	                                resultSet.getInt("forma_pago")
	                               ));
	                    }
	                }
	            }
	        } catch (SQLException e ) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }
	 
	 public void cancelarReserva() {
		 try {
			 if(con.getAutoCommit()==false) {
				 con.rollback();	 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void commitReserva() {
		 try {
			 if(con.getAutoCommit()==false) {
				con.commit();
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
