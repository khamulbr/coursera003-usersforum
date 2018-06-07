package com.forum.model.service;

import com.forum.model.Comentario;
import com.forum.model.Topico;
import com.forum.model.Usuario;
import com.forum.model.dao.ComentarioDAOImpl;
import com.forum.model.dao.TopicoDAOImpl;
import com.forum.model.dao.UsuarioDAOImpl;
import java.util.List;

public class ComentarioService {

    public void cadastrar(String comentario, Usuario usuario, Integer idTopico) {
        Comentario c = new Comentario(comentario, usuario.getLogin(), idTopico);
        ComentarioDAOImpl comentarioDAOImpl = new ComentarioDAOImpl();
        comentarioDAOImpl.inserir(c);
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.adicionarPontos(usuario.getLogin(),usuario.getPontos()+3);
    }

    public List<Comentario> buscaPorTopico(Topico topico) {
        ComentarioDAOImpl comentarioDAOImpl = new ComentarioDAOImpl();
        return comentarioDAOImpl.buscaPorTopico(topico);
    }
}
