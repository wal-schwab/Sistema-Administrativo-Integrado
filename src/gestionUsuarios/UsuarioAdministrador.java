package gestionUsuarios;

public class UsuarioAdministrador extends Usuario {
	
	protected UsuarioAdministrador(String nombre, String apellido, int legajo,String contrasena) {
		super(nombre, apellido, legajo, contrasena);
		this.setRolUsuario(new Rol());
	}
	
}
