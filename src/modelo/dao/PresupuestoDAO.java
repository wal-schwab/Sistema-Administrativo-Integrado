package modelo.dao;

import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Presupuesto;

public class PresupuestoDAO implements DAOGeneral<Presupuesto, Integer>{

	@Override
	public boolean crear(Presupuesto entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Presupuesto entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Presupuesto> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Presupuesto buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
