package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.UsuarioInvalidoException;
import util.UsuarioValidador;

public class UsuarioDAO {

	public void adicionarUsuario(Usuario usuario) {

		try {
			UsuarioValidador.validar(usuario);

			String sql = "INSERT INTO usuarios (nome, email, idade) VALUES (?, ?, ?)";

			try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setInt(3, usuario.getIdade());

				stmt.executeUpdate();
				System.out.println("Usuário cadastrado com sucesso!");

			} catch (UsuarioInvalidoException e) {
				System.err.println("Erro de validação: " + e.getMessage());
			}

		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar usuário: " + e.getMessage());

		}
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> listarUsuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";

		try (Connection conexao = Conexao.conectar();
				PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet resultado = stmt.executeQuery()) {

			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setIdade(resultado.getInt("idade"));

				listarUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao listar usuarios: " + e.getMessage());
		}
		return listarUsuarios;
	}

	public Usuario buscarUsuario(String nome) {
		String sql = "SELECT * FROM usuarios Where nome = ?";
		Usuario usuario = null;

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

			stmt.setString(1, nome);
			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setIdade(resultado.getInt("idade"));
			}
		} catch (SQLException e) {
			System.err.println("Erro ao buscar usuário: " + e.getMessage());
		}
		return usuario;
	}

	public boolean removerUsuario(int id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";

		try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Usuário removido com sucesso!");
				return true;
			} else {
				System.out.println("Nenhum usuário encontrado com esse ID.");
			}

		} catch (SQLException e) {
			System.err.println("Erro ao remover usuário: " + e.getMessage());
		}
		return false;
	}
	

	public boolean atualizarUsuario(Usuario usuario) {
		try {
			UsuarioValidador.validar(usuario);

			String sql = "UPDATE usuarios SET  nome = ?, email = ?, idade = ? WHERE id = ?";

			try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setInt(3, usuario.getIdade());
				stmt.setInt(4, usuario.getId());

				int linhasAfetadas = stmt.executeUpdate();

				if (linhasAfetadas > 0) {
					System.out.println("Usuário atualizado com sucesso!");
					return true;
				} else {
					System.out.println("Nenhum usuário foi encontrado. Verifique se o ID existe.");
					return false;
				}
			} catch (UsuarioInvalidoException e) {
				System.err.println("Erro de validação: " + e.getMessage());
			}
		} catch (SQLException e) {
			System.err.println("Erro ao atualizar usuário: " + e.getMessage());

		}
		return false;

	}

}