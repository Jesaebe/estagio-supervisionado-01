package br.com.estagio.teste;

import br.com.estagio.entities.Contato;
import br.com.estagio.jdbc.ContatoDao;

public class TestaRemocao {
	public static void main(String[] args) {
	 ContatoDao dao = new ContatoDao();
	 
	 Contato contato = dao.buscaPorId(1l);
	 
	 dao.remove(contato);
	 
	 System.out.println("Contato " + contato.getId() + " excluido com sucesso");
	 
	 
	}
}
