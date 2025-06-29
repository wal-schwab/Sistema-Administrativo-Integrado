package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBD;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;


public class UsuarioAdministradorDAO {

	Connection conexion;
	ResultSet miResulSet;
	Statement miStatement;
	PreparedStatement miPrepared;

	public List<Usuario> obtenerTodosLosUsuarios() throws SQLException{
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
	
	public String[] ObtenerTituloColumnaTablaUsuario() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		miStatement = conexion.createStatement();
		miResulSet = miStatement.executeQuery("SELECT * FROM Usuarios");
		ResultSetMetaData metaData = miResulSet.getMetaData();
		int cantidadColumnas = metaData.getColumnCount();
		String[] nombreColumnas = new String[cantidadColumnas];
		int j = 0;
		for (int i = 1; i <= cantidadColumnas; i++) {
			nombreColumnas[j] = metaData.getColumnName(i).toUpperCase();
			j++;
		}
		conexion.close();
		return nombreColumnas;
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
	
	public boolean eliminarUsuario(int legajo) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("DELETE FROM usuarios WHERE legajo=?");
		miPrepared.setInt(1, legajo);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	public boolean modificarUsuario(String nombre, String apellido, String contraseña, int legajo) throws SQLException {
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, contrasena=? WHERE legajo=?");
		miPrepared.setString(1, nombre);
		miPrepared.setString(2, apellido);
		miPrepared.setString(3, contraseña);
		miPrepared.setInt(4, legajo);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
}


