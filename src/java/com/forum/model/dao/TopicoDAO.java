package com.forum.model.dao;

import com.forum.model.Topico;
import java.util.List;

public interface TopicoDAO {

	   //insere um novo topico no banco de dados
	   public void inserir(Topico t);
	   
	   //recupera o topico pelo seu id
	   public Topico recuperar(Integer id);
	   
           // retorna todos os topicos
           public List<Topico> listaTopicos();
}
