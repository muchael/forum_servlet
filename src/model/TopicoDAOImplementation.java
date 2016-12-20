package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Comentario;
import entity.Topico;
import entity.Usuario;

public class TopicoDAOImplementation implements TopicoDAO {

	private static final String DB_DRIVER = "org.postgresql.Driver";
	private static final String DB_CONNECTION = "jdbc:postgresql://127.0.0.1:5432/forum";
	private static final String DB_USER = "forum";
	private static final String DB_PASSWORD = "forum";
	
	public TopicoDAOImplementation() {
	}

	@Override
	public void inserirTopico(Topico t) {
		PreparedStatement preparedStatement;
		String sql = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?)";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getTitulo());
			preparedStatement.setString(2, t.getConteudo());
			preparedStatement.setString(3, t.getCriador().getLogin());
			preparedStatement.execute();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void inserirComentario(Comentario c) {
		PreparedStatement preparedStatement;
		String sql = "INSERT INTO comentario(id_topico, comentario, login) VALUES (?, ?, ?)";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, c.getTopico().getId_topico().intValue() );
			preparedStatement.setString(2, c.getComentario() );
			preparedStatement.setString(3, c.getUsuario().getLogin());
			preparedStatement.execute();
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Override
	public Topico recuperar(Long id) {
		PreparedStatement preparedStatement;
		String sql = "SELECT id_topico, titulo, conteudo, nome FROM topico LEFT JOIN usuario ON topico.login = usuario.login "
				+ "WHERE id_topico = ?";
		String sqlComentario = "SELECT id_comentario, comentario, nome FROM comentario LEFT JOIN usuario on comentario.login = usuario.login "
				+ "WHERE id_topico = ?";
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id.intValue());

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			
			Topico topico = new Topico();
			topico.setId_topico( rs.getLong(1) );
			topico.setTitulo( rs.getString("titulo") );
			topico.setConteudo( rs.getString("conteudo") );
			
			Usuario usuario = new Usuario();
			usuario.setNome( rs.getString("nome") );
			topico.setCriador(usuario);

			preparedStatement.close();

			preparedStatement = connection.prepareStatement(sqlComentario);
			preparedStatement.setInt(1, id.intValue());
			
			rs = preparedStatement.executeQuery();
			
			while( rs.next() ) {
				Comentario comentario = new Comentario();
				comentario.setId_comentario(rs.getLong(1) );
				comentario.setComentario( rs.getString("comentario") );
				comentario.setUsuario( new Usuario( rs.getString("nome") ) );
				
				topico.getComentarios().add( comentario );
			}
			
			preparedStatement.close();
			
			return topico;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Topico> listar() {
		PreparedStatement preparedStatement;
		String sql = "SELECT id_topico, titulo, nome FROM topico LEFT JOIN usuario ON topico.login = usuario.login";
		List<Topico> topicos = new ArrayList<>();
		
		try( Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD) ) {
			preparedStatement = connection.prepareStatement(sql);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			
			while( rs.next() ) {
				Topico topico = new Topico();
				topico.setId_topico( rs.getLong(1) );
				topico.setTitulo( rs.getString("titulo") );
				
				Usuario usuario = new Usuario();
				usuario.setNome( rs.getString("nome") );
				topico.setCriador(usuario);
				
				topicos.add(topico);
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return topicos;
	}
}
