package com.forum.model.dao;

import com.forum.model.Usuario;
import java.util.List;

public interface UsuarioDAO {

	   //insere um novo usu�rio no banco de dados
	   public void inserir(Usuario u);
	   
	   //recupera o usu�rio pelo seu login
	   public Usuario recuperar(String login);
	   
	   //adiciona os pontos para o usu�rio no banco
	   public void adicionarPontos(String login, int pontos);
	   
	   //retorna a lista de usu�rios ordenada por pontos (maior primeiro)
	   public List<Usuario> ranking();
           
}
