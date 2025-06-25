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

public abstract class VentanaEstandarInicial extends JFrame {
	
	protected JButton boton;
	protected JPasswordField campoContrasena;
	protected JLabel label;
	protected JTextField campoTexto;
	protected JPanel panel;
	
	public VentanaEstandarInicial(String titulo) {
		setTitle(titulo);
		ImageIcon logo = new ImageIcon("resources/images/Icon.png");
		setIconImage(logo.getImage());
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla/5, alturaPantalla/2);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.panel = new PanelConFondoEI();
		add(panel);
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void mostrarMensajeErrorBD(String detalleExcepcion) {
		JOptionPane.showMessageDialog(null, "Conflicto con la base de datos \n" + detalleExcepcion);
	}

	public abstract JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado);
	
	public abstract JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY,int ancho, int alto);
	
	public abstract JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado);
	
}
