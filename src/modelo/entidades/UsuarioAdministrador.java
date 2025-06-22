package modelo.entidades;

public class UsuarioAdministrador extends Usuario {
	
	public UsuarioAdministrador(String nombre, String apellido, int legajo, String contrasena) {
		super(nombre, apellido, legajo, contrasena,1);
	}
	
}
