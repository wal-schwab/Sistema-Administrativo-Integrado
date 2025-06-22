package modelo.entidades;

import java.util.ArrayList;

public class Subleager {
	
	private int numeroID;
	private String nombre;
	private ArrayList<Inversion> inversiones;
	
	public Subleager(int numeroID, String nombre) {
		this.numeroID = numeroID;
		this.nombre = nombre;
		this.inversiones = new ArrayList<Inversion>();
	}

	public int getNumeroID() {
		return numeroID;
	}

	public void setNumeroID(int numeroID) {
		this.numeroID = numeroID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Inversion> getInversiones() {
		return inversiones;
	}

	public void agregarInversion(Inversion inversion) {
		inversiones.add(inversion);
	}
	
	
	

}
