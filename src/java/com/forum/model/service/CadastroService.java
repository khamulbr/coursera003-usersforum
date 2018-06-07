/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forum.model.service;

import com.forum.model.Usuario;
import com.forum.model.dao.UsuarioDAOImpl;

/**
 *
 * @author adias
 */
public class CadastroService {

    public void cadastrar(String nome, String login, String email, String senha) throws Exception {
        Usuario u = new Usuario(login, nome, email, senha, 0);
        
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        
        usuarioDAOImpl.inserir(u);
    }    
}
