package com.forum.controller;

import com.forum.model.Usuario;
import com.forum.model.service.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ranking")
public class RankingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            UsuarioService usuarioService = new UsuarioService();
            List<Usuario> ranking = usuarioService.obterRanking();
                    
            request.setAttribute("ranking", ranking);
            request.getRequestDispatcher("ranking.jsp").forward(request, response);
        } catch(Exception ex){
            //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("msgErro", ex.getMessage());
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        }
    }
 }
