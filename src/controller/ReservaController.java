package controller;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaController {
	
	private ReservaDAO reservaDao;
	
	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.abrirConexion());
	};
	
	public void reservar(Reserva reserva) {
		reservaDao.agregarReserva(reserva);
		
	}
}