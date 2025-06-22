package vista.estandar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public abstract class VentanaEstandarAplicacion extends JFrame{
	
	protected JPanel panel;
	protected JButton boton;
	protected JLabel label;
	
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
	
	public void mostrarMensajeErrorBD() {
		JOptionPane.showMessageDialog(null, "No hay conexión a \nla base de datos");
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public abstract JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
	
	public abstract JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
		
	public abstract JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto);
	
	public abstract JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
}
