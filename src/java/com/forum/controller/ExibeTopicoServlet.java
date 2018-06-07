package com.forum.controller;

import com.forum.model.Comentario;
import com.forum.model.Topico;
import com.forum.model.Usuario;
import com.forum.model.service.ComentarioService;
import com.forum.model.service.TopicoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/exibeTopico")
public class ExibeTopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        TopicoService topicoService = new TopicoService();
        ComentarioService comentarioService = new ComentarioService();

        try {
            Topico topico = topicoService.buscaPorId(id);
            List<Comentario> comentarios = comentarioService.buscaPorTopico(topico);
                    
            request.setAttribute("topico", topico);
            request.setAttribute("comentarios", comentarios);
            request.getRequestDispatcher("exibeTopico.jsp").forward(request, response);
        } catch(Exception ex){
            request.setAttribute("msgErro", ex.getMessage());
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        }
    }
 }
