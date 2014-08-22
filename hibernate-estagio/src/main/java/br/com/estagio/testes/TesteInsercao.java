package br.com.estagio.testes;

import java.util.Calendar;

import br.com.estagio.dao.ContatoDao;
import br.com.estagio.entities.Contato;

public class TesteInsercao {
	
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Johnny My Rayshon");
		contato.setEmail("johnny@johnny.com.br");
		contato.setEndereco("rua g quadra g 40 sei lá o que!");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
	}
}
