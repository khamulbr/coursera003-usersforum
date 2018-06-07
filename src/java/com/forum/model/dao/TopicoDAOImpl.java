package com.forum.model.dao;

import com.forum.model.Topico;
import com.forum.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicoDAOImpl implements TopicoDAO {
	
	public TopicoDAOImpl(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Topico t) {
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
			String sql = "INSERT into TOPICO (titulo, conteudo, login) VALUES (?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, t.getTitulo());
			ps.setString(2, t.getConteudo());
			ps.setString(3, t.getLogin());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível inserir o tópico ", e);
		}
	}



    @Override
    public Topico recuperar(Integer id) {
        Topico t = null;
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
            String sql = "SELECT * FROM topico WHERE id_topico = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                t = new Topico(rs.getInt("id_topico"), rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"));
            }
        } catch (SQLException e) {
                throw new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
        }		
        return t;    
    }

    @Override
    public List<Topico> listaTopicos() {
        List<Topico> topicos = new ArrayList<>();
		
        try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
                String sql = "SELECT * FROM topico";
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                        Topico t = new Topico(rs.getInt("id_topico"), rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login"));
                        topicos.add(t);
                }
        } catch (SQLException e) {
                throw new RuntimeException("Não foi possível executar o acesso à lista de tópicos", e);
        }
        return topicos;    
    }
}
