package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.conexion.ConexionBD;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;

public class UsuarioDAO {
	
	Connection conexion;
	PreparedStatement miPrepared;
	ResultSet miResulSet;
	
	public boolean crearUsuario(Usuario usuario) throws SQLException {
		 boolean usuarioCreado = false;
		 String nombre = usuario.getNombre();
		 String apellido = usuario.getApellido();
		 int legajo = usuario.getLegajo();
		 String contrasena = usuario.getContrasena();
		 int idRolUsuario = usuario.getRolUsuario().getIdRol();
		
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("INSERT INTO usuarios (legajo, nombre, apellido, contrasena, idRol) "
				+ "VALUES (?,?,?,?,?)");
		miPrepared.setInt(1, legajo);
		miPrepared.setString(2, nombre);
		miPrepared.setString(3, apellido);
		miPrepared.setString(4, contrasena);
		miPrepared.setInt(5, idRolUsuario);
		int filasModificadas = miPrepared.executeUpdate();
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
		miPrepared = conexion.prepareStatement("SELECT * FROM usuarios WHERE legajo=? AND contrasena=?");
		miPrepared.setInt(1, numlegajo);
		miPrepared.setString(2, contrasena);
		miResulSet = miPrepared.executeQuery();
		if (miResulSet.next()) {
			Rol rolUsuario = obtenerRolUsuario(miResulSet.getInt("idRol"));
			usuario = new Usuario(miResulSet.getString("nombre"), miResulSet.getString("apellido"),miResulSet.getInt("legajo"), miResulSet.getString("contrasena"), rolUsuario);
	    }
		conexion.close();
    	return usuario;
    }
        
    public boolean comprobarLegajoSinUsuario(int numLegajo) throws SQLException{
    	boolean noTieneUsuario;
    	conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("SELECT * FROM usuarios WHERE legajo=?");
		miPrepared.setInt(1, numLegajo);
		miResulSet = miPrepared.executeQuery();
		if(miResulSet.next()) {
			noTieneUsuario = false;
		}else {
			noTieneUsuario = true;
		}
		conexion.close();
    	return noTieneUsuario;
    };
    
    public Rol obtenerRolUsuario(int idRol) throws SQLException {
       	Rol rolUsuario = null;
    	conexion = ConexionBD.obtenerConexion();
		PreparedStatement miStnt = conexion.prepareStatement("SELECT * FROM roles WHERE idRol=?");
		miStnt.setInt(1, idRol);
		ResultSet miRtst = miStnt.executeQuery();
		if (miRtst.next()) {
			rolUsuario = new Rol(miRtst.getInt("idRol"), miRtst.getString("nombreRol"), miRtst.getString("descripcion"));
		}
    	return rolUsuario;
    }
}
    	

