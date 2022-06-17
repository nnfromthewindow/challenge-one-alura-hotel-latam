package test;

import java.sql.Connection;
import java.sql.SQLException;
import factory.ConnectionFactory;

public class ConnectionTest {

	 public static void main(String[] args) throws SQLException {
	        ConnectionFactory factory = new ConnectionFactory();
	        Connection con = factory.abrirConexion();

	        System.out.println("Cerrando la conexión");

	        con.close();
	    }


}
