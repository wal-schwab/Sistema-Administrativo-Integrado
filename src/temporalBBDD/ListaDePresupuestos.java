package temporalBBDD;

import java.util.ArrayList;
import gestionPresupuestos.Presupuesto;

public class ListaDePresupuestos {

	private static ArrayList<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
	
	public static ArrayList<Presupuesto> getPresupuestos() {
		return presupuestos;	
	}	
}
