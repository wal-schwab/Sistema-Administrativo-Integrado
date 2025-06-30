package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBD;
import modelo.entidades.Proveedor;
import modelo.entidades.Rol;
import modelo.entidades.Usuario;

public class ProveedorDAO {

	Connection conexion;
	Statement miStatement;
	PreparedStatement miPrepared;
	ResultSet miResulSet;

	public List<Proveedor> obtenerTodosLosProveedores() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<Proveedor> proveedores = new ArrayList<>();
		String consulta = "SELECT * FROM proveedores";
		miStatement = conexion.createStatement();
		miResulSet = miStatement.executeQuery(consulta);
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
	
	public boolean crearProveedor(Proveedor proveedor) throws SQLException {
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
	
	public boolean modificarProveedor(Proveedor proveedor) throws SQLException{
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
	
	public boolean eliminarProveedor(int idProveedor) throws SQLException{
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


