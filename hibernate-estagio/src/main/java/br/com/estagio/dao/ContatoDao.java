package br.com.estagio.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.estagio.entities.Contato;

public class ContatoDao {
	
    EntityManager manager = new JPAUtil().getEntityManager();

	public void adiciona(Contato contato) {
		manager.getTransaction().begin();
		
		manager.persist(contato);
		
		manager.getTransaction().commit();
	}
	
	public void altera(Contato contato) {
		manager.getTransaction().begin();
		
		manager.merge(contato);
		
		manager.getTransaction().commit();		
	}

	public void remove(Contato contato) {
		manager.getTransaction().begin();

		manager.remove(contato);
		
		manager.getTransaction().commit();

	}
	
	public List<Contato> todos() {
	  return manager.createQuery("from Contato", Contato.class).getResultList();
	}

	public List<Contato> ordenadosPeloNome() {
		return manager.createQuery("select c from Contato c order by c.nome", Contato.class).getResultList();
	}	
	
	public Contato porId(Long id) {
		return manager.find(Contato.class, id);
	}
	// Vocês perceberam a repetição da transação? 
	// Calma, depois vamos implementar uma forma melhor.
	// No final das contas, DRY (don't repeat yourself).
}
