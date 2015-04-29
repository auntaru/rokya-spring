package com.keylesson.dao;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.keylesson.model.UserModel;
import com.keylesson.persistence.Role;
import com.keylesson.persistence.User;

@Named
@Transactional("transactionManager")
public class UserDAO {

	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUser(UserModel model) {
		User user = new User();
		user.setLogin(model.getLogin());
		user.setPwd(model.getPwd());
		user.setEnabled(1);
		Role role = (Role) sessionFactory.getCurrentSession()
				.createQuery("from Role where code='ROLE_USER'").uniqueResult();
		if (role == null) {
			role = new Role();
			role.setCode("ROLE_USER");
			role.setLabel("ROLE FOR SIMPLE ACCESS");
			sessionFactory.getCurrentSession().save(role);
		}
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		sessionFactory.getCurrentSession().save(user);
	}
}
