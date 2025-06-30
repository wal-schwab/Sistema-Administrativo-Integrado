package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.conexion.ConexionBD;
import modelo.entidades.CentroDeCosto;
import modelo.entidades.Proveedor;

public class CentroDeCostoDAO {
	
	Connection conexion;
	Statement miStatement;
	PreparedStatement miPrepared;
	ResultSet miResulSet;

	public List<CentroDeCosto> obtenerTodosLosCentrosDeCostos() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<CentroDeCosto> centrosDeCostos = new ArrayList<>();
		String consulta = "SELECT * FROM centrosDeCostos";
		miStatement = conexion.createStatement();
		miResulSet = miStatement.executeQuery(consulta);
		while (miResulSet.next()) {
			int idCentro = miResulSet.getInt("idCentro");
			String nombreCentro = miResulSet.getString("nombreCentro");
			String direccion = miResulSet.getString("direccion");
			
			CentroDeCosto centroDeCosto = new CentroDeCosto(idCentro, nombreCentro, direccion);
			centrosDeCostos.add(centroDeCosto);
		}
		conexion.close();
		return centrosDeCostos;
	}
	
	public boolean crearCentroDeCosto(CentroDeCosto centroDeCosto) throws SQLException {
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("INSERT INTO centrosDeCostos (idCentro, nombreCentro, direccion) " +
                "VALUES (?, ?, ?)");
		miPrepared.setInt(1, centroDeCosto.getIdCentro());
		miPrepared.setString(2, centroDeCosto.getNombreCentro());
		miPrepared.setString(3, centroDeCosto.getDireccion());
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	public boolean modificarCentroDeCosto(CentroDeCosto centroDeCosto) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("UPDATE centrosDeCostos SET nombreCentro = ?, direccion = ? WHERE idCentro = ?");
		miPrepared.setString(1, centroDeCosto.getNombreCentro());
	    miPrepared.setString(2, centroDeCosto.getDireccion());
	    miPrepared.setInt(3, centroDeCosto.getIdCentro());			
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
	
	public boolean eliminarCentrosDeCostos(int idCentro) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("DELETE FROM centrosDeCostos WHERE idCentro=?");
		miPrepared.setInt(1, idCentro);
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
}
