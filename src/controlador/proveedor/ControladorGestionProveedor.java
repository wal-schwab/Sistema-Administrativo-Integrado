package controlador.proveedor;

import controlador.estandar.ControladorGeneral;
import modelo.dao.ProveedorDAO;
import modelo.entidades.Usuario;
import vista.proveedor.VentanaGestionProveedor;

public class ControladorGestionProveedor extends ControladorGeneral{
	
	VentanaGestionProveedor vista;
	ProveedorDAO modelo;
	Usuario usuario;
	
	public ControladorGestionProveedor(VentanaGestionProveedor vista, ProveedorDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
}
