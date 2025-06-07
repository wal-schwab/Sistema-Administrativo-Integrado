package gestionInversiones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import VentanasPorDefecto.VentanaEstandarAplicacion;
import gestionUsuarios.VentanaInicioSesion;
import main.VentanaAplicacion;

public class VentanaGestionInversion extends VentanaEstandarAplicacion implements ActionListener {
	
	String rolUsuario;
	String legajo;
	JButton volver;

	public VentanaGestionInversion(String legajo, String nombreRol) {
		super("Gestión de Inversiones - " + legajo + " ("+nombreRol+")");
		
		this.rolUsuario = nombreRol;
		this.legajo = legajo;
		
	
		panel.add(agregarBotonImagen("Volver", new ImageIcon("images/imageBack.png"), 10, 10, 60, 40, 0, true));
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		if(nombreRol.equals("Solo lectura")){
			panel.add(agregarBoton("Crear Inversion",  80, 90, 270, 60, 16, false));
			panel.add(agregarBoton("Modificar Inversion", 80, 155, 270, 60, 16, false));
			panel.add(agregarBoton("Eliminar Inversion", 80, 220, 270, 60, 16, false));
		}else {
			panel.add(agregarBoton("Crear Inversion", 80, 90, 270, 60, 16, true));
			panel.add(agregarBoton("Modificar Inversion", 80, 155, 270, 60, 16, true));
			panel.add(agregarBoton("Eliminar Inversion", 80, 220, 270, 60, 16, true));
		}
		panel.add(agregarBoton("Listar Inversiones", 80, 285, 270, 60, 16, true));
		panel.add(agregarBoton("Cerrar Sesión", 80, 520, 270, 60, 16, true));
		panel.add(agregarBoton("Salir", 80, 585, 270, 60, 16, true));	
	}
	
	@Override
	public JButton agregarBoton(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.addActionListener(this);
		boton.setEnabled(visible);
		return boton;
	}
	
	@Override
	public JButton agregarBotonImagen(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho,int alto, int tamanoFuente, boolean visible) {
		boton = new JButton(nombre,imagen);
		boton.setBounds(ubicacionX,ubicacionY,ancho,alto);
		boton.setBackground(new Color(220, 220, 220));
		boton.setFont(new Font("Arial", 1, tamanoFuente));
		boton.setForeground(new Color(0,0,0));
		boton.addActionListener(this);
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
	public void actionPerformed(ActionEvent e) {
		JButton boton =(JButton)e.getSource();
		if(boton.getText().equals("Cerrar Sesión")) {
			new VentanaInicioSesion().setVisible(true);
			this.dispose();
		}else if(boton.getText().equals("Salir")) {
			this.dispose();
		}else if(boton.getText().equals("Volver")){
			new VentanaAplicacion(legajo, rolUsuario).setVisible(true);
			dispose();
		}
	}

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JLabel agregarLabelImagen(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}
}

