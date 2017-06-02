package br.ufes.sdman.dashboard.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.sdman.dashboard.domain.Usuario;

@Local
public interface UsuarioDAO extends BaseDAO<Usuario> {

	
	public Usuario getByEmail(String email)throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

}
