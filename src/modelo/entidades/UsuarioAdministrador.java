package modelo.entidades;

public class UsuarioAdministrador extends Usuario {
	
	String[] logManejoUsuario;
	
	public UsuarioAdministrador(String nombre, String apellido, int legajo, String contrasena, Rol rolUsuario) {
		super(nombre, apellido, legajo, contrasena,rolUsuario);
	}
	
}
