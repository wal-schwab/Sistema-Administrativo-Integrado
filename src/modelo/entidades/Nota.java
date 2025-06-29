package modelo.entidades;

public class Nota {
	
    private int idNota;
    private String tipoNota; // DÉBITO o CRÉDITO
    private double importe;

    public Nota(int idNota, Gasto gasto, String tipoNota, double importe) {
        this.idNota = idNota;
        this.tipoNota = tipoNota;
        this.importe = importe;
    }

    // Getters y setters
    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
