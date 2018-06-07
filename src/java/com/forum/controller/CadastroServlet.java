package com.forum.controller;

import com.forum.model.service.CadastroService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        CadastroService cadastroService = new CadastroService();

        try {
            cadastroService.cadastrar(nome, login, email, senha);
            request.setAttribute("msgErro", "Usuário cadastrado com sucesso.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch(Exception ex){
            request.setAttribute("msgErro", ex.getMessage());
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
        }
    }
 }
