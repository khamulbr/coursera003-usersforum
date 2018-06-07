/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forum.model.service;

import com.forum.model.Usuario;
import com.forum.model.dao.UsuarioDAOImpl;
import java.util.List;

/**
 *
 * @author adias
 */
public class UsuarioService {

    public Usuario autenticar(String login, String senha) throws Exception {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        Usuario u = usuarioDAOImpl.recuperar(login);
        
        if ((u==null) || (!u.getSenha().equals(senha))){
            throw new Exception("Não foi possivel autenticar o usuário! Não existe? Cadastre <a href='cadastro.jsp'>aqui</a>.");
        }
        return u;
    }

    public List<Usuario> obterRanking() {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        return usuarioDAOImpl.ranking();
    }
    
}
