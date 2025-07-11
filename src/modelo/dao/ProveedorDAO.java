package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Proveedor;
import modelo.util.ConexionBD;

public class ProveedorDAO implements DAOGeneral<Proveedor, Integer>{

	Connection conexion;
	PreparedStatement miPrepared;
	ResultSet miResulSet;
	
	@Override
	public List<Proveedor> listarTodos() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<Proveedor> proveedores = new ArrayList<>();
		miPrepared = conexion.prepareStatement("SELECT * FROM proveedores");
		miResulSet = miPrepared.executeQuery();
		while (miResulSet.next()) {
			int idProveedor = miResulSet.getInt("idProveedor");
			String nombreProveedor = miResulSet.getString("nombreProveedor");
			String nombreContacto = miResulSet.getString("nombreContacto");
			String email = miResulSet.getString("email");
			String actividadPrincipal = miResulSet.getString("actividadPrincipal");
			Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor, nombreContacto, email, actividadPrincipal);
			proveedores.add(proveedor);
		}
		conexion.close();
		return proveedores;
	}
	
	@Override
	public boolean crear(Proveedor proveedor) throws SQLException {
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("INSERT INTO proveedores (idProveedor, nombreProveedor, nombreContacto, email, actividadPrincipal) " +
                "VALUES (?, ?, ?, ?, ?)");
		miPrepared.setInt(1, proveedor.getIdProveedor());
		miPrepared.setString(2, proveedor.getNombreProveedor());
		miPrepared.setString(3, proveedor.getNombreContacto());
		miPrepared.setString(4, proveedor.getEmail());
		miPrepared.setString(5, proveedor.getActividadPrincipal());
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	@Override
	public Proveedor buscar(Integer id) throws SQLException{
		Proveedor proveedorBuscado = null;
		int numID = id.intValue();
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("SELECT * FROM proveedores WHERE idProveedor=?");
		miPrepared.setInt(1, numID);
		miResulSet = miPrepared.executeQuery();
		while(miResulSet.next()){
			String nombreProveedor = miResulSet.getString("nombreProveedor");
			String nombreContacto = miResulSet.getString("nombreContacto");
			String email = miResulSet.getString("email");
			String actividadPrincipal = miResulSet.getString("actividadPrincipal");
			proveedorBuscado = new Proveedor(numID, nombreProveedor, nombreContacto, email, actividadPrincipal);
		}	
		conexion.close();
		return proveedorBuscado;
	}
	
	@Override
	public boolean modificar(Proveedor proveedor) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("UPDATE proveedores SET nombreProveedor = ?, nombreContacto = ?, "
														+ "email = ?, actividadPrincipal = ? WHERE idProveedor = ?");
		miPrepared.setString(1, proveedor.getNombreProveedor());
	    miPrepared.setString(2, proveedor.getNombreContacto());
	    miPrepared.setString(3, proveedor.getEmail());
	    miPrepared.setString(4, proveedor.getActividadPrincipal());
	    miPrepared.setInt(5, proveedor.getIdProveedor());			
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	@Override
	public boolean eliminar(Integer idProveedor) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("DELETE FROM proveedores WHERE idProveedor=?");
		miPrepared.setInt(1, idProveedor);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
}


