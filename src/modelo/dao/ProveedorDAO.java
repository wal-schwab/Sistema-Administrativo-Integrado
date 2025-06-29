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
}


