package controller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
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
}