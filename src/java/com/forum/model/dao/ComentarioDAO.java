package com.forum.model.dao;

import com.forum.model.Comentario;
import com.forum.model.Topico;
import java.util.List;

public interface ComentarioDAO {

	   //insere um novo comentario no banco de dados
	   public void inserir(Comentario c);
	   
	   //retorna a lista de comentarios de um usuario
	   public List<Comentario> buscaPorTopico(Topico t);
}
