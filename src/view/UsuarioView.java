package view;

import java.util.List;
import java.util.Scanner;

import model.Usuario;
import service.UsuarioService;

public class UsuarioView {

	private UsuarioService usuarioService;
	private Scanner sc;

	public UsuarioView() {
		usuarioService = new UsuarioService();
		sc = new Scanner(System.in);
	}

	public void exibirMenu() {
		while (true) {
			System.out.println("============= SISTEMA DE CADASTRO DE USUÁRIOS ==============");
			System.out.println("[1] Cadastrar usuário no sistema");
			System.out.println("[2] Listar usuários");
			System.out.println("[3] Buscar usuário pelo nome");
			System.out.println("[4] Atualizar usuário");
			System.out.println("[5] Deletar usuário por ID");
			System.out.println("[0] Sair");
			System.out.print("Escolha uma opção: ");

			if (!sc.hasNextInt()) {
				System.out.println("Opção inválida! Digite um número.");
				sc.next();
				continue;
			}
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println("============================================================");
			System.out.println();

			switch (option) {
			case 1:
				cadastrarUsuario();
				break;
			case 2:
				listarUsuarios();
				break;
			case 3:
				buscarUsuarioPorNome();
				break;
			case 4:
				atualizarUsuario();
				break;
			case 5:
				deletarUsuarioPorId();
				break;
			case 0:
				System.out.println("Saindo do Sistema...");
				sc.close();
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private void cadastrarUsuario() {
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Idade: ");
		while (!sc.hasNextInt()) {
			System.out.println("Por favor, digite um número válido para a idade.");
			sc.next();
		}
		int idade = sc.nextInt();
		sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();

		Usuario novoUsuario = new Usuario(0, nome, idade, email);
		usuarioService.cadastrarUsuario(novoUsuario);
	}

	private void listarUsuarios() {
		List<Usuario> usuarios = usuarioService.listarUsuario();
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário cadastrado.");
		} else {
			System.out.println("Lista de usuários:");
			for (Usuario u : usuarios) {
				System.out.println(u);
			}
		}
	}

	private void buscarUsuarioPorNome() {
		System.out.print("Digite o nome do usuário: ");
		String buscaNome = sc.nextLine();
		Usuario usuarioEncontrado = usuarioService.buscarUsuario(buscaNome);

		if (usuarioEncontrado != null) {
			System.out.println("Usuário encontrado: " + usuarioEncontrado);
		} else {
			System.out.println("Usuário não encontrado.");
		}
	}

	private void atualizarUsuario() {
		System.out.print("Digite o ID do usuário que deseja atualizar: ");
		while (!sc.hasNextInt()) {
			System.out.println("Por favor, digite um número válido para o ID.");
			sc.next();
		}
		int idAtualizar = sc.nextInt();
		sc.nextLine();

		System.out.print("Novo nome: ");
		String novoNome = sc.nextLine();
		System.out.print("Nova idade: ");
		while (!sc.hasNextInt()) {
			System.out.println("Por favor, digite um número válido para a idade.");
			sc.next();
		}
		int novaIdade = sc.nextInt();
		sc.nextLine();

		System.out.print("Novo email: ");
		String novoEmail = sc.nextLine();

		Usuario usuarioAtualizado = new Usuario(idAtualizar, novoNome, novaIdade, novoEmail);
		usuarioService.atualizarUsuario(usuarioAtualizado);
	}

	private void deletarUsuarioPorId() {
		System.out.print("Digite o ID do usuário a ser removido: ");
		while (!sc.hasNextInt()) {
			System.out.println("Por favor, digite um número válido para o ID.");
			sc.next();
		}
		int removerID = sc.nextInt();
		sc.nextLine();
		usuarioService.removerUsuario(removerID);
	}
}