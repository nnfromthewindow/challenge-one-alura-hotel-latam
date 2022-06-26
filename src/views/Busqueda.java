package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import controller.HuespedController;
import controller.ReservaController;
import model.Huesped;
import model.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;

public class Busqueda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas; 
	private DefaultTableModel modeloHuesped;
	private DefaultTableModel modeloReserva;
	private ReservaController reservaController;
	private HuespedController huespedController;
	private int tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		
		this.huespedController = new HuespedController();
		this.reservaController = new ReservaController();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(647, 85, 158, 31);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/lupa2.png")));
		btnBuscar.setBounds(815, 75, 54, 41);
		contentPane.add(btnBuscar);
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String textInput = txtBuscar.getText();
			limpiarTablaHuesped();
			modeloHuesped.fireTableDataChanged();
			List<Huesped> resultado =huespedController.listar(textInput);
			resultado.forEach(huesped->{modeloHuesped.addRow(
	                new Object[] {
	                        huesped.getIdHuesped(),
	                        huesped.getNombre(),
	                        huesped.getApellido(),
	                        huesped.getFechaNacimiento(),
	                        huesped.getNacionalidad(),
	                        huesped.getTelefono(),
	                        huesped.getIdReserva() });});
				
			if(textInput.isEmpty()) {
				limpiarTablaHuesped();
				modeloHuesped.fireTableDataChanged();
				cargarTablaHuespedes();
				modeloHuesped.fireTableDataChanged();
			}
			}	
		});
		
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/editar-texto.png")));
		btnEditar.setBackground(SystemColor.menu);
		btnEditar.setBounds(587, 416, 54, 41);
		contentPane.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(tab) {
				case 0:	editarHuesped();
				break;
				case 1:	editarReserva();
				}
				
				
			}
			});

		JLabel lblNewLabel_4 = new JLabel("Sistema de Búsqueda");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_4.setBounds(155, 42, 258, 42);
		contentPane.add(lblNewLabel_4);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/cerrar-sesion 32-px.png")));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(815, 416, 54, 41);
		contentPane.add(btnSalir);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(10, 127, 874, 265);
		contentPane.add(panel);
		
		
		
		tbHuespedes = new JTable();
		tbHuespedes.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/persona.png")), tbHuespedes, null);
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Id");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Id Reserva");
		
		cargarTablaHuespedes();
		List<Huesped>listaInicialHuespedes=tablaInicialHuespedes();
		
		tbReservas = new JTable();
		tbReservas.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/calendario.png")), tbReservas, null);
		modeloReserva = (DefaultTableModel) tbReservas.getModel();
		modeloReserva.addColumn("Id");
		modeloReserva.addColumn("Fecha Entrada");
		modeloReserva.addColumn("Fecha Salida");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de pago");		
		cargarTablaReservas();
		List<Reserva>listaInicialReservas=tablaInicialReservas();
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/deletar.png")));
		btnEliminar.setBackground(SystemColor.menu);
		btnEliminar.setBounds(651, 416, 54, 41);
		contentPane.add(btnEliminar);
		
		//LISTENER DE TABLA CUANDO CAMBIAMOS DE PESTAÑA
		panel.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				setTab(panel.getSelectedIndex());
				System.out.println("tab: "+tab);
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				if(tab==0) {
					
					int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar al huésped?", "¿Eliminar Huésped?", JOptionPane.YES_NO_OPTION);
				
				if (reply == JOptionPane.YES_OPTION) {
					 
					eliminarHuesped();
				
				   } else {
				    JOptionPane.showMessageDialog(null, "Se cancelo la eliminación del huésped");
				   };
				}
				
				if(tab==1) {
					
					int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar la reserva?", "¿Eliminar reserva?", JOptionPane.YES_NO_OPTION);
					
					if (reply == JOptionPane.YES_OPTION) {
						
						eliminarReserva();
					
					   } else {
					    JOptionPane.showMessageDialog(null, "Se cancelo la eliminación de la reserva");
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Elimine primero al huesped para eliminar la reserva");
			}
				
			}
		});
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/cancelar.png")));
		btnCancelar.setBackground(SystemColor.menu);
		btnCancelar.setBounds(713, 416, 54, 41);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(tab==0) {
						
						int reply = JOptionPane.showConfirmDialog(null, "Está seguro que cancelar los cambios realizados en Huespedes?", "¿Cancelar cambios?", JOptionPane.YES_NO_OPTION);
						
						if (reply == JOptionPane.YES_OPTION) {
							 huespedController.borrarLista();
							 limpiarTablaHuesped();
							 huespedController.listaInicial(listaInicialHuespedes);
							 cargarTablaHuespedes();
						} 
					};
					
					if(tab==1) {
						
						int reply = JOptionPane.showConfirmDialog(null, "Está seguro que cancelar los cambios realizados en Reservas?", "¿Cancelar cambios?", JOptionPane.YES_NO_OPTION);
						
						if (reply == JOptionPane.YES_OPTION) {
							 reservaController.borrarLista();
							 limpiarTablaReserva();
							 reservaController.listaInicial(listaInicialReservas);
							 
							 cargarTablaReservas();
							// tbReservas.repaint();
							 
						} 
					}
				} catch (Exception e2) {
						// TODO: handle exception
				}
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(25, 10, 104, 107);
		contentPane.add(lblNewLabel_2);
		setResizable(false);
	}
	

	private void cargarTablaHuespedes() {
	        var huespedes = this.huespedController.listar();

	        huespedes.forEach(huesped -> modeloHuesped.addRow(
	                new Object[] {
	                        huesped.getIdHuesped(),
	                        huesped.getNombre(),
	                        huesped.getApellido(),
	                        huesped.getFechaNacimiento(),
	                        huesped.getNacionalidad(),
	                        huesped.getTelefono(),
	                        huesped.getIdReserva() }));
	    }
	 
	 private void cargarTablaReservas() {
	        var reservas = this.reservaController.listar();

	        reservas.forEach(reserva -> modeloReserva.addRow(
	                new Object[] {
	                		reserva.getIdReserva(),
	                		reserva.getCheckin(),
	                		reserva.getCheckout(),
	                		reserva.getValorToString(),
	                		reserva.getFormaPago()})
	       );
	    }
	 	
	 	
	 private List<Huesped> tablaInicialHuespedes(){
		 List<Huesped>result = new ArrayList<>();
		 result = this.huespedController.listar();
		 return result;
	 }
	 
	 private List<Reserva> tablaInicialReservas(){
		 List<Reserva>result = new ArrayList<>();
		 result = this.reservaController.listar();
		 return result;
	 }
	 
	 	private boolean sinSeleccionFilaHuesped() {
	 		return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
	    }
	 	
	 	private boolean sinSeleccionFilaReserva() {
	 		return tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
	    }
	
	    private void editarHuesped() {
	        if (sinSeleccionFilaHuesped()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elija un huesped");
	            return;
	        }

	        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    int idHuesped = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
	                    String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
	                    String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
	                    String fechaNacimiento = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3);
	                    String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
	                    String telefono = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);

	                    
	                    var filasModificadas = this.huespedController.editar(nombre, apellido, fechaNacimiento, nacionalidad,telefono,idHuesped);
	                    
	                    JOptionPane.showMessageDialog(this, String.format("%d huesped editado con éxito!", filasModificadas));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un huesped"));
	    }
	    
	    private void editarReserva() {
	        if (sinSeleccionFilaReserva()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elija una reserva");
	            return;
	        }

	        Optional.ofNullable(modeloReserva.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    int idReserva = Integer.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                    String fechaIngreso = (String) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 1);
	                    String fechaSalida = (String) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 2);
	                    String valor = (String) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 3);
	                    int formaPago = (Integer) modeloReserva.getValueAt(tbReservas.getSelectedRow(), 4);
	                    

	                    
	                    var filasModificadas = this.reservaController.editar(idReserva, fechaIngreso, fechaSalida, valor,formaPago);
	                    
	                    JOptionPane.showMessageDialog(this, String.format("%d reserva editada con éxito!", filasModificadas));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije una reserva"));
	    };

	    private void eliminarHuesped() {
	        if (sinSeleccionFilaHuesped()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un huesped");
	            return;
	        }

	        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

	                    var filasModificadas = this.huespedController.borrarHuesped(id);

	                    modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

	                    JOptionPane.showMessageDialog(this,
	                            String.format("%d huesped eliminado con éxito!", filasModificadas));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un huesped"));
	    }
	    
	    private void eliminarReserva() {
	        if (sinSeleccionFilaReserva()) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije una reserva");
	            return;
	        }

	        Optional.ofNullable(modeloReserva.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer id = Integer.valueOf(modeloReserva.getValueAt(tbReservas.getSelectedRow(), 0).toString());

	                    var filasModificadas = this.reservaController.borrarReserva(id);

	                    modeloReserva.removeRow(tbReservas.getSelectedRow());

	                    JOptionPane.showMessageDialog(this,
	                            String.format("%d reserva eliminada con éxito!", filasModificadas));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije una reserva"));
	    }
	    
	    private void limpiarTablaHuesped() {
	        modeloHuesped.getDataVector().clear();
	    }
	    
	    private void limpiarTablaReserva() {
	        modeloReserva.getDataVector().clear();
	    }
	    
		 public void setTab(int tab) {
				this.tab = tab;
			}
}
