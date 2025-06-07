package gestionUsuarios;

public class Rol {
	
	private String[] roles = {"Administrador", "Lectura/Escritura", "Solo lectura"};
	private String nombreRol;
	
	protected Rol() {
		nombreRol = roles[0];
	}
	
	protected Rol(int rol) {
		nombreRol = roles[rol];
	}
	
	protected String[] getRoles() {
		return roles;
	}
	
	protected String getNombreRol() {
		return nombreRol;
	}
}
