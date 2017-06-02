package br.ufes.sdman.dashboard.persistence;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.sdman.dashboard.domain.Projeto;
import br.ufes.sdman.dashboard.domain.Projeto_;

@Stateless
public class ProjetoJPADAO extends BaseJPADAO<Projeto> implements ProjetoDAO{
	
	/*
    long retrieveCount(): returns how many instances of the @Entity class are found in the database;
    long retrieveFilteredCount(Filter<?> filter, String value): returns how many instances of the Entity class that match the specified filter (with the given value) are found in the database;
    List<T> retrieveAll(): returns all the instances of the Entity class from the database;
    List<T> retrieveWithFilter(Filter<?> filter, String value): returns all the instances of the Entity class that match the specified filter (with the given value) from the database;
    List<T> retrieveSome(int[] interval): same as retrieveAll(), but with pagination (returns instances from interval[0] up to interval[1]);
    List<T> retrieveSomeWithFilter(Filter<?> filter, String value, int[] interval): same as retrieveWithFilter(), but with pagination;
    T retrieveById(Long id): returns the instance of the Entity class that has the given ID;
    T retrieveByUuid(String uuid): returns the instance of the Entity class that has the given UUID;
    void save(T object): saves the instance in the database;
    void delete(T object): deletes the instance from the database;
    T merge(T object): merges the instance with the current entity manager (c.f. the life-cycle of a persistent object);
    T refresh(T object): refreshes the instance with the current entity manager (c.f. the life-cycle of a persistent object).
*/
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Projeto getByName(String name) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		// Constructs the query over the Academic class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Projeto> cq = cb.createQuery(Projeto.class);
		Root<Projeto> root = cq.from(Projeto.class);

		// Filters the query with the name.
		cq.where(cb.equal(root.get(Projeto_.nome), name));
		Projeto result = executeSingleResultQuery(cq, name);
		return result;
    }

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
