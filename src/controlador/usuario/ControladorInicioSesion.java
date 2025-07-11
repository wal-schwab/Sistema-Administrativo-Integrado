package controlador.usuario;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JButton;

import controlador.estandar.ControladorGeneral;
import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;
import modelo.util.Validador;
import vista.usuarios.VentanaInicioSesion;

public class ControladorInicioSesion extends ControladorGeneral {

	private VentanaInicioSesion vista;
	private UsuarioDAO modelo;

	public ControladorInicioSesion(VentanaInicioSesion vista, UsuarioDAO modelo) {
		this.vista = vista;
		this.modelo = modelo;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Ingresar".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e ->{
					manejarIngresar();
				});
			}
			if (c instanceof JButton && "Volver".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e ->{
					abrirVentanaPrincipal(vista);
				});
			}
		}
	}

	private void manejarIngresar() {
		try {
			String legajo = vista.getTextoLegajo().getText();
			String contrasena = new String(vista.getTextoContrasena().getPassword());
			boolean legajoValido = Validador.validarLegajo(legajo);
			Usuario usuario = null;
			if(legajoValido) {
				Integer numLegajo = Integer.parseInt(legajo);
				usuario = modelo.buscar(numLegajo);
			}else{	
				vista.mostrarMensajeLegajoInvalido();
				return;
			}
			if(usuario == null || !usuario.getContrasena().equals(contrasena)){
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
	}
}

