package main;

import controlador.principal.ControladorPrincipal;
import vista.principal.VentanaPrincipal;

public class Main {
	
	public static void main(String[] args){
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		new ControladorPrincipal(ventanaPrincipal);
		ventanaPrincipal.setVisible(true);
	
		
	}
}
