package controlador.principal;

import java.awt.Component;

import javax.swing.JButton;

import modelo.entidades.Usuario;
import vista.principal.VentanaAplicacion;

public class ControladorAplicacion {
	
	private VentanaAplicacion vista;
	private Usuario usuario;

	public ControladorAplicacion(VentanaAplicacion vista, Usuario usuario) {
		this.vista = vista;
		this.usuario = usuario;
		
		
		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
		    if (c instanceof JButton && "Gestión de Usuario".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	
		        });
		    }
		}

		
		
	}

}
