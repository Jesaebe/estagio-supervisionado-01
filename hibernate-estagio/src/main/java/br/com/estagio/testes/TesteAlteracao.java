package br.com.estagio.testes;

import br.com.estagio.dao.ContatoDao;
import br.com.estagio.entities.Contato;

public class TesteAlteracao {
	
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();

		//Passando o id de quem eu quero alterar
		Contato contato = dao.porId(1l);
		
		System.out.println("Nome antes = " + contato.getNome());
		
		//Alterando o nome
		contato.setNome("Joao da Silva");
		
		dao.altera(contato);
		
		System.out.println("Alteração realizada com sucesso!");
	}
}
