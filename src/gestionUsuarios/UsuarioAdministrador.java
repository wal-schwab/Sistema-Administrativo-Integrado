package gestionUsuarios;

import java.util.ArrayList;

public class UsuarioAdministrador extends Usuario {
	
	ArrayList<String> logEventoUsuario = new ArrayList<String>();
	
	public UsuarioAdministrador(String nombre, String apellido, int legajo, String contrasena) {
		super(nombre, apellido, legajo, contrasena);
		this.setRolUsuario(new Rol());
	}

	public ArrayList<String> getLog() {
		return logEventoUsuario;
	}

	public void guardarEvento(String evento) {
		logEventoUsuario.add(evento);
	}
	
}
