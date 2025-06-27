package modelo.entidades;

public class Proveedor {
	
    private int idProveedor;
    private String nombreProveedor;
    private String nombreContacto;
    private String email;
    private String actividadPrincipal;


    public Proveedor(int idProveedor, String nombreProveedor, String nombreContacto, String email, String actividadPrincipal) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.nombreContacto = nombreContacto;
        this.email = email;
        this.actividadPrincipal = actividadPrincipal;
    }

    // Getters y setters
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }
}
