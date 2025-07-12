package controlador.usuarioAdministrador;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import controlador.estandar.ControladorGeneral;
import modelo.dao.RolDAO;
import modelo.dao.UsuarioAdministradorDAO;
import modelo.dao.UsuarioDAO;
import modelo.entidades.Usuario;
import vista.usuarioAministrador.VentanaGestionUsuario;

public class ControladorGestionUsuario extends ControladorGeneral {

	VentanaGestionUsuario vista;
	UsuarioAdministradorDAO modelo;
	Usuario usuario;

	public ControladorGestionUsuario(VentanaGestionUsuario vista, UsuarioAdministradorDAO modelo, Usuario usuario) {

		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Usuarios".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarListarUsuario();
				}); 	
			}
			if (c instanceof JButton && "Asignar Rol".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarAsignarRol();
				});
			}
			if (c instanceof JButton && "Eliminar Usuario".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarEliminarUsuario();
				});
			}  
			if (c instanceof JButton && "Modificar Usuario".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarModificarUsuario();
				});	
			}    
			if (c instanceof JButton && "Volver".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirVentanaAplicacion(vista, usuario);
				});
			}
			if (c instanceof JButton && "Cerrar Sesión".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirVentanaPrincipal(vista);
				});
			}
			if (c instanceof JButton && "Salir".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					salir();
				});
			}
		}
	}

	private void manejarListarUsuario() {
		vista.getPanel().getFondo().setVisible(false);
		try {
			String[] nombresColumnas = {"LEGAJO","NOMBRE","APELLIDO","CONTRASEÑA","ROL"};
			List <Object[]> filas = new ArrayList<Object[]>();
			List <Usuario> usuarios = new UsuarioDAO().listarTodos(); 
			Integer[] legajos = new Integer[usuarios.size()];
			String[] nombresRoles = new RolDAO().listarTodos().stream()
									.map(r -> r.getNombreRol())
									.toArray(String[]::new);
			int i = 0;
			for(Usuario u : usuarios) {
				Object[] fila = {
						u.getLegajo(),
						u.getNombre(),
						u.getApellido(),
						u.getContrasena(),
						u.getRolUsuario().getNombreRol()
				};
				filas.add(fila);
				legajos[i] = u.getLegajo();
				i++;
			}	
			vista.mostrarUsuariosEnTabla(nombresColumnas, filas);
			if(vista.getLegajos() == null) {
				vista.agregarComboBox(nombresRoles, legajos);				
			}

		} catch (SQLException ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());   		
		}
	}

	private void manejarAsignarRol() {
		try {
			int legajo = (int) vista.getLegajos().getSelectedItem();
			String nombreRol = (String) vista.getRoles().getSelectedItem();
			int respuesta = vista.pedirConfirmacion(legajo, nombreRol);
			if(respuesta == JOptionPane.YES_OPTION) {
				boolean esExito = modelo.asignarRol(legajo, nombreRol);
				if(esExito) {
					vista.mostrarCambioExitoso();
				}
			}
			
		}catch(SQLException ex){
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}finally {
			manejarListarUsuario();
		}
	}

	private void manejarEliminarUsuario() {
		try {
			String legajos[] = new UsuarioDAO().listarTodos().stream()
								.map(u -> String.valueOf(u.getLegajo()))
								.toArray(String[]::new);
			String legajo = vista.mostrarCuadroEliminacionUsuario(legajos);
			if(legajo.length() > 0) {
				Integer numLegajo = Integer.parseInt(legajo);
				boolean esExitoso = modelo.eliminar(numLegajo);
				if(esExitoso) {
					vista.mostrarEliminacionExitoso(legajo);
				}	
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}
	}

	private void manejarModificarUsuario() {
		
	}
}
