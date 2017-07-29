package br.ufes.sdman.dashboard.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.sdman.dashboard.domain.Usuario;
import br.ufes.sdman.dashboard.persistence.UsuarioDAO;

@Stateless
public class CadastroServiceBean {

	@EJB private UsuarioDAO usuarioDao;

	public void cadastrar(Usuario usuario){
		// TODO Auto-generated method stub
		//usar save do dao
		usuarioDao.save(usuario);
		//FacesContext.getCurrentInstance().getExternalContext().redirect("/SdmanDwws/core/login/login.faces");
	}

}
