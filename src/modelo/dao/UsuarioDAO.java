package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import modelo.util.ConexionBD;

public class UsuarioDAO implements DAOGeneral<Usuario, Integer>{
	
	Connection conexion;
	PreparedStatement miPrepared;
	ResultSet miResulSet;
	
	@Override
	public boolean crear(Usuario usuario) throws SQLException {
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
		// TODO Auto-generated method stub
		return null;
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
}
    	

