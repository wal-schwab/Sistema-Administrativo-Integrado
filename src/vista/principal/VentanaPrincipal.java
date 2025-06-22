package vista.principal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarInicial;

public class VentanaPrincipal extends VentanaEstandarInicial{
	
	private JButton botonIniciarSesion;
	private JButton botonRegistrarse;
	
	public VentanaPrincipal() {
		super("Sistema Administrativo Integrado");
	
		panel.add(agregarLabel("resources/images/logo.png",45,80,270,270));
		panel.add(agregarLabel("Bienvenido", 115, 45,300,30,25));
		botonIniciarSesion = (agregarBoton("Iniciar Sesión", 85, 375,200,40,16,true));
		botonRegistrarse = (agregarBoton("Registrarse", 85, 420,200,40,16,true));
		panel.add(botonIniciarSesion);
		panel.add(botonRegistrarse);
				
	}
	
	public JButton getBotonIniciarSesion() {
		return botonIniciarSesion;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente,boolean estaHabilitado) {
		boton = new JButton(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.setEnabled(estaHabilitado);
		return boton;	
	}

	@Override
	public JLabel agregarLabel(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		label = new JLabel(nombre);
		label.setFont(new Font("Arial", Font.BOLD, tamanoFuente));
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}
	
	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(rutaDeImagen);
		label = new JLabel(imagen);
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado){return null;}
	
	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente){return null;}
	
}


