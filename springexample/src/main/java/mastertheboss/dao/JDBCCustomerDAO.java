package mastertheboss.dao;

import java.util.List;

import mastertheboss.manager.Customer;

public interface JDBCCustomerDAO {

	public void insert(Customer customer);
 
	public List<Customer> findAll();
 
	public void createTable();
	public void dropTable();
}
