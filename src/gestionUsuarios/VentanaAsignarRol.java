package gestionUsuarios;

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
import main.VentanaAplicacion;

public class VentanaAsignarRol extends VentanaEstandarAplicacion implements ActionListener {
	
	String nombreRol;
	String legajo;

	public VentanaAsignarRol(String legajo, String nombreRol) {
		super("Gestión de Usuarios: Asignar Rol - " + legajo + " ("+nombreRol+")");
		
		this.nombreRol = nombreRol;
		this.legajo = legajo;
		
		panel.add(agregarBoton("Volver", new ImageIcon("resources/images/imageBack.png"), 10, 10, 60, 40, 0, true));
		
		panel.add(agregarBoton("Crear Usuario",  80, 90, 270, 60, 16, true));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton =(JButton)e.getSource();
		if(boton.getText().equals("Volver")){
			new VentanaGestionUsuario(legajo, nombreRol).setVisible(true);
			dispose();	
		}
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
	public JButton agregarBoton(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho, int alto,int tamanoFuente, boolean visible) {
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
