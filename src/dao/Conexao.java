package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static final String URL = "jdbc:postgresql://localhost:5432/cadastro_usuarios";
	private static final String USER = "app_cad";
	private static final String PASSWORD = "CdtU02";

	public static Connection conectar() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar ao banco de dados", e);
		}
	}

	public static void fecharConexao(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				System.err.println("Erro ao fechar a conexão: " + e.getMessage());
			}
		}
	}

}
