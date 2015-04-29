package com.keylesson.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.keylesson.manager.UserManager;
import com.keylesson.model.UserModel;

@ManagedBean
@Named
public class UserController {

	@Inject
	public UserManager userManager;
	private UserModel model = new UserModel();

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserModel getModel() {
		return model;
	}

	public void setModel(UserModel model) {
		this.model = model;
	}

	/**
	 * @return
	 */
	public String register() {
		try {
			if (!model.getPwd().equals(model.getPwdConfirm())) {
				throw new Exception("Passwords do not match!!");
			}
			userManager.addUser(model);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Registration Failure, " + e.getMessage(), ""));
			return null;
		}
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Registration Success!", ""));
		model.reset();
		return "login";
	}

}
