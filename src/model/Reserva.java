package model;

import java.text.DecimalFormat;

public class Reserva {

	private Integer idReserva;
	
	private String checkin;
	
	private String checkout;
	
	private Long valor;
	
	private String valorToString;

	private Integer formaPago;
	
	public Reserva(String checkin, String checkout, Long valor, Integer formaPago) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(Integer idReserva, String checkin, String checkout, String valorToString, Integer formaPago) {
		this.idReserva= idReserva;
		this.checkin = checkin;
		this.checkout = checkout;
		this.valorToString = valorToString;
		this.formaPago = formaPago;
	}
	
	public Reserva(Integer idReserva) {
		this.idReserva=idReserva;
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
	
	public String getValorToString() {
		String pattern = "###,###,###";
	    DecimalFormat myFormatter = new DecimalFormat(pattern);
	    String output = myFormatter.format(Double.valueOf(valorToString));
	    valorToString= "$"+" "+output;
		return valorToString;
	}

	public void setValorToString(String valorToString) {
		this.valorToString = valorToString;
	}
	
}
