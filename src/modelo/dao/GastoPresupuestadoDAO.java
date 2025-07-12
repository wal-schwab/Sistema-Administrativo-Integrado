package modelo.dao;

import java.sql.SQLException;
import java.util.List;

import modelo.entidades.GastoPresupuestado;

public class GastoPresupuestadoDAO implements DAOGeneral<GastoPresupuestado, Integer> {

	public GastoPresupuestadoDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<GastoPresupuestado> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crear(GastoPresupuestado entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GastoPresupuestado buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(GastoPresupuestado entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
