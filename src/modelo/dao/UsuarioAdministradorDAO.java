package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Usuario;
import modelo.util.ConexionBD;


public class UsuarioAdministradorDAO implements DAOGeneral<Usuario, Integer> {

	Connection conexion;
	ResultSet miResulSet;
	PreparedStatement miPrepared;
	
	public boolean asignarRol(int legajo, String nombreRol) throws SQLException {
		boolean cambioExitoso = false;
		int idRol = -1;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("SELECT * FROM roles WHERE nombreRol=?");
		miPrepared.setString(1, nombreRol);
		miResulSet = miPrepared.executeQuery();
		while(miResulSet.next()) {
			idRol = miResulSet.getInt("idRol");
		}
		miPrepared = conexion.prepareStatement("UPDATE usuarios SET idRol=? WHERE legajo=?");
		miPrepared.setInt(1, idRol);
		miPrepared.setInt(2, legajo);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	@Override
	public boolean eliminar(Integer legajo) throws SQLException{
		boolean cambioExitoso = false;
		int numID = legajo.intValue();
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("DELETE FROM usuarios WHERE legajo=?");
		miPrepared.setInt(1, numID);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	@Override
	public boolean modificar(Usuario usuario) throws SQLException {
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, contrasena=? WHERE legajo=?");
		miPrepared.setString(1, usuario.getNombre());
		miPrepared.setString(2, usuario.getApellido());
		miPrepared.setString(3, usuario.getContrasena());
		miPrepared.setInt(4, usuario.getLegajo());
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}

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
	public Usuario buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Usuario> listarTodos() throws SQLException{
		return null;
	}
	
}


