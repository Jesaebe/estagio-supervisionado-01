package br.com.estagio.teste;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaBuscaPorId {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.buscaPorId(4L);
		
		System.out.println(contato.getNome());
		
	}
}
