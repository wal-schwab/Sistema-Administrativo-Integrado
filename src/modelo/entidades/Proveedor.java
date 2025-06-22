package modelo.entidades;

public class Proveedor {
	
	private int numeroID;
	private String nombre;
	private String detalle;
	
	public Proveedor(int numeroIdentificacion, String nombre, String actividaPrincipal) {
		this.numeroID = numeroIdentificacion;
		this.nombre = nombre;
		this.detalle = actividaPrincipal;
	}

	public int getNumeroIdentificacion() {
		return numeroID;
	}

	public void setNumeroIdentificacion(int numeroID) {
		this.numeroID = numeroID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}
