package entity;

public class Usuario {

	String login;
	String email;
	String nome;
	String senha;
	Integer pontos;
	
	public Usuario() {
	}
	
	public Usuario(String nome) {
		this.nome = nome;
	}
	
	public Usuario(String login, String email, String nome, String senha, Integer pontos) {
		super();
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.pontos = pontos;
	}

	public String getLogin() {
		return login;
	}
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", email=" + email + ", nome=" + nome + ", senha=" + senha + ", pontos="
				+ pontos + "]";
	}
}
