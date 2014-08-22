package br.com.estagio.teste;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaAlteracao {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
	    //buscando o contato que eu quero alterar
	    Contato contato =  dao.buscaPorId(2l);
	
	    //mudando o endereco do contato
	    contato.setNome("Maria Luisa Froes");
	    
	    dao.altera(contato);
	    
	    System.out.println("Sucesso na altare????o!");
	}
}
