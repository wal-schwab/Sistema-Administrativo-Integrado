package controlador.principal;

import controladorUsuario.ControladorInicioSesion;
import controladorUsuario.ControladorRegistro;
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
			UsuarioDAO moduloUsuario = new UsuarioDAO();
			new ControladorInicioSesion(ventanaInicioSesion, moduloUsuario);
			ventanaInicioSesion.setVisible(true);
		});
		
		vista.getBotonRegistrarse().addActionListener(e -> {
			vista.dispose();
			
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			UsuarioDAO moduloUsuario = new UsuarioDAO();
			new ControladorRegistro(ventanaRegistro, moduloUsuario);
			ventanaRegistro.setVisible(true);
		});
		
	}

}
