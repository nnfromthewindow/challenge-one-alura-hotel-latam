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
	                    + " valor = ?"
	             	                 
	                    + " WHERE id = ?"
	                    );

	            try (statement) {
	            	statement.setString(1, fechaEntrada);
	                statement.setString(2, FechaSalida);
	                statement.setFloat(3, Float.parseFloat(valor.substring(2, valor.length()).replace(".", "")));
	                statement.setInt(4, idReserva);
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
	                    .prepareStatement("SELECT r.id, r.fecha_entrada, r.fecha_salida, r.valor, f.nombre FROM reservas r INNER JOIN formas_de_pago f ON r.forma_pago=f.id");
	    
	            try (statement) {
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new Reserva(
	                                resultSet.getInt("r.id"),
	                                resultSet.getString("r.fecha_entrada"),
	                                resultSet.getString("r.fecha_salida"),
	                                resultSet.getString("r.valor"),
	                                resultSet.getString("f.nombre")));
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
	            + " FROM reservas WHERE id = ? ";
	           
	            
	            final PreparedStatement statement = con.prepareStatement(
	                    sql);
	    
	            try (statement) {
	                statement.setString(1, textoABuscar);
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
	 
	 public int valorReserva(Integer valor) {
		 try {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE valor SET "
	                    + " valor = ?"
	             	                 
	                    + " WHERE id = 1");

	            try (statement) {
	            	statement.setInt(1, valor);
	                
	                statement.execute();

	                int updateCount = statement.getUpdateCount();

	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	 }
	 
	 public void cancelarReserva() {
		 try {
			 if(con.getAutoCommit()==false) {
				 con.rollback();	 
			 }
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	 
	 public void commitReserva() {
		 try {
			 if(con.getAutoCommit()==false) {
				con.commit();
			 }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	 public String getValorReserva() {
		
		 String valor= "";

		        try {
		            final PreparedStatement statement = con
		                    .prepareStatement("SELECT valor FROM valor");
		    
		            try (statement) {
		                statement.execute();
		    
		                final ResultSet resultSet = statement.getResultSet();
		    
		                try (resultSet) {
		                    while (resultSet.next()) {
		                      
		                       valor= String.valueOf(resultSet.getInt("valor")); 
		                                
		                    }
		                }
		            }
		        } catch (SQLException e) {
		            throw new RuntimeException(e);
		        }

		        return valor;
		    }
}
