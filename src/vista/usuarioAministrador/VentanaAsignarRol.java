package vista.usuarioAministrador;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarAplicacion;

public class VentanaAsignarRol extends VentanaEstandarAplicacion{
	
	public VentanaAsignarRol(String nombreVentana,String nombreUsuario,String apellidoUsuario, String nombreRol) {
		super(nombreVentana, nombreUsuario, apellidoUsuario, nombreRol);

		panel.add(agregarBoton("Volver", new ImageIcon("resources/images/imageBack.png"), 10, 10, 60, 40, 0, true));
	}

	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(visible);
		return boton;
	}

	@Override
	public JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho, int alto,int tamanoFuente, boolean visible) {
		boton = new JButton(nombre,imagen);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(visible);
		return boton;
		
	}

	@Override
	public JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto,
			int tamanoFuente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto,
			int tamanoFuente) {
		// TODO Auto-generated method stub
		return null;
	}
}
