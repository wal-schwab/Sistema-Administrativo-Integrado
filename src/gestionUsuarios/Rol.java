package gestionUsuarios;

public class Rol {
	
	private final String rolAdministrador = "Administrador";
	private String[] roles = {"Lectura/Escritura", "Solo lectura"};
	private String nombreRol;
	
	protected Rol() {
		nombreRol = rolAdministrador;
	}
	
	protected Rol(int rol) {
		nombreRol = roles[rol];
	}
	
	public String[] getRoles() {
		return roles;
	}
	
	public String getNombreRol() {
		return nombreRol;
	}
	
	public static String getDescripcion(String rol) {
		String descripcion = "";
		if(rol.equals("Solo lectura")) {
			descripcion = "Solo podrá consultar listados de datos";
		}else if (rol.equals("Lectura/Escritura")){
			descripcion = "Podrá crear, modificar, eliminar y listar cualquier datos que no corresponda a un usuario";
		}else if (rol.equals("Administrador")){
			descripcion = "Permite utilizar todas la funcionalidades de la aplicación";
		}else {
			descripcion = "Rol de usuario inexistente";
		}
		return descripcion;
	}
}
