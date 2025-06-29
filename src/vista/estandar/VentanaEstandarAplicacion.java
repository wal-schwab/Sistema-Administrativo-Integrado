package vista.estandar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public abstract class VentanaEstandarAplicacion extends JFrame{
	
	protected PanelConFondoEA panel;
	protected JButton boton;
	protected JLabel label;
	protected JDialog formularioModificacion;
	
	public VentanaEstandarAplicacion(String nombrePantalla, String nombreUsuario, String apellidoUsuario, String nombreRol) {
		setTitle("SAI: "+ nombrePantalla +" - "+ nombreUsuario +" "+ apellidoUsuario +" - "+ nombreRol);
		ImageIcon logo = new ImageIcon("resources/images/Icon.png");
		setIconImage(logo.getImage());
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla-anchoPantalla/3, alturaPantalla-alturaPantalla/3);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		panel = new PanelConFondoEA();
		add(panel);
	}
	
	public PanelConFondoEA getPanel() {
		return panel;
	}

	public void mostrarMensajeErrorBD(String detalleExcepcion) {
		JOptionPane.showMessageDialog(null, "No hay conexión a la base de datos \n" + detalleExcepcion);
	}
	
	protected void activarOpciones() {
		for (Component c : panel.getComponents()) {
			JButton boton = null;
			if (c instanceof JButton) {
				boton = (JButton) c;
				boton.setEnabled(true);
			}
		}
	}
	
	protected JScrollPane mostrarEnTabla(String[] nombresColumnas, List <Object[]> filas, int x, int y, int ancho, int alto) {
		DefaultTableModel tablaModelo = new DefaultTableModel();
		for (int i = 0; i < nombresColumnas.length; i++) {
			tablaModelo.addColumn(nombresColumnas[i]);
		}
		for(Object[] fila : filas) {
			tablaModelo.addRow(fila);
		}
		JTable tablaDatos = new JTable();
		tablaDatos.setModel(tablaModelo);
		tablaDatos.setBounds(x, y, ancho, alto);
		JScrollPane scrollTabla = new JScrollPane(tablaDatos);
		scrollTabla.setBounds(x, y, ancho, alto);
		
		return scrollTabla;
	}
	
	protected abstract JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
	
	protected abstract JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
		
	protected abstract JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	protected abstract JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto);
	
	protected abstract JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	protected abstract JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
}
