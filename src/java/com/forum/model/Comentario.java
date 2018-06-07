package com.forum.model;

public class Comentario {
    private int id;
    private String comentario;
    private String login;
    private Integer idTopico;

    public Comentario(int id, String comentario, String login, Integer topico) {
        this.id = id;
        this.comentario = comentario;
        this.login = login;
        this.idTopico = topico;
    }
    
    public Comentario(String comentario, String login, Integer topico) {
        this.comentario = comentario;
        this.login = login;
        this.idTopico = topico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Integer idTopico) {
        this.idTopico = idTopico;
    }
}
