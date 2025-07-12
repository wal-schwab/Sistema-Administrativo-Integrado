package controlador.proveedor;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controlador.estandar.ControladorGeneral;
import modelo.dao.ProveedorDAO;
import modelo.entidades.Proveedor;
import modelo.entidades.Usuario;
import vista.proveedor.VentanaGestionProveedor;

public class ControladorGestionProveedor extends ControladorGeneral{

	private VentanaGestionProveedor vista;
	private ProveedorDAO modelo;
	private Usuario usuario;

	public ControladorGestionProveedor(VentanaGestionProveedor vista, ProveedorDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Proveedores".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarListarProveedores();
				});	
			}
			if (c instanceof JButton && "Eliminar Proveedor".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarEliminarProveedor();
				});
			}
			if (c instanceof JButton && "Crear Proveedor".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarCrearProveedor();
				});
			}
			if (c instanceof JButton && "Modificar Proveedor".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					manejarModificarProveedor();
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

	private void manejarListarProveedores() {
		String rolUsuario = usuario.getRolUsuario().getNombreRol();
		if(rolUsuario.equals("Lectura/Escritura") || rolUsuario.equals("Administrador")	){
			vista.activarOpciones();
		}
		vista.getPanel().getFondo().setVisible(false);
		try {
			String[] nombresColumnas = {"ID","Nombre","Contacto","Correo","Actividad Principal"};
			List <Object[]> filas = new ArrayList<Object[]>();
			List <Proveedor> proveedores = modelo.listarTodos(); 
			for(Proveedor p : proveedores) {
				Object[] fila = {
						p.getIdProveedor(),
						p.getNombreProveedor(),
						p.getNombreContacto(),
						p.getEmail(),
						p.getActividadPrincipal()
				};
				filas.add(fila);
			}	
			vista.mostrarProveedoresEnTabla(nombresColumnas, filas);
		} catch (SQLException ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());   		
		}
	}

	private void manejarEliminarProveedor() {
		try {			
			String idProveedores[] = modelo.listarTodos().stream()
									.map(p -> String.valueOf(p.getIdProveedor()))
									.toArray(String[]::new);
			String idProveedor = vista.mostrarCuadroEliminacionProveedor(idProveedores);
			if(idProveedor.length() > 0) {
				Integer numIdProveedor = Integer.parseInt(idProveedor);
				boolean esExitoso = modelo.eliminar(numIdProveedor);
				if(esExitoso) {
					vista.mostrarEliminacionExitoso(String.valueOf(numIdProveedor));
				}	
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD(ex.getLocalizedMessage());
		}
	}

	private void manejarCrearProveedor() {
		try {
			List<String> datos = vista.mostrarVentanasCrearProveedor();

			if (datos.get(0) != null && datos.get(1) != null && datos.get(4) != null) {
				int id = Integer.parseInt(datos.get(0));
				Proveedor nuevoProveedor = new Proveedor(id, datos.get(1), datos.get(2), datos.get(3), datos.get(4));
				boolean creado = modelo.crear(nuevoProveedor);
				if (creado) {
					JOptionPane.showMessageDialog(vista, "¡Proveedor creado exitosamente!");
				} else {
					JOptionPane.showMessageDialog(vista, "Error al crear el proveedor.");
				}
			} else {
				JOptionPane.showMessageDialog(vista, "Operación cancelada.");
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD("Error: " + ex.getMessage());
		}
	}

	private void manejarModificarProveedor() {
		try {
			List<Proveedor> proveedores = modelo.listarTodos();
			String[] opciones = new String[proveedores.size()];
			int i = 0;
			for(Proveedor p : proveedores) {
				opciones[i] = p.getNombreProveedor();
				i++;
			}
			int indice = vista.mostrarListaDeProveedores(opciones);
			if (indice > -1) {
				List<String> nuevosDatos = vista.mostrarVentanasModificarProveedor();
				Proveedor proveedorSeleccionado = proveedores.get(indice);
				if (nuevosDatos.get(0) != null && nuevosDatos.get(3) != null) {
					proveedorSeleccionado.setNombreProveedor(nuevosDatos.get(0));
					proveedorSeleccionado.setNombreContacto(nuevosDatos.get(1));
					proveedorSeleccionado.setEmail(nuevosDatos.get(2));
					proveedorSeleccionado.setActividadPrincipal(nuevosDatos.get(3));

					boolean exito = modelo.modificar(proveedorSeleccionado);
					if (exito) {
						vista.mostrarModificacionExitoso(proveedorSeleccionado.getIdProveedor());
					}
				}
			}
		} catch (Exception ex) {
			vista.mostrarMensajeErrorBD("Error al modificar proveedor: " + ex.getMessage());
		}
	}
}
