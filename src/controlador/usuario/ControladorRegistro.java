package controlador.usuario;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JButton;

import controlador.estandar.ControladorGeneral;

import modelo.dao.UsuarioDAO;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import modelo.util.Validador;

import vista.usuarios.VentanaRegistro;

public class ControladorRegistro extends ControladorGeneral {

	VentanaRegistro vista;
	UsuarioDAO modelo;
	Usuario usuarioIncompleto;

	public ControladorRegistro(VentanaRegistro vista, UsuarioDAO modelo) {
		this.modelo = modelo;
		this.vista = vista;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Validar datos".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarValidarDatos();
				});
			}
			if (c instanceof JButton && "Registrarse".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarRegistrarse();
				});
			}
			if (c instanceof JButton && "Volver".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirVentanaPrincipal(vista);
				});
			}
		}	
	}

	private void manejarValidarDatos() {
		try {
			String nombre = vista.getTextoNombre().getText();
			String apellido = vista.getTextoApellido().getText();
			String legajo = vista.getTextoLegajo().getText();
			int numLegajo = 0;
			boolean legajoSinUsuario = false;
			boolean nombreValido = Validador.validarNombre(nombre);
			boolean apellidoValido = Validador.validarNombre(apellido);
			boolean legajoValido = Validador.validarLegajo(legajo);

			if(legajoValido) {
				numLegajo = Integer.parseInt(legajo);
				legajoSinUsuario = modelo.comprobarLegajoSinUsuario(numLegajo);
			}

			if(nombreValido && apellidoValido && legajoValido && legajoSinUsuario) {
				usuarioIncompleto = new Usuario(nombre, apellido,numLegajo );
				vista.habilitarContrasenas();
			}else if(!(nombreValido && apellidoValido && legajoValido)){
				vista.mostrarMensajeDatosIncorrectos();
			}else if(!legajoSinUsuario) {
				vista.mostrarMensajeLegajoConUsuario();
			}
		}catch(SQLException ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}
	}

	private void manejarRegistrarse() {
		try {
			String contrasena = new String(vista.getTextoContrasena().getPassword());
			String contrasenaRepetida = new String(vista.getTextoRepetirContrasena().getPassword()); 
			if(!contrasena.equals(contrasenaRepetida)) {
				vista.mostrarMensajeContrasenasDistintas();
				return;
			}
			boolean formatoContrasenaValida = Validador.validarFormatoContrasena(contrasena);
			if(formatoContrasenaValida) {
				String nombre = usuarioIncompleto.getNombre();
				String apellido = usuarioIncompleto.getApellido();
				int legajo = usuarioIncompleto.getLegajo();
				Rol usuarioSinRol = modelo.obtenerRolUsuario(2);
				Usuario usarioCreado = new Usuario(nombre, apellido, legajo, contrasena, usuarioSinRol);
				if(modelo.crear(usarioCreado)) {
					vista.mostrarMensajeUsuarioCreado();
				};
				abrirVentanaPrincipal(vista);
			}else {
				vista.mostrarMensajeFormatoContrasenaIncorrecta();
			}
		}catch(SQLException ex){
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}
	}
}
