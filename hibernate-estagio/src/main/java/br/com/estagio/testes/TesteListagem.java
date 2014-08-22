package br.com.estagio.testes;

import br.com.estagio.dao.ContatoDao;
import br.com.estagio.entities.Contato;

public class TesteListagem {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();

		for (Contato c : dao.todos()) {
			System.out.println(c.getId() + " - " + c.getNome());
		}
	}
}
