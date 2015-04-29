package mastertheboss.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.sql.DataSource;

import mastertheboss.manager.Customer;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCCustomerDAOImpl implements JDBCCustomerDAO{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void createTable() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("create table customer (name varchar, surname varchar, age integer)");
	}
	
	public void dropTable() {
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("drop table customer");
	}
  
	public void insert(Customer customer){
 
		String sql = "INSERT INTO CUSTOMER " +
			"(NAME,SURNAME, AGE) VALUES (?, ?, ?)";
 
		jdbcTemplate = new JdbcTemplate(dataSource);
 
		jdbcTemplate.update(sql, new Object[] { customer.getName(),
				customer.getSurname(), customer.getAge()  
		});
	}
	
	 
	@SuppressWarnings("rawtypes")
	public List<Customer> findAll(){
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM CUSTOMER";
	 
		List<Customer> customers = new ArrayList<Customer>();
	 
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Customer customer = new Customer();
			customer.setSurname((String)row.get("SURNAME"));
			customer.setName((String)row.get("NAME"));
			customer.setAge(Integer.parseInt(String.valueOf(row.get("AGE"))));
			customers.add(customer);
		}
		 
		return customers;
	}
	
	 
	 
	
}
