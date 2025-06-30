package controlador.usuario;

public class Validador {

	public static boolean validarNombre(String nombre) {
		boolean esNombreValido = true;
		for (char c : nombre.toCharArray()) {
			if(!(Character.isLetter(c))) {
				esNombreValido = false;
			}
		}
		return esNombreValido;
	}	
	
	public static boolean validarLegajo(String numLegajo) {
		boolean esLegajoValido = true;
		if(numLegajo.length() == 0) {
			return esLegajoValido = false;
		}
		for (char n : numLegajo.toCharArray()) {
			if (!(Character.isDigit(n))) {
				esLegajoValido = false;
			}
		}
		return esLegajoValido;
	}
	
	public static boolean validarFormatoContrasena(String contrasena) {
		boolean formatoContrasenaValida = false;
		boolean tieneNumeros = false;
		boolean tieneLetras = false;
		boolean tieneOchoCaracteresOMas = false;
		boolean noTieneEspacios = true;
		
		if(contrasena.length() > 8) {
			tieneOchoCaracteresOMas = true;
		}
		for(Character c : contrasena.toCharArray()) {
			if(Character.isDigit(c)) {
				tieneNumeros = true;
			}else if(Character.isLetter(c)) {
				tieneLetras = true;
			}else if(Character.isSpaceChar(c)) {
				noTieneEspacios = false;
			}
		}
		if(tieneLetras && tieneNumeros && tieneOchoCaracteresOMas && noTieneEspacios) {
			formatoContrasenaValida = true;
		}
		
		return formatoContrasenaValida;
	}
	
}
