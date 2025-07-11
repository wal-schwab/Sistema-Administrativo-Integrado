package vista.principal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarAplicacion;

public class VentanaAplicacion extends VentanaEstandarAplicacion{
	
	public VentanaAplicacion(String nombreUsuario,String apellidoUsuario, String nombreRol) {
		super("Inicio", nombreUsuario, apellidoUsuario, nombreRol);
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		panel.add(agregarBoton("Gestión de Usuario", 80, 90, 270, 60, 16, false));											  
		panel.add(agregarBoton("Gestión de Proveedores", 80, 155, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Centro de Costos", 80, 220, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Gastos", 80, 285, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Presupuestos", 80, 350, 270, 60, 16, true));
		panel.add(agregarBoton("Cerrar Sesión", 80, 520, 270, 60, 16, true));
		panel.add(agregarBoton("Salir", 80, 585, 270, 60, 16, true));	
	}
		
	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre);
		boton.setName(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(visible);
		return boton;
	}
		
	@Override
	public JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {
		label = new JLabel(nombre);
		label.setFont(new Font("Arial", Font.BOLD, tamanoFuente));
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;	
	}
	
	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}

	@Override
	public JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho,
			int alto, int tamanoFuente, boolean visible) {return null;}
}
