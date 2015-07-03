package dao;

public interface DAOInterface {
	
	public <T> int insert(T object);
	public <T> int update(T object);
	public <T> int delete(T object);
	public <T> T findById(int id);
	//public List<?> findAll();
	//public List<?> findByColumn(String columnName);
	//public List<?> findByCriteria(String criteria);

}