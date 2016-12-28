package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDAOImplementation implements UsuarioDAO {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/forum-test";
	private static final String DB_USER = "forum";
	private static final String DB_PASSWORD = "forum";
	
	public UsuarioDAOImplementation() {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Usuario u) {
		PreparedStatement preparedStatement;
		String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, u.getLogin());
			preparedStatement.setString(2, u.getEmail());
			preparedStatement.setString(3, u.getNome());
			preparedStatement.setString(4, u.getSenha());
			preparedStatement.setInt(5, 0);
			preparedStatement.execute();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario recuperar(String login) {
		PreparedStatement preparedStatement;
		String sql = "SELECT * FROM usuario WHERE login = ?";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			
			Usuario usuario = new Usuario();
			usuario.setLogin( rs.getString("login") );
			usuario.setEmail( rs.getString("email") );
			usuario.setNome( rs.getString("nome") );
			usuario.setSenha( rs.getString("senha") );
			usuario.setPontos( rs.getInt( 5 ) );

			preparedStatement.close();
			
			return usuario;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		PreparedStatement preparedStatement;
		String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pontos);
			preparedStatement.setString(2, login);
			preparedStatement.execute();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> ranking() {
//		SELECT * FROM usuario ORDER BY pontos DESC;
		PreparedStatement preparedStatement;
		String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
		List<Usuario> usuarios = new ArrayList<>();
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			while( rs.next() ) {
				Usuario usuario = new Usuario();
				usuario.setLogin( rs.getString("login") );
				usuario.setEmail( rs.getString("email") );
				usuario.setNome( rs.getString("nome") );
				usuario.setSenha( rs.getString("senha") );
				usuario.setPontos( rs.getInt( 5 ) );
				
				usuarios.add(usuario);
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
