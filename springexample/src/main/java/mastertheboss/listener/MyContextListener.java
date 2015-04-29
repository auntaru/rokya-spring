package mastertheboss.listener;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mastertheboss.dao.JDBCCustomerDAO;

import org.springframework.context.ConfigurableApplicationContext;

@WebListener
public class MyContextListener implements ServletContextListener {
@Inject
ConfigurableApplicationContext context;
	
@Override
public void contextInitialized(ServletContextEvent sce) {
	JDBCCustomerDAO dao = (JDBCCustomerDAO) context
			.getBean("jdbcCustomerDAO");

	dao.createTable();
 
}
@Override
public void contextDestroyed(ServletContextEvent sce) {
	JDBCCustomerDAO dao = (JDBCCustomerDAO) context
			.getBean("jdbcCustomerDAO");

	dao.dropTable();
 
}
}
