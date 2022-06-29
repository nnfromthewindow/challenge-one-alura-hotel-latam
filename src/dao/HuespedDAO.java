package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Huesped;

public class HuespedDAO {

private Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void agregarHuesped(Huesped huesped) {
		try {
			
			PreparedStatement statement;
				statement = con.prepareStatement("INSERT INTO huespedes(nombre,apellido,fecha_de_nacimiento,nacionalidad,telefono,id_reserva)"+"VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
					 try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				            if (generatedKeys.next()) {
				                huesped.setIdHuesped(generatedKeys.getInt(1));
				            }
				            else {
				                throw new SQLException("Fallo el registro, intente de nuevo");
				            }
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	 public int borrarHuesped(Integer id) {
	        try {
	        	con.setAutoCommit(false);
	            final PreparedStatement statement = con.prepareStatement("DELETE FROM huespedes WHERE ID = ?");

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

	 public int editar(String nombre, String apellido,String fechaNacimiento, String nacionalidad, String telefono, Integer idHuesped) {
	        try {
	            final PreparedStatement statement = con.prepareStatement(
	                    "UPDATE huespedes SET "
	                    + " nombre = ?, "
	                    + " apellido = ?,"
	                    + " fecha_de_nacimiento = ?,"
	                    + " nacionalidad = ?,"
	                    + " telefono = ?"
	                 
	                    + " WHERE id = ?");

	            try (statement) {
	                statement.setString(1, nombre);
	                statement.setString(2, apellido);
	                statement.setString(3, fechaNacimiento);
	                statement.setString(4, nacionalidad);
	                statement.setString(5, telefono);
	                statement.setInt(6, idHuesped);
	                statement.execute();

	                int updateCount = statement.getUpdateCount();

	                return updateCount;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public List<Huesped> listar() {
	        List<Huesped> resultado = new ArrayList<>();

	        try {
	            final PreparedStatement statement = con
	                    .prepareStatement("SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes");
	    
	            try (statement) {
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new Huesped(
	                                resultSet.getInt("id"),
	                                resultSet.getString("nombre"),
	                                resultSet.getString("apellido"),
	                                resultSet.getString("fecha_de_nacimiento"),
	                                resultSet.getString("nacionalidad"),
	                                resultSet.getString("telefono"),
	                                resultSet.getInt("id_reserva")));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }
	 
	 
	 public List<Huesped> listar(String textoABuscar) {
	        List<Huesped> resultado = new ArrayList<>();

	        try {
	            String sql = "SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva "
	            + " FROM huespedes WHERE apellido LIKE '%" + textoABuscar + "%' OR id_reserva = ?";
	           
	            
	            final PreparedStatement statement = con.prepareStatement(
	                    sql);
	    
	            try (statement) {
	                statement.setString(1, textoABuscar);
	               
	                statement.execute();
	    
	                final ResultSet resultSet = statement.getResultSet();
	    
	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new Huesped(
	                                resultSet.getInt("id"),
	                                resultSet.getString("nombre"),
	                                resultSet.getString("apellido"),
	                                resultSet.getString("fecha_de_nacimiento"),
	                                resultSet.getString("nacionalidad"),
	                                resultSet.getString("telefono"),
	                                resultSet.getInt("id_reserva")));
	                    }
	                }
	            }
	        } catch (SQLException e ) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
	    }
	 
	 public void resetAutoIncrement() {
		 try {
	            final PreparedStatement statement = con.prepareStatement("ALTER TABLE huespedes AUTO_INCREMENT=1;");
	            try (statement) {	                
	                statement.execute();
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	 }
	 
	 public void cancelarHuesped() {
		 try {
			 if(con.getAutoCommit()==false) {
			con.rollback();
			 }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }
	 public void commitHuesped() {
		 try {
			 if(con.getAutoCommit()==false) {
				con.commit();
			 }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	 }

}
