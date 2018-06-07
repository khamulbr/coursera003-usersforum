package com.forum.model;

public class Usuario {
	
	private String login;
	private String nome;
	private String email;
	private String senha;
	private int pontos;
	
	public Usuario(String login, String nome, String email, String senha, int pontos) {
		super();
		this.login = login;
		this.nome = nome;
		this.email = email;
		this.setSenha(senha);
		this.setPontos(pontos);
	}
        
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	@Override 
	public String toString(){
		return "Usuario [login=" + login + ", nome=" + nome + ", email=" + email + "]";
	}
}
