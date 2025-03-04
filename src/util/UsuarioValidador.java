package util;

import java.util.regex.Pattern;

import model.Usuario;

public class UsuarioValidador {

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

	public static void validar(Usuario usuario) {
		if (usuario == null) {
			throw new UsuarioInvalidoException("Erro Usuário Inválido. Objeto nulo.");
		}

		if (!validarNome(usuario.getNome())) {
			throw new UsuarioInvalidoException("Erro: Nome inválido. Ele não pode estar vazio.");
		}
		
		System.out.println("DEBUG: Validando e-mail:[" + usuario.getEmail() + "]");
		
		if(!validarEmail(usuario.getEmail())) {
			throw new UsuarioInvalidoException("Erro: Email Inválido. Use o formato correto (ex: nome@email.com).");
		}
		
		if(!validarIdade(usuario.getIdade())) {
			throw new UsuarioInvalidoException("Erro: idade inválida. Deve estar entre 1 e 120 anos.");
		}
	}
	public static boolean validarNome(String nome) {
		return nome != null && nome.trim().length() > 1;
	}

	public static boolean validarEmail(String email) {
		return email != null && EMAIL_PATTERN.matcher(email).matches();
	}

	public static boolean validarIdade(int idade) {
		return idade >= 1 && idade <= 120;
	}

}