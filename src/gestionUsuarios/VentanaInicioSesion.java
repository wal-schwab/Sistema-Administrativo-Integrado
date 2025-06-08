package gestionUsuarios;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import VentanasPorDefecto.VentanaEstandarInicial;
import main.VentanaPrincipal;
import main.VentanaAplicacion;

public class VentanaInicioSesion extends VentanaEstandarInicial implements ActionListener{
	
	private JPasswordField textoContrasena;
	private JTextField textoLegajo;
	
	public VentanaInicioSesion() {
		super("SAI - Iniciar Sesión");

		panel.add(agregarLabel("Inicio Sesión",95,50,180,50,25));
		panel.add(agregarLabel("resources/images/icon.png", 100, 65, 130, 130));
		panel.add(agregarLabel("Legajo", 140, 175,100,30,15));
		textoLegajo = agregarTextField("textoLegajo", 45, 210,255,30,15);
		panel.add(textoLegajo);
		panel.add(agregarLabel("Contraseña", 125, 260,100,30,15));
		textoContrasena = agregarPasswordField("textoContrasena", 45, 300,255,30,15);	
		panel.add(textoContrasena);
		panel.add(agregarBoton("Ingresar",75,385,200,40,16));
		panel.add(agregarBoton("Volver",75,430,200,40,16));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton =(JButton)e.getSource();
		if(boton.getText().equals("Ingresar")) {
			boolean usuarioValido = ControladorInicioSesion.validarIngreso(textoLegajo.getText(), textoContrasena.getPassword());
			if(usuarioValido) {
				String nombreRol = ControladorInicioSesion.pedirRol(textoLegajo.getText());
					if(nombreRol.length() > 0){
						VentanaAplicacion ventanaUsuario = new VentanaAplicacion(textoLegajo.getText(),nombreRol);
						this.setVisible(false);
						ventanaUsuario.setVisible(true);
				}
			}
		}else if(boton.getText().equals("Volver")) {
			this.setVisible(false);
			VentanaPrincipal principal = new VentanaPrincipal();
			principal.setVisible(true);
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
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(rutaDeImagen);
		label = new JLabel(imagen);
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}

}
