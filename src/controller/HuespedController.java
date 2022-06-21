package controller;

import dao.HuespedDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.abrirConexion());
	};

	public int setIdReserva(Reserva reserva) {
		return reserva.getIdReserva();
	}
}
