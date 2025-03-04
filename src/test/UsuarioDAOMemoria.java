package test;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioDAOMemoria {

	private List<Usuario> usuarios;

	public UsuarioDAOMemoria() {
		this.usuarios = new ArrayList<>();
	}

	public void adicionarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarios;
	}

	public Usuario buscarUsuario(String nome) {
		for (Usuario usuarios : usuarios) {
			if (usuarios.getNome().trim().equalsIgnoreCase(nome)) {
				return usuarios;

			}
		}
		return null;

	}

	public boolean removerUsuario(String nome) {
		return usuarios.removeIf(usuario -> usuario.getNome().equalsIgnoreCase(nome));
	}

}
