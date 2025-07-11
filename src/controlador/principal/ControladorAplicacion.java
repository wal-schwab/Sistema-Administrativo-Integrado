package controlador.principal;

import java.awt.Component;

import javax.swing.JButton;

import controlador.centroDeCosto.ControladorGestionCentroCosto;
import controlador.estandar.ControladorGeneral;
import controlador.gasto.ControladorGestionGasto;
import controlador.presupuesto.ControladorGestionPresupuesto;
import controlador.proveedor.ControladorGestionProveedor;
import controlador.usuarioAdministrador.ControladorGestionUsuario;
import modelo.dao.CentroDeCostoDAO;
import modelo.dao.GastoDAO;
import modelo.dao.PresupuestoDAO;
import modelo.dao.ProveedorDAO;
import modelo.dao.UsuarioAdministradorDAO;
import modelo.entidades.Usuario;
import vista.centroDeCosto.VentanaGestionCentroDeCosto;
import vista.gasto.VentanaGestionGasto;
import vista.presupuesto.VentanaGestionPresupuesto;
import vista.principal.VentanaAplicacion;
import vista.proveedor.VentanaGestionProveedor;
import vista.usuarioAministrador.VentanaGestionUsuario;

public class ControladorAplicacion extends ControladorGeneral {

	private VentanaAplicacion vista;
	private Usuario usuario;

	public ControladorAplicacion(VentanaAplicacion vista, Usuario usuario) {
		this.vista = vista;
		this.usuario = usuario;

		String rolUsuario = usuario.getRolUsuario().getNombreRol();
		if(rolUsuario.equals("Lectura/Escritura") || rolUsuario.equals("Administrador")	){
			vista.activarOpciones();
		}

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;

			if (c instanceof JButton && "Gestión de Usuario".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirGestioUsuario(vista,usuario);
				});
			}
			if (c instanceof JButton && "Gestión de Proveedores".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirGestionProveedores(vista, usuario);
				});
			}
			if (c instanceof JButton && "Gestión de Centro de Costos".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirGestionCentroCosto(vista, usuario);

				});
			}
			if (c instanceof JButton && "Gestión de Gastos".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirGestionGastos(vista, usuario);
				});
			}
			if (c instanceof JButton && "Gestión de Presupuestos".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					abrirGestionPresupuesto(vista, usuario);
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

}
