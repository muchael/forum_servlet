package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comentario;
import entity.Topico;
import entity.Usuario;
import service.ForumService;

/**
 * Servlet implementation class Topico
 */
@WebServlet("/topico")
public class TopicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ForumService forumService = new ForumService();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ( request.getSession().getAttribute("usuario") == null ) {
			request.setAttribute( "mensagem", "Usuário não autenticado." );
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		Long id = Long.parseLong( request.getParameter("id") );
		
		Topico topico = this.forumService.buscaTopico( id );
		
		request.setAttribute( "topico", topico );
		request.getRequestDispatcher("topico.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		if ( usuario == null ) {
			request.setAttribute( "mensagem", "Usuário não autenticado." );
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		System.out.println("Comentário: " + request.getParameter("comentario"));
		
		Long topicoId = Long.parseLong( request.getParameter("id") );
		
		Comentario comentario = new Comentario( new Topico( topicoId ), 
									request.getParameter("comentario"), usuario );
		
		this.forumService.inserirComentario(comentario);
		
		doGet(request, response);
	}

}
