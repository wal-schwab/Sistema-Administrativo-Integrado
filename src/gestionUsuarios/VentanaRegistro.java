package gestionUsuarios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import VentanasPorDefecto.VentanaEstandarInicial;
import main.VentanaPrincipal;

public class VentanaRegistro extends VentanaEstandarInicial implements ActionListener{
	
	private JTextField textoNombre, textoApellido, textoLegajo;
	private JButton validarDatos, botonRegistrase, botonVolver;
	private JPasswordField textoContrasena, textoRepetirContrasena;
	private int numLegajo;
	private String nombre, apellido, contrasena;
	
	public VentanaRegistro() {
		super("SAI - Registrarse");
		
		panel.add(agregarLabel("Registrarse", 120, 10, 250, 30, 25));
		panel.add(agregarLabel("Ingrese sus datos", 10, 50, 250, 30, 17));
		panel.add(agregarLabel("Nombre:", 10, 90, 80, 30, 15));
		textoNombre = agregarTextField("", 90, 90, 200, 30, 15);
		panel.add(textoNombre);
		panel.add(agregarLabel("Apellido:", 10, 130, 80, 30, 15));
		textoApellido = agregarTextField("", 90, 130, 200, 30, 15);
		panel.add(textoApellido);
		panel.add(agregarLabel("Legajo:", 10, 170, 80, 30, 15));
		textoLegajo = agregarTextField("", 90, 170, 200, 30, 15);
		panel.add(textoLegajo);
		validarDatos = agregarBoton("Validar datos", 90, 215, 200, 40, 16);
		panel.add(validarDatos);
		panel.add(agregarLabel("Contraseña", 145, 275, 150, 30, 15));
		textoContrasena = agregarPasswordField("", 90, 305, 200, 30, 15);
		textoContrasena.setEnabled(false);
		panel.add(textoContrasena);
		panel.add(agregarLabel("Repetir Contraseña", 125, 350, 150, 30, 15));
		textoRepetirContrasena = agregarPasswordField("", 90, 380, 200, 30, 15);
		textoRepetirContrasena.setEnabled(false);
		panel.add(textoRepetirContrasena);
		botonRegistrase = agregarBoton("Registrarse", 190, 440, 160, 40, 16);
		botonRegistrase.setEnabled(false);
		panel.add(botonRegistrase);
		botonVolver = agregarBoton("Volver", 20, 440, 160, 40, 16);
		panel.add(botonVolver);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == validarDatos) {
			numLegajo = ControladorRegistro.validarLegajo(textoLegajo.getText());
			nombre = ControladorRegistro.validarNombreOApellido(textoNombre.getText());
			apellido = ControladorRegistro.validarNombreOApellido(textoApellido.getText());
			if(numLegajo > 0 && nombre.length() > 0 && apellido.length() > 0 ) {
				textoLegajo.setEnabled(false);
				textoNombre.setEnabled(false);
				textoApellido.setEnabled(false);
				textoContrasena.setEnabled(true);
				textoContrasena.setBackground(new Color(255,255,255));
				textoRepetirContrasena.setEnabled(true);
				textoRepetirContrasena.setBackground(new Color(255,255,255));
				botonRegistrase.setEnabled(true);
				validarDatos.setEnabled(false);
			}
		}else if(e.getSource() == botonRegistrase) {
			contrasena = ControladorRegistro.validarContrasena(textoContrasena.getPassword(), textoRepetirContrasena.getPassword());
			if(contrasena.length() > 0) {
				ControladorRegistro.crearUsuario(nombre, apellido, numLegajo, contrasena);
				new VentanaPrincipal().setVisible(true);
				dispose();
			}
		}else if(e.getSource() == botonVolver) {
			new VentanaPrincipal().setVisible(true);
			dispose();	
		}
	}
	
	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		boton = new JButton(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.addActionListener(this);
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
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente) {
		campoContrasena = new JPasswordField();
		campoContrasena.setBounds(ubicacionX,ubicacionY,ancho,alto);
		campoContrasena.setBackground(new Color(255,255,255));
		campoContrasena.setFont(new Font("Andale Mono", 1, tamanoFuente));
		campoContrasena.setForeground(new Color(0,0,0));
		return campoContrasena;
	}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}

}
