package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidades.CentroDeCosto;
import modelo.util.ConexionBD;

public class CentroDeCostoDAO implements DAOGeneral<CentroDeCosto, Integer> {
	
	Connection conexion;
	PreparedStatement miPrepared;
	ResultSet miResulSet;

	@Override
	public List<CentroDeCosto> listarTodos() throws SQLException{
		conexion = ConexionBD.obtenerConexion();
		List<CentroDeCosto> centrosDeCostos = new ArrayList<>();
		miPrepared = conexion.prepareStatement("SELECT * FROM centrosDeCostos");
		miResulSet = miPrepared.executeQuery();
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
	
	@Override
	public boolean crear(CentroDeCosto centroDeCosto) throws SQLException {
		boolean creacionExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("INSERT INTO centrosDeCostos (idCentro, nombreCentro, direccion) " +
                "VALUES (?, ?, ?)");
		miPrepared.setInt(1, centroDeCosto.getIdCentro());
		miPrepared.setString(2, centroDeCosto.getNombreCentro());
		miPrepared.setString(3, centroDeCosto.getDireccion());
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) creacionExitoso = true;
		conexion.close();
		return creacionExitoso;
	}
	
	@Override
	public CentroDeCosto buscar(Integer id) throws SQLException{
		CentroDeCosto centroBuscado = null;
		int numID = id.intValue();
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("SELECT * FROM centrosDeCostos WHERE idCentro=?");
		miPrepared.setInt(1, numID);
		miResulSet = miPrepared.executeQuery();
		while(miResulSet.next()){
			centroBuscado = new CentroDeCosto(miResulSet.getInt("idCentro"), miResulSet.getString("nombreCentro"), miResulSet.getString("direccion"));
		}
		conexion.close();
		return centroBuscado;
	}
	
	@Override
	public boolean modificar(CentroDeCosto centroDeCosto) throws SQLException{
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
	
	@Override
	public boolean eliminar(Integer idCentro) throws SQLException{
		boolean cambioExitoso = false;
		conexion = ConexionBD.obtenerConexion();
		miPrepared = conexion.prepareStatement("DELETE FROM centrosDeCostos WHERE idCentro=?");
		miPrepared.setInt(1, idCentro.intValue());
		int filasAfectadas = miPrepared.executeUpdate();
		if(filasAfectadas > 0) cambioExitoso = true;
		conexion.close();
		return cambioExitoso;
	}
}
