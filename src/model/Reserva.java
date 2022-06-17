package model;

public class Reserva {

	private Integer idReserva;
	
	private String checkin;
	
	private String checkout;
	
	private Integer valor;
	
	private Integer formaPago;
	
	public Reserva(String checkin, String checkout, Integer valor, Integer formaPago) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	
}
