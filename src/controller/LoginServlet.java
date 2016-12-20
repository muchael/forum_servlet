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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211899501682787125L;

	private ForumService forumService = new ForumService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ( request.getSession().getAttribute("usuario") != null ) {
			request.getRequestDispatcher("listTopicos").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setLogin( request.getParameter("login") );
		usuario.setSenha( request.getParameter("senha") );

		System.out.println( usuario );
		
		try {
			this.forumService.login( usuario );
			
			request.getSession().setAttribute("usuario", usuario);
			
			request.getRequestDispatcher("listTopicos.jsp").forward(request, response);	
		} catch (Exception e) {
			request.setAttribute( "mensagem", e.getMessage() );
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
