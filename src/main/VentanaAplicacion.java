package main;

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
import gestionCentrosDeCosto.VentanaGestionCentroDeCosto;
import gestionGastos.VentanaGestionGasto;
import gestionInversiones.VentanaGestionInversion;
import gestionPresupuestos.VentanaGestionPresupuesto;
import gestionProveedores.VentanaGestionProveedor;
import gestionUsuarios.VentanaGestionUsuario;
import gestionUsuarios.VentanaInicioSesion;

public class VentanaAplicacion extends VentanaEstandarAplicacion implements ActionListener {
	
	String rolUsuario;
	String legajo;

	public VentanaAplicacion(String legajo, String nombreRol) {
		super("SAI - " + legajo + " ("+nombreRol+")");
		
		this.rolUsuario = nombreRol;
		this.legajo = legajo;
		
		panel.add(agregarLabel("Menu", 180, 40, 200, 50, 22));
		panel.add((nombreRol.equals("Administrador")) ? panel.add(agregarBoton("Gestión de Usuario", 80, 90, 270, 60, 16, true))  
													  :	panel.add(agregarBoton("Gestión de Usuario", 80, 90, 270, 60, 16, false))); 
		panel.add(agregarBoton("Gestión de Proveedores", 80, 155, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Centro de Costos", 80, 220, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Inversiones", 80, 285, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Gastos", 80, 350, 270, 60, 16, true));
		panel.add(agregarBoton("Gestión de Presupuestos", 80, 415, 270, 60, 16, true));
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
		if(boton.getText().equals("Gestión de Usuario")){
			new VentanaGestionUsuario(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Gestión de Proveedores")){
			new VentanaGestionProveedor(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Gestión de Centro de Costos")){
			new VentanaGestionCentroDeCosto(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Gestión de Inversiones")){
			new VentanaGestionInversion(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Gestión de Gastos")){
			new VentanaGestionGasto(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Gestión de Presupuestos")){
			new VentanaGestionPresupuesto(legajo, rolUsuario).setVisible(true);
			dispose();
		}else if(boton.getText().equals("Cerrar Sesión")){
			new VentanaInicioSesion().setVisible(true);
			this.dispose();
		}else if(boton.getText().equals("Salir")) {
			this.dispose();
		}	
	}

	@Override
	public JTextField agregarTextField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JPasswordField agregarPasswordField(String nombre, int ubicacionX, int ubicacionY, int ancho, int alto, int tamanoFuente) {return null;}

	@Override
	public JLabel agregarLabelImagen(String rutaDeImagen, int ubicacionX, int ubicacionY, int ancho, int alto) {return null;}

	@Override
	public JButton agregarBotonImagen(String nombre, ImageIcon imagen, int ubicacionX, int ubicacionY, int ancho,
			int alto, int tamanoFuente, boolean visible) {return null;}
}
