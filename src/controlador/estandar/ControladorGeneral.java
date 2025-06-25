package controlador.estandar;

import javax.swing.JFrame;

import controlador.principal.ControladorAplicacion;
import controlador.principal.ControladorPrincipal;
import modelo.entidades.Usuario;
import vista.principal.VentanaAplicacion;
import vista.principal.VentanaPrincipal;

public class ControladorGeneral {
	
	public void abrirVentanaAplicacion(JFrame vista, Usuario usuario) {
		vista.dispose();
		VentanaAplicacion ventanaAplicacion = new VentanaAplicacion(usuario.getNombre(),usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
		new ControladorAplicacion(ventanaAplicacion, usuario);
		ventanaAplicacion.setVisible(true);
	}

	public void salir() {
		System.exit(0);
	}
	
	public void cerrarSesion(JFrame vista) {
		vista.dispose();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		new ControladorPrincipal(ventanaPrincipal);
		ventanaPrincipal.setVisible(true);
    }
	
	

}
