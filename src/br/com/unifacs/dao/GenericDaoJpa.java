package br.com.unifacs.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.unifacs.model.Categoria;
import br.com.unifacs.utils.JpaUtil;

public class GenericDaoJpa<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	private Class  tipoModel;
	
	public GenericDaoJpa(Class tipoModel){
		this.tipoModel = tipoModel;
	}
	
	public void inserir(T model)throws DaoException{
		
		try {
			EntityManager entitymanager = JpaUtil.getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(model);
			entitymanager.getTransaction().commit();
			entitymanager.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}
		
	}

	public void atualizar(T model) throws DaoException{
		try {
			EntityManager entitymanager = JpaUtil.getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.merge(model);
			entitymanager.getTransaction().commit();
			entitymanager.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}
		
	}

	public void excluir(T model) throws DaoException{
		try {
			EntityManager entitymanager = JpaUtil.getEntityManager();
			entitymanager.getTransaction().begin();
			T entityToBeRemoved = entitymanager.merge(model);
			entitymanager.remove(entityToBeRemoved);	
			entitymanager.getTransaction().commit();
			entitymanager.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException(e);
		}
		
	}
	public T obter(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> obterTodos() {
			EntityManager entitymanager = JpaUtil.getEntityManager();
			entitymanager.getTransaction().begin();
			final String jpql = "select this from " + getTipoModel().getSimpleName() + " this";
			Query query = entitymanager.createQuery(jpql); 	
			entitymanager.close();
			return query.getResultList();
	}

	public Class getTipoModel() {
		return tipoModel;
	}
}