package controlador.proveedor;

import java.awt.Component;

import javax.swing.JButton;

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

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Proveedores".equals(c.getName())){
				boton = (JButton) c;
				boton.addActionListener(e -> {
					if(usuario.getRolUsuario().getNombreRol().equals("Lectura/Escritura") ||
					   usuario.getRolUsuario().getNombreRol().equals("Administrador")	){
						
							vista.usuarioLecturaEscritura();
					}
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
