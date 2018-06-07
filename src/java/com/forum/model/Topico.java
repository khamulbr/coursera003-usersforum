package com.forum.model;

public class Topico {
    
    private int id;
    private String titulo;
    private String conteudo;
    private String login;

    public Topico(int id, String titulo, String conteudo, String login) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }
    
     public Topico(String titulo, String conteudo, String login) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
   
}
