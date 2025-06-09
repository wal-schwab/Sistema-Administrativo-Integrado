package gestionUsuarios;

import java.util.ArrayList;

public class UsuarioAdministrador extends Usuario {
	
	private ArrayList<String> eventosUsuarios = new ArrayList<String>();
	
	public UsuarioAdministrador(String nombre, String apellido, int legajo, String contrasena) {
		super(nombre, apellido, legajo, contrasena);
		this.setRolUsuario(new Rol());
	}

	public ArrayList<String> obtenerEventosUsuarios() {
		return eventosUsuarios;
	}

	public void guardarEvento(String evento) {
		eventosUsuarios.add(evento);
	}
	
}
