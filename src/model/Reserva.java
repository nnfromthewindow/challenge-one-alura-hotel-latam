package model;

public class Reserva {

	private Integer idReserva;
	
	private String checkin;
	
	private String checkout;
	
	private Long valor;
	
	private Integer formaPago;
	
	public Reserva(String checkin, String checkout, Long valor, Integer formaPago) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Integer getIdReserva() {
		return idReserva;
	}

	public String getCheckin() {
		return checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public Long getValor() {
		return valor;
	}

	public Integer getFormaPago() {
		return formaPago;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public void setFormaPago(Integer formaPago) {
		this.formaPago = formaPago;
	}

	
}
