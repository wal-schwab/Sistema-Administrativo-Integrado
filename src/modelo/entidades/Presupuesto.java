package modelo.entidades;

import java.util.List;

public class Presupuesto {
    private int idPresupuesto;
    private int periodo;	//AÑO
    private String estado; // CONFIRMADO - EN REVISIÓN
    private List<GastoPresupuestado> gastosPresupuestados;
    private List<Gasto> gastos;
 

    public Presupuesto(int idPresupuesto, int periodo, String estado, int montoTotal) {
        this.idPresupuesto = idPresupuesto;
        this.periodo = periodo; 
        this.estado = estado;
    }

    // Getters y setters
    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public List<GastoPresupuestado> getGastoPresupuestado() {
		return gastosPresupuestados;
	}

	public void setGastoPresupuestado(List<GastoPresupuestado> gastosPresupuestados) {
		this.gastosPresupuestados = gastosPresupuestados;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
}
