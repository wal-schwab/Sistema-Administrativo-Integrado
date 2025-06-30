package controlador.usuario;

import java.sql.SQLException;

import controlador.estandar.ControladorGeneral;
import controlador.principal.ControladorAplicacion;
import controlador.principal.ControladorPrincipal;
import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;
import vista.principal.VentanaAplicacion;
import vista.principal.VentanaPrincipal;
import vista.usuarios.VentanaInicioSesion;

public class ControladorInicioSesion extends ControladorGeneral {
	
	private VentanaInicioSesion vista;
	private UsuarioDAO modelo;
	
	public ControladorInicioSesion(VentanaInicioSesion vista, UsuarioDAO modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		vista.getBotonIngresar().addActionListener(e -> {
			try {
				String legajo = vista.getTextoLegajo().getText();
				String contrasena = new String(vista.getTextoContrasena().getPassword());
				boolean legajoValido = Validador.validarLegajo(legajo);
				Usuario usuario = null;
				if(legajoValido) {
					usuario = modelo.obtenerUsuario(legajo, contrasena);
				}else{	
					vista.mostrarMensajeLegajoInvalido();
					return;
				}
				if(usuario == null){
					vista.mostrarMensajeErrorAutenticacion();
					return;
				}else if(usuario.getRolUsuario().getIdRol() == 2){
					vista.mostrarMensajeUsuarioSinRol();
					return;
				}else {
					abrirVentanaAplicacion(vista, usuario);
				}
				
			}catch (SQLException ex) {
				vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
			}
		});
		
		vista.getBotonVolver().addActionListener(e -> {
			vista.dispose();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
			new ControladorPrincipal(ventanaPrincipal);
			ventanaPrincipal.setVisible(true);
		});
	}
}
