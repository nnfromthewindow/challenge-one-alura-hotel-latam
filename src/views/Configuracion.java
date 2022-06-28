package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.HuespedController;
import controller.ReservaController;

public class Configuracion extends JDialog {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	
	private ReservaController reservaController;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Configuracion dialog = new Configuracion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Configuracion() {
		
		this.reservaController = new ReservaController();
	
			setIconImage(Toolkit.getDefaultToolkit().getImage(Configuracion.class.getResource("/imagenes/aH-40px.png")));
			setBounds(100, 250, 394, 226);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBackground(SystemColor.control);
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			setLocationRelativeTo(null);
			contentPanel.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Configuracion.class.getResource("/imagenes/Ha-100px.png")));
			lblNewLabel.setBounds(10, 11, 100, 100);
			contentPanel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Valor diario de estadia:");
			lblNewLabel_1.setForeground(new Color (18, 176, 23));
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
			lblNewLabel_1.setBounds(140, 22, 322, 21);
			contentPanel.add(lblNewLabel_1);
			
			String valorReserva = reservaController.getValorReserva();
			String pattern = "###,###,###";
		    DecimalFormat myFormatter = new DecimalFormat(pattern);
		    String output = myFormatter.format(Integer.valueOf(valorReserva));
		  
			
			JLabel valorActual = new JLabel("$ "+output);
			valorActual.setForeground(new Color (12, 138, 199));
			valorActual.setFont(new Font("Arial", Font.BOLD, 18));
			valorActual.setBounds(200, 50, 322, 21);
			contentPanel.add(valorActual);
			
			JLabel ingrese_valor = new JLabel("Ingrese un valor nuevo:");
			ingrese_valor.setForeground(new Color (18, 176, 23));
			ingrese_valor.setFont(new Font("Arial", Font.BOLD, 18));
			ingrese_valor.setBounds(138, 80, 322, 21);
			contentPanel.add(ingrese_valor);
	
			JTextField valorNuevo = new JTextField();
			valorNuevo.setColumns(10);
			valorNuevo.setBounds(160, 110, 180, 35);
			valorNuevo.setFont(new Font("Arial", Font.PLAIN, 18));
			contentPanel.add(valorNuevo);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton okButton = new JButton("Guardar");
			
			okButton.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
						
					reservaController.valorReserva(Integer.valueOf(valorNuevo.getText()));
					JOptionPane.showMessageDialog(null, "Valor modificado con exito!!");
					valorActual.setText("$ "+formatearValor(reservaController.getValorReserva()));
					valorNuevo.setText("");

					}
				});
			
			okButton.setActionCommand("Guardar");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
			
			JButton cancelButton = new JButton("Salir");
			cancelButton.setActionCommand("Salir");
			buttonPane.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
			
				@Override
					public void actionPerformed(ActionEvent e) {
									
						MenuUsuario menu = new MenuUsuario();
						menu.setVisible(true);
						dispose();
					}
					
				});
			}
			
			public String formatearValor(String valor) {
				String pattern = "###,###,###";
			    DecimalFormat myFormatter = new DecimalFormat(pattern);
			    String output = myFormatter.format(Float.valueOf(valor));	
			    return output;
			}
			
		
	}




