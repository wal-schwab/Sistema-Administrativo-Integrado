package modelo.entidades;

public class GastoPresupuestado {
    private int idGastoPresupuestado;
    private Proveedor proveedor; // Puede ser null si está "A DEFINIR"
    private Presupuesto presupuesto;
    private CentroDeCosto centroDeCosto;
    private Gasto gastoAsociado; // Puede ser null si aún no se generó
    private double importe;

    public GastoPresupuestado() {}

    public GastoPresupuestado(int idGastoPresupuestado, Proveedor proveedor, Presupuesto presupuesto,
                               CentroDeCosto centroDeCosto, Gasto gastoAsociado, double importe) {
        this.idGastoPresupuestado = idGastoPresupuestado;
        this.proveedor = proveedor;
        this.presupuesto = presupuesto;
        this.centroDeCosto = centroDeCosto;
        this.gastoAsociado = gastoAsociado;
        this.importe = importe;
    }

    // Getters y setters
    public int getIdGastoPresupuestado() {
        return idGastoPresupuestado;
    }

    public void setIdGastoPresupuestado(int idGastoPresupuestado) {
        this.idGastoPresupuestado = idGastoPresupuestado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    public CentroDeCosto getCentroDeCosto() {
        return centroDeCosto;
    }

    public void setCentroDeCosto(CentroDeCosto centroDeCosto) {
        this.centroDeCosto = centroDeCosto;
    }

    public Gasto getGastoAsociado() {
        return gastoAsociado;
    }

    public void setGastoAsociado(Gasto gastoAsociado) {
        this.gastoAsociado = gastoAsociado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
