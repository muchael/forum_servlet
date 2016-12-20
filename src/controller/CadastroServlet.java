package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Usuario;
import model.UsuarioDAO;
import model.UsuarioDAOImplementation;
import service.ForumService;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1892862386552138117L;

	private ForumService forumService = new ForumService();
	
	public CadastroServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome( request.getParameter("nome") );
		usuario.setLogin( request.getParameter("login") );
		usuario.setEmail( request.getParameter("email") );
		usuario.setSenha( request.getParameter("senha") );

		System.out.println( usuario );
		
		this.forumService.inserirUsuario( usuario );
		
		request.setAttribute("mensagem", "Usuário " + usuario.getNome() + " cadastrado com sucesso!");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
