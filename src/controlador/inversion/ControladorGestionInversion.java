package controlador.inversion;

import controlador.estandar.ControladorGeneral;
import modelo.dao.InversionDAO;
import modelo.entidades.Usuario;
import vista.inversion.VentanaGestionInversion;

public class ControladorGestionInversion extends ControladorGeneral {
	
	VentanaGestionInversion vista;
	InversionDAO modelo;
	Usuario usuario;
	
	public ControladorGestionInversion(VentanaGestionInversion vista, InversionDAO modelo, Usuario usuario) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		this.usuario = usuario;
	}
	
	


}
