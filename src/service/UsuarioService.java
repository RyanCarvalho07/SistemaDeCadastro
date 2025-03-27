package service;

import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	
	private UsuarioDAO usuarioDAO;

	public UsuarioService() {
		this.usuarioDAO = new UsuarioDAO();
	
	}

	public boolean cadastrarUsuario(Usuario usuario) {
		   usuarioDAO.adicionarUsuario(usuario);
			return true;
		}

	public List<Usuario> listarUsuario() {
		return usuarioDAO.listarUsuarios();
	}
	
	public Usuario buscarUsuario(String nome) {
		return usuarioDAO.buscarUsuario(nome);
	}
	
	public boolean removerUsuario(int id ) {
		return usuarioDAO.removerUsuario(id);
	}
	
	public boolean atualizarUsuario(Usuario usuario) {
		return usuarioDAO.atualizarUsuario(usuario);
	}
}
