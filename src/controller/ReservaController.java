package controller;

import dao.HuespedDAO;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;
import views.RegistroHuesped;

public class ReservaController {
	
	private ReservaDAO reservaDao;
	//private HuespedDAO huespedDao;
	private int idReserva;
	private RegistroHuesped reg;
	
	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.abrirConexion());
		//this.huespedDao = new HuespedDAO(factory.abrirConexion());
	};
	
	public void reservar(Reserva reserva) {
		reservaDao.agregarReserva(reserva);
		this.idReserva=reserva.getIdReserva();
		int id = reserva.getIdReserva();
		//Reserva res = new Reserva(id);
		//this.reg.setIdReserva(50);
		System.out.println(id);
		//this.reg.setIdReserva(id);
		
		//System.out.println(idReserva);
		//this.resgistroHuesped.setIdReserva(reserva.getIdReserva());
	
		
	}
	
	public int getIdReserva() {
		return this.idReserva;
	}
}