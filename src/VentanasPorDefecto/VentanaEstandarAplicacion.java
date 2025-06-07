package VentanasPorDefecto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gestionUsuarios.VentanaInicioSesion;

public abstract class VentanaEstandarAplicacion extends JFrame{
	
	protected JPanel panel;
	protected JButton boton;
	protected JLabel label;
	
	public VentanaEstandarAplicacion(String titulo) {
		setTitle(titulo);
		ImageIcon logo = new ImageIcon("images/logo.png");
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
	
	public abstract JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
	
	public abstract JButton agregarBotonImagen(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean visible);
		
	public abstract JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JLabel agregarLabelImagen(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto);
	
	public abstract JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
	
	public abstract JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente);
}
