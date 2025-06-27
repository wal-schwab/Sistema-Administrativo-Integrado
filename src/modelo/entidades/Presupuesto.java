package modelo.entidades;

public class Presupuesto {
    private int idPresupuesto;
    private int ano;
    private String estado; // CONFIRMADO / EN REVISIÓN
    private int montoTotal;

    public Presupuesto(int idPresupuesto, int ano, String estado, int montoTotal) {
        this.idPresupuesto = idPresupuesto;
        this.ano = ano;
        this.estado = estado;
        this.montoTotal = montoTotal;
    }

    // Getters y setters
    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
}
