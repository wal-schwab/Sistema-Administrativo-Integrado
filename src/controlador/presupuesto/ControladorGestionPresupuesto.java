package controlador.presupuesto;

import controlador.estandar.ControladorGeneral;
import modelo.dao.PresupuestoDAO;
import modelo.entidades.Usuario;
import vista.presupuesto.VentanaGestionPresupuesto;

public class ControladorGestionPresupuesto extends ControladorGeneral{

	VentanaGestionPresupuesto vista;
	PresupuestoDAO modelo;
	Usuario usuario;
	
	public ControladorGestionPresupuesto(VentanaGestionPresupuesto vista, PresupuestoDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
}
