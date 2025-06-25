package controlador.centroDeCosto;

import controlador.estandar.ControladorGeneral;
import modelo.dao.CentroDeCostoDAO;
import modelo.entidades.Usuario;
import vista.centroDeCosto.VentanaGestionCentroDeCosto;

public class ControladorGestionCentroCosto extends ControladorGeneral {
	
	CentroDeCostoDAO modelo;
	VentanaGestionCentroDeCosto vista;
	Usuario usuario;

	public ControladorGestionCentroCosto(VentanaGestionCentroDeCosto vista, CentroDeCostoDAO modelo ,Usuario usuario) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		this.usuario = usuario;
	}

}
