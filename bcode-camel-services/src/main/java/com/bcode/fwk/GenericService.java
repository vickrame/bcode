/**
 * 
 */
package com.bcode.fwk;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.Logger;

/**
 * @author vickrame
 *
 */
public abstract class GenericService<Y, T> {// extends AbstractBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	protected EntityManager em;

	@Inject
	protected Logger logger;

	private Class<Y> typeModel;

	public GenericService(Class<Y> type) {
		typeModel = type;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	public Y create(Y model) {
		logger.info("creation de l'entite " + model + " depuis le service "
				+ this.getClass());
		em.persist(model);

		return model;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	public Y update(Y model) {
		logger.info("maj de l'entite " + model + " depuis le service "
				+ this.getClass());
		em.merge(model);

		return model;
	}

	/**
	 * 
	 * @param model
	 */
	public void delete(Y model) {
		logger.info("maj de l'entite " + model + " depuis le service "
				+ this.getClass());
		em.remove(model);
	}

	/**
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	public Y findById(Integer id) {
		logger.info("recherche de l'entite " + typeModel.getName()
				+ " par son id " + id + " depuis le service " + this.getClass());
		return em.find(typeModel, id);
	}

	/**
	 * 
	 * @param type
	 * @param nameQuery
	 * @return
	 */
	public Y findUniqueEntityByNameQuery(String nameQuery) {
		return findUniqueEntityByNameQuery(nameQuery, null);
	}

	/**
	 * 
	 * @param type
	 * @param nameQuery
	 * @return
	 */
	public Y findUniqueEntityByNameQuery(String nameQuery,
			Map<String, Object> param) {
		logger.info("recherche de l'entite " + typeModel.getName()
				+ " par son id " + nameQuery + " depuis le service "
				+ this.getClass());
		Query q = null;
		q = em.createNamedQuery(nameQuery);
		if (param != null) {
			Set<String> listClef = param.keySet();

			for (String clef : listClef) {
				q.setParameter(clef, param.get(clef));
			}

		}

		return (Y) q.getSingleResult();
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public List<Y> findListEntityByNameQuery(String nameQuery) {
		return findListEntityByNameQuery(nameQuery, null);
	}

	/**
	 * 
	 * @param type
	 * @param nameQuery
	 * @return
	 */
	public List<Y> findListEntityByNameQuery(String nameQuery,
			Map<String, Object> param) {
		logger.info("recherche de l'entite " + typeModel.getName()
				+ " par son id " + nameQuery + " depuis le service "
				+ this.getClass());
		Query q = null;
		q = em.createNamedQuery(nameQuery);

		if (param != null) {
			Set<String> listClef = param.keySet();

			for (String clef : listClef) {
				q.setParameter(clef, param.get(clef));
			}

		}

		return (List<Y>) q.getResultList();
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public T findEntity(String nameQuery, Map<String, Object> param) {
		Y entiteList = findUniqueEntityByNameQuery(nameQuery, param);

		T ret = transformModelToDTO(entiteList);

		return ret;
	}

	protected abstract T transformModelToDTO(Y entiteList);
}
