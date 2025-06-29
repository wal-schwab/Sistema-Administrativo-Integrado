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
}
