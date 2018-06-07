package com.forum.model.dao;

import com.forum.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	public UsuarioDAOImpl(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Usuario u) {
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
			String sql = "INSERT into USUARIO (login, nome, email, senha, pontos) VALUES (?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSenha());
			ps.setInt(5, u.getPontos());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível inserir o usuário ", e);
		}
	}

	@Override
	public Usuario recuperar(String login) {
		Usuario u = null;
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, login);

			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				u = new Usuario(rs.getString("login"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("pontos"));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso ao banco de dados", e);
		}		
		return u;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, pontos);
			ps.setString(2, login);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar a atualização de pontos", e);
		}
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> ranking = new ArrayList<>();
		
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/usuarios","postgres","postgres")){
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Usuario u = new Usuario(rs.getString("login"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getInt("pontos"));
				ranking.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Não foi possível executar o acesso ao ranking", e);
		}
		return ranking;
	}
}
