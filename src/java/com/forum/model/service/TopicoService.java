package com.forum.model.service;

import com.forum.model.Topico;
import com.forum.model.Usuario;
import com.forum.model.dao.TopicoDAOImpl;
import com.forum.model.dao.UsuarioDAOImpl;
import java.util.List;

public class TopicoService {

    public List<Topico> listaTopicos() throws Exception {
        TopicoDAOImpl topicoDAOImpl = new TopicoDAOImpl();
        return topicoDAOImpl.listaTopicos();
    }    

    public void cadastrar(String titulo, String conteudo, Usuario usuario) {
        Topico t = new Topico(titulo, conteudo, usuario.getLogin());
        TopicoDAOImpl topicoDAOImpl = new TopicoDAOImpl();
        topicoDAOImpl.inserir(t);
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.adicionarPontos(usuario.getLogin(),usuario.getPontos()+10);
    }

    public Topico buscaPorId(Integer id) {
        TopicoDAOImpl topicoDAOImpl = new TopicoDAOImpl();
        return topicoDAOImpl.recuperar(id);
    }
}
