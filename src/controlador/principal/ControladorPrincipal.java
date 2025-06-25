package controlador.principal;

import controlador.usuario.ControladorInicioSesion;
import controlador.usuario.ControladorRegistro;
import modelo.dao.UsuarioDAO;
import vista.principal.VentanaPrincipal;
import vista.usuarios.VentanaInicioSesion;
import vista.usuarios.VentanaRegistro;

public class ControladorPrincipal {
	
	VentanaPrincipal vista;

	public ControladorPrincipal(VentanaPrincipal vista) {
		
		this.vista = vista;
		
		vista.getBotonIniciarSesion().addActionListener(e -> {
			vista.dispose();
			
			VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion();
			UsuarioDAO modeloUsuario = new UsuarioDAO();
			new ControladorInicioSesion(ventanaInicioSesion, modeloUsuario);
			ventanaInicioSesion.setVisible(true);
		});
		
		vista.getBotonRegistrarse().addActionListener(e -> {
			vista.dispose();
			
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			UsuarioDAO modeloUsuario = new UsuarioDAO();
			new ControladorRegistro(ventanaRegistro, modeloUsuario);
			ventanaRegistro.setVisible(true);
		});
		
	}

}
