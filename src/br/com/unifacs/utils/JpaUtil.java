package br.com.unifacs.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rdl");
		return emf.createEntityManager();
	}
}
