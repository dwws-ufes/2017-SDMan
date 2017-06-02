package br.ufes.sdman.dashboard.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.sdman.dashboard.domain.Projeto;

@Local
public interface ProjetoDAO extends BaseDAO<Projeto> {
	
	public Projeto getByName(String name)throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;
	
}
