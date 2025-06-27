package modelo.entidades;

public class Nota {
	
    private int idNota;
    private Gasto gasto;
    private String tipoNota; // DÉBITO o CRÉDITO
    private double importe;

    public Nota(int idNota, Gasto gasto, String tipoNota, double importe) {
        this.idNota = idNota;
        this.gasto = gasto;
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

    public Gasto getGasto() {
        return gasto;
    }

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
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
