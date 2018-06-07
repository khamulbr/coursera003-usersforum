package com.forum.controller;

import com.forum.model.Topico;
import com.forum.model.Usuario;
import com.forum.model.service.UsuarioService;
import com.forum.model.service.TopicoService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioService loginService = new UsuarioService();
        
        try {
            Usuario usuario = loginService.autenticar(login, senha);
            
            TopicoService topicoService = new TopicoService();
            List<Topico> topicos = topicoService.listaTopicos();
                    
            request.setAttribute("topicos", topicos);
            request.getSession().setAttribute("usuario", usuario);
            request.getRequestDispatcher("topicos.jsp").forward(request, response);
        } catch(Exception ex){
            //Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("msgErro", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
 }
