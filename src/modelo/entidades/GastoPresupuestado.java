package modelo.entidades;

public class GastoPresupuestado extends Gasto {
	
	private int idPresupuesto;

	public GastoPresupuestado(int numeroID, Proveedor proveedor, CentroDeCosto centroDeCosto, String detalle,double importe, int idPresupuesto) {
		super(numeroID, proveedor, centroDeCosto, detalle, importe);
		this.idPresupuesto = idPresupuesto;
	}

	public int getIdPresupuesto() {
		return idPresupuesto;
	}

	public void setIdPresupuesto(int idPresupuesto) {
		this.idPresupuesto = idPresupuesto;
	}

	
}
