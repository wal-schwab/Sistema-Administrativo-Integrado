package temporalBBDD;

import java.util.ArrayList;
import gestionCentrosDeCosto.CentroDeCosto;

public class ListaDeCentrosDeCostos {

	private static ArrayList<CentroDeCosto> centrosDeCostos = new ArrayList<CentroDeCosto>();
	
	public static ArrayList<CentroDeCosto> getCentrosDeCostos() {
		return centrosDeCostos;	
	}	
}
