package com.forum.model.dao;

import com.forum.model.Comentario;
import com.forum.model.Topico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAOImpl implements ComentarioDAO {
	
	public ComentarioDAOImpl(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
    @Override
    public void inserir(Comentario comentario) {
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
                String sql = "INSERT into COMENTARIO (comentario, login, id_topico) VALUES (?,?,?)";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1, comentario.getComentario());
                ps.setString(2, comentario.getLogin());
                ps.setInt(3, comentario.getIdTopico());

                ps.executeUpdate();
        } catch (SQLException e) {
                throw new RuntimeException("Não foi possível inserir o comentário ", e);
        }    
    }

    @Override  
    public List<Comentario> buscaPorTopico(Topico topico) {
        List<Comentario> comentarios = new ArrayList<>();
		
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
                String sql = "SELECT * FROM comentario where id_topico = ?";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setInt(1, topico.getId());
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                        Comentario comentario = new Comentario(rs.getInt("id_comentario"), rs.getString("comentario"), rs.getString("login"), rs.getInt("id_topico"));
                        comentarios.add(comentario);
                }
        } catch (SQLException e) {
                throw new RuntimeException("Não foi possível executar o acesso à lista de comentários", e);
        }
        return comentarios;        
    }
}
