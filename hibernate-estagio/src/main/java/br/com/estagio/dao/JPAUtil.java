package br.com.estagio.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EstagioPU");
    
    public EntityManager getEntityManager(){
    	return entityManagerFactory.createEntityManager();
    }
}
