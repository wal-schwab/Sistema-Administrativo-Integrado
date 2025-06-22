package modelo.entidades;

public class CentroDeCosto {

	private int numeroID;
	private String sector;
	
	public CentroDeCosto(int numeroID, String sector) {
		this.numeroID = numeroID;
		this.sector = sector;
	}

	public int getNumeroID() {
		return numeroID;
	}

	public void setNumeroID(int numeroID) {
		this.numeroID = numeroID;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
}
