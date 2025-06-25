package modelo.entidades;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private int legajo;
	private String contrasena;
	private Rol rolUsuario;
	
	public Usuario(String nombre, String apellido, int legajo, String contrasena, Rol rolUsuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.contrasena = contrasena;
		this.rolUsuario = rolUsuario;
	}
	
	public Usuario(String nombre, String apellido, int legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Rol getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(Rol rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	
}
