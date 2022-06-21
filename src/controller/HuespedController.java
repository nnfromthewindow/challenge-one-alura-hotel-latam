package controller;

import dao.HuespedDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Huesped;
import model.Reserva;

public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.abrirConexion());
	};

	public void agregarHuesped(Huesped huesped) {
		huespedDao.agregarHuesped(huesped);
		System.out.println("Huesped Insertado en Id:"+huesped.getIdReserva());
	}
}
