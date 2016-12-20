package service;

import java.util.List;

import entity.Comentario;
import entity.Topico;
import entity.Usuario;
import model.TopicoDAO;
import model.TopicoDAOImplementation;
import model.UsuarioDAO;
import model.UsuarioDAOImplementation;

public class ForumService {

	private static UsuarioDAO usuarioDAO;
	private static TopicoDAO topicoDAO;
	
	public ForumService() {
		if ( ForumService.usuarioDAO == null ) {
			ForumService.usuarioDAO = new UsuarioDAOImplementation();
		}
		
		if ( ForumService.topicoDAO == null ) {
			ForumService.topicoDAO = new TopicoDAOImplementation();
		}
	}
	
	public void inserirUsuario( Usuario usuario ) {
		usuarioDAO.inserir( usuario );
	}
	
	public void login( Usuario usuario ) throws Exception {
		Usuario usuarioRecuperado = ForumService.usuarioDAO.recuperar( usuario.getLogin() );
		
		if ( usuarioRecuperado == null || !usuarioRecuperado.getSenha().equals(usuario.getSenha() ) ) {
			throw new Exception("Usuário e/ou senha inválido(s).");
		}
	}
	
	public List<Usuario> ranking() {
		return ForumService.usuarioDAO.ranking();
	}
	
	public void criarTopico( Topico topico ) {
		ForumService.topicoDAO.inserirTopico(topico);
		ForumService.usuarioDAO.adicionarPontos( topico.getCriador().getLogin(), 10);
	}
	
	public void inserirComentario( Comentario comentario ) {
		ForumService.topicoDAO.inserirComentario( comentario );
		ForumService.usuarioDAO.adicionarPontos( comentario.getUsuario().getLogin(), 3);
	}
	
	public List<Topico> listarTopicos() {
		return ForumService.topicoDAO.listar();
	}

	public Topico buscaTopico(Long id) {
		return ForumService.topicoDAO.recuperar(id);
	}
}
