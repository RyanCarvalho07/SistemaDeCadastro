package model;

public class Usuario {

	private int id;
	private String nome;
	private Integer idade;
	private String email;

	public Usuario() {
	}

	public Usuario(int id, String nome, Integer idade, String email) {

		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {

		return "ID: " + id +" Nome: " + nome + ", Idade: " + idade + ",  Email: " + email;
	}
}
