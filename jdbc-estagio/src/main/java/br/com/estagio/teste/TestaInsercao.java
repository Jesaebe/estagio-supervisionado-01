package br.com.estagio.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {
		Contato contato = new Contato();
		contato.setNome("Bob Charles");
		contato.setEmail("charles.mirandafroes@gmail.com");
		contato.setEndereco("Rua Odilon Correia numero 50");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		System.out.println("Gravado com sucesso!");		
	}
}
