package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.conexion.ConexionBD;
import modelo.entidades.Usuario;

public class UsuarioDAO {
	
	Connection conexion;
	PreparedStatement miStatment;
	ResultSet miResulSet;
	
	public boolean crearUsuario(Usuario usuario) throws SQLException {
		 boolean usuarioCreado = false;
		
		 String nombre = usuario.getNombre();
		 String apellido = usuario.getApellido();
		 int legajo = usuario.getLegajo();
		 String contrasena = usuario.getContrasena();
		 int idRolUsuario = usuario.getIdRolUsuario();
		
		conexion = ConexionBD.obtenerConexion();
		miStatment = conexion.prepareStatement("INSERT INTO usuarios (legajo, nombre, apellido, contrasena, idRol) "
				+ "VALUES (?,?,?,?,?)");
		miStatment.setInt(1, legajo);
		miStatment.setString(2, nombre);
		miStatment.setString(3, apellido);
		miStatment.setString(4, contrasena);
		miStatment.setInt(5, idRolUsuario);
		int filasModificadas = miStatment.executeUpdate();
		if(filasModificadas > 0) {
			usuarioCreado = true;
		}
		conexion.close();
		
		return usuarioCreado;
	}
 
    public Usuario obtenerUsuario(String legajo, String contrasena) throws SQLException {
    	Usuario usuario = null;
    	conexion = ConexionBD.obtenerConexion();
    	int numlegajo = Integer.parseInt(legajo);
		miStatment = conexion.prepareStatement("SELECT * FROM usuarios WHERE legajo=? AND contrasena=?");
		miStatment.setInt(1, numlegajo);
		miStatment.setString(2, contrasena);
		miResulSet = miStatment.executeQuery();
		if (miResulSet.next()) {
			usuario = new Usuario(miResulSet.getString("nombre"), miResulSet.getString("apellido"),miResulSet.getInt("legajo"), miResulSet.getString("contrasena"),miResulSet.getInt("idRol"));
	    }
		conexion.close();
    	return usuario;
    }
    
    public String obtenerNombreRol(Usuario usuario) throws SQLException{
    	conexion = ConexionBD.obtenerConexion();
    	miStatment = conexion.prepareStatement("SELECT * FROM roles WHERE idRol=?");
    	miStatment.setInt(1, usuario.getIdRolUsuario());
    	miResulSet = miStatment.executeQuery();
    	conexion.close();
    	return new String(miResulSet.getString("nombreRol"));
    }
    
    public boolean comprobarLegajoSinUsuario(int numLegajo) throws SQLException{
    	boolean noTieneUsuario;
    	conexion = ConexionBD.obtenerConexion();
		miStatment = conexion.prepareStatement("SELECT * FROM usuarios WHERE legajo=?");
		miStatment.setInt(1, numLegajo);
		miResulSet = miStatment.executeQuery();
		if(miResulSet.next()) {
			noTieneUsuario = false;
		}else {
			noTieneUsuario = true;
		}
		conexion.close();
    	return noTieneUsuario;
    };
}
    	

