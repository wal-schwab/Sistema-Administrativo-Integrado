package modelo.dao;

import java.sql.SQLException;
import java.util.List;

import modelo.entidades.Item;

public class ItemDAO implements DAOGeneral<Item, Integer> {

	public ItemDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Item> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean crear(Item entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item buscar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificar(Item entidad) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
