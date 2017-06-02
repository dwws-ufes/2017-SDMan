package br.ufes.sdman.dashboard.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.sdman.dashboard.domain.Usuario;
import br.ufes.sdman.dashboard.persistence.UsuarioDAO;

@Stateless
public class LoginServiceBean {

	@EJB private UsuarioDAO usuarioDao;
	
	public Usuario createNewEntity() {
		return new Usuario();
	}

	public Usuario login(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException{
		// TODO Auto-generated method stub
		//usar save do dao
		return usuarioDao.getByEmail(email);
		
	}
}
