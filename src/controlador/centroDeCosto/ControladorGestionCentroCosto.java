package controlador.centroDeCosto;

import java.awt.Component;

import javax.swing.JButton;

import controlador.estandar.ControladorGeneral;
import modelo.dao.CentroDeCostoDAO;
import modelo.entidades.Usuario;
import vista.centroDeCosto.VentanaGestionCentroDeCosto;

public class ControladorGestionCentroCosto extends ControladorGeneral {
	
	CentroDeCostoDAO modelo;
	VentanaGestionCentroDeCosto vista;
	Usuario usuario;

	public ControladorGestionCentroCosto(VentanaGestionCentroDeCosto vista, CentroDeCostoDAO modelo ,Usuario usuario) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.usuario = usuario;
		
		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Listar Centros de Costos".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
					if(usuario.getRolUsuario().getNombreRol().equals("Lectura/Escritura")||
					   usuario.getRolUsuario().getNombreRol().equals("Administrador")){
						
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
