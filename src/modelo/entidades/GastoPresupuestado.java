package modelo.entidades;

public class GastoPresupuestado {
    private int idGastoPresupuestado;
    private String detalle;
    private Proveedor proveedor; // Puede ser null si está "A DEFINIR"
    private CentroDeCosto centroDeCosto;
    private Gasto gastoAsociado; // Puede ser null si aún no se generó
    private double importe;

    public GastoPresupuestado(int idGastoPresupuestado, Proveedor proveedor, 
                               CentroDeCosto centroDeCosto, Gasto gastoAsociado, double importe) {
        this.idGastoPresupuestado = idGastoPresupuestado;
        this.proveedor = proveedor;
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
    
}
