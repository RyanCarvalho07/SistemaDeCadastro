package test;

import java.sql.Connection;

import dao.Conexao;

public class TesteConexao {
	public static void main(String[] args) {
		Connection conn = Conexao.conectar();
		if (conn != null) {
           System.out.println("Conexão bem-sucedida!");
		}
	}

}
