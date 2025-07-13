package modelo.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOGeneral  <T, ID>{
	
	public List<T> listarTodos() throws SQLException;
	
	public boolean crear(T entidad) throws SQLException;
	
	public T buscar(ID id) throws SQLException;
	
	public boolean modificar(T entidad) throws SQLException;
	
	public boolean eliminar(ID id) throws SQLException;
}
