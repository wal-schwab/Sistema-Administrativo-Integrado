package controlador.presupuesto;

import java.awt.Component;

import javax.swing.JButton;

import controlador.estandar.ControladorGeneral;
import modelo.dao.PresupuestoDAO;
import modelo.entidades.Usuario;
import vista.presupuesto.VentanaGestionPresupuesto;

public class ControladorGestionPresupuesto extends ControladorGeneral{

	VentanaGestionPresupuesto vista;
	PresupuestoDAO modelo;
	Usuario usuario;
	
	public ControladorGestionPresupuesto(VentanaGestionPresupuesto vista, PresupuestoDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
		

		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
			if (c instanceof JButton && "Nuevo Presupuesto".equals(c.getName())) {
				 boton = (JButton) c;
			     boton.addActionListener(e -> {
			    	 
			     });
			}
			if (c instanceof JButton && "Consultar Presupuesto".equals(c.getName())) {
				 boton = (JButton) c;
				 boton.addActionListener(e -> {
			        	
				 });
			}	 
			if (c instanceof JButton && "Confirmar Presupuesto".equals(c.getName())) {
				boton = (JButton) c;
				boton.addActionListener(e -> {
				        	
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
