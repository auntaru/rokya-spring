package mastertheboss.manager;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

import mastertheboss.dao.JDBCCustomerDAO;

import org.springframework.context.ConfigurableApplicationContext;

@Model
public class Customer {
	@Inject
	ConfigurableApplicationContext context;
	
	private String name;
	private String surname;

	private int age;

	public Customer() {

	}

	public Customer(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

 

	public void insertCustomer() {
		JDBCCustomerDAO dao = (JDBCCustomerDAO) context
				.getBean("jdbcCustomerDAO");
		Customer emplNew = new Customer(name, surname, age);
		dao.insert(emplNew);

	}

	List<Customer> customerList;

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Customer> getCustomerList() {
		JDBCCustomerDAO jdbcEmployeeDAO = (JDBCCustomerDAO) context
				.getBean("jdbcCustomerDAO");

		this.customerList = jdbcEmployeeDAO.findAll();
		return customerList;
	}
}
