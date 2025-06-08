package main;

import gestionUsuarios.VentanaInicioSesion;
import gestionUsuarios.VentanaRegistro;
import javax.swing.*;

import VentanasPorDefecto.VentanaEstandarInicial;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends VentanaEstandarInicial implements ActionListener {
	
	public VentanaPrincipal() {
		super("Sistema Administrativo Integrado");
		
		
		
		panel.add(agregarLabel("resources/images/logo.png",45,80,270,270));
		panel.add(agregarLabel("Bienvenido", 115, 45,300,30,25));
		panel.add(agregarBoton("Iniciar Sesión", 85, 375,200,40,16));
		panel.add(agregarBoton("Registrarse", 85, 420,200,40,16));
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton =(JButton)e.getSource();
		if(boton.getText().equals("Iniciar Sesión")) {
			this.setVisible(false);
			VentanaInicioSesion inicioSesión = new VentanaInicioSesion();
			inicioSesión.setVisible(true);
		}else if(boton.getText().equals("Registrarse")) {
			this.setVisible(false);
			VentanaRegistro registro = new VentanaRegistro();
			registro.setVisible(true);
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
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente){return null;}
	
	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY,int ancho, int alto, int tamanoFuente){return null;}

	@Override
	public JLabel agregarLabel(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {
		ImageIcon imagen = new ImageIcon(rutaDeImagen);
		label = new JLabel(imagen);
		label.setBounds(ubicacionX,ubicacionY ,ancho ,alto);
		label.setForeground(new Color(255,255,255));
		return label;
	}
}


