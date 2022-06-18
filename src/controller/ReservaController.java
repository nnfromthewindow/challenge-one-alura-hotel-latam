package controller;

import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import dao.ReservaDAO;

public class ReservaController {
	
	private ReservaDAO reservaDao;
	
	
	
	public int calcularReserva(JDateChooser txtFechaE, JDateChooser txtFechaS) {
		
		int resultado = 0;
		var estadia = txtFechaS.getDate().getDate()-txtFechaE.getDate().getDate();
		var valor = 7500;
		if(!txtFechaE.isValid() && !txtFechaS.isValid() && txtFechaS.getDate().getDate() > txtFechaE.getDate().getDate() ) {

			return estadia*valor;
		}
		JOptionPane.showMessageDialog(null, "Debe ingresar fechas de check in y check out validas");
		
		return 0;	
	}
	

}