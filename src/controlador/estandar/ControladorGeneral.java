package controlador.estandar;

import javax.swing.JFrame;

import controlador.centroDeCosto.ControladorGestionCentroCosto;
import controlador.gasto.ControladorGestionGasto;
import controlador.presupuesto.ControladorGestionPresupuesto;
import controlador.principal.ControladorAplicacion;
import controlador.principal.ControladorPrincipal;
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
import vista.principal.VentanaPrincipal;
import vista.proveedor.VentanaGestionProveedor;
import vista.usuarioAministrador.VentanaGestionUsuario;

public class ControladorGeneral {
	
	public void abrirVentanaPrincipal(JFrame vista) {
		vista.dispose();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
    	new ControladorPrincipal(ventanaPrincipal);
    	ventanaPrincipal.setVisible(true);
	}
	
	public void abrirVentanaAplicacion(JFrame vista, Usuario usuario) {
		vista.dispose();
		VentanaAplicacion ventanaAplicacion = new VentanaAplicacion(usuario.getNombre(),usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
		new ControladorAplicacion(ventanaAplicacion, usuario);
		ventanaAplicacion.setVisible(true);
	}
	
	public void abrirGestioUsuario(JFrame vista,Usuario usuario) {
		vista.dispose();
    	UsuarioAdministradorDAO modeloAdministrador = new UsuarioAdministradorDAO();
		VentanaGestionUsuario ventanaGestionUsuario = new VentanaGestionUsuario(usuario.getNombre(), usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
		new ControladorGestionUsuario(ventanaGestionUsuario, modeloAdministrador, usuario);
		ventanaGestionUsuario.setVisible(true);
	};
	
	public void abrirGestionProveedores(JFrame vista,Usuario usuario) {
		vista.dispose();
    	ProveedorDAO modeloProveedor = new ProveedorDAO();
		VentanaGestionProveedor ventanaGestionProveedor = new VentanaGestionProveedor(usuario.getNombre(), usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
		new ControladorGestionProveedor(ventanaGestionProveedor, modeloProveedor, usuario);
		ventanaGestionProveedor.setVisible(true);
	}
	
	public void abrirGestionCentroCosto(JFrame vista,Usuario usuario) {
		vista.dispose();
    	CentroDeCostoDAO modeloCentroCosto = new CentroDeCostoDAO();
    	VentanaGestionCentroDeCosto ventanaCentroCosto = new VentanaGestionCentroDeCosto(usuario.getNombre(), usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
    	new ControladorGestionCentroCosto(ventanaCentroCosto, modeloCentroCosto, usuario);
    	ventanaCentroCosto.setVisible(true);
	}
	
	public void abrirGestionGastos(JFrame vista,Usuario usuario) {
		vista.dispose();
    	GastoDAO modeloGastos = new GastoDAO();
    	VentanaGestionGasto ventanaGestionGasto = new VentanaGestionGasto(usuario.getNombre(), usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
    	new ControladorGestionGasto(ventanaGestionGasto, modeloGastos, usuario); 
    	ventanaGestionGasto.setVisible(true);
	}
	
	public void abrirGestionPresupuesto(JFrame vista, Usuario usuario) {
		vista.dispose();
    	PresupuestoDAO modeloPresupuesto = new PresupuestoDAO();
    	VentanaGestionPresupuesto ventanaGestionPresupuesto = new VentanaGestionPresupuesto(usuario.getNombre(), usuario.getApellido(),usuario.getRolUsuario().getNombreRol());
    	new ControladorGestionPresupuesto(ventanaGestionPresupuesto, modeloPresupuesto, usuario);
    	ventanaGestionPresupuesto.setVisible(true);
	};

	public void salir() {
		System.exit(0);
	}
	
}
