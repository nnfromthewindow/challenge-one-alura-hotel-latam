package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HuespedController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Exito extends JDialog {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private HuespedController huespedController;
	
	private static int idReserva;
	
	private static int idHuesped;
	
	public static int getIdHuesped() {
		return idHuesped;
	}


	public static void setIdHuesped(int idHuesped) {
		Exito.idHuesped = idHuesped;
	}


	public static int getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(int idReserva) {
		Exito.idReserva = idReserva;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Exito dialog = new Exito(idHuesped,idReserva);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Exito(int idHuesped,int idReservaHuesped) {
		
		//CREAMOS LA CONECCION A LA CONECTION FACTORY
		this.huespedController = new HuespedController();
		
		//SETEAMOS EL ID DE LA RESERVA
		setIdReserva(idReserva);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel.setBounds(123, 11, 100, 100);
		contentPanel.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
		lblNewLabel_1.setForeground(new Color (12, 138, 199));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(27, 122, 322, 21);
		contentPanel.add(lblNewLabel_1);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		JButton okButton = new JButton("OK");
		
		//FUNCION DEL BOTON OK VUELVE AL MENU USUARIO
		
		okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();//sirve para cerrar la ventana actual
						MenuUsuario usuario = new MenuUsuario(); 
						usuario.setVisible(true);
					}
				});
				
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
				
		//FUNCION CANCELAR, ELIMINA AL HUESPED Y VUELVE AL REGISTRO DE HUESPED PARA REGISTRARLO DE MANERA CORRECTA 
		
		cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						
						huespedController.borrarHuesped(idHuesped);
						JOptionPane.showMessageDialog(null, "Huesped eliminado, intente ingresarlo nuevamente");
						RegistroHuesped huesped = new RegistroHuesped(idReservaHuesped);
						huesped.setVisible(true);
						dispose();
					}
					
				});
					
	}

}
