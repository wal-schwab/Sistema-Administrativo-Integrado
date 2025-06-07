package gestionUsuarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import temporalBBDD.ListaDeUsuarios;


public class ControladorRegistro {
	
	protected static void crearUsuario(String nombre, String apellido, int legajo, String contrasena) {
		if(ListaDeUsuarios.getUsuarios().size() == 0 ) {
			ListaDeUsuarios.getUsuarios().add(new UsuarioAdministrador(nombre, apellido, legajo, contrasena));
			JOptionPane.showMessageDialog(null, "Usuario Administrador creado");
		}else {
			ListaDeUsuarios.getUsuarios().add(new Usuario(nombre, apellido, legajo, contrasena));
			JOptionPane.showMessageDialog(null, "Usuario creado con éxito.\nDebe esperar a que el Administrador \nle brinde un rol de usuario");
		}
	}
	
	protected static String validarNombreOApellido(String nombre) {
		String nombreValido = "";
		boolean NoTieneNumeros = true;	
		boolean NoTieneEspacios = true;
		for (char c : nombre.toCharArray()) {
			if(Character.isDigit(c)) {
				NoTieneNumeros = false;
			} else if(Character.isSpaceChar(c)) {
				NoTieneEspacios = false;
			}
		}
		if(NoTieneEspacios && NoTieneNumeros) {
			nombreValido = nombre;
		}else {
			JOptionPane.showMessageDialog(null, "El nombre o apellido no puede poseer números y espacios");
		}
		return nombreValido;		
	}
	
	protected static int validarLegajo(String numLegajo) {
		int legajo = 0;
		try {
			legajo = Integer.parseInt(numLegajo);
			if(legajo <= 0) {
				JOptionPane.showMessageDialog(null, "El numero de legajo debe ser mayor a 0");
			}
			if (ListaDeUsuarios.getUsuarios().size() > 0){
				for (Usuario user  : ListaDeUsuarios.getUsuarios()) {
					if(legajo == user.getLegajo()) { 
						JOptionPane.showMessageDialog(null, "El legajo ya posee una cuenta registrada");	
						return legajo = 0;
					}
				}
			} 
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Introduzca un número en el campo Legajo");
		}	
		return legajo;
	}
	
	protected static String validarContrasena(char[] contrasena, char[] contrasenaRepetida) {
		String contrasenaValida = "";
		boolean tieneMasDeOchoDigitos = true;
		boolean sonIguales = true;
		boolean tieneNumeros = false;
		boolean tieneLetras = false;
		boolean noTieneEspacios = true;
		
		if(contrasena.length > 8) {
			if(contrasena.length == contrasenaRepetida.length) {
				for (int i = 0; i < contrasena.length; i++) {
					if(contrasena[i] == contrasenaRepetida[i]) {
						if(Character.isDigit(contrasena[i])) {
							tieneNumeros = true;
						}else if(Character.isLetter(contrasena[i])) {
							tieneLetras = true;
						}else if(Character.isSpaceChar(contrasena[i])) {
							noTieneEspacios = false;
						}
					}else {
						JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
						sonIguales = false;
						break;
					}
				}
				if(!(tieneNumeros && tieneLetras && noTieneEspacios)) {
					JOptionPane.showMessageDialog(null, "La contraseña de tener mas de 8 caracteres, estar compuesta por letras y números y no poseer espacios");
				}else {
					contrasenaValida = new String(contrasena);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
				sonIguales = false;
			}
		}else {
			JOptionPane.showMessageDialog(null, "La contraseña de tener mas de 8 caracteres, estar compuesta por letras y números y no poseer espacios");
			tieneMasDeOchoDigitos = false;
		}
		return contrasenaValida;
	}
	
}
