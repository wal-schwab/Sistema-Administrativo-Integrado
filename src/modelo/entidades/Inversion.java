package modelo.entidades;

public class Inversion {
	
	private int numeroID;
	private Proveedor proveedor;
	private Subleager subleager;
	private String detalle;
	private double importe;
	
	public Inversion(int numeroID, Proveedor proveedor, Subleager subleager, String detalle, double importe) {
		this.proveedor = proveedor;
		this.subleager = subleager;
		this.detalle = detalle;
		this.importe = importe;
	}
	
	public int getNumeroID() {
		return numeroID;
	}

	public void setNumeroID(int numeroID) {
		this.numeroID = numeroID;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Subleager getSubleager() {
		return subleager;
	}

	public void setSubleager(Subleager subleager) {
		this.subleager = subleager;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	

	
	
}
