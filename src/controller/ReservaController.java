package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Huesped;
import model.Reserva;

public class ReservaController {
	
	private ReservaDAO reservaDao;
	private int idReserva;
	
	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.abrirConexion());
	};
	
	public void reservar(Reserva reserva) {
		reservaDao.agregarReserva(reserva);
		this.idReserva=reserva.getIdReserva();
		
	}

	public int getIdReserva(Reserva reserva) {
		return this.idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public List<Reserva> listar() {
	    return reservaDao.listar();
	}
	
	public Integer borrarReserva(Integer id) {
		return reservaDao.borrarReserva(id);
	}
	
	 
	public List<Reserva> listaInicial(List<Reserva> lista) {
		lista.forEach(reserva -> {
			reservar(reserva);
		});
	    return lista;
	}
	
	public List<Reserva> borrarLista() {
		var lista = reservaDao.listar();
		lista.forEach(reserva -> {
			borrarReserva(reserva.getIdReserva());
		});
	    return lista;
	}
	
	public int editar(String fechaEntrada, String FechaSalida,String valor, String formaPago) {
        return reservaDao.editar(fechaEntrada, FechaSalida, valor, formaPago);
    }
	
	public List<Reserva> listar(String textoABuscar) {
        return reservaDao.listar(textoABuscar);
    }
}