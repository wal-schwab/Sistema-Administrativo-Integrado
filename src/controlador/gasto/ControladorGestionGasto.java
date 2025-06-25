package controlador.gasto;

import controlador.estandar.ControladorGeneral;
import modelo.dao.GastoDAO;
import modelo.entidades.Usuario;
import vista.gasto.VentanaGestionGasto;

public class ControladorGestionGasto extends ControladorGeneral{

	VentanaGestionGasto vista;
	GastoDAO modelo;
	Usuario usuario;
	
	public ControladorGestionGasto(VentanaGestionGasto vista, GastoDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
	
	
}
