package com.keylesson.manager;

import javax.inject.Inject;
import javax.inject.Named;

import com.keylesson.dao.UserDAO;
import com.keylesson.model.UserModel;

@Named
public class UserManager {

	@Inject
	public UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(UserModel model) {
		userDAO.addUser(model);
	}

}