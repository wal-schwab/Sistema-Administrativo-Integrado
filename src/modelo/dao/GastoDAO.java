package modelo.dao;

import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Gasto;

public class GastoDAO implements DAOGeneral<Gasto, Integer>{

	@Override
	public boolean crear(Gasto entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Gasto entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Gasto> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gasto buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
