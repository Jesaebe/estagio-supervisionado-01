package br.com.estagio.teste;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaListagemOrdenadaPeloNome {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		for ( Contato c : dao.ordenadosPeloNome()){
			System.out.println(c.getId() + " - " + c.getNome());
		}

	}
}
