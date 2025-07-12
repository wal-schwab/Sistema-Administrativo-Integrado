package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Rol;
import modelo.util.ConexionBD;

public class RolDAO implements DAOGeneral<Rol, Integer>{

	Connection conexion;
	ResultSet miResulSet;
	PreparedStatement miPrepared;
	
	public RolDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Rol> listarTodos() throws SQLException {
		conexion = ConexionBD.obtenerConexion();
		List<Rol> roles = new ArrayList<>();
		miPrepared = conexion.prepareStatement("SELECT * FROM roles");
		miResulSet = miPrepared.executeQuery();
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

	@Override
	public boolean crear(Rol entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rol buscar(Integer id) throws SQLException {
		conexion = ConexionBD.obtenerConexion();
		Rol rol = new Rol();
		miPrepared = conexion.prepareStatement("SELECT * FROM roles WHERE idRol=?");
		miPrepared.setInt(1, id);
		miResulSet = miPrepared.executeQuery();
		while (miResulSet.next()) {
			int idRol = miResulSet.getInt("idRol");
			String nombreRol = miResulSet.getString("nombreRol");
			String descripcion =miResulSet.getString("descripcion");
			rol.setIdRol(idRol);
			rol.setNombreRol(nombreRol);
			rol.setDescripcion(descripcion); 
		}	
		conexion.close();
		return rol;
	}

	@Override
	public boolean modificar(Rol entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
