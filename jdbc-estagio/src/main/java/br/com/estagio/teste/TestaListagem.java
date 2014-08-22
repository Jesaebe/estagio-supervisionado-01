package br.com.estagio.teste;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaListagem {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		for ( Contato c : dao.pegaTodos()){
			System.out.println(c.getId() + " - " + c.getNome());
		}

	}
}
