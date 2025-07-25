package modelo.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Gasto {
	
    private int idGasto;
    private LocalDateTime fechaEmision;
    private LocalDate fechaRecepcion;
    private String estado; // RECEPCIONADO / EMITIDO
    private int nroFactura;
    private String tipoGasto;	 // RUN: Bien o Servicio para la labor diaria / GROWTH: Bien o servicio para el crecimiento de la empresa 
    							// TRANSFORM: Bien o servicio para gestionar la implementación de un nuevo modelo de negocio.
    private Proveedor proveedor;
    private List <Item> items;
    private CentroDeCosto centroDeCosto;
    private double importe;
    private List <Nota> notas;

    public Gasto(int idGasto, LocalDateTime fechaEmision, String estado,
                 String tipoGasto, Proveedor proveedor, List <Item> items, CentroDeCosto centroDeCosto, double importe) {
        this.idGasto = idGasto;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.tipoGasto = tipoGasto;
        this.proveedor = proveedor;
        this.items = items;
        this.centroDeCosto = centroDeCosto;
        this.importe = importe;
    }

    // Getters y setters
    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public CentroDeCosto getCentroDeCosto() {
        return centroDeCosto;
    }

    public void setCentroDeCosto(CentroDeCosto centroDeCosto) {
        this.centroDeCosto = centroDeCosto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
    
}