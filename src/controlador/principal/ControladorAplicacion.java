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
		
    	if(usuario.getRolUsuario().getIdRol() != 1) {
    		vista.deshabilitarGestionUsuario();
    	}
		
		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			String nombreUsuario = usuario.getNombre();
			String apellidoUsuario = usuario.getApellido();
			String nombreRol = usuario.getRolUsuario().getNombreRol();
			
		    if (c instanceof JButton && "Gestión de Usuario".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	UsuarioAdministradorDAO modeloAdministrador = new UsuarioAdministradorDAO();
					VentanaGestionUsuario ventanaGestionUsuario = new VentanaGestionUsuario(c.getName(), nombreUsuario, apellidoUsuario,nombreRol);
					new ControladorGestionUsuario(ventanaGestionUsuario, modeloAdministrador, usuario);
					ventanaGestionUsuario.setVisible(true);
		        });
		    }
		    if (c instanceof JButton && "Gestión de Proveedores".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	ProveedorDAO modeloProveedor = new ProveedorDAO();
					VentanaGestionProveedor ventanaGestionProveedor = new VentanaGestionProveedor(c.getName(), nombreUsuario, apellidoUsuario,nombreRol);
					new ControladorGestionProveedor(ventanaGestionProveedor, modeloProveedor, usuario);
					ventanaGestionProveedor.setVisible(true);
		        });
		    }
		    if (c instanceof JButton && "Gestión de Centro de Costos".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	CentroDeCostoDAO modeloCentroCosto = new CentroDeCostoDAO();
		        	VentanaGestionCentroDeCosto ventanaCentroCosto = new VentanaGestionCentroDeCosto(c.getName(), nombreUsuario, apellidoUsuario, nombreRol);
		        	new ControladorGestionCentroCosto(ventanaCentroCosto, modeloCentroCosto, usuario);
		        	ventanaCentroCosto.setVisible(true);
		        });
		    }
		    if (c instanceof JButton && "Gestión de Gastos".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	GastoDAO modeloGastos = new GastoDAO();
		        	VentanaGestionGasto ventanaGestionGasto = new VentanaGestionGasto(c.getName(), nombreUsuario, apellidoUsuario, nombreRol);
		        	new ControladorGestionGasto(ventanaGestionGasto, modeloGastos, usuario); 
		        	ventanaGestionGasto.setVisible(true);
		        });
		    }
		    if (c instanceof JButton && "Gestión de Presupuestos".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	PresupuestoDAO modeloPresupuesto = new PresupuestoDAO();
		        	VentanaGestionPresupuesto ventanaGestionPresupuesto = new VentanaGestionPresupuesto(c.getName(), nombreUsuario, apellidoUsuario, nombreRol);
		        	new ControladorGestionPresupuesto(ventanaGestionPresupuesto, modeloPresupuesto, usuario);
		        	ventanaGestionPresupuesto.setVisible(true);
		        });
		    }
		    if (c instanceof JButton && "Cerrar Sesión".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	cerrarSesion(vista);
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
