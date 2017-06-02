package br.ufes.sdman.dashboard.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufes.sdman.dashboard.application.CadastroServiceBean;
import br.ufes.sdman.dashboard.domain.Usuario;

@Model
@ManagedBean(name = "CadastroController")
public class CadastroController {
	
	@EJB CadastroServiceBean cadastroService;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void cadastrar() throws IOException{

		cadastroService.cadastrar(usuario);
		FacesContext.getCurrentInstance().getExternalContext().redirect("/SdmanDwws/core/login/login.faces");
	}

	
}
