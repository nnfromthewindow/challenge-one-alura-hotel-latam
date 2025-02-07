package views;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import controller.ReservaController;
import model.Reserva;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;



public class Reservas extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private ReservaController reservaController;
	private int valorDia ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas frame = new Reservas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Reservas() {
		
		this.reservaController = new ReservaController();
		
		valorDia = Integer.valueOf(reservaController.getValorReserva()) ;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reservas.class.getResource("/imagenes/calendario.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 540);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245,245,245));
		panel.setBounds(0, 0, 900, 502);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Check In");
		lblNewLabel_1.setBounds(88, 142, 133, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
	
		JDateChooser txtFechaE = new JDateChooser();
		txtFechaE.setBounds(88, 166, 235, 33);
		panel.add(txtFechaE);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Check Out");
		lblNewLabel_1_1.setBounds(88, 210, 133, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		JDateChooser txtFechaS = new JDateChooser();
		txtFechaS.setBounds(88, 234, 235, 33);
		txtFechaS.getCalendarButton().setBackground(Color.WHITE);
		panel.add(txtFechaS);
		
		txtValor = new JTextField();
		txtValor.setBounds(88, 303, 235, 33);
		txtValor.setEditable(false);
		panel.add(txtValor);
		txtValor.setColumns(10);
		txtValor.setForeground(new Color(0,0,255));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Valor de la Reserva");
		lblNewLabel_1_1_1.setBounds(88, 278, 133, 14);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1);
		
		JComboBox txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(88, 373, 235, 33);
		txtFormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Forma de pago");
		lblNewLabel_1_1_1_1.setBounds(88, 347, 133, 24);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sistema de Reservas");
		lblNewLabel_4.setBounds(108, 93, 199, 42);
		lblNewLabel_4.setForeground(new Color(65, 105, 225));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_4);
		
		//CREAMOS VARIABLE DATE PARA TENER REFERENCIA A LA FECHA DE HOY
		Date hoy = new Date();
		
		//SETEAMOS LA FECHA MINIMA DE ENTRADA PARA BLOQUEAR FECHAS ANTERIORES A HOY
		txtFechaE.getJCalendar().setMinSelectableDate(hoy);
		
		//CREAMOS LISTENERS EN AMBOS CALENDARIOS PARA QUE CUANDO HAYA UN CAMBIO DE FECHA CALCULE AUTOMATICAMENTE EL PRECIO TOTAL
		txtFechaE.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						try {
							Date hoy = new Date(); 
							Date mañana = txtFechaE.getDate();
							Calendar c = Calendar.getInstance();
						    c.setTime(mañana);
						    c.add(Calendar.DATE, 1);
						    mañana = c.getTime();
							txtFechaE.getJCalendar().setMinSelectableDate(hoy);
							txtFechaS.getJCalendar().setMinSelectableDate(mañana);
							
							if("date".equals(e.getPropertyName())) {
						
								    Date firstDate = txtFechaE.getDate();
								    Date secondDate = txtFechaS.getDate();
								    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
								    long cantidadDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
								    String valor = Long.toString(cantidadDias*valorDia);
								    String pattern = "###,###,###";
								    double value = Double.valueOf(valor);
								    DecimalFormat myFormatter = new DecimalFormat(pattern);
								    String output = myFormatter.format(value);
								    txtValor.setText("$"+" "+output);
								  	    
							}
						} catch (Exception e2) {
						
						}
					
					}
				}
				);
		
		txtFechaS.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						try {
							
							Date mañana = txtFechaE.getDate();
							Calendar c = Calendar.getInstance();
						    c.setTime(mañana);
						    c.add(Calendar.DATE, 1);
						    mañana = c.getTime();
							txtFechaE.getJCalendar().setMinSelectableDate(hoy);
							txtFechaS.getJCalendar().setMinSelectableDate(mañana);
							if("date".equals(e.getPropertyName())) {
						
								Date firstDate = txtFechaE.getDate();
							    Date secondDate = txtFechaS.getDate();
							    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
							    long cantidadDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
							    String valor = Long.toString(cantidadDias*valorDia);
							    String pattern = "###,###,###";
							    double value = Double.valueOf(valor);
							    DecimalFormat myFormatter = new DecimalFormat(pattern);
							    String output = myFormatter.format(value);
							    txtValor.setText("$"+" "+output);
		
								
							}  
						} catch (Exception e2) {
					
						}
					}
				}
				);
		
		
		
		JButton btnReservar = new JButton("Continuar");
	
		//FUNCION BOTON RESERVAR CON SUS RESPECTIVAS VALIDACIONES
		
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			    try {
			    	var diaE = txtFechaE.getDate().getDate();
					var mesE = txtFechaE.getDate().getMonth()+1; 
					var anioE = txtFechaE.getDate().getYear()+1900;
					var diaS = txtFechaS.getDate().getDate();
					var mesS = txtFechaS.getDate().getMonth()+1; 
					var anioS = txtFechaS.getDate().getYear()+1900;
					String fechaEntrada = anioE+"-"+mesE+"-"+diaE;
					String fechaSalida = anioS+"-"+mesS+"-"+diaS;
					var valorEstadia = txtValor.getText();
					Date firstDate = txtFechaE.getDate();
				    Date secondDate = txtFechaS.getDate();
				    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
				    long cantidadDias = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				    long valorEstadiaParsed = cantidadDias*valorDia;
				    
			    	if(cantidadDias<1) {
				    	JOptionPane.showMessageDialog(null, "Debe ingresar fechas de check in y check out validas");
				    	return;
				    }
					if(txtFechaS.getDate().compareTo(txtFechaE.getDate()) > 0 && fechaEntrada!=fechaSalida) {
						
						int formaPago = 0;
						switch(txtFormaPago.getSelectedIndex()) {
						case 0 : formaPago=1;
						break;
						case 1 : formaPago=2;
						break;
						case 2 : formaPago=3;
						}

						var reserva = new Reserva(fechaEntrada,fechaSalida,valorEstadiaParsed,formaPago);

						reservaController.reservar(reserva);

						RegistroHuesped huesped = new RegistroHuesped(reserva.getIdReserva());
						huesped.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Debe ingresar fechas de check in y check out validas");
					}
				
				} catch (Exception e2) {
					throw new RuntimeException(e2);
				}
			}
		});
		btnReservar.setForeground(Color.WHITE);
		btnReservar.setBounds(220, 436, 140, 33);
		btnReservar.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/calendario.png")));
		btnReservar.setBackground(new Color(65,105,225));
		btnReservar.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(btnReservar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBounds(40, 436, 140, 33);
		btnVolver.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/calendario.png")));
		btnVolver.setBackground(new Color(65,105,225));
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(399, 0, 491, 502);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(""); 
		lblNewLabel.setBounds(0, -16, 500, 539);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/reservas-img-2.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(15, 6, 104, 107);
		panel.add(lblNewLabel_2);
	}
	

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
