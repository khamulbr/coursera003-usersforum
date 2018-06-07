package com.forum.controller;

import com.forum.model.Topico;
import com.forum.model.Usuario;
import com.forum.model.service.CadastroService;
import com.forum.model.service.TopicoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novoTopico")
public class NovoTopicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        TopicoService topicoService = new TopicoService();

        try {
            topicoService.cadastrar(titulo, conteudo, usuario);
            request.setAttribute("msgErro", "Tópico cadastrado com sucesso.");
             List<Topico> topicos = topicoService.listaTopicos();
                    
            request.setAttribute("topicos", topicos);
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch(Exception ex){
            request.setAttribute("msgErro", ex.getMessage());
            request.getRequestDispatcher("novoTopico.jsp").forward(request, response);
        }
    }
 }
