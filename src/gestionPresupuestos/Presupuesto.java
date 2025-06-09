package gestionPresupuestos;

import java.util.ArrayList;

import gestionGastos.Gasto;
import gestionGastos.GastoPresupuestado;

public class Presupuesto {
	
	private int numeroID;
	private int anoPresupuesto;
	private ArrayList<Gasto> gastosRealizados;
	private ArrayList<GastoPresupuestado> gastosPresupuestados;
	
	public Presupuesto(int numeroID, int anoPresupuesto) {
		this.numeroID = numeroID;
		this.anoPresupuesto = anoPresupuesto;
		gastosRealizados = new ArrayList<Gasto>();
		gastosPresupuestados = new ArrayList<GastoPresupuestado>();
	}

	public int getNumeroID() {
		return numeroID;
	}

	public void setNumeroID(int numeroID) {
		this.numeroID = numeroID;
	}

	public int getAnoPresupuesto() {
		return anoPresupuesto;
	}

	public void setAnoPresupuesto(int anoPresupuesto) {
		this.anoPresupuesto = anoPresupuesto;
	}

	public ArrayList<Gasto> getGastosRealizados() {
		return gastosRealizados;
	}

	public void agregarGastoRealizado(Gasto gastoRealizado) {
		gastosRealizados.add(gastoRealizado);
	}

	public ArrayList<GastoPresupuestado> getGastosPresupuestados() {
		return gastosPresupuestados;
	}

	public void agregarGastoPresupuestado(GastoPresupuestado gastoPresupuestado) {
		gastosPresupuestados.add(gastoPresupuestado);
	}
	
	
	
	
	

}
