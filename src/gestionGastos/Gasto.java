package gestionGastos;

import gestionCentrosDeCosto.CentroDeCosto;
import gestionProveedores.Proveedor;

public class Gasto {
	
	private int numeroID;
	private Proveedor proveedor;
	private CentroDeCosto centroDeCosto;
	private String detalle;
	private double importe;
	
	public Gasto(int numeroID, Proveedor proveedor, CentroDeCosto centroDeCosto, String detalle, double importe) {
		this.numeroID = numeroID;
		this.proveedor = proveedor;
		this.centroDeCosto = centroDeCosto;
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

	public CentroDeCosto getCentroDeCosto() {
		return centroDeCosto;
	}

	public void setCentroDeCosto(CentroDeCosto centroDeCosto) {
		this.centroDeCosto = centroDeCosto;
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
