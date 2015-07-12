package dao;

import java.util.ArrayList;
import java.util.List;

public interface DAOInterface {
	
	public <T> int insert(T object);
	public <T> int update(T object);
	public <T> int delete(T object);
	public <T> T findById(int id);
	public List<?> findAll();
	public List<?> findByColumn(String columnName, String value);
	public List<?> findByCriteria(String criteria, ArrayList<String> values);

}