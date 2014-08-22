package br.com.estagio.testes;

import br.com.estagio.dao.ContatoDao;
import br.com.estagio.entities.Contato;

public class TesteRemocao {
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		//Passando o id de quem eu quero excluir
		Contato contato =  dao.porId(1l);
				
		dao.remove(contato);
		
		System.out.println("Registro " + contato.getId() + " excluido com sucesso.");
	}
}
