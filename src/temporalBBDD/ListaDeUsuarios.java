package temporalBBDD;

import java.util.ArrayList;
import gestionUsuarios.Usuario;

public class ListaDeUsuarios {
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}