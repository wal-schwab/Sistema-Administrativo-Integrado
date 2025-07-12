package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import modelo.util.ConexionBD;

public class UsuarioDAO implements DAOGeneral<Usuario, Integer>{
	
	Connection conexion;
	PreparedStatement miPrepared;
	ResultSet miResulSet;
	        
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
			String nombreRol = miRtst.getString("nombreRol");
			String descripcion = miRtst.getString("descripcion");
			rolUsuario = new Rol(idRol, nombreRol, descripcion);
		}
    	return rolUsuario;
    }

	@Override
	public List<Usuario> listarTodos() throws SQLException {
		conexion = ConexionBD.obtenerConexion();
		List<Usuario> usuarios = new ArrayList<>();
		miPrepared = conexion.prepareStatement("SELECT * FROM usuarios");
		miResulSet = miPrepared.executeQuery();
		while (miResulSet.next()) {
			int legajo = miResulSet.getInt("legajo");
			String nombre = miResulSet.getString("nombre");
			String apellido = miResulSet.getString("apellido");
			String contrasena = miResulSet.getString("contrasena");
			miPrepared = conexion.prepareStatement("SELECT * FROM roles WHERE idRol=?");
			miPrepared.setInt(1, miResulSet.getInt("idRol"));
			ResultSet miRslSt = miPrepared.executeQuery();
			Rol rolUsuario = null;
			while (miRslSt.next()) {
				rolUsuario = new Rol(miRslSt.getInt("idRol"), miRslSt.getString("nombreRol"), miRslSt.getString("descripcion"));
			}	
			Usuario usuario = new Usuario(nombre, apellido, legajo, contrasena, rolUsuario);
			usuarios.add(usuario);
		}
		conexion.close();
		return usuarios;
	}
	
	@Override
    public Usuario buscar(Integer legajo) throws SQLException {
    	Usuario usuario = null;
    	conexion = ConexionBD.obtenerConexion();
    	int numlegajo = legajo.intValue();
		miPrepared = conexion.prepareStatement("SELECT * FROM usuarios WHERE legajo=?");
		miPrepared.setInt(1, numlegajo);
		miResulSet = miPrepared.executeQuery();
		if (miResulSet.next()) {
			String nombre = miResulSet.getString("nombre");
			String apellido = miResulSet.getString("apellido");
			String contrasena = miResulSet.getString("contrasena");
			Rol rolUsuario = obtenerRolUsuario(miResulSet.getInt("idRol"));
			usuario = new Usuario(nombre, apellido, numlegajo, contrasena, rolUsuario);
	    }
		conexion.close();
    	return usuario;
    }

	@Override
	public boolean modificar(Usuario entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean crear(Usuario usuario) throws SQLException {
		return false;
	}
}
    	

