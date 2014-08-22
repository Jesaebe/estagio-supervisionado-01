package br.com.estagio.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.estagio.entities.Contato;

import com.mysql.jdbc.PreparedStatement;

public class ContatoDao {

	// a conexão com o banco de dados
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos "
				+ "(nome,email,endereco,data_nascimento)" + " values (?,?,?,?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Contato> pegaTodos() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				contato.setDataNascimento(data);
				// adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public List<Contato> ordenadosPeloNome() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("select * from contatos order By nome");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				contato.setDataNascimento(data);
				// adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?,"
				+ "data_nascimento=? where id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = (PreparedStatement) connection
					.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Contato buscaPorId(Long id) {
		Contato contato = new Contato();
		
		 try {
	         PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from contatos where id=?");
	         stmt.setLong(1, id);
	         
	         ResultSet rs = stmt.executeQuery();
	         
				if (rs.next()) {
					contato.setId(rs.getLong("id"));
					contato.setNome(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					// montando a data através do Calendar
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("data_nascimento"));
					
					contato.setDataNascimento(data);
				}
	         stmt.close();
	         return contato;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }		
	}
	
	
}