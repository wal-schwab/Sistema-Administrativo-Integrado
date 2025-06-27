package modelo.entidades;

public class CentroDeCosto {
    private int idCentro;
    private String nombreCentro;
    private String direccion;

    public CentroDeCosto(int idCentro, String nombreCentro, String direccion) {
        this.idCentro = idCentro;
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
    }

    // Getters y setters
    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
