package view;

import java.util.List;
import java.util.Scanner;

import model.Usuario;
import service.UsuarioService;

public class Cadastro {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		UsuarioService usuarioService = new UsuarioService();

		while (true) {
			System.out.println("============= SISTEMA DE CADASTRO DE USUÁRIOS ==============");
			System.out.println("[1] Cadastrar usuário no sistema");
			System.out.println("[2] Listar usuários");
			System.out.println("[3] Buscar usuário pelo nome ");
			System.out.println("[4] Atualizar usuário");
			System.out.println("[5] Deletar usuário por ID");
			System.out.println("[0] Sair");
			System.out.print("Escolha uma opção: ");
			int option = sc.nextInt();
			sc.nextLine();
			System.out.println("============================================================");
			System.out.println();

			switch (option) {
			case 1:
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Idade:  ");
				int idade = sc.nextInt();
				System.out.print("Email: ");
				sc.nextLine();
				String email = sc.nextLine();
				Usuario novoUsuario = new Usuario(0, nome, idade, email);
				usuarioService.cadastrarUsuario(novoUsuario);

				break;

			case 2:

				List<Usuario> usuarios = usuarioService.listarUsusario();
				if (usuarios.isEmpty()) {
					System.out.println("Nenhum usuário cadastrado.");
				} else {
					System.out.println("Lista de usuários: ");
					for (Usuario u : usuarios) {
						System.out.println(u);
					}

				}
				break;

			case 3:
				System.out.println("Digite o nome do usuário: ");
				String buscaNome = sc.nextLine();
				Usuario usuarioEncontrado = usuarioService.buscarUsuario(buscaNome);

				if (usuarioEncontrado != null) {
					System.out.println("Usuário encontrado: " + usuarioEncontrado);
				} else {
					System.out.println("Usuário não encontrado.");
				}

				break;

			case 4:
				System.out.println("Digite o ID do usuário que deseja atualizar: ");
				int idAtualizar = sc.nextInt();
				sc.nextLine();
				System.out.print("Novo nome: ");
				String novoNome = sc.nextLine();
				System.out.print("Nova idade: ");
				int novaIdade = sc.nextInt();
				System.out.print("Novo email: ");
				sc.nextLine();
				String novoEmail = sc.nextLine();
				Usuario usuarioAtualizado = new Usuario(idAtualizar, novoNome, novaIdade, novoEmail);
				usuarioService.atualizarUsuario(usuarioAtualizado);

				break;

			case 5:
				System.out.println("Digite o ID do usuário a ser removido:  ");
				int removerID = sc.nextInt();
				usuarioService.removerUsuario(removerID);
				break;

			case 0:
				System.out.println("Saindo do Sistema...");
				sc.close();
				return;

			default:
				System.out.println("Opção invalida. Tente Novamente");

			}

		}
	}
	
}
	
	






