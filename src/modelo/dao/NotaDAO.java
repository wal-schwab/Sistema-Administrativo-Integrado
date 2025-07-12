package modelo.dao;

import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Nota;

public class NotaDAO implements DAOGeneral<Nota, Integer> {

	public NotaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Nota> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crear(Nota entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nota buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Nota entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
