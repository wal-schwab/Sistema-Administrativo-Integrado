package controladorUsuario;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JButton;

import controlador.principal.ControladorPrincipal;
import modelo.dao.UsuarioDAO;
import modelo.dao.Validador;
import modelo.entidades.Usuario;
import vista.principal.VentanaPrincipal;
import vista.usuarios.VentanaRegistro;

public class ControladorRegistro {
		
	VentanaRegistro vista;
	UsuarioDAO modelo;
	Usuario usuarioIncompleto;
	
	public ControladorRegistro(VentanaRegistro vista, UsuarioDAO modelo) {
		this.modelo = modelo;
		this.vista = vista;
		
		for (Component c : vista.getPanel().getComponents()) {
			JButton boton;
		    if (c instanceof JButton && "Validar datos".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	try {
		        		String nombre = vista.getTextoNombre().getText();
			        	String apellido = vista.getTextoApellido().getText();
			        	String legajo = vista.getTextoLegajo().getText();
			        	int numLegajo = 0;
			        	boolean legajoSinUsuario = false;
			        	boolean nombreValido = Validador.validarNombre(nombre);
			        	boolean apellidoValido = Validador.validarNombre(apellido);
			        	boolean legajoValido = Validador.validarLegajo(legajo);
			        	
			        	if(legajoValido) {
			        		numLegajo = Integer.parseInt(legajo);
			        		legajoSinUsuario = modelo.comprobarLegajoSinUsuario(numLegajo);
			        		System.out.println(legajoSinUsuario);
			        	}
			        	
			        	if(nombreValido && apellidoValido && legajoValido && legajoSinUsuario) {
			        		usuarioIncompleto = new Usuario(nombre, apellido,numLegajo );
			        		vista.habilitarContrasenas();
			        	}else if(!(nombreValido && apellidoValido && legajoValido)){
			        		vista.mostrarMensajeDatosIncorrectos();
			        	}else if(!legajoSinUsuario) {
			        		vista.mostrarMensajeLegajoConUsuario();
			        	}
		        	}catch(SQLException ex) {
		        		vista.mostrarMensajeErrorBD();
		        	}
		        });
		    }
		    if (c instanceof JButton && "Registrarse".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	try {
		        		String contrasena = new String(vista.getTextoContrasena().getPassword());
			        	String contrasenaRepetida = new String(vista.getTextoRepetirContrasena().getPassword()); 
			        	if(!contrasena.equals(contrasenaRepetida)) {
			        		vista.mostrarMensajeContrasenasDistintas();
			        		return;
			        	}
			        	boolean formatoContrasenaValida = Validador.validarFormatoContrasena(contrasena);
			        	if(formatoContrasenaValida) {
			        		String nombre = usuarioIncompleto.getNombre();
			        		String apellido = usuarioIncompleto.getApellido();
			        		int legajo = usuarioIncompleto.getLegajo();
			        		Usuario usarioCreado = new Usuario(nombre, apellido, legajo, contrasena, 2);
			        		if(modelo.crearUsuario(usarioCreado)) {
			        			vista.mostrarMensajeUsuarioCreado();
			        		};
			        		
			        		vista.dispose();
			        		
			        		VentanaPrincipal vistaPrinc = new VentanaPrincipal();
				        	new ControladorPrincipal(vistaPrinc);
				        	vistaPrinc.setVisible(true);
			        	}else {
			        		vista.mostrarMensajeFormatoContrasenaIncorrecta();
			        	}
		        	}catch(SQLException ex){
		        		vista.mostrarMensajeErrorBD();
		        	}
		        });
		    }
		    if (c instanceof JButton && "Volver".equals(c.getName())) {
		        boton = (JButton) c;
		        boton.addActionListener(e -> {
		        	vista.dispose();
		        	
		        	VentanaPrincipal vistaPrinc = new VentanaPrincipal();
		        	new ControladorPrincipal(vistaPrinc);
		        	vistaPrinc.setVisible(true);
		        });
		    }
		}
		
	}
}
