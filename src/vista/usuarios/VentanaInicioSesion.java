package vista.usuarios;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vista.estandar.VentanaEstandarInicial;

public class VentanaInicioSesion extends VentanaEstandarInicial{
	
	private JPasswordField textoContrasena;
	private JTextField textoLegajo;
	
	public VentanaInicioSesion(){
		super("SAI - Iniciar Sesión");

		panel.add(agregarLabel("Inicio Sesión",95,50,180,50,25));
		panel.add(agregarLabel("resources/images/icon.png", 100, 65, 130, 130));
		panel.add(agregarLabel("Legajo", 140, 175,100,30,15));
		textoLegajo = agregarTextField("textoLegajo", 45, 210,255,30,15);
		panel.add(textoLegajo);
		panel.add(agregarLabel("Contraseña", 125, 260,100,30,15));
		textoContrasena = agregarPasswordField("textoContrasena", 45, 300,255,30,15,true);	
		panel.add(textoContrasena);
		panel.add(agregarBoton("Ingresar",75,385,200,40,16,true));
		panel.add(agregarBoton("Volver",75,430,200,40,16,true));
		
	}
	
	public JPasswordField getTextoContrasena() {
		return textoContrasena;
	}

	public JTextField getTextoLegajo() {
		return textoLegajo;
	}
	
	public void mostrarMensajeErrorAutenticacion() {
		JOptionPane.showMessageDialog(null,"Legajo o contraseña incorrecta");
	}
	
	public void mostrarMensajeLegajoInvalido() {
		JOptionPane.showMessageDialog(null, "Legajo Inválido");
	}
	
	public void mostrarMensajeUsuarioSinRol() {
		JOptionPane.showMessageDialog(null, "El Usuario no tiene \nun rol asignado");
	}
	
	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado) {
		boton = new JButton(nombre);
		boton.setName(nombre);
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
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		campoTexto = new JTextField();
		campoTexto.setBounds(ubicacionX,ubicacionY,ancho,alto);
		campoTexto.setBackground(new Color(255,255,255));
		campoTexto.setFont(new Font("Andale Mono", 1, tamanoFuente));
		campoTexto.setForeground(new Color(0,0,0));
		return campoTexto;
	}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente, boolean estaHabilitado) {
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(ubicacionX,ubicacionY,ancho,alto);
		campoContrasena.setBackground(new Color(255,255,255));
		campoContrasena.setFont(new Font("Andale Mono", 1, tamanoFuente));
		campoContrasena.setForeground(new Color(0,0,0));
		campoContrasena.setEnabled(estaHabilitado);
		return campoContrasena;
	}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(rutaDeImagen);
		label = new JLabel(imagen);
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}

}
