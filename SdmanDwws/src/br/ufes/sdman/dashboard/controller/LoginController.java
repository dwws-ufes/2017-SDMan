package br.ufes.sdman.dashboard.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.sdman.dashboard.application.LoginServiceBean;
import br.ufes.sdman.dashboard.domain.Usuario;

@Model
@ManagedBean(name = "LoginController")
public class LoginController {
	
	@EJB LoginServiceBean loginServiceBean;
	
	private String email;
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void login() throws IOException, PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		
		Usuario u = loginServiceBean.login(email);
		if (u != null){
			FacesContext.getCurrentInstance().getExternalContext().redirect("/SdmanDwws/core/painel/painel.faces");	
		}else{
				//msg de erro
		}
			
	}
	
}
