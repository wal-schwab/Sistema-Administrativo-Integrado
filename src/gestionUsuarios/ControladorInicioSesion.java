package gestionUsuarios;

import javax.swing.JOptionPane;

import temporalBBDD.ListaDeUsuarios;

public class ControladorInicioSesion {

	protected static boolean validarIngreso(String legajo, char[] contrasena) {
		boolean existelegajo = false;
		boolean contrasenaCorreta = false;
		String contrasenaIngresada = new String(contrasena); 
		try {
			//Comprobar existencia de legajo
			int numLegajo = Integer.parseInt(legajo);
			for (Usuario user : ListaDeUsuarios.getUsuarios()) {
				if(user.getLegajo() == numLegajo) {
					existelegajo = true;
					//Comprobar contraseña válida
					if(contrasenaIngresada.equals(user.getContrasena())) {
						contrasenaCorreta = true;
						break;
					}
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El legajo no puede poseer letras ni espacios");
			return existelegajo && contrasenaCorreta;
		}
		if(!(existelegajo && contrasenaCorreta)) {
			JOptionPane.showMessageDialog(null, "Legajo o contraseña incorrecta");
		}
		return existelegajo && contrasenaCorreta;
	}
	
	protected static String pedirRol(String legajo){
		String nombreRol = "";
		int numLegajo = Integer.parseInt(legajo);
		for (Usuario user : ListaDeUsuarios.getUsuarios()) {
			if(user.getLegajo() == numLegajo) {
				if(user.getRolUsuario() == null) {
					JOptionPane.showMessageDialog(null, "El usuario no tiene un rol asignado");
					break;
				}else{
					nombreRol = user.getRolUsuario().getNombreRol();
					break;
				}
			}
		}	
		return nombreRol;
	}
}
