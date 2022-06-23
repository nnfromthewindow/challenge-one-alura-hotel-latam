package controller;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;


public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.abrirConexion());
	};

	public void agregarHuesped(Huesped huesped) {
		huespedDao.agregarHuesped(huesped);
	}
	
	public Integer borrarHuesped(Integer id) {
		return huespedDao.borrarReserva(id);
	}
	
}
