package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Rol;
import modelo.entidades.Usuario;
import modelo.util.ConexionBD;


public class UsuarioAdministradorDAO implements DAOGeneral<Usuario, Integer> {

	Connection conexion;
	ResultSet miResulSet;
	Statement miStatement;
	PreparedStatement miPrepared;
	
	@Override
	public List<Usuario> listarTodos() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<Usuario> usuarios = new ArrayList<>();
		String consulta = "SELECT * FROM usuarios";
		miStatement = conexion.createStatement();
		miResulSet = miStatement.executeQuery(consulta);
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
	
	public List<Rol> obtenerTodosLosRoles() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<Rol> roles = new ArrayList<>();
		miStatement = conexion.createStatement();
		miResulSet = miStatement.executeQuery("SELECT * FROM roles");
		while (miResulSet.next()) {
			int idRol = miResulSet.getInt("idRol");
			String nombreRol = miResulSet.getString("nombreRol");
			String descripcion =miResulSet.getString("descripcion");
			Rol rol = new Rol(idRol, nombreRol, descripcion);
			roles.add(rol);
		}	
		conexion.close();
		return roles;
	}
	
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
	public boolean crear(Usuario entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}


